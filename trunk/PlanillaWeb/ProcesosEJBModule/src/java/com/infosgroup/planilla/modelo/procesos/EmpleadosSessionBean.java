/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.Campania;
import com.infosgroup.planilla.modelo.entidades.DetEvaluacion;
import com.infosgroup.planilla.modelo.entidades.DetEvaluacionPK;
import com.infosgroup.planilla.modelo.entidades.Empleado;
import com.infosgroup.planilla.modelo.entidades.Evaluacion;
import com.infosgroup.planilla.modelo.entidades.EvaluacionPK;
import com.infosgroup.planilla.modelo.entidades.Factor;
import com.infosgroup.planilla.modelo.entidades.Plantilla;
import com.infosgroup.planilla.modelo.entidades.Pregunta;
import com.infosgroup.planilla.modelo.entidades.Respuesta;
import com.infosgroup.planilla.modelo.entidades.RespuestaPK;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.DetalleEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.PreguntaRespuesta;
import com.infosgroup.planilla.modelo.facades.CampaniaFacade;
import com.infosgroup.planilla.modelo.facades.DetEvaluacionFacade;
import com.infosgroup.planilla.modelo.facades.EmpleadoFacade;
import com.infosgroup.planilla.modelo.facades.EvaluacionFacade;
import com.infosgroup.planilla.modelo.facades.FactorFacade;
import com.infosgroup.planilla.modelo.facades.RespuestaFacade;
import com.infosgroup.planilla.modelo.facades.TipoEvaluacionFacade;
import java.util.Calendar;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

import java.util.List;
import javax.ejb.EJB;

/**
*
* @author root
*/
@Stateless
@LocalBean
public class EmpleadosSessionBean
{
@EJB
private CampaniaFacade campaniasFacade;

@EJB
private TipoEvaluacionFacade tipoEvaluacionFacade;

@EJB
private EmpleadoFacade empleadosFacade;

@EJB
private FactorFacade factorFacade;

@EJB
private RespuestaFacade respuestaFacade;

@EJB
private EvaluacionFacade evaluacionFacade;

@EJB
private DetEvaluacionFacade detalleEvaluacionFacade;

public List<Campania> listarCampanias()
{
return campaniasFacade.findAll();
}

public List<TipoEvaluacion> listarTiposEvaluacion()
{
return tipoEvaluacionFacade.findAll();
}

public List<Plantilla> listarPlantillasPorTipoEvaluacion(TipoEvaluacion tipoEvaluacion)
{
return (tipoEvaluacion != null) ? tipoEvaluacion.getPlantillaList() : null;
}

public List<Empleado> listarEmpleados()
{
return empleadosFacade.findAll();
}

public List<Factor> listarFactoresPorPlantilla(Plantilla plantilla)
{
return factorFacade.findByPlantilla(plantilla);
}

public List<Pregunta> listarPreguntasPorFactor(Factor factor)
{
return (factor != null) ? factor.getPreguntaList() : null;
}

public Respuesta findRespuestaById(RespuestaPK pk)
{
return respuestaFacade.find(pk);
}

public boolean cerrarEvaluacion(Campania c, TipoEvaluacion t, Plantilla p, Empleado e, List<DetalleEvaluacion> det)
{
boolean result = true;
Integer i = 1;
try
    {
    EvaluacionPK evaluacionPK = new EvaluacionPK();
    evaluacionPK.setCodCia(c.getCampaniaPK().getCodCia());
    evaluacionPK.setCodCampania(c.getCampaniaPK().getCodCampania());
    evaluacionPK.setPeriodo(c.getCampaniaPK().getPeriodo());
    evaluacionPK.setTipoEvaluacion(t.getTipoEvaluacionPK().getCodTipoEvaluacion());
    evaluacionPK.setEmpleado(e.getEmpleadoPK().getCodEmp());

    Evaluacion ev = new Evaluacion();
    ev.setEvaluacionPK(evaluacionPK);
    ev.setCampania(c);
    ev.setPlantilla(p);
    ev.setEmpleado1(e);
    ev.setFecha(Calendar.getInstance().getTime());
    ev.setFinalizada(1);
    evaluacionFacade.create(ev);

    ev = evaluacionFacade.find(evaluacionPK);

    for (DetalleEvaluacion d : det)
        {
        List<PreguntaRespuesta> preguntasRespuestasList = d.getRespuestas();
        for (PreguntaRespuesta pr : preguntasRespuestasList)
            {
            DetEvaluacionPK detEvaluacionPK = new DetEvaluacionPK();
            detEvaluacionPK.setCodCia(ev.getEvaluacionPK().getCodCia());
            detEvaluacionPK.setPeriodo(ev.getEvaluacionPK().getPeriodo());
            detEvaluacionPK.setCodCampania(ev.getEvaluacionPK().getCodCampania());
            detEvaluacionPK.setEmpleado(ev.getEvaluacionPK().getEmpleado());
            detEvaluacionPK.setTipoEvaluacion(ev.getEvaluacionPK().getTipoEvaluacion());
            detEvaluacionPK.setCodDetEvaluacion(i++);
            //detEvaluacionPK.setCodDetEvaluacion(detalleEvaluacionFacade.max(ev.getEvaluacionPK())+1);                

            DetEvaluacion detEvaluacion = new DetEvaluacion();
            detEvaluacion.setEvaluacion(ev);
            detEvaluacion.setDetEvaluacionPK(detEvaluacionPK);
            detEvaluacion.setPregunta(pr.getPregunta());
            detEvaluacion.setRespuesta(pr.getRespuesta());

            detalleEvaluacionFacade.create(detEvaluacion);
            }
        }
    }
catch (Exception excpt)
    {
    result = false;
    }
return result;
}

public List<Empleado> listarEmpleadosNoEvaluados(Campania c)
{
return empleadosFacade.findEmpleadosNoEvaluados(c);
}
}
