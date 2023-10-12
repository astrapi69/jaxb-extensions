/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.jaxb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.file.create.DirectoryFactory;
import io.github.astrapi69.file.create.FileFactory;
import io.github.astrapi69.file.delete.DeleteFileExtensions;
import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.file.search.FileSearchExtensions;
import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.jaxb.menu.model.MenuModel;
import io.github.astrapi69.jaxb.model.Company;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import jakarta.xml.bind.JAXBException;

/**
 * The unit test class for the class {@link ClassToXsdExtensions}
 */
class ClassToXsdExtensionsTest
{

	/**
	 * Test method for {@link ClassToXsdExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ClassToXsdExtensions.class);
	}

	/**
	 * Test method for {@link ClassToXsdExtensions#classesToXsdFile(File, Class[])}
	 */
	@Test
	void classesToXsdFile() throws JAXBException, IOException
	{
		String actual;
		String expected;
		File xsdFile;
		File generatedDir;
		boolean exists;

		generatedDir = DirectoryFactory.newDirectory(PathFinder.getSrcTestResourcesDir(),
			"generated");
		// new scenario ...
		xsdFile = FileFactory.newFile(generatedDir, "Person.xsd");

		ClassToXsdExtensions.classesToXsdFile(xsdFile, Person.class);
		exists = FileSearchExtensions.containsFile(generatedDir, xsdFile);
		assertTrue(exists);
		actual = ReadFileExtensions.fromFile(xsdFile);
		// cleanup
		DeleteFileExtensions.delete(xsdFile);

		expected = """
			<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			<xs:schema version="1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema">

			  <xs:complexType name="person">
			    <xs:sequence>
			      <xs:element name="about" type="xs:string" minOccurs="0"/>
			      <xs:element name="gender" type="gender" minOccurs="0"/>
			      <xs:element name="married" type="xs:boolean" minOccurs="0"/>
			      <xs:element name="name" type="xs:string" minOccurs="0"/>
			      <xs:element name="nickname" type="xs:string" minOccurs="0"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:simpleType name="gender">
			    <xs:restriction base="xs:string">
			      <xs:enumeration value="FEMALE"/>
			      <xs:enumeration value="MALE"/>
			      <xs:enumeration value="UNDEFINED"/>
			    </xs:restriction>
			  </xs:simpleType>
			</xs:schema>

			""";
		assertEquals(expected, actual);
		// new scenario ...
		xsdFile = FileFactory.newFile(generatedDir, "MenuModel.xsd");

		ClassToXsdExtensions.classesToXsdFile(xsdFile, MenuModel.class);
		exists = FileSearchExtensions.containsFile(generatedDir, xsdFile);
		assertTrue(exists);
		actual = ReadFileExtensions.fromFile(xsdFile);
		// cleanup
		DeleteFileExtensions.delete(xsdFile);
		expected = """
			<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			<xs:schema version="1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema">

			  <xs:element name="KeyStrokeModel" type="keyStrokeModel"/>

			  <xs:element name="MenuModel" type="menuModel"/>

			  <xs:complexType name="menuModel">
			    <xs:sequence>
			      <xs:element name="name" type="xs:string" minOccurs="0"/>
			      <xs:element name="text" type="xs:string" minOccurs="0"/>
			      <xs:element name="mnemonic" type="xs:int" minOccurs="0"/>
			      <xs:element name="ordinal" type="xs:int"/>
			      <xs:element name="keyStrokeModel" type="keyStrokeModel" minOccurs="0"/>
			      <xs:element name="type" type="menuType" minOccurs="0"/>
			      <xs:element name="anchor" type="anchor" minOccurs="0"/>
			      <xs:element name="relativeToMenuId" type="xs:string" minOccurs="0"/>
			      <xs:element name="actionCommand" type="xs:string" minOccurs="0"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:complexType name="keyStrokeModel">
			    <xs:sequence>
			      <xs:element name="keyChar" type="xs:unsignedShort" minOccurs="0"/>
			      <xs:element name="keyCode" type="xs:int" minOccurs="0"/>
			      <xs:element name="modifiers" type="xs:int" minOccurs="0"/>
			      <xs:element name="onKeyRelease" type="xs:boolean" minOccurs="0"/>
			      <xs:element name="keystrokeAsString" type="xs:string" minOccurs="0"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:simpleType name="menuType">
			    <xs:restriction base="xs:string">
			      <xs:enumeration value="SYSTEM_TRAY"/>
			      <xs:enumeration value="MENU_BAR"/>
			      <xs:enumeration value="TOOL_BAR"/>
			      <xs:enumeration value="MENU"/>
			      <xs:enumeration value="MENU_ITEM"/>
			      <xs:enumeration value="CHECK_BOX_MENU_ITEM"/>
			      <xs:enumeration value="RADIO_BUTTON_MENU_ITEM"/>
			      <xs:enumeration value="POPUP"/>
			    </xs:restriction>
			  </xs:simpleType>

			  <xs:simpleType name="anchor">
			    <xs:restriction base="xs:string">
			      <xs:enumeration value="BEFORE"/>
			      <xs:enumeration value="AFTER"/>
			      <xs:enumeration value="FIRST"/>
			      <xs:enumeration value="LAST"/>
			    </xs:restriction>
			  </xs:simpleType>
			</xs:schema>

						""";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ClassToXsdExtensions#classesToXsdFile(File, Class[])}
	 */
	@Test
	@Disabled
	void classesToXsdFileWithMoreClasses() throws JAXBException, IOException
	{
		String actual;
		String expected;
		File xsdFile;
		File generatedDir;

		generatedDir = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "generated");
		xsdFile = FileFactory.newFile(generatedDir, "PersonAndCompany.xsd");

		ClassToXsdExtensions.classesToXsdFile(xsdFile, Person.class, Company.class);

		actual = ReadFileExtensions.fromFile(xsdFile);
		// cleanup
		DeleteFileExtensions.delete(xsdFile);

		expected = """
			<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			<xs:schema version="1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema">

			  <xs:element name="employee" type="employee"/>

			  <xs:complexType name="person">
			    <xs:sequence>
			      <xs:element name="about" type="xs:string" minOccurs="0"/>
			      <xs:element name="gender" type="gender" minOccurs="0"/>
			      <xs:element name="married" type="xs:boolean" minOccurs="0"/>
			      <xs:element name="name" type="xs:string" minOccurs="0"/>
			      <xs:element name="nickname" type="xs:string" minOccurs="0"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:complexType name="company">
			    <xs:sequence>
			      <xs:element name="employeeList" minOccurs="0">
			        <xs:complexType>
			          <xs:sequence>
			            <xs:element ref="employee" minOccurs="0" maxOccurs="unbounded"/>
			          </xs:sequence>
			        </xs:complexType>
			      </xs:element>
			      <xs:element name="location" type="xs:string" minOccurs="0"/>
			      <xs:element name="name" type="xs:string" minOccurs="0"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:complexType name="employee">
			    <xs:sequence>
			      <xs:element name="id" type="xs:string" minOccurs="0"/>
			      <xs:element name="gender" type="xs:string" minOccurs="0"/>
			      <xs:element name="name" type="xs:string" minOccurs="0"/>
			      <xs:element name="married" type="xs:boolean" minOccurs="0"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:simpleType name="gender">
			    <xs:restriction base="xs:string">
			      <xs:enumeration value="FEMALE"/>
			      <xs:enumeration value="MALE"/>
			      <xs:enumeration value="UNDEFINED"/>
			    </xs:restriction>
			  </xs:simpleType>
			</xs:schema>

			<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			<xs:schema version="1.0" targetNamespace="io.github.astrapi69.jaxb" xmlns:xs="http://www.w3.org/2001/XMLSchema">

			  <xs:import schemaLocation="schema2.xsd"/>

			  <xs:element name="company" type="company"/>

			</xs:schema>

			""";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ClassToXsdExtensions#classToXsdFile(Class, File)}
	 */
	@Test
	void classToXsdFile() throws JAXBException, IOException
	{
		String actual;
		String expected;
		File xsdFile;
		File generatedDir;

		generatedDir = DirectoryFactory.newDirectory(PathFinder.getSrcTestResourcesDir(),
			"generated");
		xsdFile = FileFactory.newFile(generatedDir, "Employee.xsd");

		ClassToXsdExtensions.classToXsdFile(Employee.class, xsdFile);

		actual = ReadFileExtensions.fromFile(xsdFile);
		// cleanup
		DeleteFileExtensions.delete(xsdFile);

		expected = """
			<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			<xs:schema version="1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema">

			  <xs:complexType name="employee">
			    <xs:sequence>
			      <xs:element name="id" type="xs:string" minOccurs="0"/>
			      <xs:element name="person" type="person" minOccurs="0"/>
			      <xs:element name="subOrdinates" type="employee" nillable="true" minOccurs="0" maxOccurs="unbounded"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:complexType name="person">
			    <xs:sequence>
			      <xs:element name="about" type="xs:string" minOccurs="0"/>
			      <xs:element name="gender" type="gender" minOccurs="0"/>
			      <xs:element name="married" type="xs:boolean" minOccurs="0"/>
			      <xs:element name="name" type="xs:string" minOccurs="0"/>
			      <xs:element name="nickname" type="xs:string" minOccurs="0"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:simpleType name="gender">
			    <xs:restriction base="xs:string">
			      <xs:enumeration value="FEMALE"/>
			      <xs:enumeration value="MALE"/>
			      <xs:enumeration value="UNDEFINED"/>
			    </xs:restriction>
			  </xs:simpleType>
			</xs:schema>

			""";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ClassToXsdExtensions#classToXsdString(Class)}
	 */
	@Test
	void classToXsdString() throws JAXBException, IOException
	{

		String actual;
		String expected;

		actual = ClassToXsdExtensions.classToXsdString(Employee.class);

		expected = """
			<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			<xs:schema version="1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema">

			  <xs:complexType name="employee">
			    <xs:sequence>
			      <xs:element name="id" type="xs:string" minOccurs="0"/>
			      <xs:element name="person" type="person" minOccurs="0"/>
			      <xs:element name="subOrdinates" type="employee" nillable="true" minOccurs="0" maxOccurs="unbounded"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:complexType name="person">
			    <xs:sequence>
			      <xs:element name="about" type="xs:string" minOccurs="0"/>
			      <xs:element name="gender" type="gender" minOccurs="0"/>
			      <xs:element name="married" type="xs:boolean" minOccurs="0"/>
			      <xs:element name="name" type="xs:string" minOccurs="0"/>
			      <xs:element name="nickname" type="xs:string" minOccurs="0"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:simpleType name="gender">
			    <xs:restriction base="xs:string">
			      <xs:enumeration value="FEMALE"/>
			      <xs:enumeration value="MALE"/>
			      <xs:enumeration value="UNDEFINED"/>
			    </xs:restriction>
			  </xs:simpleType>
			</xs:schema>

			""";
		assertEquals(expected, actual);

		actual = ClassToXsdExtensions.classToXsdString(Person.class);
		expected = """
			<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			<xs:schema version="1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema">

			  <xs:complexType name="person">
			    <xs:sequence>
			      <xs:element name="about" type="xs:string" minOccurs="0"/>
			      <xs:element name="gender" type="gender" minOccurs="0"/>
			      <xs:element name="married" type="xs:boolean" minOccurs="0"/>
			      <xs:element name="name" type="xs:string" minOccurs="0"/>
			      <xs:element name="nickname" type="xs:string" minOccurs="0"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:simpleType name="gender">
			    <xs:restriction base="xs:string">
			      <xs:enumeration value="FEMALE"/>
			      <xs:enumeration value="MALE"/>
			      <xs:enumeration value="UNDEFINED"/>
			    </xs:restriction>
			  </xs:simpleType>
			</xs:schema>

			""";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ClassToXsdExtensions#classesToXsdString(Class[])}
	 */
	@Test
	void classesToXsdString() throws JAXBException, IOException
	{
		String actual;
		String expected;

		actual = ClassToXsdExtensions.classesToXsdString();
		expected = "";
		assertEquals(expected, actual);

		actual = ClassToXsdExtensions.classesToXsdString(Employee.class);

		expected = """
			<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			<xs:schema version="1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema">

			  <xs:complexType name="employee">
			    <xs:sequence>
			      <xs:element name="id" type="xs:string" minOccurs="0"/>
			      <xs:element name="person" type="person" minOccurs="0"/>
			      <xs:element name="subOrdinates" type="employee" nillable="true" minOccurs="0" maxOccurs="unbounded"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:complexType name="person">
			    <xs:sequence>
			      <xs:element name="about" type="xs:string" minOccurs="0"/>
			      <xs:element name="gender" type="gender" minOccurs="0"/>
			      <xs:element name="married" type="xs:boolean" minOccurs="0"/>
			      <xs:element name="name" type="xs:string" minOccurs="0"/>
			      <xs:element name="nickname" type="xs:string" minOccurs="0"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:simpleType name="gender">
			    <xs:restriction base="xs:string">
			      <xs:enumeration value="FEMALE"/>
			      <xs:enumeration value="MALE"/>
			      <xs:enumeration value="UNDEFINED"/>
			    </xs:restriction>
			  </xs:simpleType>
			</xs:schema>

			""";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ClassToXsdExtensions#classesToXsdString(Class[])}
	 */
	@Test
	@Disabled
	void classesToXsdStringWithMoreClasses() throws JAXBException, IOException
	{
		String actual;
		String expected;

		actual = ClassToXsdExtensions.classesToXsdString(Person.class, Company.class);
		expected = """
			<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			<xs:schema version="1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema">

			  <xs:element name="employee" type="employee"/>

			  <xs:complexType name="person">
			    <xs:sequence>
			      <xs:element name="about" type="xs:string" minOccurs="0"/>
			      <xs:element name="gender" type="gender" minOccurs="0"/>
			      <xs:element name="married" type="xs:boolean" minOccurs="0"/>
			      <xs:element name="name" type="xs:string" minOccurs="0"/>
			      <xs:element name="nickname" type="xs:string" minOccurs="0"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:complexType name="company">
			    <xs:sequence>
			      <xs:element name="employeeList" minOccurs="0">
			        <xs:complexType>
			          <xs:sequence>
			            <xs:element ref="employee" minOccurs="0" maxOccurs="unbounded"/>
			          </xs:sequence>
			        </xs:complexType>
			      </xs:element>
			      <xs:element name="location" type="xs:string" minOccurs="0"/>
			      <xs:element name="name" type="xs:string" minOccurs="0"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:complexType name="employee">
			    <xs:sequence>
			      <xs:element name="id" type="xs:string" minOccurs="0"/>
			      <xs:element name="gender" type="xs:string" minOccurs="0"/>
			      <xs:element name="name" type="xs:string" minOccurs="0"/>
			      <xs:element name="married" type="xs:boolean" minOccurs="0"/>
			    </xs:sequence>
			  </xs:complexType>

			  <xs:simpleType name="gender">
			    <xs:restriction base="xs:string">
			      <xs:enumeration value="FEMALE"/>
			      <xs:enumeration value="MALE"/>
			      <xs:enumeration value="UNDEFINED"/>
			    </xs:restriction>
			  </xs:simpleType>
			</xs:schema>

			<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
			<xs:schema version="1.0" targetNamespace="io.github.astrapi69.jaxb" xmlns:xs="http://www.w3.org/2001/XMLSchema">

			  <xs:import schemaLocation="schema2.xsd"/>

			  <xs:element name="company" type="company"/>

			</xs:schema>

			""";
		assertEquals(expected, actual);
	}
}
