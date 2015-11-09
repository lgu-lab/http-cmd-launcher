package org.lgulab.testcmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestCScript {

    public static void main(String[] args) throws Exception
    {
    	String windir = System.getenv("windir");
    	System.out.println("windir = " + windir);
    	executeCommand("cmd /c dir");
    	executeCommand("cmd /c ver");
    	
    	executeVBScript("foo.vbs");
    	executeVBScript("D:\\TMP\\myscript.vbs");
    }
    
    public static void executeVBScript(String scriptFile) throws Exception
    {
    	String windir = System.getenv("windir");
    	if ( windir == null ) {
    		windir = "C:\\Windows" ; // default value
    	}
    	System.out.println("windir = " + windir);
    	// Option "//B" : nothing in stdout/stderr
    	//String command = windir + "\\System32\\cscript.exe //B " + scriptFile ;
    	String command = windir + "\\System32\\cscript.exe " + scriptFile ;
    	executeCommand( command);
    }
    
    public static void executeCommand(String command) throws Exception
    {
        System.out.println("----------" ); 
        System.out.println("Execute : " + command ); 
    	try { 
            Process process = Runtime.getRuntime().exec( command ); 
            int exitValue = process.waitFor(); 
            
            String out = toString(process.getInputStream() );
            String err = toString(process.getErrorStream() );

            System.out.println(out);
            System.out.println(err);
            System.out.println("Exit value : " + exitValue );
            System.out.println("Exit value : " + process.exitValue() );
        }
        catch(InterruptedException e2) {
        	System.out.println("Interrupted");
        } 

        System.out.println("Done"); 
    }
    
    public static String toString(InputStream is) {
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
