package io.github.astrapi69.jaxb;

import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "io.github.astrapi69.jaxb")
public class Company
{
	@XmlElementWrapper(name = "employeeList")
	@XmlElement(name = "employee")
	List<Employee> employeeList;
	private String name;
	private String location;

	// Note the name is not getEmployeeList but getEmployeesList!!!
	public List<Employee> getEmployeesList()
	{
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList)
	{
		this.employeeList = employeeList;
	}


	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Company company = (Company)o;
		return Objects.equals(employeeList, company.employeeList)
			&& Objects.equals(name, company.name) && Objects.equals(location, company.location);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(employeeList, name, location);
	}
}
