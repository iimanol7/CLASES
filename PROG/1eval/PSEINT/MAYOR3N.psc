Algoritmo MAYOR3N
	
	Definir a Como Entero
	Definir b Como Entero
	Definir c Como Entero
	
	Escribir "Vamos a introducir 3 n�meros por pantalla y calcular cual o cuales son los n�meros m�s grandes."
	Esperar 2 Segundos
	Escribir " "
	Escribir "Introduzca el primer n�mero."
	Leer a
	Escribir "Introduzca el segundo n�mero."
	Leer b
	Escribir "Introduzca el tercer n�mero."
	Leer c
	Si (a > b y a > c) 
		Entonces
		Escribir a ," es mayor que ", b ," y ", c ,"."
		
	SiNo
		Si (b > a y b > c)
			
			Entonces
			Escribir b ," es mayor que ", a ," y ", c ,"."
		
		SiNo 
			Si (c > a y c > b)
			
			Entonces
			Escribir c ," es mayor que ", a ," y ", b ,"."
			
		SiNo
			Si (a == b y a > c)
				Entonces
				Escribir a ," y ", b ," son mayores que ", c ,"."
				
			SiNo
				Si (b == c y b > a)
					Entonces
					Escribir b ," y ", c ," son mayores que ", a ,"."
					
				SiNo
					
				Si (a == c y a > b)
						Entonces
						Escribir a ," y ", c ," son mayores que ", b ,"."
						
					
				SiNo
					Si (a == b y b == c)
						Entonces
						Escribir a ,", ", b ," y ", c ," son iguales todos."
						
						FinSi
					FinSi
				FinSi
			FinSi
			
		FinSi
		
	FinSi
	
	FinSi
FinAlgoritmo
