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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

/**
 * The unit test class for the class {@link XmlToObjectConverter}
 */
class XmlToObjectConverterTest
{

	/**
	 * Test method for {@link XmlToObjectConverter}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(XmlToObjectConverter.class);
	}

	/**
	 * Test method for {@link XmlToObjectConverter#toObject(String, Class)}
	 */
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


	/**
	 * Test method for {@link XmlToObjectConverter#toObject(String, Class)}
	 */
	@Test
	void toObjectEntryModel()
	{
		EntryModel actual;
		EntryModel expected;
		expected = TestDataFactory.newEntryModel();

		ObjectToXmlConverter converter = new ObjectToXmlConverter();
		String xml = converter.toXml(expected);

		XmlToObjectConverter xmlToObjectConverter = new XmlToObjectConverter();
		actual = xmlToObjectConverter.toObject(xml, EntryModel.class);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link XmlToObjectConverter#toObject(String, Class)}
	 */
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

	/**
	 * Test method for {@link XmlToObjectExtensions#toObject(String, Class)}
	 */
	@Test
	public void testToObjectWithNullValue()
	{
		String actual;
		String expected;

		Company company = TestDataFactory.newCompany();
		XmlToObjectConverter xmlToObjectConverter = new XmlToObjectConverter();
		String xml = ObjectToXmlExtensions.toXml(company);

		NullPointerException nullPointerException = Assertions.assertThrows(
			NullPointerException.class, () -> xmlToObjectConverter.toObject(null, Company.class));
		expected = "xmlString is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);

		nullPointerException = Assertions.assertThrows(NullPointerException.class,
			() -> xmlToObjectConverter.toObject(xml, null));
		expected = "clazz is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

}
