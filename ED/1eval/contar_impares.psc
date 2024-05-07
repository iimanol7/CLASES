Algoritmo contar_impares
	
	
	Definir n Como Entero
	Definir cont como entero
	
	
	Mientras (n<101) Hacer
		
		si (n mod 2==1) Entonces
			cont<- cont+1
			
		FinSi
		n<- n+1
	FinMientras
	
	Escribir "Hay un total de " ,cont, " números impares"
	
FinAlgoritmo
