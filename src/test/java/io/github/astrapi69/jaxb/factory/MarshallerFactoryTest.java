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

/**
 * The unit test class for the class {@link MarshallerFactory}
 */
class MarshallerFactoryTest
{

	/**
	 * Test method for {@link MarshallerFactory#newPrettyPrintMarshaller(Object)}
	 */
	@Test
	void testNewPrettyPrintMarshaller()
	{
		Marshaller actual;
		Club club = TestDataFactory.newClub();
		actual = MarshallerFactory.newPrettyPrintMarshaller(club);
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link MarshallerFactory#newMarshaller(Class)}
	 *
	 * @throws JAXBException
	 *             is thrown if an error was encountered while creating the {@code JAXBContext}
	 */
	@Test
	void getMarshallerWithClass() throws JAXBException
	{
		Marshaller actual;
		actual = MarshallerFactory.newMarshaller(Employee.class);
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link MarshallerFactory#newMarshaller(Class)}
	 */
	@Test
	void getMarshallerWithClassWithNullValue()
	{
		String actual;
		String expected;

		NullPointerException nullPointerException = Assertions
			.assertThrows(NullPointerException.class, () -> MarshallerFactory.newMarshaller(null));
		expected = "clazz is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link MarshallerFactory#newMarshaller(JAXBContext, Class)}
	 */
	@Test
	void testGetMarshallerWithContextAndClassWithNullValue()
	{
		String actual;
		String expected;

		NullPointerException nullPointerException = Assertions.assertThrows(
			NullPointerException.class, () -> MarshallerFactory.newMarshaller(null, null));
		expected = "clazz is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link MarshallerFactory#newMarshaller(JAXBContext, Class)}
	 */
	@Test
	void testGetMarshallerWithContextAndClass() throws JAXBException
	{
		Marshaller actual;
		actual = MarshallerFactory.newMarshaller(null, Employee.class);
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link MarshallerFactory#newMarshaller(Object)}
	 */
	@Test
	void testGetMarshallerWithObjectWithNullValue()
	{
		String actual;
		String expected;
		Club club;

		club = null;
		NullPointerException nullPointerException = Assertions
			.assertThrows(NullPointerException.class, () -> MarshallerFactory.newMarshaller(club));
		expected = "object is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link MarshallerFactory#newPrettyPrintMarshaller(Object)}
	 */
	@Test
	void testNewPrettyPrintMarshallerWithNullValue()
	{
		String actual;
		String expected;
		Club club;

		club = null;
		NullPointerException nullPointerException = Assertions.assertThrows(
			NullPointerException.class, () -> MarshallerFactory.newPrettyPrintMarshaller(club));
		expected = "object is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link MarshallerFactory#newMarshaller(JAXBContext, Class, Map)}
	 */
	@Test
	void testGetMarshallerWithContextAndClassAndProperties() throws JAXBException
	{
		Marshaller actual;
		Map<String, Object> marshallerProperties;

		marshallerProperties = new HashMap<>();
		marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		actual = MarshallerFactory.newMarshaller(JAXBContext.newInstance(Employee.class),
			Employee.class, marshallerProperties);
		assertNotNull(actual);
		marshallerProperties.clear();
		actual = MarshallerFactory.newMarshaller(JAXBContext.newInstance(Employee.class),
			Employee.class, marshallerProperties);
		assertNotNull(actual);
		marshallerProperties = null;
		actual = MarshallerFactory.newMarshaller(JAXBContext.newInstance(Employee.class),
			Employee.class, marshallerProperties);
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link MarshallerFactory#newMarshaller(JAXBContext, Class, Map)}
	 */
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
			() -> MarshallerFactory.newMarshaller(JAXBContext.newInstance(Employee.class), null,
				marshallerProperties));
		expected = "clazz is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link MarshallerFactory#addProperties(Marshaller, Map)}
	 */
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
