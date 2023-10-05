package tech_work;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ShopCart {
	
	 public static int[] getArray() {
	        int lengthOfArray = 0;  //init value
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Length of array ?");
	        lengthOfArray = scanner.nextInt();

	        if (lengthOfArray <= 1 || lengthOfArray >= 100) {
	            throw new RuntimeException("Invalid length of array");
	        }

	        int[] nums = new int[lengthOfArray];
	        Random random = new Random();

	        for (int i = 0; i < lengthOfArray; i++) {
	            nums[i] = random.nextInt(0, 2000);
	        }
	        return nums;
	    }

	    public static void calculateDiscount(int[] nums) {
	        int[] numsCopy = nums.clone();
	        int lengthOfNoDiscount = nums.length;

	        System.out.println("---Value of array before discount---");
	        for (int value : nums) {
	            System.out.println(value);
	        }

	        //calculate discount
	        for (int i = 0; i < nums.length; i++) {
	            for (int j = 0; j < nums.length; j++) {
	                if (i == j - 1) {
	                    if (nums[i] > nums[j]) {
	                        nums[i] = nums[i] - nums[j];
	                        lengthOfNoDiscount -= 1;
	                        break;
	                    }
	                }
	            }
	        }

	        //print
	        System.out.println("\n---Value of array after discount---");
	        for (int i = 0; i < nums.length; i++) {
	            System.out.println(nums[i]);
	        }

	        //calculate total
	        int total = 0;
	        for (int i = 0; i < nums.length; i++) {
	            total += nums[i];
	        }
	        System.out.println("\nTotal : " + total);

	        List<Integer> noDiscount = new ArrayList<>();

	        //first way using list's methods
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] == numsCopy[i]) {
	                noDiscount.add(nums[i]);
	            }
	        }

	        System.out.println("\nNot discount using list's methods");
	        noDiscount.sort((o1, o2) -> o1.compareTo(o2));
	        for (int value : noDiscount) {
	            System.out.println(value);
	        }

	        //second way using sorting algorithm

	        int[] noDiscountArray = new int[lengthOfNoDiscount];
	        int index = 0;
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] == numsCopy[i]) {
	                noDiscountArray[index] = nums[i];
	                index++;
	            }
	        }
	        for (int i = 0; i < noDiscountArray.length; i++) {
	            for (int j = 0; j < noDiscountArray.length; j++) {
	                if (noDiscountArray[i] < noDiscountArray[j]) {
	                    int temp = noDiscountArray[i];
	                    noDiscountArray[i] = noDiscountArray[j];
	                    noDiscountArray[j] = temp;
	                }
	            }
	        }

	        System.out.println("\nNot discount using sorting algorithm");
	        for (int value : noDiscountArray) {
	            System.out.println(value);
	        }
	    }

}
