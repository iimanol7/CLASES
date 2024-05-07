Algoritmo CALCUIVA
	
	Definir n Como Real
	Definir iva Como real
	Definir resultado Como Real
	
	Escribir "INTRODUZCA UN NUMERO ENTERO"
	Leer  n
	
	
	SI (n < 20000) Entonces
		//si N menor que 20000
		iva<-0.1
		resultado<-n+ (n*iva)
		Escribir "el valor sumandole el iva es: ",resultado
	SiNo
		//si N es mayor que 20000
		iva<-0.21
		resultado<-n+ (n*iva)
		Escribir "El valor sumandole el iva es: " ,(n + (n*iva))
	FinSi
	
	
	
FinAlgoritmo
