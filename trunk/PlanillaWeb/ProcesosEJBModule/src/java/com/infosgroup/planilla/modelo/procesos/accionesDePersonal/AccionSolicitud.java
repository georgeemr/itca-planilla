package com.infosgroup.planilla.modelo.procesos.accionesDePersonal;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import com.infosgroup.planilla.modelo.entidades.AccionPersonal;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author root
 */
public abstract class AccionSolicitud implements java.io.Serializable {

    private AccionPersonal accionPersonal;

    public AccionSolicitud(AccionPersonal accionPersonal) {
        this.accionPersonal = accionPersonal;
    }

    public abstract void efectuar();

    public PlanillaSessionBean planillaSessionBean() {
        try {
            Context c = new InitialContext();
            return (PlanillaSessionBean) c.lookup("java:global/PlanillaWeb/ProcesosEJBModule/PlanillaSessionBean!com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public AccionPersonal getAccionPersonal() {
        return accionPersonal;
    }

    public void setAccionPersonal(AccionPersonal accionPersonal) {
        this.accionPersonal = accionPersonal;
    }
}