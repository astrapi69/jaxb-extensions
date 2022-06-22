package io.github.astrapi69.jaxb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

class XmlToObjectConverterTest
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

	@Test
	void toObjectClub()
	{
		Club actual;
		Club expected;
		expected = TestDataFactory.newClub();

		ObjectToXmlConverter converter = new ObjectToXmlConverter();
		String xml = converter.toXml(expected);

		XmlToObjectConverter xmlToObjectConverter = new XmlToObjectConverter();
		actual = xmlToObjectConverter.toObject(xml, Club.class);
		assertEquals(expected, actual);
	}

	@Test
	void toObjectCompany()
	{
		Company actual;
		Company expected;
		expected = TestDataFactory.newCompany();

		ObjectToXmlConverter converter = new ObjectToXmlConverter();
		String xml = converter.toXml(expected);

		XmlToObjectConverter xmlToObjectConverter = new XmlToObjectConverter();
		actual = xmlToObjectConverter.toObject(xml, Company.class);
		assertEquals(expected, actual);
	}
}
