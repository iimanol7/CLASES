Algoritmo BISIESTO
	
	
	Definir año Como Entero
	Definir resp Como Caracter
	
	Escribir "Escriba un año y le dire si es o no bisiesto"
	leer año
	
	si (año mod 4 == 0) Entonces
		resp<- "Es un año bisiesto"
		
		si (año mod 100 == 0) Entonces
			resp<- "No es un año bisiesto"
		FinSi
		
		si (año mod 400 == 0) Entonces
		resp<- "Si es bisiesto"
		FinSi
		
	sino
		resp<- "No es un año bisiesto"
	
	FinSi
	
	Escribir resp
FinAlgoritmo
