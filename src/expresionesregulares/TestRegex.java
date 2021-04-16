package expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	public static void main(String[] args) {
		Pattern pat = Pattern.compile("DISPARO\\(\\s*[0-9]{1,3}\\s*,\\s*[0-9]{1,3}\\s*\\)");
		String[] input = {"DISPARO(492,124)", 
				"DISPARO(323,200)", 
				"DISPARO(14,2)",
				"DISPARO(00003,000)", 
				"DISPAR(492,124)", 
				"DISPARO(  14,2)", 
				"DISPARO(14 ,2  )", 
				"egrhrty",  
				"disparo(a,b)"};
		
		for (int i = 0; i < input.length; i++) {
			Matcher mat = pat.matcher(input[i]);
			if (mat.find()) {
				System.out.println(input[i] + ": ESTA BIEN");
			}
			else {
				System.out.println(input[i] + ": MAL");				
			}
		}
		
		for (int i = 0; i < 50; i++) {
			System.out.println(i + ":" + (isPrime(i) ? "PRIMO" : ""));
		}
	}
	
	public static boolean isPrime(int n) {
	    return !new String(new char[n]).matches(".?|(..+?)\\1+");
	}
}
