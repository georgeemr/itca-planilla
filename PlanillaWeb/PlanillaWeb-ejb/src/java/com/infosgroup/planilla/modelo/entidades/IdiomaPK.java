/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**

 @author root
 */
@Embeddable
public class IdiomaPK implements Serializable
{

@Basic(optional = false)
@NotNull
@Column(name = "COD_CIA", nullable = false)
private short codCia;
@Basic(optional = false)
@NotNull
@Column(name = "COD_IDIOMA", nullable = false)
private int codIdioma;

public IdiomaPK()
{
}

public IdiomaPK(short codCia, int codIdioma)
{
    this.codCia = codCia;
    this.codIdioma = codIdioma;
}

public short getCodCia()
{
    return codCia;
}

public void setCodCia(short codCia)
{
    this.codCia = codCia;
}

public int getCodIdioma()
{
    return codIdioma;
}

public void setCodIdioma(int codIdioma)
{
    this.codIdioma = codIdioma;
}

@Override
public int hashCode()
{
    int hash = 0;
    hash += (int) codCia;
    hash += (int) codIdioma;
    return hash;
}

@Override
public boolean equals(Object object)
{
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof IdiomaPK))
        {
        return false;
        }
    IdiomaPK other = (IdiomaPK) object;
    if (this.codCia != other.codCia)
        {
        return false;
        }
    if (this.codIdioma != other.codIdioma)
        {
        return false;
        }
    return true;
}

@Override
public String toString()
{
    return "com.infosgroup.planilla.modelo.entidades.IdiomaPK[ codCia=" + codCia + ", codIdioma=" + codIdioma + " ]";
}
}
