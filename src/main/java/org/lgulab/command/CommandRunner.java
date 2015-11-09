package org.lgulab.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandRunner  {
	
	private String command   = "" ;
	private int    exitValue = 0 ;
	private String stdOut    = "" ;
	private String stdErr    = "" ;
	
    public CommandRunner() {
		super();
	}

	private void log(String msg) {
        //System.out.println("LOG : " + msg ); 
	}
	
	public String getCommand() {
		return command;
	}

	public int getExitValue() {
		return exitValue;
	}

	public String getStdOut() {
		return stdOut;
	}

	public String getStdErr() {
		return stdErr;
	}

	public int executeCommand(String command) throws Exception {
		this.command = command;
    	Process process ;
        log("Execute : " + command ); 
    	try { 
            process = Runtime.getRuntime().exec( command ); 
        }
        catch(IOException e) {
        	log("IOException : " + e.getMessage() );
        	throw e;
        } 

    	try { 
            this.exitValue = process.waitFor(); 
        }
        catch(InterruptedException e) {
        	log("Interrupted : " + e.getMessage() );
        	throw e;
        } 

    	this.stdOut = toString(process.getInputStream() );
        this.stdErr = toString(process.getErrorStream() );

        log("Exit value = " + exitValue );
        log ("--- stdout : (" + stdOut + ")" );
        log ("--- stderr : (" + stdErr + ")" );

        return exitValue ;
    }
    
    private String toString(InputStream is) {
    	StringBuffer sb = new StringBuffer();
	    BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(is) ); 
	    String line; 
	    try {
			while((line = bufferedReader.readLine()) != null)  { 
				sb.append(line);
				sb.append("\n");
			}
		} catch (IOException e) {
			return "ERROR : IOException" + e.getMessage() ;
		} 
	    return sb.toString();
	}    

}
