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
import com.infosgroup.planilla.modelo.entidades.Factor;
import com.infosgroup.planilla.modelo.entidades.Gerencia;
import com.infosgroup.planilla.modelo.entidades.GerenciaPK;
import com.infosgroup.planilla.modelo.entidades.Plantilla;
import com.infosgroup.planilla.modelo.entidades.Pregunta;
import com.infosgroup.planilla.modelo.entidades.Puesto;
import com.infosgroup.planilla.modelo.entidades.PuestoEmpleado;
import com.infosgroup.planilla.modelo.entidades.Respuesta;
import com.infosgroup.planilla.modelo.entidades.RespuestaPK;
import com.infosgroup.planilla.modelo.entidades.TipoEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.DetalleEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.HeadCountModel;
import com.infosgroup.planilla.modelo.estructuras.PreguntaRespuesta;
import com.infosgroup.planilla.modelo.facades.CampaniaFacade;
import com.infosgroup.planilla.modelo.facades.DetEvaluacionFacade;
import com.infosgroup.planilla.modelo.facades.EmpleadoFacade;
import com.infosgroup.planilla.modelo.facades.EvaluacionFacade;
import com.infosgroup.planilla.modelo.facades.FactorFacade;
import com.infosgroup.planilla.modelo.facades.GerenciaFacade;
import com.infosgroup.planilla.modelo.facades.PuestoEmpleadoFacade;
import com.infosgroup.planilla.modelo.facades.PuestoFacade;
import com.infosgroup.planilla.modelo.facades.RespuestaFacade;
import com.infosgroup.planilla.modelo.facades.TipoEvaluacionFacade;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

import java.util.List;
import javax.annotation.security.PermitAll;
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
private EmpleadoFacade empleadosFacade;

@EJB
private PuestoEmpleadoFacade puestoEmpleadoFacade;

@EJB
private FactorFacade factorFacade;

@EJB
private RespuestaFacade respuestaFacade;

@EJB
private DetEvaluacionFacade detalleEvaluacionFacade;

@EJB
private EvaluacionFacade evaluacionFacade;

@EJB
private PuestoFacade puestoFacade;

@EJB
private TipoEvaluacionFacade tipoEvaluacionFacade;

@EJB
private GerenciaFacade gerenciaFacade;

public List<Campania> listarCampanias()
{
return campaniasFacade.findAll();
}

@PermitAll
public List<Campania> listarCampaniasPorEmpleado(Empleado empleado)
{
return campaniasFacade.findByEmpleadoEvaluador(empleado);
}

public List<Plantilla> listarPlantillasPorTipoEvaluacion(TipoEvaluacion tipoEvaluacion)
{
return (tipoEvaluacion != null) ? tipoEvaluacion.getPlantillaList() : null;
}

public List<Factor> listarFactoresPorPlantilla(Plantilla plantilla)
{
return factorFacade.findByPlantilla(plantilla);
}

@PermitAll
public List<Pregunta> listarPreguntasPorFactor(Factor factor)
{
return (factor != null) ? factor.getPreguntaList() : null;
}

public Respuesta findRespuestaById(RespuestaPK pk)
{
return respuestaFacade.find(pk);
}

public List<Evaluacion> listarEvaluacionesAbiertasPorCampania(Campania campania)
{
return evaluacionFacade.findEvaluacionesAbiertasByCampania(campania);
}

public boolean cerrarEvaluacion(Evaluacion ev, List<DetalleEvaluacion> det)
{
boolean result = true;
Integer i = 1;
try
    {
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

            DetEvaluacion detEvaluacion = new DetEvaluacion();
            detEvaluacion.setEvaluacion(ev);
            detEvaluacion.setDetEvaluacionPK(detEvaluacionPK);
            detEvaluacion.setPregunta(pr.getPregunta());
            detEvaluacion.setRespuesta(pr.getRespuesta());

            detalleEvaluacionFacade.create(detEvaluacion);
            }
        }
    ev.setFinalizada(1L);
    evaluacionFacade.edit(ev);
    }
catch (Exception excpt)
    {
    result = false;
    }
return result;
}

public List<PuestoEmpleado> listarPuestosEmpleados()
{
return puestoEmpleadoFacade.findAll();
}

public List<Empleado> listarEmpleadosEvaluados(Campania c)
{
return empleadosFacade.findEmpleadosEvaluados(c);
}

public List<Empleado> listarEmpleadosNoEvaluados(Campania c)
{
return empleadosFacade.findEmpleadosNoEvaluados(c);
}

public Empleado buscarEmpleadoPorUsuario(String usuario)
{
return empleadosFacade.findByUsuario(usuario);
}

public List<Puesto> listarPuestos()
{
return puestoFacade.findAll();
}

public List<TipoEvaluacion> listarTiposEvaluacion()
{
return tipoEvaluacionFacade.findAll();
}

@PermitAll
public Integer crearEvaluaciones(List<Evaluacion> listaEvaluaciones)
{
Integer excepciones = 0;
for (Evaluacion evaluacion : listaEvaluaciones)
    {
    try
        {
        evaluacionFacade.create(evaluacion);
        }
    catch (Exception excpt)
        {
        excepciones++;
        }
    }
return excepciones;
}

@PermitAll
public Integer asignarEvaluaciones(List<Evaluacion> listaEvaluaciones, Empleado evaluador)
{
Integer excepciones = 0;
List<Evaluacion> evaluacionesActuales = evaluador.getEvaluacionList();
for (Evaluacion evaluacion : listaEvaluaciones)
    {
    if (!evaluacionesActuales.contains(evaluacion))
        {
        evaluacionesActuales.add(evaluacion);
        }
    }
try
    {
    evaluador.setEvaluacionList(evaluacionesActuales);
    empleadosFacade.edit(evaluador);
    }
catch (Exception excpt)
    {
    excepciones += listaEvaluaciones.size();
    }
return excepciones;
}

@PermitAll
public List<Gerencia> listarGerencias()
{
return gerenciaFacade.findAll();    
}

@PermitAll
public List<HeadCountModel> generarHeadCount(Gerencia gerencia)
{
List<HeadCountModel> lista = new ArrayList<HeadCountModel>(0);    
List<Object> listaResultado = gerenciaFacade.generarHeadCount(gerencia);
for (Object o : listaResultado)
    {
    Object[] fila = (Object[]) o ;
    HeadCountModel hcm = new HeadCountModel((BigDecimal) fila[0], (BigDecimal) fila[1], (String) fila[2], (BigDecimal) fila[3], (String) fila[4], (BigDecimal) fila[5], (String) fila[6], (BigDecimal) fila[7], (String) fila[8], (BigDecimal) fila[9], (BigDecimal) fila[10]);
    lista.add(hcm);
    }
return lista;
}

@PermitAll
public Gerencia findGerenciaByPK(GerenciaPK gerenciaPK)
{
return gerenciaFacade.find(gerenciaPK);
}
}
