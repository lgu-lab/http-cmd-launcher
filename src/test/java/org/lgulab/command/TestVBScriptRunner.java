package org.lgulab.command;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestVBScriptRunner {

	@Test
	public void test1() {
		int exitValue = executeVBScript("D:\\TMP\\myscript.vbs", false);
		assertEquals(0, exitValue);
	}
	
	@Test
	public void test2() {
		int exitValue = executeVBScript("D:\\TMP\\myscript.vbs", true);
		assertEquals(0, exitValue);
	}
	
	@Test
	public void test3() {
		int exitValue = executeVBScript("D:\\TMP\\nofile.vbs", false);
		assertEquals(1, exitValue);
	}
	
	@Test
	public void test4() {
		int exitValue = executeVBScript("D:\\TMP\\nofile.vbs", true);
		assertEquals(1, exitValue);
	}
	
    private int executeVBScript(String scriptFile, boolean batchMode) 
    {
        System.out.println("----------" ); 
    	VBScriptRunner vbscriptRunner = new VBScriptRunner();
    	int exitValue;
		try {
			if ( batchMode ) {
				exitValue = vbscriptRunner.executeBatchMode(scriptFile);
			}
			else {
				exitValue = vbscriptRunner.execute(scriptFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
        System.out.println("Command = " + vbscriptRunner.getCommand() ); 
        System.out.println("Exit value = " + vbscriptRunner.getExitValue() ); 
        System.out.println("STDOUT : ");
        System.out.println(vbscriptRunner.getStdOut() );
        System.out.println("STDERR : ");
        System.out.println(vbscriptRunner.getStdErr() );
        return exitValue;
    }

}
