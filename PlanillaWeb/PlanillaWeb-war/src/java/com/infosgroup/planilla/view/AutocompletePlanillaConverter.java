/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.view;

import com.infosgroup.planilla.modelo.entidades.Planilla;
import com.infosgroup.planilla.modelo.entidades.ProgramacionPla;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author root
 */
@FacesConverter("AutocompletePlanillaConverter")
public class AutocompletePlanillaConverter implements javax.faces.convert.Converter {

    public List<Planilla> listaPlanilla = new ArrayList<Planilla>();

    public AutocompletePlanillaConverter(List<Planilla> listaPlanilla) {
        this.listaPlanilla = listaPlanilla;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("")) {
            return null;
        } else {
            for (Planilla p : listaPlanilla) {
                if (p.getPkAsString().equals(value)) {
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(value);
        }
    }
}
