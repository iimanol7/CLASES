Algoritmo SEGUNDOI
	
	
	Definir h Como Entero
	Definir m Como Entero
	Definir s Como Entero
	
	Escribir "Introduce la hora: "
	leer h
	
	Escribir "Introduce los minutos: "
	leer m
	
	Escribir "Introduce los segundos: "
	leer s
	
	s<- s+1
	
	si (s>59) Entonces
		s<- 0
		m<- m+1
		
		si (m>59)
			m<-0
			h<- h+1
		FinSi
	FinSi
	
	Escribir "Su hora pasado un segundo es " ,h, " horas " ,m, " minutos y " ,s, " segundos"
	
FinAlgoritmo
