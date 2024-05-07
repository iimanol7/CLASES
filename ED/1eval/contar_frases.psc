Algoritmo contar_frases
	
	
	Definir frase Como Caracter
	Definir cont Como Entero
	Definir respuesta Como Caracter
	
	respuesta<- "SI"
	
	Mientras respuesta=="SI" hacer
		
		Escribir "vamos a contar el numero de frases que usted quiera poner"
		Leer frase
		cont <- cont+1
		Escribir "Escriba SI para continuar o NO para finalizar"
		leer respuesta
		
	FinMientras	
	Escribir "Ha escrito un total de " ,cont, " frases"
FinAlgoritmo
