/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.planilla;

import com.infosgroup.planilla.modelo.entidades.*;
import com.infosgroup.planilla.modelo.procesos.PlanillaSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.AutocompleteProgramacionPlaConverter;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author root
 */
@ManagedBean(name = "planilla$CargarDatosBackendBean")
@ViewScoped
public class CargarDatosBackendBean extends AbstractJSFPage implements java.io.Serializable {

    @EJB
    private PlanillaSessionBean planillaSessionBean;
    private List<TiposPlanilla> listaTipos;
    private List<ProgramacionPla> listaPlanillas;
    private List<DeducPresta> listaDeduccionPrestacion;
    private Short tipoPlanilla = -1;
    private Integer deduccionPrestacion = -1;
    private String anio;
    private String mes;
    private String numeroPlanilla;
    private DeducPresta deduccionPrestacionSeleccionada;
    private Short empresa;
    private List<ResumenAsistencia> listaResumenAsistencia;

    public CargarDatosBackendBean() {
    }

    @PostConstruct
    public void _initPage() {
        empresa = getSessionBeanADM().getCompania().getCodCia();
        limpiarCampos();
    }
    private AutocompleteProgramacionPlaConverter programacionPlaConverter;
    private ProgramacionPla programacionPlaSeleccionada;

    public ProgramacionPla getProgramacionPlaSeleccionada() {
        return programacionPlaSeleccionada;
    }

    public void setProgramacionPlaSeleccionada(ProgramacionPla programacionPlaSeleccionada) {
        this.programacionPlaSeleccionada = programacionPlaSeleccionada;
    }

    public List<ProgramacionPla> completeProgramacionPla(String query) {
        List<ProgramacionPla> suggestions = new ArrayList<ProgramacionPla>();
        for (ProgramacionPla p : programacionPlaConverter.listaProgramacionPla) {
            if (p.getStringProgramacionPla().startsWith(query)) {
                suggestions.add(p);
            }
        }
        return suggestions;
    }

    public AutocompleteProgramacionPlaConverter getProgramacionPlaConverter() {
        if (tipoPlanilla != null && tipoPlanilla != -1) {
            programacionPlaConverter = new AutocompleteProgramacionPlaConverter(planillaSessionBean.getProgramacionPlaByTipo(getSessionBeanADM().getCompania().getCodCia(), tipoPlanilla));
        } else {
            programacionPlaConverter = new AutocompleteProgramacionPlaConverter(new ArrayList<ProgramacionPla>());
        }
        return programacionPlaConverter;
    }

    public void setProgramacionPlaConverter(AutocompleteProgramacionPlaConverter programacionPlaConverter) {
        this.programacionPlaConverter = programacionPlaConverter;
    }

    public List<ResumenAsistencia> getListaResumenAsistencia() {
        return listaResumenAsistencia;
    }

    public void setListaResumenAsistencia(List<ResumenAsistencia> listaResumenAsistencia) {
        this.listaResumenAsistencia = listaResumenAsistencia;
    }

    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile file = event.getFile();

        if (file == null) {
            addMessage("Carga de Datos", "Seleccione un archivo.", TipoMensaje.ERROR);
            return;
        }
        listaResumenAsistencia = new ArrayList<ResumenAsistencia>();
        try {

            InputStreamReader inputStreamReader = new InputStreamReader(file.getInputstream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (bufferedReader.ready()) {
                Integer codDeduccion = null;
                Integer codEmpleado = null;
                Short codEmpresa = null;
                Double valor = null;
                String linea = bufferedReader.readLine();
                String[] valores = linea.split(",");

                try {
                    codEmpresa = Short.parseShort(valores[0]);
                } catch (Exception excpt) {
                    codEmpresa = 0;
                }

                try {
                    codDeduccion = Integer.parseInt(valores[1]);
                } catch (Exception excpt) {
                    codDeduccion = 0;
                }

                try {
                    codEmpleado = Integer.parseInt(valores[2]);
                } catch (Exception excpt) {
                    codEmpleado = 0;
                }

                try {
                    valor = Double.parseDouble(valores[3]);
                } catch (Exception excpt) {
                    valor = 0.00d;
                }

                if (codDeduccion.equals(deduccionPrestacion) && codEmpresa.equals(empresa)) {
                    ResumenAsistencia r = planillaSessionBean.existeEnResumen(new ResumenAsistenciaPK(empresa, new Short(anio), new Short(mes), new Short(numeroPlanilla), codEmpleado, tipoPlanilla));
                    if (r != null) {
                        r.setValorTemp(valor);
                        listaResumenAsistencia.add(r);
                    }
                }
            }
            Set t = new HashSet();
            t.addAll(listaResumenAsistencia);
            listaResumenAsistencia.clear();
            listaResumenAsistencia.addAll(t);
            addMessage("Carga de Datos", "Datos obtenidos con exito, " + listaResumenAsistencia.size() + " empleados cargados.", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            addMessage("Carga de Datos", "Ha sido imposible reconocer la estructura del archivo seleccionado.", TipoMensaje.ERROR);
            e.printStackTrace();
        }
    }

    public Short getTipoPlanilla() {
        return tipoPlanilla;
    }

    public void setTipoPlanilla(Short tipoPlanilla) {
        this.tipoPlanilla = tipoPlanilla;
    }

    public String getAnio() {
        anio = programacionPlaSeleccionada != null ? programacionPlaSeleccionada.getAnio().toString() : "";//  split(":")[1] : "";
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getMes() {
        mes = programacionPlaSeleccionada != null ? programacionPlaSeleccionada.getMes().toString() : "";//planilla != null ? planilla.split(":")[2] : "";
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public DeducPresta getDeduccionPrestacionSeleccionada() {
        deduccionPrestacionSeleccionada = planillaSessionBean.findDeducPrestaByPK(new DeducPrestaPK(deduccionPrestacion, getSessionBeanADM().getCompania().getCodCia()));
        return deduccionPrestacionSeleccionada;
    }

    public void setDeduccionPrestacionSeleccionada(DeducPresta deduccionPrestacionSeleccionada) {
        this.deduccionPrestacionSeleccionada = deduccionPrestacionSeleccionada;
    }

    public String getNumeroPlanilla() {
        numeroPlanilla = programacionPlaSeleccionada != null ? programacionPlaSeleccionada.getNumPlanilla().toString() : ""; //planilla != null ? planilla.split(":")[3] : "";
        return numeroPlanilla;
    }

    public void setNumeroPlanilla(String numeroPlanilla) {
        this.numeroPlanilla = numeroPlanilla;
    }

    public Integer getDeduccionPrestacion() {
        return deduccionPrestacion;
    }

    public void setDeduccionPrestacion(Integer deduccionPrestacion) {
        this.deduccionPrestacion = deduccionPrestacion;
    }

    public List<DeducPresta> getListaDeduccionPrestacion() {
        listaDeduccionPrestacion = planillaSessionBean.findDeducPrestaByCias(getSessionBeanADM().getCompania());
        return listaDeduccionPrestacion;
    }

    public void setListaDeduccionPrestacion(List<DeducPresta> listaDeduccionPrestacion) {
        this.listaDeduccionPrestacion = listaDeduccionPrestacion;
    }

    public List<ProgramacionPla> getListaPlanillas() {
        if (tipoPlanilla != null && tipoPlanilla != -1) {
            listaPlanillas = planillaSessionBean.getProgramacionPlaByTipo(getSessionBeanADM().getCompania().getCodCia(), tipoPlanilla);
        }
        return listaPlanillas != null ? listaPlanillas : new ArrayList<ProgramacionPla>();
    }

    public void setListaPlanillas(List<ProgramacionPla> listaPlanillas) {
        this.listaPlanillas = listaPlanillas;
    }

    public List<TiposPlanilla> getListaTipos() {
        listaTipos = planillaSessionBean.listarTipos(getSessionBeanADM().getCompania());
        return listaTipos;
    }

    public void setListaTipos(List<TiposPlanilla> listaTipos) {
        this.listaTipos = listaTipos;
    }

    @Override
    protected void limpiarCampos() {
        tipoPlanilla = null;
        deduccionPrestacion = null;
        programacionPlaSeleccionada = null;
        listaResumenAsistencia = null;
    }

    public String procesar() {
        if (listaResumenAsistencia == null || listaResumenAsistencia.size() <= 0) {
            addMessage("Cargar Datos", "No se han ingresado datos para procesar.", TipoMensaje.ERROR);
            return null;
        }

        List<MovDp> listaMovDp = new ArrayList<MovDp>();
        for (ResumenAsistencia r : listaResumenAsistencia) {
            MovDp m = new MovDp();
            m.setDeducPresta(deduccionPrestacionSeleccionada);
            m.setDepartamentos(r.getEmpleados().getDepartamentos());
            m.setFactor(deduccionPrestacionSeleccionada.getFactor());
            m.setSumaResta(deduccionPrestacionSeleccionada.getSumaResta());
            m.setStatus("G");
            m.setValor(r.getValorTemp() != null ? new BigDecimal(r.getValorTemp()) : BigDecimal.ZERO);
            m.setBaseCalculo(r.getValorTemp() != null ? new BigDecimal(r.getValorTemp()) : BigDecimal.ZERO);
            m.setSecuencia(1);
            m.setFechaMovto(new Date());
            m.setVpr(deduccionPrestacionSeleccionada.getVpr());
            m.setGenerado("N");
            m.setResumenAsistencia(r);
            listaMovDp.add(m);
        }

        try {
            planillaSessionBean.cargarDatosResumenAsistencia(listaMovDp, empresa, new Short(anio), new Short(mes), tipoPlanilla, new Short(numeroPlanilla), deduccionPrestacion.shortValue());
            addMessage("Cargar Datos", "Datos procesados con exito.", TipoMensaje.INFORMACION);
            limpiarCampos();
        } catch (Exception e) {
            addMessage("Cargar Datos", "Ha ocurrido un error al intentar procesar los datos.", TipoMensaje.ERROR);
            e.printStackTrace();
        }
        return null;
    }
}