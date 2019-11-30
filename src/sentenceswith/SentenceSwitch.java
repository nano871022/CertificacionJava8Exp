package sentenceswith;
import static java.lang.System.out;

public class SentenceSwitch{

	public static void main(String... args){

		byte in = (byte)( Math.random()*4);
		switch(in){
			case 1:{out.println("A");}break;
			case 2:out.println("B");
			case 3:out.println("C");
		}
	}	
}
