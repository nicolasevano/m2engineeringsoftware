package server.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;

public class ServerLogger {
	
	ServerLogger(){
		outputLogs.add( this.outLog );
	}
	/**
	 * Calling operation on each remote operation acked on server
	 * design for log at entry point
	 * @param joinPoint
	 */
	public void logServerOperationEntry(JoinPoint joinPoint){

	    Object[] args = joinPoint.getArgs();
	    
	    // name of operation intercepted
	    String name = joinPoint.getSignature().toLongString();
	    StringBuilder toLog = new StringBuilder(name + " called with: [" );
	    
	    // parameter list received by operation
	    for(int i = 0; i < args.length; i++)
	      toLog.append( "'" + args[i] + "'" ).append( ( i == args.length - 1 ) ? "" : ", ");
	    toLog.append( "]" );
	    for(PrintStream currentPrinterLog : outputLogs)
	    	currentPrinterLog.println( toLog );
	    
	}
	
	/**
	 * Calling operation at end of each execution of remote call operation on server
	 * designed for log at end point 
	 * @param staticPart
	 */
	public void logServerOperationExit( StaticPart staticPart, Object result ){
		 
		StringBuilder toLog = new StringBuilder();
		
		toLog.append( staticPart.getSignature().toLongString() )
				 .append( " returning: [" )
				 .append( result )
				 .append( "]" );
		for(PrintStream currentPrinterLog : outputLogs)
	    	currentPrinterLog.println( toLog );
	}

	public PrintStream getOutLog() {
		return outLog;
	}

	public void setOutLog(PrintStream outLog) {
		
		outputLogs.remove( this.outLog );
		this.outLog = outLog;
		outputLogs.add( this.outLog );
		
	}
	
	public String getLoggerFile() {
		return loggerFile;
	}

	public void setLoggerFile(String loggerFile) {
		FileOutputStream outFileLog;
		
		if(this.outFileLog != null) outputLogs.remove( this.outFileLog );
		
		this.loggerFile = loggerFile;		
		try {
			
			outFileLog = new FileOutputStream( this.loggerFile );
			this.outFileLog = new PrintStream( outFileLog );
			
		} catch ( FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outputLogs.add( this.outFileLog );
		
	}
	
	private PrintStream outLog = System.out;
	
	private PrintStream outFileLog = null;
	
	private String loggerFile = null;
	
	private List< PrintStream > outputLogs = new ArrayList< PrintStream >();
	
}
