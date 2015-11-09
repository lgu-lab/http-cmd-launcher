package org.lgulab.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.lgulab.command.VBScriptRunner;
 
public class CScriptHandler extends AbstractHandler
{
    public CScriptHandler() {
    	super();
    }
 
    @Override
    public void handle( String target,
                        Request baseRequest,
                        HttpServletRequest request,
                        HttpServletResponse response ) throws IOException,
                                                      ServletException
    {
        response.setContentType("text/plain; charset=utf-8");
        
        int exitValue = 0 ;
        try {
        	exitValue = executeVBScript("D:\\TMP\\myscript.vbs");
	        response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
	        response.setStatus(500);
		}
        
 
        PrintWriter out = response.getWriter();
        out.println("exit value = " + exitValue );
        
        baseRequest.setHandled(true);
    }
    
    private int executeVBScript(String scriptFile) throws Exception
    {
        System.out.println("----------" ); 
    	VBScriptRunner vbscriptRunner = new VBScriptRunner();
    	int exitValue = vbscriptRunner.execute(scriptFile);
        System.out.println("Command = " + vbscriptRunner.getCommand() ); 
        System.out.println("Exit value = " + vbscriptRunner.getExitValue() ); 
        System.out.println("STDOUT : ");
        System.out.println(vbscriptRunner.getStdOut() );
        System.out.println("STDERR : ");
        System.out.println(vbscriptRunner.getStdErr() );
        return exitValue;
    }
    
}