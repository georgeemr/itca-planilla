/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.controlador.modulos.administracion;

import com.infosgroup.planilla.modelo.entidades.Rol;
import com.infosgroup.planilla.modelo.entidades.RolPK;
import com.infosgroup.planilla.modelo.entidades.Usuario;
import com.infosgroup.planilla.modelo.entidades.UsuarioPK;
import com.infosgroup.planilla.modelo.facades.RolFacade;
import com.infosgroup.planilla.modelo.facades.UsuarioFacade;
import com.infosgroup.planilla.view.JSFUtil;
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
public class UsuarioBackendBean extends JSFUtil implements Serializable {

    @EJB
    private RolFacade rolFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    private List<Rol> listaRoles;
    private String usuario;
    private String password;
    private Usuario usuarioSeleccionado;
    private List<Usuario> listaUsuarios;
    private Integer rolSeleccionado;

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
            addErrorMessage("Mantenimiento Usuarios.", "Usuario es un campo obligatorio.");
            return null;
        }

        if (password == null) {
            addErrorMessage("Mantenimiento Usuarios.", "Password es un campo obligatorio.");
            return null;
        }
        Usuario u = new Usuario();
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
            addInfoMessage("Mantenimiento Usuarios.", "Usuario creado éxitosamente.");
            limpiarCampos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public String eliminar_action() {

        try {
            usuarioFacade.remove(usuarioSeleccionado);
            addInfoMessage("Mantenimiento Usuarios.", "Usuario eliminado éxitosamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String actualizar_action() {
        try {
            usuarioFacade.edit(null);
            limpiarCampos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String cancelar_action() {
        setUsuarioSeleccionado(null);
        limpiarCampos();
        return null;
    }

    public List<Usuario> getListaUsuarios() {
        return usuarioFacade.findAll();
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public void onRowSelect(SelectEvent event) {
        Usuario u = (Usuario) event.getObject();
        setUsuario(u.getNomUsuario());
        setPassword(u.getPassword());
        setRolSeleccionado(u.getRol().getRolPK().getIdRol());
    }

    public List<Rol> getListaRoles() {
        return rolFacade.findAll();
    }

    public void setListaRoles(List<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public Integer getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Integer rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    @Override
    protected void limpiarCampos() {
        setUsuario(null);
        setPassword(null);
    }
}
