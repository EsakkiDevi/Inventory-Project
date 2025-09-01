package app;
import java.util.*;
public class inventory {

	public static void main(String[] args) {
		
		ProductManagement p=new ProductManagement();
		SupplierManagement sc=new SupplierManagement();
		
		Scanner s=new Scanner(System.in);
		System.out.println("---Inventory---");
		while(true)
		{
		menu();
		
			System.out.println("Choose the option");
			int option=s.nextInt();
			
			switch(option)
			{
			case 1:
				p.ProductMethods();
				break;
				
			case 2:
			
				sc.SupplierMethods();
				break;
				
			case 3:
				System.out.println("Exiting......");
				System.exit(0);
			
				
				
			}
		}

	}
	public static void menu()
	{
		System.out.println("1.Product Management");
		System.out.println("2.Supplier Management");
		System.out.println("3.Exit");
		
	}

}
