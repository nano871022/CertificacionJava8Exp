/**
* comentarios
*/
//comentario
package Arrays;
import static java.lang.System.out;

public class Arrays{
	static Integer[][] val4 = new Integer[1][2];
	static int[][] val = new int[1][2];
	final static int[][] val1 = new int[1][2];
	int[][] val2 = new int[1][2];
	final int[][] val3 = new int[1][2];


	public static void main(String... args){
		out.println("load");
		finalIntMulti();
		intMulti();
		multiDem();
		multiString();
		multiString2();
		multiString3();
		intMultiGobal();
		intMultifinalGobal();
		integerMultifinalGobal();
		Arrays arr = new Arrays();
		arr.intMultiGobalInstInst();
		arr.intMultifinalGobalInst();
		arr.finalIntMultiInst();
		intMultiFirst();
	}

	void intMultiGobalInstInst(){
		print(val2,"IntGlbInst");
	}

	void intMultifinalGobalInst(){
		print(val3,"IntFnGlbInst");
	}

	static void integerMultifinalGobal(){
		print(val4,"IntegerFnGlb");
	}


	static void intMultifinalGobal(){
		print(val1,"IntFnGlb");
	}

	static void intMultiGobal(){
		print(val,"IntGlb");
	}

	void finalIntMultiInst(){
		final int[][] list = new int[1][2];
		print(list,"IntInst");
	}

	static void finalIntMulti(){
		final int[][] list = new int[1][2];
		print(list,"Int");
	}

	static void intMulti(){
		int[][] list = new int[1][2];
		print(list,"IntMulti");
	}

	static void intMultiFirst(){
		int[][] list = new int[1][];
		print(list,"IntMultiFirst");
	}

	static void multiString(){
		String[][] list = new String[][]{{"a","as"},{"as","a","dse"}};
		list[0][0] = "ok2";
		print(list,"String");
	}

	static void multiString2(){
		String[][] list = new String[1][];
		list[0] = new String[]{"ok2"};
		print(list,"2");
	}

	static void multiString3(){
		String[] l1 = new String[]{"ok3"};
		String[][] list = new String[1][];
		list[0] = l1;
		print(list,"3");
	}

	static void print(Object[][] objs,String method){
		for(Object[] arr : objs){
			java.util.Arrays.asList(arr)
			.stream()
			.map(val->method+"=>"+val)
			.forEach(out::println);
		}
	}

	static void print(int[][] objs,String method){
		for(int[] arr : objs){
			if(arr == null)throw new RuntimeException("El sub array ingresado es nulo.");
			for(int u : arr)
				out.println(method+"=>"+u);
		}
	}

	static void multiDem(){
		int[][] list = new int[][]{{1,1,2,2,2},{1,44,2}};
		print(list,"multiDem");
			//java.util.Arrays.toList(list).stream().forEach(out::println);//no se puede multidimecional solo una dimension
	}
}
