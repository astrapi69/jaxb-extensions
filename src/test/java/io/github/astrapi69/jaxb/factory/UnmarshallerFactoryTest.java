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

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.jaxb.Employee;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

/**
 * The unit test class for the class {@link UnmarshallerFactory}
 */
class UnmarshallerFactoryTest
{

	/**
	 * Test method for {@link UnmarshallerFactory}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(UnmarshallerFactory.class);
	}

	/**
	 * Test method for {@link UnmarshallerFactory#newUnmarshaller(Class)}
	 *
	 * @throws JAXBException
	 *             is thrown if an error was encountered while creating the {@code JAXBContext}
	 */
	@Test
	void testNewUnmarshallerWithClass() throws JAXBException
	{
		Unmarshaller actual;
		actual = UnmarshallerFactory.newUnmarshaller(Employee.class);
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link UnmarshallerFactory#newUnmarshaller(JAXBContext)}
	 *
	 * @throws JAXBException
	 *             is thrown if an error was encountered while creating the {@code JAXBContext}
	 */
	@Test
	void testNewUnmarshallerWithContext() throws JAXBException
	{
		Unmarshaller actual;
		actual = UnmarshallerFactory.newUnmarshaller(JAXBContext.newInstance(Employee.class));
		assertNotNull(actual);
	}

	/**
	 * Test method for {@link UnmarshallerFactory#newUnmarshaller(JAXBContext, Class)}
	 *
	 * @throws JAXBException
	 *             is thrown if an error was encountered while creating the {@code JAXBContext}
	 */
	@Test
	void testGetUnmarshallerWithContextAndClass() throws JAXBException
	{
		Unmarshaller actual;
		actual = UnmarshallerFactory.newUnmarshaller(JAXBContext.newInstance(Employee.class),
			Employee.class);
		assertNotNull(actual);
	}

}
