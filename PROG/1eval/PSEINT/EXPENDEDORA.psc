Algoritmo EXPENDEDORA
	
	definir saldo Como Real
	Definir prod Como Caracter
	Definir vueltas como real
	Definir precio Como Real
	
	Escribir "Indique que producto desea obtener: Café, Monster o agua"
	leer prod
	Escribir "Indique su saldo por favor"
	leer saldo
	
	Segun prod hacer
		"cafe":
			precio<- 0.43
		"monster":
			precio<- 1.11
		"agua":
			precio<- 0.36
	FinSegun
	
	si (saldo>=precio) Entonces
		vueltas<- (saldo-precio)
		Escribir "perfecto, sus vueltas seran de " ,vueltas, " euros"
	SiNo
		Escribir "saldo insuficiente, le faltan " ,(precio-saldo) , " euros" 
	FinSi
	
	
FinAlgoritmo
