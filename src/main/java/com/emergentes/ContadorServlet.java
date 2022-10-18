
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ContadorServlet", urlPatterns = {"/ContadorServlet"})
public class ContadorServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //viene de una url
        int contador =0;
        
        //obtener el arreglo de cookie del cliente
        Cookie[] cukis= request.getCookies();
        
        if(cukis  != null){
            for(Cookie c: cukis){
                if(c.getName().equals("visitas")){
                    //anttees de la asignacion se convierte el valor en cadena
                    contador=Integer.parseInt(c.getValue());
                    
                }
            }
        }
        contador++;
         //anttees de la asignacion se convierte de cadena a valor
        Cookie c =new Cookie("visitas",Integer.toString(contador));
        c.setMaxAge(30);
        response.addCookie(c);
        
        response.setContentType("text/html");
        PrintWriter out =response.getWriter();
        out.println("visitante N° " +contador);       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
