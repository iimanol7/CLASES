@echo off
:menu
cls
echo ---------------------------------------
echo           QUE DESEAS HACER?	   
echo ---------------------------------------
echo 1- ABRIR LA PAGINA WEB DEL CENTRO	   
echo 2- SABER TU DIRECCION IP		   
echo 3- SALIR				   
echo ---------------------------------------
:pregunta
set /p opcion=Selecciona una opcion (1-3):
if %opcion%==1 goto abrir_pagina
if %opcion%==2 goto obtener_ip
if %opcion%==3 goto salir
echo Opcion no valida. Intentalo de nuevo.
goto pregunta

:abrir_pagina
start https://fptxurdinaga.eus/
pause
goto fin

:obtener_ip
ipconfig | findstr IPv4
pause
goto fin

:salir
echo Saliendo del programa...
exit

:fin