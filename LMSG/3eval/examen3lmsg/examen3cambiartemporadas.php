<?php


$archivo_xml = 'examen3temporadas.xml';

// Cargar el XML existente
$xml = new DOMDocument();
$xml->load($archivo_xml);

// Crear una nueva variable para usar con XPath
$xpath = new DOMXPath($xml);
$xpath->registerNamespace("php", "http://php.net/xpath");
$xpath->registerPHPFunctions();

// Consulta XPath para encontrar al usuario por su correo electrónico
$consulta = "/temporadas/temporada[codigo='$temporadaSeleccionada']";

// Buscar los nodos que coincidan con la consulta XPath
$temporada = $xpath->query($consulta);

if ($temporada->length > 0) {
    //creo un xml para sacar los datos con un xsl
    $nuevoXML=new DOMDocument();
    $raiz = $nuevoXML->createElement('datos');
    $raiz = $nuevoXML->appendChild($raiz);
    foreach ($temporada as $temporadaS) {
      $nuevaTemporada = $nuevoXML->importNode($temporadaS, true);
      $raiz->appendChild($nuevaTemporada);
    }

    $nuevoXML->save('datos.xml') . ' bytes';
   // Cargar el fichero XSL y transformar el XML
   $xsl = new DOMDocument;
   $xsl->load('transformacion.xsl');
   $proc = new XSLTProcessor;
   $proc->importStyleSheet($xsl);
   //cargo lo que quiero cargar (variable xml)
   echo $proc->transformToXML($nuevoXML);
    
}

?>