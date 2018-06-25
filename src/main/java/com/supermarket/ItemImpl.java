package com.supermarket;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Date :June 16,2018 This file contains three function of SuperMarker
 * Application.
 * 
 * @author MukulJaiswal.
 * @version 1.0
 */
public class ItemImpl {

	ConfigureSetting configureSetting = new ConfigureSetting();
	Items item = new Items();

	/**
	 * This function list all items available in SuperMarket.
	 * 
	 * @return Nothing.
	 */
	void listAllItems() {
		Session session = configureSetting.database();

		session.beginTransaction();

		Query query = session.createQuery("FROM Items");
		@SuppressWarnings("unchecked")
		List<Items> items = query.list();

		for (Items item : items) {
			System.out.println(item);
		}

		session.getTransaction().commit();
	}

	/**
	 * This function is used to add new items in a Store.
	 * 
	 * @return Nothing.
	 */
	void addNewItem() {

		Session session = configureSetting.database();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		String name;
		int quantity;
		String date;
		System.out.println("Enter the details of an items: ");

		System.out.print("Name: ");
		name = scanner.nextLine();

		System.out.print("Quantity :");
		quantity = scanner.nextInt();

		scanner.nextLine();

		System.out.print("Date :");
		date = scanner.nextLine();

		session.beginTransaction();

		item.setName(name);
		item.setQuantity(quantity);
		item.setDate(date);
		session.save(item);

		session.getTransaction().commit();
		System.out.println("Item is Successfully Added.");
		session.close();
	}
	/**
	 * This function is used to remove a particular item from a Store.
	 * 
	 * @return Nothing.
	 */
	void removeItem() {

		int removeItem;
		Session session = configureSetting.database();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the Product ID which you want to Delete: ");
		removeItem = scanner.nextInt();

		session.beginTransaction();

		Items item = (Items) session.get(Items.class, removeItem);
		if (item != null) {
			session.delete(item);
			session.getTransaction().commit();
			System.out.println("Item with ID-" + removeItem + " is Successfully Removed.");

		} else {
			System.out.println("Sorry! No such Item ID found.");
		}
	}
}
