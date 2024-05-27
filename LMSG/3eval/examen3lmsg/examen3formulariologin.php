<?php
error_reporting(0);
session_start();
$nombresesion = $_SESSION['username'];
    if(isset($_SESSION['username'])){
        header("Location: examen3equipos.php");
    }
?>

<!DOCTYPE html>
<html>

<head>
    <title>Login Examen3 - IMANOL GULLON</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="imagenes/iconolmsg.ico" type="image/x-icon">
    <link rel="stylesheet" href="examen3estilos.css">
</head>

<body>
    <header>
        <div class="logo">
            <img src="imagenes/logolmsg.png" alt="Logo de Mi Sitio Web">
        </div>
        <nav>
            <h1>Acceso Restringido. Haga Login para Continuar</h1>
        </nav>
    </header>
    <section id="contenido">
        <h1>Login de Usuarios</h1>
        <form action="examen3login.php" method="post">
            <p>Username: <input type="text" name="username" value="invitado" /></p>
            <p>Password: <input type="text" name="password" value="1234" /></p>
            <p><input type="submit" value="Enviar" /></p>
        </form>
    </section>
    <footer>
        <p>Realizado por Imanol Gullon</p>
    </footer>
</body>

</html>
</body>

</html>