package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		String delim = delim(text);
		String values = value(text);
		String [] string = values.split(delim);

		if (text.length()==0)
			return 0;
	
		checkForNeg(string);

		return sum(values.split(delim));	
	}

	private static void checkForNeg(String[] string){

		String negatives = "";
		for(String strings : string){
			if(strings.contains("-")){
				negatives += "," + strings;
			}
		}

		if(!"".equals(negatives)){
			throw new RuntimeException("Negatives Not Allowed: " + negatives.substring(1));
		}
	}	

	private static String value (String text){
		String value = text;
		
		if(text.startsWith("//")){
			value = value.substring(3);
		}
		return value;
	}

	private static String delim (String text){
		String delim = ",|\n";
		if (text.startsWith("//")){
			delim = text.substring(2,3);
		}
		return delim;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static int sum(String[] numbers){
		int _sum = 0;
			for (String number : numbers){
				if(toInt(number) > 1000)
					continue;
				_sum += toInt(number);
			}
			return _sum;
	}
}
