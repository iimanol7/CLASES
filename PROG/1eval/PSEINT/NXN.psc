Algoritmo NXN
	
	Definir respuesta Como Real
	definir cuadrado Como Real
	Definir resultado Como Real
	
	Escribir "Escriba un n�mero"
	leer respuesta
	
	cuadrado<- respuesta * respuesta
	
	si cuadrado >100 Entonces
		
		resultado<- cuadrado  - 100
		Escribir "El resultado es: " ,resultado
		
	SiNo
		resultado<- 100 - cuadrado
		Escribir "A su n�mero le hacen falta ",resultado," para llegar a 100"
	FinSi
	
FinAlgoritmo
