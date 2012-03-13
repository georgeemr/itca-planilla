/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos.accionesDePersonal;

import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.entidades.Empleados;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;

/**
 *
 * @author root
 */
public class NombramientoAction extends AccionSolicitud implements java.io.Serializable {

    public NombramientoAction(AccionPersonal accionPersonal) {
        super(accionPersonal);
    }

    @Override
    public void efectuar() {
        Empleados e = getAccionPersonal().getEmpleados();
        e.setPuestos(getAccionPersonal().getNuevoPuesto());
        e.setDepartamentos(getAccionPersonal().getNuevoDepartamento());
        planillaSessionBean().actualizarEmpleado(e);
    }
}
