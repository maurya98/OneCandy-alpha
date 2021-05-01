package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DatabaseOperations implements DBEssentials {
	
	@Override
	public Connection createConnection(String driver, String databaseURL, String username, String password) {
		try {
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(databaseURL,username,password);
			return connection;
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Something went wrong due to following error has occured\n"+ex.getMessage());
			return null;
		}
		
	}

	@Override
	public String newRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readAllRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readSelectedRecord(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAllRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSelectedRecord(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
