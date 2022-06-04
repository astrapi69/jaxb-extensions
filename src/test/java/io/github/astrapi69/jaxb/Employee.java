package io.github.astrapi69.jaxb;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "employee")
@XmlType(propOrder = { "id", "gender", "name", "married" })
public class Employee
{

	/**
	 * The id.
	 */
	private String id;

	/**
	 * The about.
	 */
	private String gender;

	/**
	 * The name.
	 */
	private String name;

	/**
	 * The married flag.
	 */
	private Boolean married;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Boolean getMarried()
	{
		return married;
	}

	public void setMarried(Boolean married)
	{
		this.married = married;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Employee employee = (Employee)o;
		return Objects.equals(id, employee.id) && Objects.equals(gender, employee.gender)
			&& Objects.equals(name, employee.name) && Objects.equals(married, employee.married);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id, gender, name, married);
	}
}
