<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="examen3estilos.css"/>
    </head>
    <body>

      <xsl:for-each select="datos/temporada/equipos/equipo">
        <table border="1">
          <tr>
            <th rowspan="6" style="background-color: orange; "><img src="escudos/{escudo}" width="50px"/></th>
            <th style="background-color: orange; ">Codigo Equipo</th>
            <th style="background-color: orange; ">Nombre Equipo</th>
            <th style="background-color: orange; ">Fundacion</th>
            <th colspan="3" style="background-color: orange; ">Presupuesto</th>
          </tr>
          <tr>
            <td><xsl:value-of select="codigoequipo"/></td>
            <td><xsl:value-of select="nombreequipo"/></td>
            <td><xsl:value-of select="fundacion"/></td>
            <td colspan="3"><xsl:value-of select="presupuesto"/></td>
          </tr>
          <tr>
            <th style="background-color: forestgreen; ">Codigo Jugador</th>
            <th style="background-color: forestgreen; ">Nombre Jugador</th>
            <th style="background-color: forestgreen; ">Edad</th>
            <th style="background-color: forestgreen; ">Sueldo</th>
            <th colspan="2" style="background-color: forestgreen; ">foto</th>
          </tr>
          <xsl:for-each select="jugadores/jugador">
            <tr>
              <td><xsl:value-of select="codigojugador"/></td>
              <td><xsl:value-of select="nombrejugador"/></td>
              <td><xsl:value-of select="edad"/></td>
              <td><xsl:value-of select="sueldo"/></td>
              <td colspan="2"><img src="jugadores/{foto}" width="50px"/></td>
            </tr>
          </xsl:for-each>
          <tr>
              <th style="background-color: fuchsia;" >Edad Media</th>
              <th style="background-color: fuchsia;"><xsl:value-of select="sum(jugadores/jugador/edad)  div  count(jugadores/jugador)"/></th>
              <th style="background-color: fuchsia;">Suma Sueldos</th>
              <th style="background-color: fuchsia;"><xsl:value-of select="sum(jugadores/jugador/sueldo)"/></th>
              <th style="background-color: fuchsia;">Balance</th>
              <th style="background-color: fuchsia;"><xsl:value-of select="presupuesto - sum(jugadores/jugador/sueldo)"/></th>
          </tr>
        </table>
      </xsl:for-each>

    </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
