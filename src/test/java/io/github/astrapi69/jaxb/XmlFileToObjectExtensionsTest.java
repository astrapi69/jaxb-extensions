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

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.jaxb.model.Club;
import io.github.astrapi69.jaxb.model.MasterPwFileModelBean;
import io.github.astrapi69.jaxb.model.factory.TestDataFactory;

/**
 * The unit test class for the class {@link XmlFileToObjectExtensions}
 */
public class XmlFileToObjectExtensionsTest
{

	/**
	 * Test method for {@link XmlFileToObjectExtensions#toObject(File, Class)}
	 */
	@Test
	void toObjectFileClass()
	{
		Club actual;
		Club expected;
		File xmlFile;
		Club club;

		club = TestDataFactory.newClub();

		xmlFile = new File(PathFinder.getSrcTestResourcesDir(), "model/club-jaxb.xml");

		actual = XmlFileToObjectExtensions.toObject(xmlFile, Club.class);
		assertNotNull(actual);
		expected = club;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link XmlFileToObjectExtensions#toObject(File, Class)}
	 */
	@Test
	@Disabled("Runs green locally and fails remote on github")
	void toObjectMasterPwFileModelFromXmlFileAndClass()
	{
		MasterPwFileModelBean actual;
		MasterPwFileModelBean expected;
		File xmlFile;
		MasterPwFileModelBean masterPwFileModelBean;

		masterPwFileModelBean = TestDataFactory.newMasterPwFileModelBean();

		File modelDir = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "model");
		xmlFile = new File(modelDir, "master-pw-file-jaxb.xml");

		actual = XmlFileToObjectExtensions.toObject(xmlFile, MasterPwFileModelBean.class);
		assertNotNull(actual);
		expected = masterPwFileModelBean;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link XmlFileToObjectExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(XmlFileToObjectExtensions.class);
	}

}
