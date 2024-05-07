Algoritmo NUMPRIMO
	
	definir n Como Entero
	definir division Como Entero
	Definir esprimo Como Logico
	
	
	Escribir "introduzca un número entero y le diré si es o no un número primo"
	leer n
	
	esprimo <- Verdadero
	division<- 2
	Mientras (division < n y esprimo)
		
		si (n mod division =0)
			esprimo<- falso
		FinSi
		division<- division +1
	FinMientras
	
	si (esprimo)
		escribir "Es primo"
	SiNo
		Escribir "No es primo"
	FinSi
	
FinAlgoritmo
