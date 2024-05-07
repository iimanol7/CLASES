@echo off
cls
color F9

echo                                         ==================================
echo                                         =                                =
echo                                         =              Hello             =
echo                                         =                                =
echo                                         ==================================
echo.
echo.
echo                                       Kaixo, para salir presiona una tecla.
pause>nul

:Menu
color f9
cls
echo Seleccione su opcion tecleando el numero respectivo.
echo.
echo 1.-Saber direccion IP
echo 2.-Ir a la pagina oficial
echo 3.-salir
echo.
echo.
set /p ver=Que desea hacer?

if %ver%==1 goto IP
if %ver%==2 goto Pagina
if %ver%==3 goto salir

:IP
cls 
title Saber Direccion IP
color a
Echo    Precione    ENTER PARA CONTINUAR
Pause>Nul
cd..
cd..
ipconfig
echo.
echo.
Echo Precione una tecla para volver al menu
Pause>Nul
goto :Menu

:Pagina
color 1a
start www.classroom.com
msg * Bienvenido 
echo.
Echo Precione una tecla para volver al menu
Pause>Nul
goto :Menu

:salir
msg * Thanks for using my program
msg * HAVE  A  NICE  DAY

echo.
