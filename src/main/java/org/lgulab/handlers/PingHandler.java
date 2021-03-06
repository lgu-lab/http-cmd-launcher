package org.lgulab.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
 
public class PingHandler extends AbstractHandler
{
    @Override
    public void handle( String target, Request baseRequest,
                        HttpServletRequest request, HttpServletResponse response ) 
                        throws IOException, ServletException
    {
        response.setContentType("text/plain; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
 
        PrintWriter out = response.getWriter();
        out.println("pong");
        
        baseRequest.setHandled(true);
    }
}