/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.planilla.modelo.procesos.usuarios;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 *
 * @author root
 */
public class ForethoughtException extends Exception {

    /**
     * The root cause generating this exception
     */
    private Throwable cause;

    public ForethoughtException(String msg) {
        super(msg);
    }

    public ForethoughtException(String msg, Throwable cause) {
        super(msg);
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        if (cause != null) {
            return super.getMessage() + ": " + cause.getMessage();
        } else {
            return super.getMessage();
        }
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        if (cause != null) {
            System.err.print("Root cause: ");
            cause.printStackTrace();
        }
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
        if (cause != null) {
            s.print("Root cause: ");
            cause.printStackTrace(s);
        }
    }

    @Override
    public void printStackTrace(PrintWriter w) {
        super.printStackTrace(w);
        if (cause != null) {
            w.print("Root cause: ");
            cause.printStackTrace(w);
        }
    }

    @Override
    public Throwable getCause() {
        return cause;
    }
}
