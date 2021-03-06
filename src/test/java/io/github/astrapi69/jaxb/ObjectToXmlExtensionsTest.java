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

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;

/**
 * The unit test class for the class {@link ObjectToXmlExtensions}
 */
public class ObjectToXmlExtensionsTest
{

	/**
	 * Test method for {@link ObjectToXmlExtensions#toXml(Object)}
	 */
	@Test
	void toXml()
	{
		String actual;
		String expected;
		File xmlFile;
		Club club;

		club = TestDataFactory.newClub();

		actual = ObjectToXmlExtensions.toXml(club);
		xmlFile = new File(PathFinder.getSrcTestResourcesDir(), "club-jaxb.xml");
		expected = RuntimeExceptionDecorator
			.decorate(() -> ReadFileExtensions.readFromFile(xmlFile));
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ObjectToXmlExtensions#toXml(Object)}
	 */
	@Test
	public void testToXmlWithNullValue()
	{
		String actual;
		String expected;
		NullPointerException nullPointerException = Assertions
			.assertThrows(NullPointerException.class, () -> ObjectToXmlExtensions.toXml(null));
		expected = "object is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ObjectToXmlExtensions#toXml(Object, File)}
	 */
	@Test
	void toXmlFileWithNullValues()
	{
		String actual;
		String expected;
		File xmlFile;
		Club club;

		club = TestDataFactory.newClub();

		xmlFile = new File(PathFinder.getSrcTestResourcesDir(), "new-club-jaxb.xml");
		NullPointerException nullPointerException = Assertions.assertThrows(
			NullPointerException.class, () -> ObjectToXmlExtensions.toXml(club, null));
		expected = "file is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
		nullPointerException = Assertions.assertThrows(NullPointerException.class,
			() -> ObjectToXmlExtensions.toXml(null, xmlFile));
		expected = "object is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link ObjectToXmlExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ObjectToXmlExtensions.class);
	}

}
