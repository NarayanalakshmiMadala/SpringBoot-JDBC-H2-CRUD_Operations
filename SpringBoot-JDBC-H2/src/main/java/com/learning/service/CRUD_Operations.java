package com.learning.service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dao.SpringJdbcDao;
import com.learning.jdbc.CourceInfo;

@Service
public class CRUD_Operations 
{
	@Autowired
	private SpringJdbcDao app;
	
	//Inserting new Record
	public void create()
	{
		System.out.println("---------------------------------");
		System.out.println("Inserting Data to Database : ");
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Id :");
		int id=Integer.parseInt(sc.nextLine());
		
		System.out.print("Enter CourseName :");
		String courceName=sc.nextLine();
		
		System.out.print("Enter CourceFee :");
		int courceFee=Integer.parseInt(sc.nextLine());
		
		int rows=app.insert(new CourceInfo(id,courceName,courceFee));
		if(rows > 0)
		{
			System.out.println("---------------------------------");
			System.out.println("Data Entered Succesfully");
			System.out.println("---------------------------------");
		}
		else
		{
			System.out.println("---------------------------------");
			System.out.println("Failed to store the record");
			System.out.println("---------------------------------");
		} 
	}
	
	//To Retrieve a Particular Record with Known ID
	public void read()
	{
		System.out.println("---------------------------------");
		System.out.println("Retrive a Partcular Record ");
		System.out.print("Enter ID : ");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		List<CourceInfo> li=app.findById(id);
		Iterator<CourceInfo> itr=li.iterator();
		if(itr.hasNext())
		{
			System.out.println("---------------------------------");
			System.out.println("Record Found ");
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}
			System.out.println("---------------------------------");
		}
		else
		{
			System.out.println("---------------------------------");
			System.out.println("No record Found in Database...");
			System.out.println("---------------------------------");
		}
	}
	public void update()
	{
		System.out.println("---------------------------------");
		System.out.println("Updating Record");
		System.out.print("Enter ID : ");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		List<CourceInfo> li=app.findById(id);
		if(li.size()>1)
		{
			System.out.println("---------------------------------");
			System.out.println("More than One Record Found With the same ID");
			Iterator<CourceInfo> itr=li.iterator();
			if(itr.hasNext())
			{
				while(itr.hasNext())
				{
					System.out.println(itr.next());
					System.out.println("---------------------------------");
				}
			}
		}
		else if(li.size()==1)
		{
			System.out.println("---------------------------------");
			System.out.println("Record Found in Database...");
			System.out.print("Enter Updated CourceName : ");
			sc.nextLine();
			String cName=sc.nextLine();
			System.out.println("Updated Name : "+cName);
			
			System.out.print("Enter Updated CourceFee :");
			int courceFee=Integer.parseInt(sc.nextLine());
			System.out.println("---------------------------------");
			int rows=app.update(new CourceInfo(id,cName,courceFee));
			if(rows > 0)
			{
				System.out.println("---------------------------------");
				System.out.println("Record Updated Successfuly");
				System.out.println("---------------------------------");
			}
			else
			{
				System.out.println("---------------------------------");
				System.out.println("Failed To Update the Record...");
				System.out.println("---------------------------------");
			}
		}
		else
		{
			System.out.println("---------------------------------");
			System.out.println("No record Found in Database to Update");
			System.out.println("---------------------------------");
		}
	}
	
	//To Retrieve All Records
	public void allRecords()
	{
		List<CourceInfo> list=app.findAll();
		Iterator<CourceInfo> it=list.iterator();
		System.out.println("---------------------------------");
		System.out.println("Fetching All Records");
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		System.out.println("---------------------------------");
		 
	}
	
	//To delete Particular Record with Known ID
	public void delete()
	{
		System.out.println("---------------------------------");
		System.out.print("Enter ID To be deleted..: ");
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		if(app.deleteById(id)>0)
		{
			System.out.println("---------------------------------");
			System.out.println("Record Deleted From Database..");
			System.out.println("---------------------------------");
		}
		else {
			System.out.println("---------------------------------");
			System.out.println("No record found to Delete");
			System.out.println("---------------------------------");
		}
	}
}
