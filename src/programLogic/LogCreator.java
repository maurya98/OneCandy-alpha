package programLogic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogCreator {
	public static void logwriter(String strLog, String logPath) {
		 	FileWriter logwriter;
			try {
				logwriter = new FileWriter(logPath, true);
				 PrintWriter Pwriter = new PrintWriter(logwriter);
				    Pwriter.println(strLog);
				    logwriter.close();
				    Pwriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	}
}
