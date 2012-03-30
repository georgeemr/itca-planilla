/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**

 @author root
 */
@ManagedBean(name = "empleados$campania")
@ViewScoped
public class CampaniaBackendBean extends AbstractJSFPage implements Serializable
{

@EJB
private EmpleadosSessionBean empleadosBean;
private List<TipoEvaluacion> tipoEvaluacionTableModel;
private List<Plantilla> plantillaTableModel;

public List<Plantilla> getPlantillaTableModel()
{
    if (tipoEvaluacionSeleccionada != null)
        plantillaTableModel = empleadosBean.listarPlantillasPorTipoEvaluacion(tipoEvaluacionSeleccionada);
    return plantillaTableModel;
}

public void setPlantillaTableModel(List<Plantilla> plantillaTableModel)
{
    this.plantillaTableModel = plantillaTableModel;
}

public List<TipoEvaluacion> getTipoEvaluacionTableModel()
{
    return tipoEvaluacionTableModel;
}

public void setTipoEvaluacionTableModel(List<TipoEvaluacion> tipoEvaluacionTableModel)
{
    this.tipoEvaluacionTableModel = tipoEvaluacionTableModel;
}
// =========================================================================================================
private TipoEvaluacion tipoEvaluacionSeleccionada;
private Plantilla plantillaSeleccionada;

public Plantilla getPlantillaSeleccionada()
{
    return plantillaSeleccionada;
}

public void setPlantillaSeleccionada(Plantilla plantillaSeleccionada)
{
    this.plantillaSeleccionada = plantillaSeleccionada;
}

public TipoEvaluacion getTipoEvaluacionSeleccionada()
{
    return tipoEvaluacionSeleccionada;
}

public void setTipoEvaluacionSeleccionada(TipoEvaluacion tipoEvaluacionSeleccionada)
{
    this.tipoEvaluacionSeleccionada = tipoEvaluacionSeleccionada;
}

// =========================================================================================================
@Override
protected void limpiarCampos()
{
    throw new UnsupportedOperationException("Not supported yet.");
}
// =========================================================================================================
@PostConstruct
public void init()
{
    accion = CREANDO;
    tipoEvaluacionTableModel = empleadosBean.listarTiposEvaluacion(getSessionBeanADM().getCompania());
}

public String guardarCampania$action()
{
    if (!validarCampos())
        return null;
    switch (accion)
        {
        case CREANDO:
            guardarCampania();
            accion = CREANDO;
            break;
        case EDITANDO:
            editarCampania(preevaluacionSeleccionada);
            accion = CREANDO;
            break;
        }
    return null;
}

public String editarCampania$action()
{
    if (preevaluacionSeleccionada != null)
        {
        Campania campania = preevaluacionSeleccionada.getCampania();
        nombre = campania.getNomCampania();
        fechaInicial = campania.getFechaInicial();
        fechaFinal = campania.getFechaFinal();
        periodo = campania.getCampaniaPK().getPeriodo();
        nota = campania.getNota().doubleValue();
        tipoEvaluacionSeleccionada = preevaluacionSeleccionada.getTipoEvaluacion1();
        plantillaSeleccionada = preevaluacionSeleccionada.getPlantilla1();
        accion = EDITANDO;
        }
    else
        {
        addMessage("InfoswebRRHH", "Seleccione una campa&ntilde;a", TipoMensaje.INFORMACION);
        }
    return null;
}

public String cancelar$action()
{
    nombre = null;
    fechaInicial = null;
    fechaFinal = null;
    periodo = null;
    nota = null;
    accion = CREANDO;
    preevaluacionSeleccionada = null;
    tipoEvaluacionSeleccionada = null;
    plantillaSeleccionada = null;
    return null;
}

private boolean validarCampos()
{
    List<String> listaMensajes = new ArrayList<String>();
    boolean formValido = true;
    if ((nombre == null) || nombre.trim().isEmpty())
        {
        listaMensajes.add("Ingrese el nombre de la campa&ntilde;a");
        formValido = false;
        }
    if (periodo == null)
        {
        listaMensajes.add("Ingrese el periodo de la campa&ntilde;a");
        formValido = false;
        }
    if (fechaInicial == null)
        {
        listaMensajes.add("Seleccione la fecha inicial de la campa&ntilde;a");
        formValido = false;
        }
    if (fechaFinal == null)
        {
        listaMensajes.add("Seleccione la fecha final de la campa&ntilde;a");
        formValido = false;
        }
//    if ((estado == null) || estado.equals("0"))
//        {
//        listaMensajes.add("Seleccione el estado de la campa&ntilde;a");
//        formValido = false;
//        }
    if (nota == null)
        {
        listaMensajes.add("Ingrese la nota de la campa&ntilde;a");
        formValido = false;
        }
    if (tipoEvaluacionSeleccionada == null)
        {
        listaMensajes.add("Seleccione el tipo de evaluaci&oacute;n");
        formValido = false;
        }
    if (plantillaSeleccionada == null)
        {
        listaMensajes.add("Seleccione la plantilla");
        formValido = false;
        }
    for (String mensaje : listaMensajes)
        addMessage("Infosweb RRHH", mensaje, TipoMensaje.INFORMACION);
    return formValido;
}

private void guardarCampania()
{
    try
        {
        CampaniaPK campaniaPK = new CampaniaPK();

        campaniaPK.setCodCia(getSessionBeanADM().getCompania().getCodCia());
        campaniaPK.setPeriodo(periodo);
        campaniaPK.setCodCampania(empleadosBean.maxCampania(getSessionBeanADM().getCompania()).shortValue());

        Campania campania = new Campania(campaniaPK);
        campania.setNomCampania(nombre);
        campania.setFechaInicial(fechaInicial);
        campania.setFechaFinal(fechaFinal);
        campania.setEstado("G");
        campania.setNota(new BigDecimal(nota));

        empleadosBean.crearCampania(campania);

        campania = empleadosBean.findCampaniaByPK(campaniaPK);

        PreEvaluacionPK preevaluacionPK = new PreEvaluacionPK();
        preevaluacionPK.setCodCia(campania.getCampaniaPK().getCodCia());
        preevaluacionPK.setCodCampania(campania.getCampaniaPK().getCodCampania());
        preevaluacionPK.setPeriodo(campania.getCampaniaPK().getPeriodo());
        preevaluacionPK.setTipoEvaluacion(tipoEvaluacionSeleccionada.getTipoEvaluacionPK().getCodTipoEvaluacion());
        preevaluacionPK.setPlantilla(plantillaSeleccionada.getPlantillaPK().getCodPlantilla());
        PreEvaluacion preEvaluacion = new PreEvaluacion(preevaluacionPK);

        preEvaluacion.setCampania(campania);
        preEvaluacion.setTipoEvaluacion1(tipoEvaluacionSeleccionada);
        preEvaluacion.setPlantilla1(plantillaSeleccionada);

        empleadosBean.crearPreEvaluacion(preEvaluacion);

        addMessage("Infosweb RRHH", "Campa&ntilde;a creada exitosamente", TipoMensaje.INFORMACION);

        nombre = null;
        periodo = null;
        fechaInicial = null;
        fechaFinal = null;
        nota = null;
        preevaluacionSeleccionada = null;
        tipoEvaluacionSeleccionada = null;
        plantillaSeleccionada = null;
        }
    catch (Exception e)
        {
        e.printStackTrace(System.err);
        addMessage("Infosweb RRHH", "Ocurrió un error al guardar la campa&ntilde;a", TipoMensaje.ERROR);
        }
}

private void editarCampania(PreEvaluacion p)
{
    if (p == null)
        {
        addMessage("Infosweb RRHH", "Seleccione la campa&tilde;a", TipoMensaje.ADVERTENCIA);
        return;
        }
    try
        {
        Campania campania = empleadosBean.findCampaniaByPK(p.getCampania().getCampaniaPK());
        campania.setNomCampania(nombre);
        campania.setFechaInicial(fechaInicial);
        campania.setFechaFinal(fechaFinal);
        campania.setEstado("G");
        campania.setNota(new BigDecimal(nota));

        empleadosBean.editarCampania(campania);

        p.setCampania(campania);
        p.setTipoEvaluacion1(tipoEvaluacionSeleccionada);
        p.setPlantilla1(plantillaSeleccionada);
        empleadosBean.editarPreEvaluacion(p);

        addMessage("Infosweb RRHH", "Campa&ntilde;a editada exitosamente", TipoMensaje.INFORMACION);

        nombre = null;
        periodo = null;
        fechaInicial = null;
        fechaFinal = null;
        nota = null;
        preevaluacionSeleccionada = null;
        tipoEvaluacionSeleccionada = null;
        plantillaSeleccionada = null;
        }
    catch (Exception e)
        {
        e.printStackTrace(System.err);
        addMessage("Infosweb RRHH", "Ocurrió un error al guardar la campa&ntilde;a", TipoMensaje.ERROR);
        }
}
// ====================================================================================================================
private String nombre;
private Integer periodo;
private Date fechaInicial;
private Date fechaFinal;
private String estado;
private Double nota;

public String getEstado()
{
    return estado;
}

public void setEstado(String estado)
{
    this.estado = estado;
}

public Date getFechaFinal()
{
    return fechaFinal;
}

public void setFechaFinal(Date fechaFinal)
{
    this.fechaFinal = fechaFinal;
}

public Date getFechaInicial()
{
    return fechaInicial;
}

public void setFechaInicial(Date fechaInicial)
{
    this.fechaInicial = fechaInicial;
}

public String getNombre()
{
    return nombre;
}

public void setNombre(String nombre)
{
    this.nombre = nombre;
}

public Double getNota()
{
    return nota;
}

public void setNota(Double nota)
{
    this.nota = nota;
}

public Integer getPeriodo()
{
    return periodo;
}

public void setPeriodo(Integer periodo)
{
    this.periodo = periodo;
}
// ============================================================
private static final int CREANDO = 1;
private static final int EDITANDO = 2;
private int accion = 0;

public int getAccion()
{
    return accion;
}

public void setAccion(int accion)
{
    this.accion = accion;
}
// ============================================================================================================
private List<PreEvaluacion> listaPreevaluaciones;

public List<PreEvaluacion> getListaPreevaluaciones()
{
    listaPreevaluaciones = empleadosBean.findPreevaluacionByCias(getSessionBeanADM().getCompania());
    return listaPreevaluaciones;
}

public void setListaPreevaluaciones(List<PreEvaluacion> listaPreevaluaciones)
{
    this.listaPreevaluaciones = listaPreevaluaciones;
}
private PreEvaluacion preevaluacionSeleccionada;

public PreEvaluacion getPreevaluacionSeleccionada()
{
    return preevaluacionSeleccionada;
}

public void setPreevaluacionSeleccionada(PreEvaluacion preevaluacionSeleccionada)
{
    this.preevaluacionSeleccionada = preevaluacionSeleccionada;
}
}