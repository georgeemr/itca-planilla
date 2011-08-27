/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.view;

import com.infosgroup.planilla.modelo.entidades.Menu;
import com.infosgroup.planilla.modelo.facades.MenuFacade;
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
@ManagedBean(name="menu")
@ViewScoped
public class BackendBeanMenu {
    
    @EJB
    private MenuFacade menuFacade;

    private MenuModel menuModel;
    
    public BackendBeanMenu() {
}

    public MenuModel getMenuModel() {
        menuModel = new DefaultMenuModel();
        
        /* Agregando los submenu */
        for (Menu s : menuFacade.findAll()) {
            Submenu submenu = new Submenu();
            submenu.setLabel(s.getTitulo());
            for (Menu o : s.getMenuList() ) {
                MenuItem item = new MenuItem();
                item.setValue(o.getTitulo());
                item.setUrl(o.getRuta());
                submenu.getChildren().add(item);
            }
            menuModel.addSubmenu(submenu);
        }

        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }
}
