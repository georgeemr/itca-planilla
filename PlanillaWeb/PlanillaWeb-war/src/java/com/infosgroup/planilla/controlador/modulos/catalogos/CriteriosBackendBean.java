/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.catalogos;

import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.AbstractCatalog;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */
@ManagedBean(name = "criteriosBackendBean")
@ViewScoped
public class CriteriosBackendBean extends AbstractCatalog implements java.io.Serializable {

    public CriteriosBackendBean() {
    }

    @Override
    protected void limpiarCampos() {

    }

    @Override
    public String guardar$action() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String remover$action() {
        return null;
    }

    @Override
    public String actualizar$action() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
