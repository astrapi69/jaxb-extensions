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

import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The unit test class for the class {@link ClassToXsdExtensions}
 */
class ClassToXsdExtensionsTest
{

	/**
	 * Test method for {@link ClassToXsdExtensions#classToXsd(Class[])}
	 */
	@Test
	void classToXsd() throws JAXBException, IOException
	{
		String actual;
		String expected;

		actual = ClassToXsdExtensions.classToXsd();
		expected = "";
		assertEquals(expected, actual);

		actual = ClassToXsdExtensions.classToXsd(Employee.class);
		expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
			+ "<xs:schema version=\"1.0\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n" + "\n"
			+ "  <xs:complexType name=\"employee\">\n" + "    <xs:sequence>\n"
			+ "      <xs:element name=\"id\" type=\"xs:string\" minOccurs=\"0\"/>\n"
			+ "      <xs:element name=\"person\" type=\"person\" minOccurs=\"0\"/>\n"
			+ "      <xs:element name=\"subOrdinates\" type=\"employee\" nillable=\"true\" minOccurs=\"0\" maxOccurs=\"unbounded\"/>\n"
			+ "    </xs:sequence>\n" + "  </xs:complexType>\n" + "\n"
			+ "  <xs:complexType name=\"person\">\n" + "    <xs:sequence>\n"
			+ "      <xs:element name=\"about\" type=\"xs:string\" minOccurs=\"0\"/>\n"
			+ "      <xs:element name=\"gender\" type=\"gender\" minOccurs=\"0\"/>\n"
			+ "      <xs:element name=\"married\" type=\"xs:boolean\" minOccurs=\"0\"/>\n"
			+ "      <xs:element name=\"name\" type=\"xs:string\" minOccurs=\"0\"/>\n"
			+ "      <xs:element name=\"nickname\" type=\"xs:string\" minOccurs=\"0\"/>\n"
			+ "    </xs:sequence>\n" + "  </xs:complexType>\n" + "\n"
			+ "  <xs:simpleType name=\"gender\">\n" + "    <xs:restriction base=\"xs:string\">\n"
			+ "      <xs:enumeration value=\"FEMALE\"/>\n"
			+ "      <xs:enumeration value=\"MALE\"/>\n"
			+ "      <xs:enumeration value=\"UNDEFINED\"/>\n" + "    </xs:restriction>\n"
			+ "  </xs:simpleType>\n" + "</xs:schema>\n" + "\n";
		assertEquals(expected, actual);

		actual = ClassToXsdExtensions.classToXsd(Person.class, Company.class);
		expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
			+ "<xs:schema version=\"1.0\" targetNamespace=\"io.github.astrapi69.jaxb\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n"
			+ "\n" + "  <xs:import schemaLocation=\"schema2.xsd\"/>\n" + "\n"
			+ "  <xs:element name=\"company\" type=\"company\"/>\n" + "\n" + "</xs:schema>\n" + "\n"
			+ "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
			+ "<xs:schema version=\"1.0\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n" + "\n"
			+ "  <xs:element name=\"employee\" type=\"employee\"/>\n" + "\n"
			+ "  <xs:complexType name=\"person\">\n" + "    <xs:sequence>\n"
			+ "      <xs:element name=\"about\" type=\"xs:string\" minOccurs=\"0\"/>\n"
			+ "      <xs:element name=\"gender\" type=\"gender\" minOccurs=\"0\"/>\n"
			+ "      <xs:element name=\"married\" type=\"xs:boolean\" minOccurs=\"0\"/>\n"
			+ "      <xs:element name=\"name\" type=\"xs:string\" minOccurs=\"0\"/>\n"
			+ "      <xs:element name=\"nickname\" type=\"xs:string\" minOccurs=\"0\"/>\n"
			+ "    </xs:sequence>\n" + "  </xs:complexType>\n" + "\n"
			+ "  <xs:complexType name=\"company\">\n" + "    <xs:sequence>\n"
			+ "      <xs:element name=\"employeeList\" minOccurs=\"0\">\n"
			+ "        <xs:complexType>\n" + "          <xs:sequence>\n"
			+ "            <xs:element ref=\"employee\" minOccurs=\"0\" maxOccurs=\"unbounded\"/>\n"
			+ "          </xs:sequence>\n" + "        </xs:complexType>\n" + "      </xs:element>\n"
			+ "      <xs:element name=\"location\" type=\"xs:string\" minOccurs=\"0\"/>\n"
			+ "      <xs:element name=\"name\" type=\"xs:string\" minOccurs=\"0\"/>\n"
			+ "    </xs:sequence>\n" + "  </xs:complexType>\n" + "\n"
			+ "  <xs:complexType name=\"employee\">\n" + "    <xs:sequence>\n"
			+ "      <xs:element name=\"id\" type=\"xs:string\" minOccurs=\"0\"/>\n"
			+ "      <xs:element name=\"gender\" type=\"xs:string\" minOccurs=\"0\"/>\n"
			+ "      <xs:element name=\"name\" type=\"xs:string\" minOccurs=\"0\"/>\n"
			+ "      <xs:element name=\"married\" type=\"xs:boolean\" minOccurs=\"0\"/>\n"
			+ "    </xs:sequence>\n" + "  </xs:complexType>\n" + "\n"
			+ "  <xs:simpleType name=\"gender\">\n" + "    <xs:restriction base=\"xs:string\">\n"
			+ "      <xs:enumeration value=\"FEMALE\"/>\n"
			+ "      <xs:enumeration value=\"MALE\"/>\n"
			+ "      <xs:enumeration value=\"UNDEFINED\"/>\n" + "    </xs:restriction>\n"
			+ "  </xs:simpleType>\n" + "</xs:schema>\n" + "\n";
		assertEquals(expected, actual);
	}
}
