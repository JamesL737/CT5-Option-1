package com.module5CTOption1.model;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Recursion example program
 * @author James L.
 * Uses a recursive method to calculate the product of five integers
 */

public class RecursionExample {

	/**
	 * Recursive method to calculate product of integers in an array list
	 * @param numList the array list holding the integers
	 * @param product the current product
	 * @param index the index of the integer array
	 * @return product if index is size of array - 1, else return a recursive call to the method, increasing the passed index by 1
	 */
	public static int recursiveProduct(ArrayList<Integer> numList, int product, int index) {
		
		//return product is index is at end of array list
		if(index == numList.size() - 1) {
			return product;
		}
		/**
		 * product is calculated using next index
		 * then recursive call is made increasing the index by one for next call
		 */
		else {
			product *= numList.get(index + 1);
			return recursiveProduct(numList, product, index + 1);
		}
	
	}
	
	/**
	 * main is the driver for the function
	 * @param args
	 */
	public static void main(String [] args) {
		
		/**
		 * variables for user's integers, a counter, the product,
		 * and an array list of integers to hold numbers
		 */
		int userNum = 0;
		int numCounter = 0;
		int userProduct = 0;
		Scanner scnr = new Scanner(System.in);
		ArrayList<Integer> userList = new ArrayList<Integer>();
		
		/**
		 * user can enter at most 5 integers, or exit via the sentinel value
		 */
		while(numCounter < 5 || userNum != -99) {
			
			try {
				if(numCounter > 4 || userNum == -99) {
					try {
						//if user enters no numbers before entering sentinel value
						if(userList.size() == 0) {
							throw new Exception("No numbers were entered!");
						}
						//set product to the first element in the array list before recursive calculations
						else {
							userProduct = userList.get(0);
							userProduct = recursiveProduct(userList, userProduct, 0);
							break;
						}
					}
					catch(Exception excpt) {
						System.out.println(excpt.getMessage());
						break;
					}
				}
				else {
					System.out.print("Enter 5 numbers, or enter -99 to stop: ");
					userNum = scnr.nextInt();
					
					//if user value is not sentinel value, add it to the list
					if(userNum != -99) {
						userList.add(userNum);
						numCounter++;
					}
				}	
			}
			catch(InputMismatchException excpt){
				System.out.println("Not a valid integer!");
				scnr.nextLine();
			}
		}
		
		//display product
		System.out.println("Product of entered numbers is " + userProduct);
		
	}
}
