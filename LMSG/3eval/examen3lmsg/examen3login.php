<?php

$username= $_POST['username'];
$pass= $_POST['password'];


$archivo_xml = 'examen3usuarios.xml';

// Cargar el XML existente
$xml = new DOMDocument();
$xml->load($archivo_xml);

// Crear una nueva variable para usar con XPath
$xpath = new DOMXPath($xml);
$xpath->registerNamespace("php", "http://php.net/xpath");
$xpath->registerPHPFunctions();

// Consulta XPath para encontrar al usuario por su correo electrónico
$consulta = "usuario[username='$username' and password='$pass']";

// Buscar los nodos que coincidan con la consulta XPath
$usuarios = $xpath->query($consulta);

if ($usuarios->length > 0) {
    
    session_start();
    $_SESSION['username'] = $username;
    header("Location: examen3equipos.php");
    
}else{
    header("Location: examen3formulariologin.php");
}
?>