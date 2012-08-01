package com.sodifrance.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodifrance.jsf.Traitement;

public class Zoom extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType( "image/jpeg" );
		OutputStream out = response.getOutputStream();
		Traitement traitement = ( Traitement )request.getSession().getAttribute( "traitement" );
		ImageIO.write(traitement.getZoom(), "JPEG", out);
		out.close();
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}
