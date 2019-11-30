import static java.lang.System.out;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.time.*;


public class DataManager{

	
	public static void main(String... args){

		LocalDate ldt = LocalDate.now();
		LocalDate ldtBorn = LocalDate.of(1987,10,22);
		Period period = Period.between(ldtBorn,ldt);
		out.println(new StringBuilder()
			.append(String.format("%04d",period.getYears()))
			.append("/")
			.append(String.format("%02d",period.getMonths()))
			.append("/")
			.append(String.format("%02d",period.getDays()))
			.toString());
	}

}