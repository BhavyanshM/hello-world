import java.sql.*;

public class DatabaseConnector {
	private Connection conn;
	private Statement statement;	
	private ResultSet rows;
	private String query;
	
	public DatabaseConnector(){
		this.setQuery("select * from songs");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://54.159.166.105:8080/Tester", "naman", "chocolate");
			this.statement = this.conn.createStatement();
			this.rows = this.statement.executeQuery(this.query);
			while(this.rows.next()){
				System.out.println(this.rows.getInt("Srno")+"\t"+
									this.rows.getString("Name")+"\t"+
									this.rows.getInt("Duration")+"\t"+
									this.rows.getString("Singer")+"\t"+
									this.rows.getDouble("Cost")+"\t"+
									this.rows.getString("Location")+"\t"+
									this.rows.getString("Icon")+"\t");
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLException: " + ex.getErrorCode());			
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}				
	}
	
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public Statement getStatement() {
		return statement;
	}
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	public ResultSet getRows() {
		return rows;
	}
	public void setRows(ResultSet rows) {
		this.rows = rows;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}	
}
