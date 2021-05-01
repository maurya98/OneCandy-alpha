package dao;

import java.sql.Connection;

public interface DBEssentials {
	public Connection createConnection(String driver, String database, String username, String password) ;
	public String newRecord();
	public String updateRecord();
	public String readAllRecords();
	public String readSelectedRecord(int index);
	public String deleteAllRecords();
	public String deleteSelectedRecord(int index);
}
