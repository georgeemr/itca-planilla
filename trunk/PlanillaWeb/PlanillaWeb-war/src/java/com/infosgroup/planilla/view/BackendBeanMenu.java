/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.view;

import com.infosgroup.planilla.modelo.entidades.Menu;
import com.infosgroup.planilla.modelo.facades.MenuFacade;
import java.io.Serializable;
import java.util.List;
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
public class BackendBeanMenu implements Serializable{

    @EJB
    private MenuFacade menuFacade;
    private MenuModel menuModel;
    public BackendBeanMenu() {
    }

    public MenuModel getMenuModel() {
        menuModel = new DefaultMenuModel();
        return construyeArbol(menuFacade.findAll());
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }
    
    public MenuModel construyeArbol(List<Menu> e){
        
        /* Para cada uno de los elementos que vienen en la lista */
        for (Menu s : e) {
            /* Ordenar todos los que son padres */
            if(s.getMenu() != null){
                
//                Submenu submenu = new Submenu();
//                submenu.setLabel(s.getTitulo());
//                for (Menu o : s.getMenuList()) {
//                    MenuItem item = new MenuItem();
//                    item.setValue(o.getTitulo());                
//                    item.setUrl(o.getRuta());
//                    submenu.getChildren().add(item);
//                }     
//                menuModel.addSubmenu(submenu);
                /* Si es padre iterar cada uno de sus hijos */
                construyeArbol(s.getMenuList());
                
            }else{
                /* de lo contrario agregar los items normalmente */
                Submenu submenu = new Submenu();
                submenu.setLabel(s.getTitulo());
                for (Menu o : s.getMenuList()) {
                    MenuItem item = new MenuItem();
                    //item.setValue("&diams;&nbsp;" +o.getTitulo());                
                    item.setValue(o.getTitulo());
                    item.setUrl(o.getRuta());
                    submenu.getChildren().add(item);
                }     
                menuModel.addSubmenu(submenu);
            }
          
        }
        
        return menuModel;
    }
    
    
}


/*
             if (s.getMenu() == null ){
                Submenu submenu = new Submenu();
                submenu.setLabel(s.getTitulo());
                for (Menu o : s.getMenuList()) {
                    MenuItem item = new MenuItem();
                    item.setValue(o.getTitulo());                
                    item.setUrl(o.getRuta());
                    submenu.getChildren().add(item);
                }     
                menuModel.addSubmenu(submenu);
            }  */