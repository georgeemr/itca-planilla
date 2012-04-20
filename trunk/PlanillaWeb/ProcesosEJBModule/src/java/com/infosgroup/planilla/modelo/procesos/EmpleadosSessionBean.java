/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.estructuras.DetalleEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.HeadCountModel;
import com.infosgroup.planilla.modelo.estructuras.PreguntaRespuesta;
import com.infosgroup.planilla.modelo.facades.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**

 @author root
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
@EJB
private PreguntaFacade preguntaFacade;
@EJB
private PlantillaFacade plantillaFacade;
@EJB
private PreEvaluacionFacade preEvaluacionFacade;
@EJB
private EvaluadorFacade evaluadorFacade;
@EJB
private EvaluadoFacade evaluadoFacade;

@PermitAll
public List<Evaluador> findEvaluadoresByPreEvaluacion(PreEvaluacion preEvaluacion)
{
    return evaluadorFacade.findByPreEvaluacion(preEvaluacion);
}

@PermitAll
public void guardarEvaluador(Evaluador evaluador)
{
    evaluadorFacade.create(evaluador);
}

@PermitAll
public void eliminarEvaluador(Evaluador evaluador)
{
    evaluadorFacade.remove(evaluador);
}

@PermitAll
public void eliminarEvaluado(Evaluado evaluado)
{
    evaluadoFacade.remove(evaluado);
}

@PermitAll
public void guardarEvaluado(Evaluado evaluado)
{
    evaluadoFacade.create(evaluado);
}


@PermitAll
public void eliminarEvaluados(Evaluador evaluador)
{
evaluadoFacade.eliminarEvaluados(evaluador);
}

@PermitAll
public void editarEvaluador(Evaluador evaluador)
{
    evaluadorFacade.edit(evaluador);
}

@PermitAll
public List<Campania> listarCampanias(Cias cia)
{
    return campaniasFacade.findAllByCia(cia.getCodCia());
}

@PermitAll
public List<PreEvaluacion> findPreevaluacionByCias(Cias cias)
{
    return preEvaluacionFacade.findPreevaluacionByCias(cias);
}

@PermitAll
public List<Campania> listarCampaniasPorEmpleado(Empleados empleado)
{
    return campaniasFacade.findByEmpleadoEvaluador(empleado);
}

@PermitAll
public List<Plantilla> listarPlantillasPorTipoEvaluacion(TipoEvaluacion tipoEvaluacion)
{
    return plantillaFacade.findPlantillasByTipoEvaluacion(tipoEvaluacion);
    //return (tipoEvaluacion != null) ? tipoEvaluacion.getPlantillaList() : null;
}

@PermitAll
public List<Factor> listarFactoresPorPlantilla(Plantilla plantilla)
{
    return factorFacade.findByPlantilla(plantilla);
}

@PermitAll
public List<Pregunta> listarPreguntasPorFactor(Factor factor)
{
    return preguntaFacade.findPreguntasByFactor(factor);
    //return (factor != null) ? factor.getPreguntaList() : null;
}

@PermitAll
public Respuesta findRespuestaById(RespuestaPK pk)
{
    return respuestaFacade.find(pk);
}

@PermitAll
public List<Evaluacion> listarEvaluacionesAbiertasPorCampania(Campania campania, Empleados empleado)
{
    return evaluacionFacade.findEvaluacionesAbiertasByCampania(campania, empleado);
}

@PermitAll
public List<Evaluacion> listarEvaluacionesAbiertasPorCampania(Campania campania)
{
    return evaluacionFacade.findEvaluacionesAbiertasByCampania(campania);
}

@PermitAll
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
                detEvaluacionPK.setCodCampania(ev.getEvaluacionPK().getCodCampania());
                detEvaluacionPK.setTipoEvaluacion(new Short("" + ev.getEvaluacionPK().getTipoEvaluacion()));
                detEvaluacionPK.setCodEmp(ev.getEmpleados().getEmpleadosPK().getCodEmp());
                detEvaluacionPK.setPeriodo(new Short("" + ev.getCampania().getCampaniaPK().getPeriodo()));
                detEvaluacionPK.setCodDetEvaluacion(i++);
                
                DetEvaluacion detEvaluacion = new DetEvaluacion();
                detEvaluacion.setEvaluacion(ev);
                detEvaluacion.setValor( pr.getValor() );
                detEvaluacion.setDetEvaluacionPK(detEvaluacionPK);
                detEvaluacion.setPregunta(preguntaFacade.find(pr.getPregunta().getPreguntaPK()));
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

@PermitAll
public List<Empleados> listarPuestosEmpleados(Cias cia)
{
    //return empleadosFacade.findAll();
    return empleadosFacade.findEmpleadosByCias(cia);
}

@PermitAll
public List<Empleados> listarEmpleadosEvaluados(Campania c)
{
    return empleadosFacade.findEmpleadosEvaluados(c);
}

@PermitAll
public List<Empleados> listarEmpleadosNoEvaluados(Campania c)
{
    return empleadosFacade.findEmpleadosNoEvaluados(c);
}

@PermitAll
public Empleados buscarEmpleadoPorUsuario(String usuario) throws javax.persistence.NoResultException
{
    return empleadosFacade.findByUsuario(usuario);
}

@PermitAll
public Empleados buscarEmpleadoPorPK(EmpleadosPK empleadoPK)
{
    return empleadosFacade.find(empleadoPK);
}

@PermitAll
public List<Puestos> listarPuestos()
{
    return puestoFacade.findAll();
}

@PermitAll
public List<TipoEvaluacion> listarTiposEvaluacion(Cias c)
{
    return tipoEvaluacionFacade.findByCompania(c);
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

public Boolean tieneEvaluaciones(Campania c)
{
    return (evaluacionFacade.findEvaluacionesByCampania(c) != 0);
}

@PermitAll
public Integer asignarEvaluaciones(List<Evaluacion> listaEvaluaciones, Empleados evaluador)
{
    Integer excepciones = 0;
    List<Evaluacion> evaluacionesActuales = evaluador.getEvaluacionList();
    for (Evaluacion evaluacion : listaEvaluaciones)
        if (!evaluacionesActuales.contains(evaluacion))
            evaluacionesActuales.add(evaluacion);
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
public List<Gerencia> listarGerencias(Cias cias)
{
    return gerenciaFacade.findGerenciasByCias(cias);
}

@PermitAll
public List<HeadCountModel> generarHeadCount(Gerencia gerencia)
{
    List<HeadCountModel> lista = new ArrayList<HeadCountModel>(0);
    List<Object> listaResultado = gerenciaFacade.generarHeadCount(gerencia);
    for (Object o : listaResultado)
        {
        Object[] fila = (Object[]) o;
        HeadCountModel hcm = new HeadCountModel((BigDecimal) fila[0], (BigDecimal) fila[1], (String) fila[2], (BigDecimal) fila[3], (String) fila[4], (BigDecimal) fila[5], (String) fila[6], (BigDecimal) fila[7], (BigDecimal) fila[8]);
        lista.add(hcm);
        }
    return lista;
}

@PermitAll
public Gerencia findGerenciaByPK(GerenciaPK gerenciaPK)
{
    return gerenciaFacade.find(gerenciaPK);
}

@PermitAll
public List<Empleados> listarEmpleados()
{
    return empleadosFacade.findAll();
}

@PermitAll
public Integer calcularEmpleadosEvaluados(Campania c)
{
    Integer r;
    r = campaniasFacade.calcularEmpleadosEvaluados(c);
    return r;
}

@PermitAll
public void editarCampania(Campania c)
{
    campaniasFacade.edit(c);
}

@PermitAll
public Campania findCampaniaByPK(CampaniaPK campaniaPK)
{
    return campaniasFacade.find(campaniaPK);
}

@PermitAll
public List<Campania> findAllByCia(Short empresa)
{
    return campaniasFacade.findAllByCia(empresa);
}

@PermitAll
public List<Empleados> findEmpleadosByCias(Cias empresa)
{
    return empleadosFacade.findEmpleadosByCias(empresa);
}

@PermitAll
public Integer maxCampania(Cias cia)
{
    return campaniasFacade.max(cia);
}

@PermitAll
public void crearCampania(Campania c)
{
    campaniasFacade.create(c);
}

@PermitAll
public void crearPreEvaluacion(PreEvaluacion p)
{
preEvaluacionFacade.create(p);
}


@PermitAll    
public List<Empleados> findEmpleadosByJefe(Empleados jefe) {
return empleadosFacade.findEmpleadosByJefe(jefe);
}

@PermitAll    
public List<Evaluado> findEvaluadosByJefe(Evaluador evaluador) {
    List<Empleados> l = findEmpleadosByJefe(evaluador.getEmpleados());
    List<Evaluado> evls = new ArrayList<Evaluado>();
    for( Empleados e :l ){
        evls.add( new Evaluado(evaluador, e) );
    }
    return evls;
}

@PermitAll
public void editarPreEvaluacion(PreEvaluacion p)
{
preEvaluacionFacade.edit(p);
}

}
