package org.lgulab.command;
import static org.junit.Assert.*;

import org.junit.Test;
import org.lgulab.command.CommandRunner;


public class TestCommandRunner {

	@Test
	public void test1() {
		int exitValue = executeCommand("cmd /c ver");
		assertEquals(0, exitValue);
	}
	
	@Test
	public void test2() {
		int exitValue = executeCommand("cmd /c dir");
		assertEquals(0, exitValue);
	}
	
    private int executeCommand(String command) 
    {
        System.out.println("----------" ); 
        CommandRunner cr = new CommandRunner();
        int exitValue;
		try {
			exitValue = cr.executeCommand(command);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
        System.out.println("Command = " + cr.getCommand() ); 
        System.out.println("Exit value = " + cr.getExitValue() ); 
        System.out.println("STDOUT : ");
        System.out.println(cr.getStdOut() );
        System.out.println("STDERR : ");
        System.out.println(cr.getStdErr() );
        return exitValue;
    }

}
