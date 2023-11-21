package com.learning.service;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringJdbcService 
{
	@Autowired
	private CRUD_Operations co;
	public void show_menu()
	{
		while(true)
		{
			System.out.println("\t\tMenu");
			System.out.println("1.Create New Record");
			System.out.println("2.Retrive Record");
			System.out.println("3.Update Record");
			System.out.println("4.Delete Record");
			System.out.println("5.View All Records");
			System.out.println("6.Exit");
			System.out.print("Please select Your Choice : ");
			Scanner sc=new Scanner(System.in);
			int choice=Integer.parseInt(sc.next());
			
			switch(choice)
			{
				case 1 :co.create();
						  break;
				case 2 :co.read();
				  		  break;
				case 3 :co.update();
				          break;
				case 4 :co.delete();
		  		  		  break;
				case 5 :co.allRecords();
						  break;
				case 6 :  System.out.println("---------------------------------");
						  System.out.println("Thanks For Using Application\nHave a Wonderful day");
						  System.out.println("---------------------------------");
						  System.exit(0);
				default  :System.out.println("Invalid Choice...\nPlease Select a Valid Choice(1 to 6)");
						  continue;
			}
		}
	}
}
