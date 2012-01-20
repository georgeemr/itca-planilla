/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.administracion;

import com.infosgroup.planilla.modelo.entidades.Rol;
import com.infosgroup.planilla.modelo.entidades.RolPK;
import com.infosgroup.planilla.modelo.facades.RolFacade;
import com.infosgroup.planilla.view.AbstractJSFPage;
import com.infosgroup.planilla.view.TipoMensaje;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author root
 */
@ManagedBean(name = "usuarioBackendBean")
@ViewScoped
public class UsuarioBackendBean extends AbstractJSFPage implements Serializable {

    @EJB
    private RolFacade rolFacade;

    private List<Rol> listaRoles;
    private String usuario;
    private String password;
    private Long rolSeleccionado;

    public UsuarioBackendBean() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String guardar_action() {

        if (usuario == null) {
            addMessage("Mantenimiento Usuarios.", "Usuario es un campo obligatorio.", TipoMensaje.ERROR);
            return null;
        }

        if (password == null) {
            addMessage("Mantenimiento Usuarios.", "Password es un campo obligatorio.", TipoMensaje.ERROR);
            return null;
        }
/*        Usuario u = new Usuario();
        UsuarioPK pk = new UsuarioPK();
        u.setNomUsuario(usuario);
        u.setPassword(password);
        u.setRol(rolFacade.find(new RolPK(getSessionBeanADM().getCompania().getIdCompania(), rolSeleccionado)));
        pk.setIdCompania(getSessionBeanADM().getCompania().getIdCompania());
        //pk.setIdUsuario(usuarioFacade.max(getSessionBeanADM().getCompania().getIdCompania()));
        pk.setIdUsuario(usuarioFacade.count());
        u.setUsuarioPK(pk);
        try {
            usuarioFacade.create(u);
            addMessage("Mantenimiento Usuarios.", "Usuario creado éxitosamente.", TipoMensaje.INFORMACION);
            limpiarCampos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

        return null;
    }

    public String eliminar_action() {

        try {
            //usuarioFacade.remove(usuarioSeleccionado);
            addMessage("Mantenimiento Usuarios.", "Usuario eliminado éxitosamente.", TipoMensaje.INFORMACION);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String actualizar_action() {
        try {
            //usuarioFacade.edit(null);
            limpiarCampos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String cancelar_action() {
//        setUsuarioSeleccionado(null);
        limpiarCampos();
        return null;
    }

//    public List<Usuario> getListaUsuarios() {
//        return usuarioFacade.findAll();
//    }
//
//    public void setListaUsuarios(List<Usuario> listaUsuarios) {
//        this.listaUsuarios = listaUsuarios;
//    }
//
//    public Usuario getUsuarioSeleccionado() {
//        return usuarioSeleccionado;
//    }

//    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
//        this.usuarioSeleccionado = usuarioSeleccionado;
//    }

//    public void onRowSelect(SelectEvent event) {
//        Usuario u = (Usuario) event.getObject();
//        setUsuario(u.getNomUsuario());
//        setPassword(u.getPassword());
//        setRolSeleccionado(u.getRol().getRolPK().getIdRol());
//    }

    public List<Rol> getListaRoles() {
        return rolFacade.findAll();
    }

    public void setListaRoles(List<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public Long getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Long rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    @Override
    protected void limpiarCampos() {
        setUsuario(null);
        setPassword(null);
    }
}
