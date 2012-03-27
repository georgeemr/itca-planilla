/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.view;

import com.infosgroup.planilla.modelo.entidades.Menu;
import com.infosgroup.planilla.modelo.facades.MenuFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

/**
 *
 * @author root
 */
@ManagedBean(name = "menu")
@ViewScoped
public class BackendBeanMenu extends AbstractJSFPage implements Serializable {

    @EJB
    private MenuFacade menuFacade;
    private MenuModel menuModel;

    @PermitAll
    public MenuModel getMenuModel() {
        List<Menu> n = new ArrayList<Menu>(),m = new ArrayList<Menu>();
        menuModel = new DefaultMenuModel();
        if (isInRole("rrhh")) {
            n = menuFacade.findAllEnOrden(getSessionBeanADM().getCompania(), "2");
            m = menuFacade.findAllSubMenu(getSessionBeanADM().getCompania(), "2");
        } else if (isInRole("empleados")) {
            n = menuFacade.findAllEnOrden(getSessionBeanADM().getCompania(), "1");
            m = menuFacade.findAllSubMenu(getSessionBeanADM().getCompania(), "1");
        } else if (isInRole("jefes")) {
            n = menuFacade.findAllEnOrden(getSessionBeanADM().getCompania(), "3");
            m = menuFacade.findAllSubMenu(getSessionBeanADM().getCompania(), "3");
        }
        return construyeArbol(n,m);
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    public MenuModel construyeArbol(List<Menu> e, List<Menu> f) {
        
        for (Menu s : e) {                              //Para cada uno de los elementos que vienen en la lista 
            if (s.getMenu() != null) {
                construyeArbol(s.getMenuList(), f);     //Si es padre iterar cada uno de sus hijos
            } else {
                Submenu submenu = new Submenu();        //de lo contrario agregar los items normalmente                 
                submenu.setLabel(s.getTitulo());
                Collections.sort(s.getMenuList());      //gb 12032012 ordenar los nodos hijos.
                for (Menu o : s.getMenuList()) {
                    if ( !f.contains(o) ) continue;
                    MenuItem item = new MenuItem();
                    item.setValue(o.getTitulo());
                    item.setUrl(o.getRuta());
                    submenu.getChildren().add(item);
                }
                menuModel.addSubmenu(submenu);
            }
        }
        return menuModel;
    }

    @Override
    protected void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}