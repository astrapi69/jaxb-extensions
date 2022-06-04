package io.github.astrapi69.jaxb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.checksum.FileChecksumExtensions;
import io.github.astrapi69.file.delete.DeleteFileExtensions;
import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;

class ObjectToXmlConverterTest
{

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
