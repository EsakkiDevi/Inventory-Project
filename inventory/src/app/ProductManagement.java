package app;

import java.util.*;
public class ProductManagement {
	Scanner s=new Scanner(System.in);
	
	void ProductMethods()
	{
		while(true)
		{
		System.out.println("---Product Management---");
		System.out.println("1.Add Product" );
		System.out.println("2.Update Product Details");
		System.out.println("3.Delete Product");
		System.out.println("4.Search Product by Id");
		System.out.println("5.SearchProduct by Name");
		System.out.println("6.Show All Product Details");
		
		System.out.println("Choose the option");
		int option=s.nextInt();
		switch(option)
		{
		case 1:
			addProduct();
			break;
			
		case 2:
			updateProduct();
			break;
			
		case 3:
			deleteProduct();
			break;
			
		case 4:
			searchProductById();
			break;
			
		case 5:
			searchProductByName();
			break;
			
		case 6:
			showAllProduct();
			break;
			
		case 7:
			System.exit(0);
			
		default:
			System.out.println("Invalid Option...!");
	}
		}
		
		
	}
	public void addProduct()
	{
		System.out.println("Enter the Product ID:");
		int productId=s.nextInt();
		System.out.println("Enter the Product Name:");
		String productName=s.nextLine();
		System.out.println("Enter the Description:");
		String description=s.nextLine();
		System.out.println("Enter the Price:");
		double price=s.nextDouble();
		System.out.println("Enter the Manufacturing Date:");
		String manufacturingDate=s.nextLine();
		System.out.println("Enter the Expiry Date:");
		String expiryDate=s.nextLine();
		
		//call constructor;
		
		System.out.println("---Product Details Added---");
		
		
		
	}
	public void updateProduct()
	{
		System.out.println("Enter the Product ID to update:");
		int prouctId=s.nextInt();
		
		//show the previous productname,description,price,dates
		
		System.out.println("Enter the Updated Description");
		String description=s.nextLine();
		System.out.println("Enter the Updated Price:");
		double price=s.nextDouble();
		System.out.println("Enter the Updated Manufacturing Date:");
		String manufacturingDate=s.nextLine();
		System.out.println("Enter the Updated Expiry Date:");
		String expiryDate=s.nextLine();
		
		//call constructor  for updating
		
		System.out.println("---Product Details Updated---");
		
	}
	public void deleteProduct()
	{

		System.out.println("Enter the Product ID to Delete:");
		int prouctId=s.nextInt();
		
		//call the constructor  also show that detail
		
		System.out.println("---Product Details Deleted---");
		
	}
	public void searchProductById()
	{

		System.out.println("Enter the Product ID to Delete:");
		int prouctId=s.nextInt();
		
		
		
		//show the details of id in arraylist
		
		
	}
	public void searchProductByName()
	{
		
		System.out.println("Enter the Product Name:");
		String productName=s.nextLine();
		
		//show the details of the name
		
	}
	public void showAllProduct()
	{
		
		System.out.println("All Details of Product");
		
		
		// show all the details
		
	}

}
