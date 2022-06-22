package io.github.astrapi69.jaxb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.checksum.FileChecksumExtensions;
import io.github.astrapi69.file.delete.DeleteFileExtensions;
import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;

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
	 * Test method for {@link ObjectToXmlConverter#toXml(Object, File)}
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
		ObjectToXmlConverter converter = new ObjectToXmlConverter();

		NullPointerException nullPointerException = Assertions
			.assertThrows(NullPointerException.class, () -> converter.toXml(club, null));
		expected = "file is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);
		nullPointerException = Assertions.assertThrows(NullPointerException.class,
			() -> converter.toXml(null, xmlFile));
		expected = "object is marked non-null but is null";
		actual = nullPointerException.getMessage();
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link ObjectToXmlConverter#toXml(Object, File)}
	 */
	@Test
	void toXmlFile() throws IOException
	{
		File actual;
		File expected;
		File xmlFile;
		Club club;

		club = TestDataFactory.newClub();

		xmlFile = new File(PathFinder.getSrcTestResourcesDir(), "new-club-jaxb.xml");
		ObjectToXmlConverter converter = new ObjectToXmlConverter();
		converter.toXml(club, xmlFile);
		actual = xmlFile;
		expected = new File(PathFinder.getSrcTestResourcesDir(), "club-jaxb.xml");
		assertEquals(FileChecksumExtensions.getChecksum(expected, true),
			FileChecksumExtensions.getChecksum(actual, true));
		RuntimeExceptionDecorator.decorate(() -> DeleteFileExtensions.delete(xmlFile));
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
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ObjectToXmlConverter#toXml(Object, File)}
	 */
	@Test
	void toXmlFileWithCompany() throws IOException
	{
		File actual;
		File expected;
		File xmlFile;
		Company company;

		company = TestDataFactory.newCompany();

		ObjectToXmlConverter converter = new ObjectToXmlConverter();
		xmlFile = new File(PathFinder.getSrcTestResourcesDir(), "new-company-jaxb.xml");
		converter.toXml(company, xmlFile);
		actual = xmlFile;
		expected = new File(PathFinder.getSrcTestResourcesDir(), "company-jaxb.xml");
		assertEquals(FileChecksumExtensions.getChecksum(expected, true),
			FileChecksumExtensions.getChecksum(actual, true));
		RuntimeExceptionDecorator.decorate(() -> DeleteFileExtensions.delete(xmlFile));
	}
}
