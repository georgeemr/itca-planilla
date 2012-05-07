/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos.usuarios;

/**
 *
 * @author root
 */
public class UserNotFoundException extends ForethoughtException {

    private String username;
    private String firstName;
    private String lastName;

    public UserNotFoundException(String username) {
        super("A user with the username " + username + " could not be found.");
        this.username = username;
    }

    public UserNotFoundException(String firstName, String lastName) {
        super("A user with the name " + firstName + " " + lastName + " could not be found.");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
