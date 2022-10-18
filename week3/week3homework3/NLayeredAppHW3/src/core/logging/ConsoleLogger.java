package core.logging;

public class ConsoleLogger implements Logger {
	
	public void log(String message) {
		System.out.println("Logged to console : " + message);
	}
}
