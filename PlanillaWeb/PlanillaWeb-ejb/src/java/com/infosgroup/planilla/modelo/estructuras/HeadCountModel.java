/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.estructuras;

import java.io.Serializable;
import java.math.BigDecimal;

/**
*
* @author root
*/
public class HeadCountModel implements Serializable
{
private BigDecimal idCompania;

private BigDecimal idGerencia;

private String nombreGerencia;

private BigDecimal idDepartamento;

private String nombreDepartamento;

private BigDecimal idSeccion;

private String nombreSeccion;

private BigDecimal idPuesto;

private String nombrePuesto;

private BigDecimal cantidad;

private BigDecimal salario;

public HeadCountModel(BigDecimal idCompania, BigDecimal idGerencia, String nombreGerencia, BigDecimal idDepartamento, String nombreDepartamento, BigDecimal idSeccion, String nombreSeccion, BigDecimal idPuesto, String nombrePuesto, BigDecimal cantidad, BigDecimal salario)
{
this.idCompania = idCompania;
this.idGerencia = idGerencia;
this.nombreGerencia = nombreGerencia;
this.idDepartamento = idDepartamento;
this.nombreDepartamento = nombreDepartamento;
this.idSeccion = idSeccion;
this.nombreSeccion = nombreSeccion;
this.idPuesto = idPuesto;
this.nombrePuesto = nombrePuesto;
this.cantidad = cantidad;
this.salario = salario;
}

public BigDecimal getCantidad()
{
return cantidad;
}

public void setCantidad(BigDecimal cantidad)
{
this.cantidad = cantidad;
}

public BigDecimal getIdCompania()
{
return idCompania;
}

public void setIdCompania(BigDecimal idCompania)
{
this.idCompania = idCompania;
}

public BigDecimal getIdDepartamento()
{
return idDepartamento;
}

public void setIdDepartamento(BigDecimal idDepartamento)
{
this.idDepartamento = idDepartamento;
}

public BigDecimal getIdGerencia()
{
return idGerencia;
}

public void setIdGerencia(BigDecimal idGerencia)
{
this.idGerencia = idGerencia;
}

public BigDecimal getIdPuesto()
{
return idPuesto;
}

public void setIdPuesto(BigDecimal idPuesto)
{
this.idPuesto = idPuesto;
}

public BigDecimal getIdSeccion()
{
return idSeccion;
}

public void setIdSeccion(BigDecimal idSeccion)
{
this.idSeccion = idSeccion;
}

public String getNombreDepartamento()
{
return nombreDepartamento;
}

public void setNombreDepartamento(String nombreDepartamento)
{
this.nombreDepartamento = nombreDepartamento;
}

public String getNombreGerencia()
{
return nombreGerencia;
}

public void setNombreGerencia(String nombreGerencia)
{
this.nombreGerencia = nombreGerencia;
}

public String getNombrePuesto()
{
return nombrePuesto;
}

public void setNombrePuesto(String nombrePuesto)
{
this.nombrePuesto = nombrePuesto;
}

public String getNombreSeccion()
{
return nombreSeccion;
}

public void setNombreSeccion(String nombreSeccion)
{
this.nombreSeccion = nombreSeccion;
}

public BigDecimal getSalario()
{
return salario;
}

public void setSalario(BigDecimal salario)
{
this.salario = salario;
}
}
