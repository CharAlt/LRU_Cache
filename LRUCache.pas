program LRUCache;
const
	cant = 12;
	n = 4;
type
	
	listaDoblemente = ^nodo;
	rangoVec = 0..cant-1;
	
	info = record
		id:integer;
		dato:integer;
	end;
	
	nodo = record
		dato:info;
		sig,ant:listaDoblemente;
	end;
	
	
	hashTable = array[rangoVec] of listaDoblemente;
	
	var
		l,ultlista:listaDoblemente;
		dim:integer;
		hash:hashTable;
		
	procedure insertarEnLista(n:info);
		var
			aux:listaDoblemente;
		begin
			new(aux);
			aux^.dato:=n;
			if(l = nil)then begin
				l := aux;
				ultlista:=aux;
				l^.sig:=nil;				
			end
			else begin
				aux^.sig:=l;
				l^.ant:=aux;
				l:=aux;
			end;
			l^.ant:=nil;
		end;
				
	procedure eliminarUltimoMenosUsado;
		begin
			hash[ultlista^.dato.id]:=nil;
			ultlista:=ultlista^.ant;
			dispose(ultlista^.sig);
			ultlista^.sig:=nil;
		end;
	
	procedure reacomodarLista(nodo:listaDoblemente);
			var
				aux:listaDoblemente;
			begin
				if(l <> nodo)then begin
					aux:=nodo^.ant;
					aux^.sig:=nodo^.sig;
					
					if(nodo = ultlista)then
						ultlista := aux
					else
						nodo^.sig^.ant:=aux;
						
					nodo^.sig:=l;
					l^.ant:=nodo;
					nodo^.ant:=nil;	
					l:=nodo;
				end;	
			end;	
								
	procedure put(llave:integer; inf:integer);	
		var
			dato:info;
		begin
			if(llave >=0)and(llave <= cant-1)then begin
				dato.id:= llave;
				dato.dato:=	inf;
				if(hash[llave] <> nil)then begin
					hash[llave]^.dato:=dato;
					reacomodarLista(hash[llave]);
				end		
				else begin			
					if(dim+1 > n)then
						eliminarUltimoMenosUsado
					else 
						dim:=dim+1;	
					insertarEnLista(dato);
					hash[llave] := l;
				end;
			end;							
		end;
		
	function get(llave:integer):listaDoblemente;		
		var
			result:listaDoblemente;	
		begin
			result := nil;
			if((llave >=0)and(llave <= cant-1)and(hash[llave] <> nil))then begin
				result:= hash[llave];
				reacomodarLista(hash[llave]);
			end;
			get:=result;			
		end;
		
	procedure imprimirLista();
		var
			laux:listaDoblemente;
		begin
			laux:=l;
			while(laux <> nil)do begin
				writeln(laux^.dato.dato);
				laux:=laux^.sig;
			end;
		end;	
	
var
	llave,dato:integer;
	result:listaDoblemente;
begin
	dim:=0;
	l:=nil;
	writeln('Ingrese la llave: '); readln(llave);
	while(llave <> -1)do begin
		writeln('Ingrese el dato: '); readln(dato);
		put(llave,dato);
		writeln('Ingrese la llave: '); readln(llave);
	end;	
	imprimirLista();
	writeln('');	

	writeln('Ingrese la llave: '); readln(llave);
	while(llave <> -1)do begin
		result := get(llave);
		if(result <> nil)then
			writeln(hash[llave]^.dato.dato)
		else
			writeln('nil');	
		
		writeln();
		imprimirLista();	
		writeln();
		writeln('Ingrese la llave: '); readln(llave);
	end;
	
end.

