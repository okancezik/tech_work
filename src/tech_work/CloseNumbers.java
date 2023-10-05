package tech_work;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CloseNumbers {

	  public static int[] getArray() throws Exception {
	        int lengthOfArray = 0;  //init value
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Length of array ?");
	        lengthOfArray = scanner.nextInt();

	        if(lengthOfArray <= 1 || lengthOfArray >= 1000){
	            throw new RuntimeException("Invalid length of array");
	        }
	        int[] nums = new int[lengthOfArray];
	        Random random = new Random();

	        for (int i = 0; i < lengthOfArray; i++) {
	            nums[i] = random.nextInt(-20000, 20000);
	        }
	        return nums;
	    }

	    public static int getMinDiff(int[] nums) {
	        int diff;
	        int minDiff = Math.abs(nums[0] - nums[2]);

	        for (int i = 0; i < nums.length; i++) {
	            for (int j = 0; j < nums.length; j++) {
	                if (nums[i] != nums[j]) {             //iki ayný sayý birbiri ile farký alýnmasý engellendi
	                    if (nums[i] > nums[j]) {          //mutlak deðer sonuç elde etmek için
	                        diff = nums[i] - nums[j];
	                        if (diff < minDiff) {
	                            minDiff = diff;
	                        }
	                    }
	                }
	            }
	        }
	        return minDiff;
	    }

	    public static void calculateCloseNumbers(int[] nums, int minDiff){
	        List<String> ar = new ArrayList<>();

	        for (int i = 0; i < nums.length; i++) {
	            for (int j = 0; j < nums.length; j++) {
	                if (nums[i] != nums[j]) {
	                    if (minDiff == -(nums[i] - nums[j])) {
	                        ar.add(nums[i] + " " + nums[j]);
	                    }
	                }
	            }
	        }

	        System.out.println("--Value of array--");
	        for (int value : nums) {
	            System.out.println(value);
	        }

	        System.out.println("--Close numbers--");
	        for (String closes : ar){
	            System.out.println(closes);
	        }
	    }
}
