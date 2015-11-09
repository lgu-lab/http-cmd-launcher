package org.lgulab.command;

public class VBScriptRunner {
	
	CommandRunner commandRunner = new CommandRunner();

    public VBScriptRunner() {
	}
    
	public String getCommand() {
		return commandRunner.getCommand();
	}

	public int getExitValue() {
		return commandRunner.getExitValue();
	}

	public String getStdOut() {
		return commandRunner.getStdOut();
	}

	public String getStdErr() {
		return commandRunner.getStdOut();
	}

	private String buildCScriptCommand() {
    	String windir = System.getenv("windir");
    	if ( windir == null ) {
    		windir = "C:\\Windows" ; // default value
    	}
    	return windir + "\\System32\\cscript.exe" ;
    }

	public int execute(String scriptFile) throws Exception {
    	String command = buildCScriptCommand() + " " + scriptFile ;
    	return commandRunner.executeCommand(command) ;
    }
	
	public int executeBatchMode(String scriptFile) throws Exception {
    	// Option "//B" : nothing in stdout/stderr
    	String command = buildCScriptCommand() + " //B " + scriptFile ;
    	return commandRunner.executeCommand(command) ;
    }   
}
