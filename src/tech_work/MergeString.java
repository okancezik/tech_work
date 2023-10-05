package tech_work;

import java.util.Scanner;

public class MergeString {

	   private static String str1 = "";
	    private static String str2 = "";

	    public static void getValuesFromUser() throws Exception {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter first string : ");
	        str1 = scanner.nextLine();

	        System.out.print("Enter second string: ");
	        str2 = scanner.nextLine();

	        if (str1.length() != str2.length()) {
	            throw new RuntimeException("Please enter values of same length");
	        }

	        if(str1.length() <= 1 || str1.length() >= 2500){
	            throw new RuntimeException("Please enter valid length");
	        }

	        scanner.close();
	    }

	    public static void merge() {
	        char[] charArray = new char[str1.length() + str2.length()];

	        for (int i = 0; i < charArray.length; i++) {
	            if (i % 2 == 0) {
	                if (i == 0) {
	                    charArray[i] = str1.charAt(i);
	                } else {
	                    charArray[i] = str1.charAt(i / 2);
	                }
	            } else {
	                if (i == 1) {
	                    charArray[i] = str2.charAt(i - 1);
	                } else {
	                    charArray[i] = str2.charAt(i / 2);
	                }
	            }
	        }

	        for (int i = 0; i < charArray.length; i++) {
	            System.out.print(charArray[i]);
	        }

	    }
}
