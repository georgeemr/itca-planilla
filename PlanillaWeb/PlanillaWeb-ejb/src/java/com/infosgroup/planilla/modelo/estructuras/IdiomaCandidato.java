/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.estructuras;

import com.infosgroup.planilla.modelo.entidades.Idioma;
import java.io.Serializable;

/**

 @author root
 */
public class IdiomaCandidato implements Serializable
{

private Idioma idioma;
private Boolean lee;
private Boolean escribe;
private Integer nivel;

public Idioma getIdioma()
{
    return idioma;
}

public void setIdioma(Idioma idioma)
{
    this.idioma = idioma;
}

public Boolean getLee()
{
    return lee;
}

public void setLee(Boolean lee)
{
    this.lee = lee;
}

public Boolean getEscribe()
{
    return escribe;
}

public void setEscribe(Boolean escribe)
{
    this.escribe = escribe;
}

public Integer getNivel()
{
    return nivel;
}

public void setNivel(Integer nivel)
{
    this.nivel = nivel;
}
}
