package interfaces;

import java.io.IOException;
import static java.lang.System.out;

public class Interfaces{
	int i;
	public static void main(String... args){
		float f = 1.2f;
		new Interfaces().divide(f);

	}
	public void divide(double d){
		out.println(d/i);
	}
}

class impl extends Interfaz implements Intterface{
	
	protected void go(){}
}

interface Intterface{
	static String val2 = "aa";
	String val = "aam";
}

class Interfaz{
	protected void go()throws IOException{}
}