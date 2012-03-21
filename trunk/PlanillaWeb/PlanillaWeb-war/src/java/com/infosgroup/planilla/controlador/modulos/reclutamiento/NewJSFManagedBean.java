/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.reclutamiento;

import com.infosgroup.planilla.view.AbstractJSFPage;
import java.io.Serializable;
import javax.annotation.security.PermitAll;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**

 @author root
 */
@ManagedBean(name = "NewJSFManagedBean")
@ViewScoped
public class NewJSFManagedBean extends AbstractJSFPage implements Serializable
{

@Override
protected void limpiarCampos()
{
    throw new UnsupportedOperationException("Not supported yet.");
}
private String texto;

public String getTexto()
{
    return texto;
}

public void setTexto(String texto)
{
    this.texto = texto;
}

@PermitAll
public String prueba$action()
{
    texto = null;
    return null;
}
}
