package app;
import java.util.*;

public class SupplierManagement {
	
	Scanner s=new Scanner(System.in);
	void SupplierMethods()
	{
		while(true)
		{
		
		System.out.println("---Supplier Management---");
		System.out.println("1.Add new Supplier");
		System.out.println("2.Update Supplier details");
		System.out.println("3.Delete Supplier details");
		System.out.println("4.Show all Supplier Details");
		System.out.println("5.Exit");
		
		
		System.out.println("Choose the Option ");
		int option=s.nextInt();
		
		switch(option)
		{
		case 1:
			addSupplier();
			break;
			
		case 2:
			updateSupplier();
			break;
			
		case 3:
			deleteSupplier();
			break;
			
		case 4:
			showAllSupplierDetails();
			break;
			
		case 5:
			System.out.println("Exiting.....");
			System.exit(0);
			
		default:
			System.out.println("Inavlid Option....!");
		}
		}
		
	}


	void addSupplier()
	{
		System.out.println("Enter the Supplier ID:");
		int supplierId=s.nextInt();
		System.out.println("Enter the Supplier Name:");
		String supplierName=s.nextLine();
		System.out.println("Enter the ContactPerson:");
		String person=s.nextLine();
		System.out.println("Enter the PhoneNumber:");
		String phoneNumber=s.nextLine();
		System.out.println("Enter the email:");
		String email=s.nextLine();
		System.out.println("Enter the Address:");
		String address=s.nextLine();
		
		
		//add details pojo class and arraylist;
		
		System.out.println("---Added Supplier Details---");
		
		
	}
	void updateSupplier()
	{
		System.out.println("Enter the Supplier ID to Update:");
		int supplierId=s.nextInt();
		//show old details of the id
		
		System.out.println("Enter the Updated Supplier Name:");
		String supplierName=s.nextLine();
		System.out.println("Enter the Updated ContactPerson:");
		String person=s.nextLine();
		System.out.println("Enter the Updated PhoneNumber:");
		String phoneNumber=s.nextLine();
		System.out.println("Enter the Updated email:");
		String email=s.nextLine();
		System.out.println("Enter the Updated Address:");
		String address=s.nextLine();
		
		//add updated details to arraylist through pojo
		
		System.out.println("---Updated Supplier Details---");
		
		
		
	}
	void deleteSupplier()
	{
		
		System.out.println("Enter the Supplier ID to Delete:");
		int supplierId=s.nextInt();
		
		//delete by id
		
		System.out.println("---Deleted Supplier Details---");
		
		
	}
	void showAllSupplierDetails()
	{
		
		System.out.println("All Supplier Details");
		//show them;
		
	}

}
