/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.view;

/**
 *
 * @author root
 */
public abstract class AbstractCatalog extends AbstractJSFPage implements java.io.Serializable {

    private String accion = "nuevo";

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String nuevo$action() {
        setAccion("nuevo");
        limpiarCampos();
        return null;
    }

    public String consultar$action() {
        setAccion("consultar");
        return null;
    }

    public String editar$action() {
        setAccion("editar");
        return null;
    }

    public abstract String guardar$action();

    public abstract String remover$action();

    public abstract String actualizar$action();
}
