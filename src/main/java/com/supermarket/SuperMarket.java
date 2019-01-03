package com.supermarket;

import java.io.IOException;
import java.util.Scanner;

/**
 * Date :June 16,2018 
 * @author MukulJaiswal.
 * @version 1.0.0
 */
public class SuperMarket {
	/**
	 * @return Nothing.
	 * @param args the command line arguments.
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		int choice;
		System.out.println("Enter 1. List Items \nEnter 2. Add Items \nEnter 3. Remove Items");
		System.out.println("\nEnter 0 for Exit");

		// Boolean variable to store whether user wants to quit or not
		boolean flag = true;

		// Creating object of ItemImpl class
		ItemImpl itemimpl = new ItemImpl();

		while (flag) {
			System.out.print("Enter your choice : ");

			try {

				choice = scanner.nextInt();

				switch (choice)
				{
				case 1:
					itemimpl.listAllItems();
					break;

				case 2:
					itemimpl.addNewItem();
					break;

				case 3:
					itemimpl.removeItem();
					break;

				default:
					if (choice != 0)
						System.out.println("Wrong Choice !");

				}
				if (choice == 0) {
					flag = false;
					System.out.println("Thank You! Visit Again.");
				}
			} catch (Exception exception) {
				System.out.println("Wrong Choice !");
				flag = false;
			}
		}
		scanner.close();
	}
}