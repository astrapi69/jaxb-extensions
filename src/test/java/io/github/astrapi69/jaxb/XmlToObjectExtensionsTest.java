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
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import io.github.astrapi69.awt.action.NoAction;
import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.jaxb.menu.model.MenuModel;
import io.github.astrapi69.jaxb.model.Company;
import io.github.astrapi69.jaxb.model.factory.TestDataFactory;
import io.github.astrapi69.model.mapper.ModelMapperExtensions;
import io.github.astrapi69.model.mapper.factory.ModelMapperFactory;
import io.github.astrapi69.swing.menu.model.MenuInfo;
import io.github.astrapi69.swing.menu.model.MenuItemInfo;

/**
 * The unit test class for the class {@link XmlToObjectExtensions}
 */
public class XmlToObjectExtensionsTest
{

	/**
	 * Test method for {@link XmlToObjectExtensions#toObject(String, Class)}
	 */
	@Test
	public void testToObjectWithNullValue()
	{
		String actual;
		String expected;

		Company company = TestDataFactory.newCompany();
		String xml = ObjectToXmlExtensions.toXml(company);

		NullPointerException nullPointerException = Assertions.assertThrows(
			NullPointerException.class,
			() -> XmlToObjectExtensions.toObject((String)null, Company.class));
		expected = "xmlString is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);

		nullPointerException = Assertions.assertThrows(NullPointerException.class,
			() -> XmlToObjectExtensions.toObject(xml, null));
		expected = "clazz is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
	}


	/**
	 * Test method for {@link XmlToObjectExtensions#toObject(String, Class)}
	 */
	@Test
	public void testJaxbXmlToObject() throws IOException
	{

		MenuModel actual;
		MenuModel expected;
		File xmlFile;

		expected = TestDataFactory.newMenuInfo();

		xmlFile = new File(PathFinder.getSrcTestResourcesDir(), "model/menu/menu-model.xml");
		String xmlAsString = ReadFileExtensions.fromFile(xmlFile);
		actual = XmlToObjectExtensions.toObject(xmlAsString, MenuModel.class);
		assertEquals(expected, actual);

		ModelMapper modelMapper = ModelMapperFactory.newModelMapper(MatchingStrategies.LOOSE);

		MenuInfo mapped = ModelMapperExtensions.map(modelMapper, actual, MenuInfo.class);
		MenuItemInfo menuItemInfo = mapped.toMenuItemInfo(new NoAction());
		assertNotNull(menuItemInfo);
	}

	/**
	 * Test method for {@link XmlToObjectExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(XmlToObjectExtensions.class);
	}
}
