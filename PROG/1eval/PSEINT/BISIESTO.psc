Algoritmo BISIESTO
	
	definir n Como Entero
	Definir resp Como Caracter
	
	Escribir "introduzca un a�o y le dir� si es bisiesto"
	leer n
	
	si (n mod 4 == 0)
		resp<- "SI"
		
		si (n mod 100 = 0)
			resp<- "NO"
			
		FinSi
		
		si (n mod 400 == 0)
			resp<- "SI"
		FinSi
	SiNo
		resp<- "NO"
	FinSi
	
	Escribir "El numero que ha introducido " resp " es un a�o bisiesto"
	
FinAlgoritmo
