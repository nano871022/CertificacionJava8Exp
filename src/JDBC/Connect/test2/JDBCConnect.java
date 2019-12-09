package JDBC.Connect.test2;
import java.sql.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import static java.lang.System.*;
import java.time.*;
import java.time.chrono.*;
public class JDBCConnect{
	private final static String url = "jdbc:derby:demo;create=true";
	private final static String format = "| %050d | %s |";
	private final static String sqlSelect = "select id as identificador, name as nombre from test";
	private final static String sqlCount = "select count(1) from test";
	private final static String sqlInsert = "insert into test (id,name) values(%d,'name1')";
	private final static String sqlCreate = "create table test(name varchar(20) not null,id int not null)";

	public static void main(String... args){
		if(args.length == 0 || args.length != 3)throw new IllegalArgumentException("Debe tener tres argumentos numéricos.{[-1:CreateTable,0:anything,>0:#RowsCreating],Pagina inicial,cantidad registros}");
		try(
			Connection connect = DriverManager.getConnection(url);
			Statement statement = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)){
			if(Integer.valueOf(args[0])==-1){
				createTable(statement);	
			}else if(Integer.valueOf(args[0]) >0){
					IntStream.range(1,Integer.valueOf(args[0])).forEach(count->{insert(statement);});
				  }
		  out.println(count(statement));
		  printTabla(statement,Integer.valueOf(args[1]),Integer.valueOf(args[2]));
		}catch(SQLException e){
			err.println(e);
		}finally{
			out.println("finalizando jdbc");
		}

	}

	public static void printTabla(Statement statement,int first,int rows)throws SQLException{
		ResultSet rs = statement.executeQuery(sqlSelect);
		out.println((rs.last()?rs.getRow():0)+" filas.");
		LocalDateTime d1 = LocalDateTime.now();
		for(int move = first;rs.absolute(move) &&  move < first+rows;move++){
			StringBuilder sb = new StringBuilder()
				.append(" | ")
				.append(String.format("%04d",rs.getInt("identificador")))
				.append(" | ")
				.append(String.format("%20s",rs.getString("nombre")))
				.append(" | ");
			out.println(sb.toString());
		}
		LocalDateTime d2 = LocalDateTime.now();
		out.println(Duration.between(d1,d2).toMillis()+" milisegundos.");
	}

	public static int count(Statement statement)throws SQLException{
		ResultSet rs =  statement.executeQuery(sqlCount);
		return rs.first() ?  rs.getInt(1) : 0;
	}

	public static void insert(Statement statement)throws RuntimeException{
		try{
			int count = count(statement);
			statement.executeUpdate(String.format(sqlInsert,count));
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public static void createTable(Statement statement)throws SQLException{
		statement.executeUpdate(sqlCreate);
	}

}