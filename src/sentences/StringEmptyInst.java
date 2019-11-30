package sentences;
import static java.lang.System.out;

public class StringEmptyInst{
	
	static boolean b = false;
	static int val;

	public static void main(String... args){
		String arg=null;
		Integer x = 8l;
		if(b=true)arg="true";
		arg=b?arg:"false";
		out.println(x.SIZE+" "+x.BYTES);//0000 0000 0000 0000 0000 0000 0000 1000
		out.println(arg);

	}
}