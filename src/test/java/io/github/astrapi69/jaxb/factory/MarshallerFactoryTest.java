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
package io.github.astrapi69.jaxb.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.jaxb.Club;
import io.github.astrapi69.jaxb.Employee;
import io.github.astrapi69.jaxb.TestDataFactory;

class MarshallerFactoryTest
{

	@Test
	void getPrettyPrintMarshaller()
	{
		Marshaller actual;
		Club club = TestDataFactory.newClub();
		actual = MarshallerFactory.getPrettyPrintMarshaller(club);
		assertNotNull(actual);
	}

	@Test
	void getMarshallerWithClass() throws JAXBException
	{
		Marshaller actual;
		actual = MarshallerFactory.getMarshaller(Employee.class);
		assertNotNull(actual);
	}

	@Test
	void getMarshallerWithClassWithNullValue()
	{
		String actual;
		String expected;

		NullPointerException nullPointerException = Assertions
			.assertThrows(NullPointerException.class, () -> MarshallerFactory.getMarshaller(null));
		expected = "clazz is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

	@Test
	void testGetMarshallerWithContextAndClassWithNullValue()
	{
		String actual;
		String expected;

		NullPointerException nullPointerException = Assertions.assertThrows(
			NullPointerException.class, () -> MarshallerFactory.getMarshaller(null, null));
		expected = "clazz is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

	@Test
	void testGetMarshallerWithContextAndClass() throws JAXBException
	{
		Marshaller actual;
		actual = MarshallerFactory.getMarshaller(null, Employee.class);
		assertNotNull(actual);
	}

	@Test
	void testGetMarshallerWithObjectWithNullValue()
	{
		String actual;
		String expected;
		Club club;

		club = null;
		NullPointerException nullPointerException = Assertions
			.assertThrows(NullPointerException.class, () -> MarshallerFactory.getMarshaller(club));
		expected = "object is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getPrettyPrintMarshallerWithNullValue()
	{
		String actual;
		String expected;
		Club club;

		club = null;
		NullPointerException nullPointerException = Assertions.assertThrows(
			NullPointerException.class, () -> MarshallerFactory.getPrettyPrintMarshaller(club));
		expected = "object is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

	@Test
	void testGetMarshallerWithContextAndClassAndProperties() throws JAXBException
	{
		Marshaller actual;
		Map<String, Object> marshallerProperties;

		marshallerProperties = new HashMap<>();
		marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		actual = MarshallerFactory.getMarshaller(JAXBContext.newInstance(Employee.class),
			Employee.class, marshallerProperties);
		assertNotNull(actual);
		marshallerProperties.clear();
		actual = MarshallerFactory.getMarshaller(JAXBContext.newInstance(Employee.class),
			Employee.class, marshallerProperties);
		assertNotNull(actual);
		marshallerProperties = null;
		actual = MarshallerFactory.getMarshaller(JAXBContext.newInstance(Employee.class),
			Employee.class, marshallerProperties);
		assertNotNull(actual);
	}

	@Test
	void testGetMarshallerWithContextAndClassAndPropertiesWithNullValue()
	{
		String actual;
		String expected;
		Map<String, Object> marshallerProperties;

		marshallerProperties = new HashMap<>();
		marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		NullPointerException nullPointerException = Assertions.assertThrows(
			NullPointerException.class,
			() -> MarshallerFactory.getMarshaller(JAXBContext.newInstance(Employee.class), null,
				marshallerProperties));
		expected = "clazz is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

	@Test
	void testAddPropertiesWithNullValue()
	{
		String actual;
		String expected;
		Map<String, Object> marshallerProperties;

		marshallerProperties = new HashMap<>();
		marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		NullPointerException nullPointerException = Assertions.assertThrows(
			NullPointerException.class,
			() -> MarshallerFactory.addProperties(null, marshallerProperties));
		expected = "marshaller is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link MarshallerFactory}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(MarshallerFactory.class);
	}
}
