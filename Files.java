import static java.lang.System.out;
import static java.lang.System.err;
import java.nio.file.*;
import java.util.function.*;
import java.util.*;
import java.util.stream.*;
import java.io.IOException;

public class Files{
  public static void main(String... args){
      try{
	out.println("Printing");
	Path ruta = Paths.get(args[0]);
	//Files.createFile(ruta);
	out.println(ruta);
	Path absolutePath = ruta.toAbsolutePath();
	out.println(absolutePath.subpath(Integer.valueOf(args[1]),Integer.valueOf(args[2])));
	out.println(absolutePath.getParent());
	out.println(absolutePath.getRoot());
	out.println(absolutePath);
	//out.println(ruta.isWritable());
	//out.println(ruta.isReadable());
	//out.println(ruta.isExecutable());
      }catch(ArrayIndexOutOfBoundsException e){
       throw new RuntimeException("No ingreso parametros en la ejecucion de la clase, ruta archivo:1,subpathIni:2,subpathEnd:3");
      }catch(IllegalArgumentException e){
	      throw new RuntimeException("Los parametros para obtener el subpath son incorrectos.");
      }catch(Exception e){
	      throw e;
      }
      filelist();
     filelistwalk();
     fileRead();
     fileReadAllLines();
     copy();
  }

  public static void filelist(){
	try(Stream<Path> files = java.nio.file.Files.list(Paths.get("."))){
		out.println("recorriendo la carpeta");
	   files.forEach(line->System.out.println(line));
	}catch(IOException e){
		throw new RuntimeException("Problema al obtener lista de archivos");
	}
  }

  public static void filelistwalk(){
	  try(Stream<Path> files = java.nio.file.Files.walk(Paths.get("."))){
		  out.println("caminado pro los archivos");
		files.forEach(line->System.out.println(line));
	  }catch(IOException e){
		  throw new RuntimeException("Error al caminar por el archivo");
	  }
  }

  public static void fileRead(){
	  try(Stream<String> lines = java.nio.file.Files.lines(Paths.get("files.txt"))){
		lines.forEach(line->System.out.println(line));
	  }catch(IOException e){
		  throw new RuntimeException("Error al leer el archivo");
	  }
  }

  public static void fileReadAllLines(){
	Path path = Paths.get("files.txt");
	List<String> list;
	try{
		list = java.nio.file.Files.readAllLines(path);
		list.stream().filter(line->line.contains("s"))
				.forEach(line->System.out.println("encontrado::"+line));
	}catch(IOException e){
		throw new RuntimeException("Error al leer archivo con todos los registros");
	}
  }

  public static void copy(){
	  try{
	Path path1 = Paths.get("folder2");
	Path path2 = Paths.get("folder3");
	java.nio.file.Files.move(path1,path2,StandardCopyOption.REPLACE_EXISTING);
	  }catch(DirectoryNotEmptyException e){
	  	throw new RuntimeException("El directorio de destino no se encuentra vacio");
	  }catch(IOException e){
		  err.println(e);
		  throw new RuntimeException("Problema en el copiado del archivo");
	  }
  }
}



