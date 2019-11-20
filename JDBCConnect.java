import static java.lang.System.out;
import static java.lang.System.err;
import java.sql.*;
import java.io.Closeable;
import java.io.IOException;

public class JDBCConnect implements Closeable{
  	private enum Level{INFO,WARN,ERROR};
	private String url = "jdbc:derby:%s%s%s";
	private String password="";
	private String usuario="";
	private  String port="";
	private String server="";
	private Connection connect;
	private String database="";
	private Statement statement;
	public JDBCConnect(String server,String port,String usuario,String password,String database){
		if(usuario != "null")this.usuario = usuario;
		if(password != "null")this.password = password;
		if(port != "null")this.port = port;
		if(server != "null")this.server = server;
		if(database != "null")this.database = database;
	}

	public final JDBCConnect loadStatement()throws SQLException{
		statement = connect.createStatement();
		return this;
	}

	public final JDBCConnect createTable()throws SQLException{
		try{
		  count();
		}catch(SQLException e){
			print(e);
			print("createTable",Level.INFO);
		  String sql = "CREATE TABLE test (name varchar(100) not null,id integer)";
	 	  statement.executeUpdate(sql);
		}
		return this;
	}

	public final int count()throws SQLException{
		print("count",Level.INFO);
		String sql = "SELECT COUNT(1) as count FROM test";
		ResultSet rs = statement.executeQuery(sql);
		rs.next();
		return rs.getInt("count");
	}

	public final JDBCConnect insert()throws SQLException{
		int count = count();
		print("insert",Level.INFO);
		String sql = "INSERT INTO test (name,id) VALUES ('%s',%d)";
		String value = String.format(sql,"nombre"+count,count);
		//print(sql,Level.INFO);
		statement.executeUpdate(value);
	return this;
	}

	public final JDBCConnect select()throws SQLException{
		print("select",Level.INFO);
		String sql = "SELECT * FROM test";
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()){
			//rs.next();
			print(rs.getString("name"),Level.INFO);
			print(String.valueOf(rs.getInt("id")),Level.INFO);
		}
		return this;
	}

	public final JDBCConnect createConnection()throws SQLException{
		print("Conectando",Level.INFO);
		print(database,Level.WARN);
		connect = DriverManager.getConnection("jdbc:derby:"+database+";create=true");
		print("Conectado",Level.INFO);
		return this;
	}
	
	public static void main(String... args){
		if(args == null || args.length != 5){
			throw new IllegalArgumentException("debe suministrar servidor,puerto,usuario,password,nombre base datos");
		}
		try(var jdbcConnect = new JDBCConnect(args[0],args[1],args[2],args[3],args[4])){
		jdbcConnect.createConnection().loadStatement().createTable().insert().select();
		}catch(SQLException | IOException e){
		print(e);
		}finally{
		print("Saliendo ",Level.INFO);
		}
	  }

  private static void print(String msn,Level level){
	if(msn == null || msn.isEmpty()){
		throw new IllegalArgumentException("Mensaje no suministrado");
	}
	if(level == null){
		throw new IllegalArgumentException("No suministro el nivel");
	}
  	switch(level){
		case INFO:out.println(msn);break;
		case ERROR:err.println(msn);break;
		case WARN:out.println("WARN:::"+msn);break;
		default:throw new IllegalArgumentException("Opcion de nivel no valida.");
	}


  }

  public static void print(Throwable e){
	  print(e.getMessage(),Level.ERROR);
  }

  public void close()throws IOException{
	  try{
	  if(statement != null)statement.close();
	  if(connect != null)
  	    connect.close();
	  }catch(Exception e){
		  print(e);
	}
  }

}
