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

import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The unit test class for the class {@link ObjectToXmlConverter}
 */
class ObjectToXmlConverterTest
{

	/**
	 * Test method for {@link ObjectToXmlConverter}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ObjectToXmlConverter.class);
	}

	/**
	 * Test method for {@link ObjectToXmlConverter#toXml(Object)}
	 */
	@Test
	void toXml()
	{
		String actual;
		String expected;
		File xmlFile;
		Club club;


		club = TestDataFactory.newClub();

		ObjectToXmlConverter converter = new ObjectToXmlConverter();
		actual = converter.toXml(club);
		xmlFile = new File(PathFinder.getSrcTestResourcesDir(), "club-jaxb.xml");
		expected = RuntimeExceptionDecorator
			.decorate(() -> ReadFileExtensions.readFromFile(xmlFile));
		actual = actual.replace("\n", "").replace("\r", "");
		expected = expected.replace("\n", "").replace("\r", "");
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link ObjectToXmlConverter#toXml(Object)}
	 */
	@Test
	void toXmlEntryModel()
	{
		String actual;
		String expected;
		File xmlFile;
		EntryModel entryModel;

		entryModel = TestDataFactory.newEntryModel();

		ObjectToXmlConverter converter = new ObjectToXmlConverter();
		actual = converter.toXml(entryModel);
		xmlFile = new File(PathFinder.getSrcTestResourcesDir(), "entry-jaxb.xml");
		expected = RuntimeExceptionDecorator
			.decorate(() -> ReadFileExtensions.readFromFile(xmlFile));
		actual = actual.replace("\n", "").replace("\r", "");
		expected = expected.replace("\n", "").replace("\r", "");
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link ObjectToXmlConverter#toXml(Object)}
	 */
	@Test
	public void testToXmlWithNullValue()
	{
		String actual;
		String expected;
		ObjectToXmlConverter objectToXmlConverter = new ObjectToXmlConverter();
		NullPointerException nullPointerException = Assertions
			.assertThrows(NullPointerException.class, () -> objectToXmlConverter.toXml(null));
		expected = "object is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ObjectToXmlConverter#toXml(Object)}
	 */
	@Test
	void toXmlWithCompany()
	{
		String actual;
		String expected;
		File xmlFile;
		Company company;

		company = TestDataFactory.newCompany();

		ObjectToXmlConverter converter = new ObjectToXmlConverter();
		actual = converter.toXml(company);
		xmlFile = new File(PathFinder.getSrcTestResourcesDir(), "company-jaxb.xml");
		expected = RuntimeExceptionDecorator
			.decorate(() -> ReadFileExtensions.readFromFile(xmlFile));
		actual = actual.replace("\n", "").replace("\r", "");
		expected = expected.replace("\n", "").replace("\r", "");
		assertEquals(expected, actual);
	}

}
