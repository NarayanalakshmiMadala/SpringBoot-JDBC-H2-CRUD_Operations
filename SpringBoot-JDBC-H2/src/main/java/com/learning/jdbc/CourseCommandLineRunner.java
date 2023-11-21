package com.learning.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learning.service.SpringJdbcService;

@Component
public class CourseCommandLineRunner implements CommandLineRunner
{
	@Autowired
	SpringJdbcService sjd;
	@Override
	public void run(String... args) throws Exception
	{
		System.out.println("=========================================================");
		System.out.println("\tSpringBoot-JDBC-H2-CRUD Operations");
		System.out.println("=========================================================");
		sjd.show_menu();
	}
}
