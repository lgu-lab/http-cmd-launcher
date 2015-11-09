package org.lgulab.testcmd;

import org.lgulab.command.CommandRunner;
import org.lgulab.command.VBScriptRunner;

public class TestCScript2 {

    public static void main(String[] args) throws Exception
    {
    	executeVBScript("foo.vbs");
    	executeVBScript("D:\\TMP\\myscript.vbs");
    }
    
    public static void executeVBScript(String scriptFile) throws Exception
    {
        System.out.println("----------" ); 
    	VBScriptRunner vbscriptRunner = new VBScriptRunner();
    	int exitValue = vbscriptRunner.execute(scriptFile);
        System.out.println("Done : exit value = " + exitValue ); 
        System.out.println("STDOUT : ");
        System.out.println(vbscriptRunner.getStdOut() );
        System.out.println("STDERR : ");
        System.out.println(vbscriptRunner.getStdErr() );
    }
    
    public static void executeCommand(String command) throws Exception
    {
        System.out.println("----------" ); 
        CommandRunner cr = new CommandRunner();
        int exitValue = cr.executeCommand(command);
        System.out.println("Done : exit value = " + exitValue ); 
        System.out.println("STDOUT : ");
        System.out.println(cr.getStdOut() );
        System.out.println("STDERR : ");
        System.out.println(cr.getStdErr() );
    }
    
}
