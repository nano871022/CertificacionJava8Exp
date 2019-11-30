package inputparams;

import java.util.Arrays;
import static java.lang.System.out;

public class InputParams{
	public static void main(String[] args){
		
		print(args);
		other(args);
		otherFinalParamChangeValue(args);
		otherFinalParam(args);
		otherFinalParamCompiler(args);		
	}	

	static void otherFinalParam(final String... args){
		args[3] = "change";
		print(args);
	}

	static void otherFinalParamCompiler(final String... args){//error en compilacion
		//args = new String[4];
		args[3] = "change";
		print(args);
	}

	static void otherFinalParamChangeValue(final String... args){
		args[2] = "change";
		print(args);
	}	

	static void other(String... args){
		args = new String[4];
		args[3] = "change";
		print(args);
	}

	static void print(String... args){
		Arrays.asList(args)
		.stream()
		.filter(filter-> filter != null)
		.filter(filter->!filter.equals("null"))
		.forEach(out::println);		
	}
}