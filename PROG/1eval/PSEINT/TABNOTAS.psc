Algoritmo BISIESTO
	
	
	Definir a�o Como Entero
	Definir resp Como Caracter
	
	Escribir "Escriba un a�o y le dire si es o no bisiesto"
	leer a�o
	
	si (a�o mod 4 == 0) Entonces
		resp<- "Es un a�o bisiesto"
		
		si (a�o mod 100 == 0) Entonces
			resp<- "No es un a�o bisiesto"
		FinSi
		
		si (a�o mod 400 == 0) Entonces
		resp<- "Si es bisiesto"
		FinSi
		
	sino
		resp<- "No es un a�o bisiesto"
	
	FinSi
	
	Escribir resp
FinAlgoritmo
