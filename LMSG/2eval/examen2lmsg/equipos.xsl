<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <section class="xml">
      <table border="1">
        <tr>
          <th>Código</th> 
          <th>Nombre</th>
          <th>Creación</th>
          <th>Número Jugadores</th>
          <th>Presupuesto</th>
          <th>Ganados</th>
          <th>Perdidos</th>
          <th>Puntos</th>
        </tr>
            <xsl:for-each select="//equipo">
            <xsl:sort select="ganados"  data-type="number" order="descending"></xsl:sort>
            <xsl:sort select="perdidos"  data-type="number" order="ascending"></xsl:sort>
            <xsl:variable name="puntos" select="ganados * 3"/>
              <tr>
                <td><xsl:value-of select="codigo"/></td>
                <td><xsl:value-of select="nombre"/></td>
                <td><xsl:value-of select="creacion"/></td>
                <td><xsl:value-of select="plantilla"/></td>
                <td><xsl:value-of select="presupuesto"/></td>
                <td><xsl:value-of select="ganados"/></td>
                <td><xsl:value-of select="perdidos"/></td>
                <td><xsl:value-of select="$puntos"/></td>
              </tr>
            </xsl:for-each>
            <xsl:variable name="count" select="count(//equipo/codigo)"/>
            <xsl:variable name="suma" select=" sum(//equipo/ganados) * 3"/>

            <tr>
              <td>Numero de Equipos</td>
              <td colspan="3"><xsl:value-of select="$count"/></td>
              <td>Media de Puntos</td>
              <td colspan="3" class="Mediapuntos">
                <xsl:value-of select=" $suma div $count"/>
              </td>
            </tr>
      </table>
    </section>
  </xsl:template>
</xsl:stylesheet>
