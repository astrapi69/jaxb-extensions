package io.github.astrapi69.jaxb;

import java.util.ArrayList;
import java.util.List;

public class TestDataFactory
{

	public static Club newClub()
	{
		List persons = new ArrayList<Person>();

		persons.add(Person.builder().name("Lea").gender("woman").married(Boolean.FALSE)
			.nickname("princess").build());

		persons.add(Person.builder().name("Luke").gender("man").married(Boolean.FALSE)
			.nickname("wannabejedi").build());

		Club company = new Club();
		company.setPersonsList(persons);
		company.setLocation("Greece/Katerini");
		company.setName("StarPiece");
		return company;
	}


	public static Company newCompany()
	{
		List employees = new ArrayList<Employee>();

		Employee employee1 = new Employee();
		employee1.setGender("woman");
		employee1.setId("1");
		employee1.setName("Lea");
		employee1.setMarried(Boolean.FALSE);
		employees.add(employee1);

		Employee employee2 = new Employee();
		employee2.setGender("man");
		employee2.setId("2");
		employee2.setName("Luke");
		employee2.setMarried(Boolean.FALSE);
		employees.add(employee2);

		Company company = new Company();
		company.setEmployeeList(employees);
		company.setLocation("Greece/Katerini");
		company.setName("StarPiece");
		return company;
	}
}
