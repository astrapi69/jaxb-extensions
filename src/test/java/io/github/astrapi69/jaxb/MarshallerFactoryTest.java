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

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

class MarshallerFactoryTest
{

	@Test
	void getMarshallerWithClass() throws JAXBException
	{
		Marshaller actual;
		actual = MarshallerFactory.getMarshaller(Employee.class);
		assertNotNull(actual);
	}

	@Test
	void testGetMarshallerWithContextAndClass() throws JAXBException
	{
		Marshaller actual;
		actual = MarshallerFactory.getMarshaller(null, Employee.class);
		assertNotNull(actual);
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
