package io.github.astrapi69.jaxb;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.jupiter.api.Test;

class UnmarshallerFactoryTest
{

	@Test
	void getUnmarshallerWithClass() throws JAXBException
	{
		Unmarshaller actual;
		actual = UnmarshallerFactory.getUnmarshaller(Employee.class);
		assertNotNull(actual);
	}

	@Test
	void testGetUnmarshallerWithContext() throws JAXBException
	{
		Unmarshaller actual;
		actual = UnmarshallerFactory.getUnmarshaller(JAXBContext.newInstance(Employee.class));
		assertNotNull(actual);
	}

	@Test
	void testGetUnmarshallerWithContextAndClass() throws JAXBException
	{
		Unmarshaller actual;
		actual = UnmarshallerFactory.getUnmarshaller(JAXBContext.newInstance(Employee.class),
			Employee.class);
		assertNotNull(actual);
	}
}
