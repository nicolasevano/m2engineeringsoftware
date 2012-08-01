package com.sodifrance.jsf;

import java.io.IOException;
import java.io.PrintWriter;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoWriter {
	
	public String info(){
		ExternalContext externe = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletResponse response = ( HttpServletResponse ) externe.getResponse();
		//HttpServletResponse response = ( HttpServletResponse ) externe.re;
		HttpServletRequest requete = ( HttpServletRequest ) externe.getRequest();
		response.setContentType( "application/octet-stream" );
		try{
			PrintWriter out;
			out = response.getWriter();
			out.println("Type de contenu du document : " + requete.getContentType());
			out.println("Adresse IP locale : " + requete.getLocalAddr() );
			out.println("Application Web : " + requete.getContextPath() );
			out.println("Nom local : " + requete.getLocalName() );
			out.println("Port local : " + requete.getLocalPort() );
			out.println("Page web sollicité : " + requete.getPathInfo() );
			out.println("Répertoire local : " + requete.getPathTranslated() );
			out.println("Protocole : " + requete.getProtocol() );
			out.println("Adresse du client : " + requete.getRemoteAddr() );
			out.println("Nom ordinateur client : " + requete.getRemoteHost() );
			out.println("Port du client : " + requete.getRemotePort() );
			out.println("URI compléte de l'application Web : " + requete.getRequestURI() );
			out.println("Identifiant de la session : " + requete.getRequestedSessionId() );
			out.println("Nom du serveur : " + requete.getServerName() );
			out.println("Port du serveur : " + requete.getServerPort() );
			out.println("URI du servlet contrôleur : " + requete.getServletPath() );
			out.println("Application Web : " + externe.getRequestContextPath() );
			out.println("Page web sollicité : " + externe.getRequestPathInfo() );
			out.println("URI du servlet contrôleur : " + externe.getRequestServletPath() );
			response.flushBuffer();
			out.close();
		} catch( IOException e ) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().responseComplete();
		return "";
	}
}
