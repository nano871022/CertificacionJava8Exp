package exceptions;

import static java.lang.System.out;

public class ExceptionThrowMath{
	public static void main(String... args){
			int[] a = new int[4];
			a[3] = (a[0]+a[1])/a[2];
			out.println(a[3]);
	}
}