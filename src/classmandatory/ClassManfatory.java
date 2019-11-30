
package classmandatory;

import java.lang.StringBuilder;
import static java.lang.System.out;

public class ClassManfatory{
	static Integer b = 0;
	public static void main(String... args){
		StringBuilder s = new StringBuilder("Java");
		s.insert(0,"The latest");
		s.append("version is");
		s.append(" 1,7");
		s.delete(27,28);
		s.append("8");
		s.substring(4);

		out.println(s);

		int y = 10;
		int x = 10;
		if(x!=10 && y++==1);
		if(y==11 | ++x==11)y+=10;
		out.println(y+" "+x);

		int c = 10;
		if(c++>10 & b++==1)b+=10;
		out.println(y);

		int r = -10;
		int t = 10;
		if(++y>10|r%(-3)==1)
		out.println("A");
	}

}