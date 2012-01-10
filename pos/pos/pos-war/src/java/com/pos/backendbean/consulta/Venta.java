/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.backendbean.consulta;

import com.pos.applicationbean.ApplicationBeanPOS;
import com.pos.backendbean.JSFUtil;
import com.pos.ejb.AgenciasFacade;
import com.pos.ejb.consulta.SessionBeanConsulta;
import com.pos.entity.Agencias;
import com.pos.model.AdapterConsulta;
import com.pos.model.FormatoReporte;
import com.pos.model.MontoSucursal;
import com.pos.model.Producto;
import com.pos.model.TipoConsulta;
import com.pos.sessionbean.SessionBeanSEG;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import org.primefaces.event.DateSelectEvent;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Soporte
 */
@ManagedBean(name = "venta")
@RequestScoped
public class Venta extends JSFUtil implements Serializable {

    @NotNull(message = "Seleccione la fecha inicial")
    private Date fechaInicial;
    @NotNull(message = "Seleccione la fecha final")
    private Date fechaFinal;
    private List<Producto> listaProductos = new ArrayList<Producto>();
    private List<Agencias> listaAgencias = new ArrayList<Agencias>();
    @EJB
    private AgenciasFacade agencias;
    @EJB
    private SessionBeanConsulta sessionBeanConsulta;
    private Integer codigoAgencia;
    //private PieChartModel pieModel;

//    public PieChartModel getPieModel() {
//        return pieModel;
//    }
//
//    public void setPieModel(PieChartModel pieModel) {
//        this.pieModel = pieModel;
//    }

    public Venta() {
        listaProductos.clear();
        listaProductos.add(new Producto("1", "Combos", "prueba", new Long("0"), new BigDecimal("0")));
        listaProductos.add(new Producto("2", "Otros productos", "prueba", new Long("0"), new BigDecimal("0")));
        //createPieModel();
    }

    public Date getFechaFinal() {
        return this.fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial() {
        return this.fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void seleccionaFechaInicial(DateSelectEvent event) {
        this.fechaInicial = event.getDate();
    }

    public void seleccionaFechaFinal(DateSelectEvent event) {
        this.fechaFinal = event.getDate();
    }

    public List<Agencias> getListaAgencias() {
        listaAgencias = agencias.getAgenciasAConsultar(getSessionBeanSEG().getCodCia());
        return listaAgencias;
    }

    public void setListaAgencias(List<Agencias> listaAgencias) {
        this.listaAgencias = listaAgencias;
    }

    public Integer getCodigoAgencia() {
        return codigoAgencia;
    }

    public void setCodigoAgencia(Integer codigoAgencia) {
        this.codigoAgencia = codigoAgencia;
    }

    public String consultaOperaciones() {

        if (validaFormulario() == false) {
            return null;
        }

        AdapterConsulta adapter = sessionBeanConsulta.consultaOperaciones(getSessionBeanSEG().getCodCia(), codigoAgencia, fechaInicial, fechaFinal, TipoConsulta.TIEMPO_REAL);

        listaProductos.clear();
        Producto combo = new Producto();
        Producto otrosProductos = new Producto();

        if (adapter.getSucursalesConectadas().size() > 0) {
            /* Iterando todas las sucursales con las que se pudo conectar */
            for (MontoSucursal itemsMonto : adapter.getSucursalesConectadas()) {
                if (itemsMonto.getTipo().equals("c")) {
                    combo.setCantidad(combo.getCantidad() + itemsMonto.getCantidad());
                    combo.setNombre("Combos");
                    combo.setTotal(itemsMonto.getMonto());
                } else if (itemsMonto.getTipo().equals("o")) {
                    otrosProductos.setCantidad(otrosProductos.getCantidad() + itemsMonto.getCantidad());
                    otrosProductos.setNombre("Otros productos");
                    otrosProductos.setTotal(itemsMonto.getMonto());
                }
            }

            listaProductos.add(combo);
            listaProductos.add(otrosProductos);
        } else {
            listaProductos.add(new Producto("1", "Combos", "", new Long("0"), new BigDecimal("0")));
            listaProductos.add(new Producto("2", "Otros productos", "", new Long("0"), new BigDecimal("0")));
        }

        return null;
    }

    public String consultaOperacionesEst() {

        if (validaFormulario() == false) {
            return null;
        }

        AdapterConsulta adapter = sessionBeanConsulta.consultaOperaciones(getSessionBeanSEG().getCodCia(), codigoAgencia, fechaInicial, fechaFinal, TipoConsulta.CONSOLIDADO);

        listaProductos.clear();
        Producto combo = new Producto();
        Producto otrosProductos = new Producto();

        if (adapter.getSucursalesConectadas().size() > 0) {
            /* Iterando todas las sucursales con las que se pudo conectar */
            for (MontoSucursal itemsMonto : adapter.getSucursalesConectadas()) {
                if (itemsMonto.getTipo().equals("c")) {
                    combo.setCantidad(combo.getCantidad() + itemsMonto.getCantidad());
                    combo.setNombre("Combos");
                    combo.setDescripcion(itemsMonto.getSucursal());
                    combo.setTotal(combo.getTotal().add(itemsMonto.getMonto()));

                } else if (itemsMonto.getTipo().equals("o")) {
                    otrosProductos.setCantidad(otrosProductos.getCantidad() + itemsMonto.getCantidad());
                    otrosProductos.setNombre("Otros productos");
                    otrosProductos.setDescripcion("");
                    otrosProductos.setTotal(otrosProductos.getTotal().add(itemsMonto.getMonto()));
                }
            }
            listaProductos.add(combo);
            listaProductos.add(otrosProductos);
        } else {
            listaProductos.add(new Producto("1", "Combos", "", new Long("0"), new BigDecimal("0")));
            listaProductos.add(new Producto("2", "Otros productos", "", new Long("0"), new BigDecimal("0")));
        }
        return null;
    }

    public Boolean validaFormulario() {
        if (fechaFinal.before(fechaInicial)) {
            addWarn("Error de validacion", "La fecha final no puede ser menor que la inicial");
            return false;
        }
        return true;
    }

    public String imprimirReporte() {
        if (validaFormulario() == false) {
            return null;
        }
        Map fillParams = new HashMap();
        try {
            fillParams.put("FECHA_INICIO", new java.text.SimpleDateFormat("dd/MM/yyyy").format(fechaInicial));
            fillParams.put("FECHA_FIN", new java.text.SimpleDateFormat("dd/MM/yyyy").format(fechaFinal));
            fillParams.put("CIA", getSessionBeanSEG().getCodCia().toString());
            fillParams.put("CONDICION", codigoAgencia.toString());
            getApplicationBeanPOS().imprimirReport(fillParams, "ConsultaVentas", FormatoReporte.PDF);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar mostrar reporte de ventas.. \n" + e.getMessage());
        }
        return null;
    }

    protected SessionBeanSEG getSessionBeanSEG() {
        return (SessionBeanSEG) getBean("SessionBeanSEG");
    }

    protected ApplicationBeanPOS getApplicationBeanPOS() {
        return (ApplicationBeanPOS) getBean("ApplicationBeanPOS");
    }
    /*
    private void createPieModel() {
        pieModel = new PieChartModel();
        pieModel.set("Biggest Escalon", 540);
        pieModel.set("Biggest Camino al puerto", 325);
    }*/
}
