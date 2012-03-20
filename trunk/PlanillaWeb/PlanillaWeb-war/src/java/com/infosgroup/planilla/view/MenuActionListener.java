/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.view;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author root
 */
public class MenuActionListener implements ActionListener {

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        System.err.println(event.getSource());
    }
}