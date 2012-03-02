/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.estructuras.DetalleEvaluacion;
import com.infosgroup.planilla.modelo.estructuras.HeadCountModel;
import com.infosgroup.planilla.modelo.estructuras.PreguntaRespuesta;
import com.infosgroup.planilla.modelo.facades.CampaniaFacade;
import com.infosgroup.planilla.modelo.facades.DetEvaluacionFacade;
import com.infosgroup.planilla.modelo.facades.EmpleadoFacade;
import com.infosgroup.planilla.modelo.facades.EvaluacionFacade;
import com.infosgroup.planilla.modelo.facades.FactorFacade;
import com.infosgroup.planilla.modelo.facades.GerenciaFacade;
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
public class EmpleadosSessionBean {

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

    public List<Campania> listarCampanias() {
        return campaniasFacade.findAll();
    }

    @PermitAll
    public List<Campania> listarCampaniasPorEmpleado(Empleados empleado) {
        return campaniasFacade.findByEmpleadoEvaluador(empleado);
    }
// 13022012  
//    public List<Plantilla> listarPlantillasPorTipoEvaluacion(TipoEvaluacion tipoEvaluacion) {
//        return (tipoEvaluacion != null) ? tipoEvaluacion.getPlantillaList() : null;
//    }

    public List<Factor> listarFactoresPorPlantilla(Plantilla plantilla) {
        return factorFacade.findByPlantilla(plantilla);
    }
    
// 13022012  
//    @PermitAll
//    public List<Pregunta> listarPreguntasPorFactor(Factor factor) {
//        return (factor != null) ? factor.getPreguntaList() : null;
//    }

    public Respuesta findRespuestaById(RespuestaPK pk) {
        return respuestaFacade.find(pk);
    }

    public List<Evaluacion> listarEvaluacionesAbiertasPorCampania(Campania campania) {
        return evaluacionFacade.findEvaluacionesAbiertasByCampania(campania);
    }

    public boolean cerrarEvaluacion(Evaluacion ev, List<DetalleEvaluacion> det) {
        boolean result = true;
        Integer i = 1;
        try {
            for (DetalleEvaluacion d : det) {
                List<PreguntaRespuesta> preguntasRespuestasList = d.getRespuestas();
                for (PreguntaRespuesta pr : preguntasRespuestasList) {
                    DetEvaluacionPK detEvaluacionPK = new DetEvaluacionPK();
                    detEvaluacionPK.setCodCia(ev.getEvaluacionPK().getCodCia());
// 13022012                     detEvaluacionPK.setPeriodo(ev.getEvaluacionPK().getPeriodo());
                    detEvaluacionPK.setCodCampania(ev.getEvaluacionPK().getCodCampania());
//   13022012                   detEvaluacionPK.setEmpleado(ev.getEvaluacionPK().getEmpleado());
//   13022012                   detEvaluacionPK.setTipoEvaluacion(ev.getEvaluacionPK().getTipoEvaluacion());
//   13022012                   detEvaluacionPK.setCodDetEvaluacion(i++);

                    DetEvaluacion detEvaluacion = new DetEvaluacion();
                    detEvaluacion.setEvaluacion(ev);
                    detEvaluacion.setDetEvaluacionPK(detEvaluacionPK);
//   13022012                   detEvaluacion.setPregunta(pr.getPregunta());
//   13022012                   detEvaluacion.setRespuesta(pr.getRespuesta());

                    detalleEvaluacionFacade.create(detEvaluacion);
                }
            }
//   13022012           ev.setFinalizada(1L);
            evaluacionFacade.edit(ev);
        } catch (Exception excpt) {
            result = false;
        }
        return result;
    }

//  13022012    public List<PuestoEmpleado> listarPuestosEmpleados() {
//        return puestoEmpleadoFacade.findAll();
//    }

    public List<Empleados> listarEmpleadosEvaluados(Campania c) {
        return empleadosFacade.findEmpleadosEvaluados(c);
    }

    public List<Empleados> listarEmpleadosNoEvaluados(Campania c) {
        return empleadosFacade.findEmpleadosNoEvaluados(c);
    }

    public Empleados buscarEmpleadoPorUsuario(String usuario) throws javax.persistence.NoResultException {
        return empleadosFacade.findByUsuario(usuario);
    }

    public Empleados buscarEmpleadoPorPK(EmpleadosPK empleadoPK) {
        return empleadosFacade.find(empleadoPK);
    }

    public List<Puestos> listarPuestos() {
        return puestoFacade.findAll();
    }

    public List<TipoEvaluacion> listarTiposEvaluacion() {
        return tipoEvaluacionFacade.findAll();
    }

    @PermitAll
    public Integer crearEvaluaciones(List<Evaluacion> listaEvaluaciones) {
        Integer excepciones = 0;
        for (Evaluacion evaluacion : listaEvaluaciones) {
            try {
                evaluacionFacade.create(evaluacion);
            } catch (Exception excpt) {
                excepciones++;
            }
        }
        return excepciones;
    }

    public Boolean tieneEvaluaciones(Campania c) {
        return (evaluacionFacade.findEvaluacionesByCampania(c) != 0);
    }

    @PermitAll
    public Integer asignarEvaluaciones(List<Evaluacion> listaEvaluaciones, Empleados evaluador) {
        Integer excepciones = 0;
//    13022012      List<Evaluacion> evaluacionesActuales = evaluador.getEvaluacionList();
//        for (Evaluacion evaluacion : listaEvaluaciones) {
//            if (!evaluacionesActuales.contains(evaluacion)) {
//                evaluacionesActuales.add(evaluacion);
//            }
//        }
//        try {
//            evaluador.setEvaluacionList(evaluacionesActuales);
//            empleadosFacade.edit(evaluador);
//        } catch (Exception excpt) {
//            excepciones += listaEvaluaciones.size();
//        }
        return excepciones;
    }

    @PermitAll
    public List<Gerencia> listarGerencias(Cias cias) {
        return gerenciaFacade.findGerenciasByCias(cias);
    }

    @PermitAll
    public List<HeadCountModel> generarHeadCount(Gerencia gerencia) {
        List<HeadCountModel> lista = new ArrayList<HeadCountModel>(0);
        List<Object> listaResultado = gerenciaFacade.generarHeadCount(gerencia);
        for (Object o : listaResultado) {
            Object[] fila = (Object[]) o;
            HeadCountModel hcm = new HeadCountModel((BigDecimal) fila[0], (BigDecimal) fila[1], (String) fila[2], (BigDecimal) fila[3], (String) fila[4], (BigDecimal) fila[5], (String) fila[6], (BigDecimal) fila[7], (BigDecimal) fila[8]);
            lista.add(hcm);
        }
        return lista;
    }

    @PermitAll
    public Gerencia findGerenciaByPK(GerenciaPK gerenciaPK) {
        return gerenciaFacade.find(gerenciaPK);
    }

    public List<Empleados> listarEmpleados() {
        return empleadosFacade.findAll();
    }

    @PermitAll
    public Integer calcularEmpleadosEvaluados(Campania c) {
        Integer r;
        r = campaniasFacade.calcularEmpleadosEvaluados(c);
        return r;
    }

    @PermitAll
    public void editarCampania(Campania c) {
        campaniasFacade.edit(c);
    }

    @PermitAll
    public List<Campania> findAllByCia(Short empresa) {
        return campaniasFacade.findAllByCia(empresa);
    }
}
