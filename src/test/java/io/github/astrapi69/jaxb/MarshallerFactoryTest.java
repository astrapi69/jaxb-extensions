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
