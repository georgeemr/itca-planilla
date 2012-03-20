/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.view;

import com.infosgroup.planilla.modelo.entidades.PruebaXPuesto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Gabriel Bran
 */
@FacesConverter("AutocompletePruebaConverter")
public class AutocompletePruebaConverter implements javax.faces.convert.Converter {

    public List<PruebaXPuesto> listaPruebaXPuesto = new ArrayList<PruebaXPuesto>();

    public AutocompletePruebaConverter(List<PruebaXPuesto> listaPruebaXPuesto) {
        this.listaPruebaXPuesto = listaPruebaXPuesto;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("")) {
            return null;
        } else {
            try {
                for (PruebaXPuesto p : listaPruebaXPuesto) {
                    if (p.getPruebaToString().equals( value )) {
                        return p;
                    }
                }

            } catch (NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversion", "No es una prueba valida"));
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
