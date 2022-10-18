package core.logging;

import java.util.ResourceBundle;

public class EmailLogger implements Logger, java.lang.System.Logger {
	public void log(String message) {
		System.out.println("Logged to mail : " + message);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLoggable(Level level) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(Level level, ResourceBundle bundle, String format, Object... params) {
		// TODO Auto-generated method stub
		
	}
}
