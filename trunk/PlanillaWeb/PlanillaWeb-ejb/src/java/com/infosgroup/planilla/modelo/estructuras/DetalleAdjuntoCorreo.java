/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.estructuras;

import java.io.Serializable;

/**
*
* @author root
*/
public class DetalleAdjuntoCorreo implements Serializable
{
private String nombreArchivo;

private String tipoMIME;

private Object datos;

public DetalleAdjuntoCorreo(String nombreArchivo, String tipoMIME, Object datos)
{
this.nombreArchivo = nombreArchivo;
this.tipoMIME = tipoMIME;
this.datos = datos;
}

public Object getDatos()
{
return datos;
}

public void setDatos(Object datos)
{
this.datos = datos;
}

public String getNombreArchivo()
{
return nombreArchivo;
}

public void setNombreArchivo(String nombreArchivo)
{
this.nombreArchivo = nombreArchivo;
}

public String getTipoMIME()
{
return tipoMIME;
}

public void setTipoMIME(String tipoMIME)
{
this.tipoMIME = tipoMIME;
}
}
