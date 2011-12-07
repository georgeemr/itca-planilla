/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.infosgroup.planilla.modelo.procesos;

import com.infosgroup.planilla.modelo.estructuras.DetalleAdjuntoCorreo;
import java.util.List;
import javax.activation.DataHandler;
import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
*
* @author root
*/
@Stateless(name = "MailStatelessBean")
@LocalBean
public class MailStatelessBean
{
// Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method")
@Resource(name = "mail/gmailSession")
private Session mailSession;

@PermitAll
public void enviarCorreoElectronico(String titulo, String contenido, String destinatarios)
{
Message msg = new MimeMessage(mailSession);
try
    {
    msg.setSubject(titulo);
    String[] arrayDestinatarios = destinatarios.split(":");
    for (String destinatario : arrayDestinatarios)
        msg.addRecipient(RecipientType.TO, new InternetAddress(destinatario));
    msg.setText(contenido);
    Transport.send(msg);
    }
catch (Exception excpt)
    {
    excpt.printStackTrace(System.err);
    }
}

@PermitAll
public void enviarCorreoElectronicoAdjuntos(String titulo, String contenido, String destinatarios, List<DetalleAdjuntoCorreo> adjuntos)
{
Message msg = new MimeMessage(mailSession);
try
    {
    msg.setSubject(titulo);
    String[] arrayDestinatarios = destinatarios.split(":");
    for (String destinatario : arrayDestinatarios)
        msg.addRecipient(RecipientType.TO, new InternetAddress(destinatario));
    Multipart contenidoCorreo = new MimeMultipart();
    BodyPart texto = new MimeBodyPart();
    texto.setText(contenido);
    contenidoCorreo.addBodyPart(texto);
    for (DetalleAdjuntoCorreo adjunto : adjuntos)
        {
        BodyPart datos = new MimeBodyPart();
        datos.setDataHandler(new DataHandler(adjunto.getDatos(), adjunto.getTipoMIME()));
        datos.setFileName(adjunto.getNombreArchivo());
        contenidoCorreo.addBodyPart(datos);
        }
    msg.setContent(contenidoCorreo);
    Transport.send(msg);
    }
catch (Exception excpt)
    {
    excpt.printStackTrace(System.err);
    }
}
}
