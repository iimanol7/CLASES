<?php
    //error_reporting(0);
    session_start();
    $nombresesion = $_SESSION['username'];
    if(!isset($_SESSION['username'])){
        header("Location: examen3formulariologin.php");
    }
     //si todavia no se ha creado
     if(!isset($_SESSION['TemporadaSeleccionada'])){
        $_SESSION['TemporadaSeleccionada'] = 2024;
    }
    
    $TemporadaSeleccionada= $_SESSION['TemporadaSeleccionada'];
?>

<!DOCTYPE html>
<html>

<head>
    <title>Examen3 - Equipos - IMANOL GULLON</title>
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
            <h1>Examen3 - Equipos <?php echo $TemporadaSeleccionada ?></h1>
            <form method="POST">
                <label>Temporada</label>
                <select name="temporadas" id="temporadas">
                    <option value="2024">2024</option>
                    <option value="2023">2023</option>
                    <option value="2025">2025</option>
                </select>
                <input type="submit" value="Seleccionar Temporada">
            </form>

        </nav>
    </header>

    <section id="contenido">
    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $temporadaSeleccionada = $_POST["temporadas"];
        echo "<h1>Equipos Temporada $temporadaSeleccionada</h1>";

        include("examen3cambiartemporadas.php");
        $_SESSION['TemporadaSeleccionada'] = $temporadaSeleccionada;
        
    }else{
        $temporadaSeleccionada = 2024;
        echo "<h1>Equipos Temporada $temporadaSeleccionada</h1>";
        include("examen3cambiartemporadas.php");
    }

    ?>
       
        
    </section>
    <footer>
        <p>Realizado por Imanol Gullon - <a href="cerrar_sesion.php">Cerrar Sesion</a></p>
    </footer>
</body>

</html>