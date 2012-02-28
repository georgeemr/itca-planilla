/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Deptos;
import com.infosgroup.planilla.modelo.entidades.NivelAcademico;
import com.infosgroup.planilla.modelo.entidades.Profesion;
import java.io.Serializable;

/**

 @author root
 */
public class PreparacionAcademicaCandidato implements Serializable
{

private String nombreInstitucion;
private Deptos departamentoInstitucion;
private NivelAcademico nivelAcademico;
private Profesion profesion;
private Short anioIngreso;
private Short anioEgreso;

public String getNombreInstitucion()
{
    return nombreInstitucion;
}

public void setNombreInstitucion(String nombreInstitucion)
{
    this.nombreInstitucion = nombreInstitucion;
}

public Deptos getDepartamentoInstitucion()
{
    return departamentoInstitucion;
}

public void setDepartamentoInstitucion(Deptos departamentoInstitucion)
{
    this.departamentoInstitucion = departamentoInstitucion;
}

public NivelAcademico getNivelAcademico()
{
    return nivelAcademico;
}

public void setNivelAcademico(NivelAcademico nivelAcademico)
{
    this.nivelAcademico = nivelAcademico;
}

public Profesion getProfesion()
{
    return profesion;
}

public void setProfesion(Profesion profesion)
{
    this.profesion = profesion;
}

public Short getAnioIngreso()
{
    return anioIngreso;
}

public void setAnioIngreso(Short anioIngreso)
{
    this.anioIngreso = anioIngreso;
}

public Short getAnioEgreso()
{
    return anioEgreso;
}

public void setAnioEgreso(Short anioEgreso)
{
    this.anioEgreso = anioEgreso;
}
}
