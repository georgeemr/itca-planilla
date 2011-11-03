/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.view;

import com.infosgroup.planilla.modelo.entidades.Menu;
import com.infosgroup.planilla.modelo.facades.MenuFacade;
import java.io.Serializable;
import java.util.List;
import java.util.Stack;
import javax.ejb.EJB;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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
public class BackendBeanMenu implements Serializable {
    
    @EJB
    private MenuFacade menuFacade;
    private MenuModel menuModel;
    
    public BackendBeanMenu() {
    }
    ExpressionFactory expFact = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
    MethodExpression methodExpression = expFact.createMethodExpression(FacesContext.getCurrentInstance().getELContext(), "#{menu.seleccionMenu}", null, new Class<?>[0]);
    MenuActionListener mal = new MenuActionListener();
    
    public MenuModel getMenuModel() {
        menuModel = new DefaultMenuModel();
        return construyeArbol(menuFacade.findAll());
    }
    
    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }
    
    Integer subMenu = 0;
    Integer menu = 0;
    
    public MenuModel construyeArbol(List<Menu> e) {
        /* Para cada uno de los elementos que vienen en la lista */
        for (Menu s : e) {
            /* Ordenar todos los que son padres */
            if (s.getMenu() != null) {

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
                
            } else {
                /* de lo contrario agregar los items normalmente */
                Submenu submenu = new Submenu();
                //submenu.setId((++subMenu).toString());
                submenu.setLabel(s.getTitulo());                
                for (Menu o : s.getMenuList()) {
                    MenuItem item = new MenuItem();
                    //item.setValue("&diams;&nbsp;" +o.getTitulo());
                    //item.setId((++menu).toString());
                    item.setValue(o.getTitulo());
                    item.setUrl(o.getRuta());                    
                    item.addActionListener(mal);                    
                    submenu.getChildren().add(item);
                }
                menuModel.addSubmenu(submenu);
            }
        }
        return menuModel;
    }
    // ==============================================================================================
    private MenuModel modeloBreadCrumbs;
    
    public MenuModel getModeloBreadCrumbs() {
        modeloBreadCrumbs = new DefaultMenuModel();
        
        MenuItem homeItem = new MenuItem();
        homeItem.setValue("Home");
        //homeItem.setAjax(false);
        homeItem.setUrl("/faces/modulos/inicio.xhtml");

        //List<MenuItem> listaItems = new ArrayList<MenuItem>(0);
        MenuItem i = new MenuItem();
        i.setValue("Prueba");
        i.setActionExpression(methodExpression);
        i.addActionListener(mal);
        pilaBreadcrumb.push(i);
        
        modeloBreadCrumbs.addMenuItem(homeItem);
        for (MenuItem m : pilaBreadcrumb) {
            modeloBreadCrumbs.addMenuItem(m);
        }
        return modeloBreadCrumbs;
    }
    
    public void setModeloBreadCrumbs(MenuModel modeloBreadCrumbs) {
        this.modeloBreadCrumbs = modeloBreadCrumbs;
    }
    
  
    private Stack<MenuItem> pilaBreadcrumb = new Stack<MenuItem>();
    
    public Stack<MenuItem> getPilaBreadcrumb() {
        return pilaBreadcrumb;
    }
    
    public void setPilaBreadcrumb(Stack<MenuItem> pilaBreadcrumb) {
        this.pilaBreadcrumb = pilaBreadcrumb;
    }
    
    public void MenuActionListener(ActionEvent evt) {
        System.err.println(evt.getSource());
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
