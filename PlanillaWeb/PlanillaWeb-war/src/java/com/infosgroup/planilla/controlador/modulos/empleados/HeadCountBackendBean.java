/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.empleados;

import com.infosgroup.planilla.modelo.entidades.Gerencia;
import com.infosgroup.planilla.modelo.entidades.GerenciaPK;
import com.infosgroup.planilla.modelo.estructuras.HeadCountModel;
import com.infosgroup.planilla.modelo.procesos.EmpleadosSessionBean;
import com.infosgroup.planilla.view.AbstractJSFPage;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author root
 */
@ManagedBean(name = "empleados$HeadCount")
@ViewScoped
public class HeadCountBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private EmpleadosSessionBean empleadosBean;

    @PostConstruct
    public void init() {
        raiz = new DefaultTreeNode("Raiz", null);
    }

    @Override
    protected void limpiarCampos() {
    }
// ===============================================================================================================
    private TreeNode raiz;

    public TreeNode getRaiz() {
        return raiz;
    }

    public void setRaiz(TreeNode raiz) {
        this.raiz = raiz;
    }
    private List<SelectItem> gerenciasModel;

    public List<SelectItem> getGerenciasModel() {
        List<Gerencia> listaGerencias = empleadosBean.listarGerencias(getSessionBeanADM().getCompania());
        gerenciasModel = new ArrayList<SelectItem>(0);
        gerenciasModel.add(new SelectItem("-1:0", "[ SELECCIONE UNA GERENCIA ]"));
        gerenciasModel.add(new SelectItem("1:0", "[ TODAS LAS GERENCIAS ]"));
        for (Gerencia gerencia : listaGerencias) {
            gerenciasModel.add(new SelectItem("" + gerencia.getGerenciaPK().getCodCia() + ":" + gerencia.getGerenciaPK().getCodGerencia(), gerencia.getNomGerencia()));
        }
        return gerenciasModel;
    }

    public void setGerenciasModel(List<SelectItem> gerenciasModel) {
        this.gerenciasModel = gerenciasModel;
    }
    private String gerenciaSeleccionada;

    public String getGerenciaSeleccionada() {
        return gerenciaSeleccionada;
    }

    public void setGerenciaSeleccionada(String gerenciaSeleccionada) {
        this.gerenciaSeleccionada = gerenciaSeleccionada;
    }

    public void generarHeadCount(AjaxBehaviorEvent e) {
        String[] gerenciaSel = gerenciaSeleccionada.split(":");
        GerenciaPK gerenciaPK = new GerenciaPK();

        if (gerenciaSel[0].equals("-1")) {
            raiz = new DefaultTreeNode("Raiz", null);
            return;
        }

        gerenciaPK.setCodCia(Short.parseShort(gerenciaSel[0]));
        gerenciaPK.setCodGerencia(Short.parseShort(gerenciaSel[1]));
        Gerencia gerencia = empleadosBean.findGerenciaByPK(gerenciaPK);
        List<HeadCountModel> listaHCM = empleadosBean.generarHeadCount(gerencia);
        List<Gerencia> listaGerencias = empleadosBean.listarGerencias(getSessionBeanADM().getCompania());
        raiz = new DefaultTreeNode("Raiz", null);
        TreeNode[] nodoGerencia = new TreeNode[listaGerencias.size()];
        for (Gerencia g : listaGerencias) {
            BigDecimal cantidad = BigDecimal.ZERO;
            BigDecimal salario = BigDecimal.ZERO;
            for (HeadCountModel hcm : listaHCM) {
                if (hcm.getIdGerencia().longValueExact() == g.getGerenciaPK().getCodGerencia()) {
                    cantidad = cantidad.add(hcm.getCantidad());
                    salario = salario.add(hcm.getSalario());
                }
            }
            if (cantidad == BigDecimal.ZERO) {
                continue;
            }
            nodoGerencia[((int) g.getGerenciaPK().getCodGerencia()) - 1] = new DefaultTreeNode(new HeadCountModel(BigDecimal.ZERO, BigDecimal.ZERO, g.getNomGerencia(), BigDecimal.ZERO, gerenciaSeleccionada, BigDecimal.ZERO, g.getNomGerencia(), cantidad, salario), raiz);
        }
        for (HeadCountModel hcm : listaHCM) {
            new DefaultTreeNode(hcm, nodoGerencia[hcm.getIdGerencia().intValueExact() - 1]);
        }
    }
}
