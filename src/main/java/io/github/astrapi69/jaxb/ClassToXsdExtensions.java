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

import java.io.File;
import java.io.IOException;

import io.github.astrapi69.file.write.WriteFileExtensions;
import io.github.astrapi69.jaxb.schema.XsdSchemaOutputResolver;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

/**
 * The class {@link ClassToXsdExtensions} provides methods for convert java class objects to xsd
 * string objects or to xsd file. <br/>
 * For transform them back you java classes, you have to use xjc. <br/>
 * <br/>
 * An example is provided in the example repository
 * <a href="https://github.com/astrapi69/jaxb-exjc">jaxb-exjc</a>
 */
public class ClassToXsdExtensions
{

	/**
	 * Converts the given java class objects to a xsd string
	 *
	 * @param classesToBeBound
	 *            the java class objects
	 * @return the xsd string
	 * @throws JAXBException
	 *             if an error occurs by creating a new instance of the {@link JAXBContext}
	 * @throws IOException
	 *             if an error occur when the {@link JAXBContext} try to generate the schema
	 */
	public static String classesToXsdString(Class<?>... classesToBeBound)
		throws JAXBException, IOException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);
		XsdSchemaOutputResolver schemaOutputResolver = new XsdSchemaOutputResolver();
		jaxbContext.generateSchema(schemaOutputResolver);
		return schemaOutputResolver.getResult();
	}

	/**
	 * Converts the given java class object to a xsd string
	 *
	 * @param <T>
	 *            the generic type of the class type
	 * @param classToBeBound
	 *            the java class object
	 * @return the xsd string
	 * @throws JAXBException
	 *             if an error occurs by creating a new instance of the {@link JAXBContext}
	 * @throws IOException
	 *             if an error occur when the {@link JAXBContext} try to generate the schema
	 */
	public static <T> String classToXsdString(Class<T> classToBeBound)
		throws JAXBException, IOException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(classToBeBound);
		XsdSchemaOutputResolver schemaOutputResolver = new XsdSchemaOutputResolver();
		jaxbContext.generateSchema(schemaOutputResolver);
		return schemaOutputResolver.getResult();
	}

	/**
	 * Converts the given java class object into the given xsd file
	 *
	 * @param <T>
	 *            the generic type of the class type
	 * @param classToBeBound
	 *            the java class object
	 * @param xsdOutputFile
	 *            the xsd file to write the result
	 * @throws JAXBException
	 *             if an error occurs by creating a new instance of the {@link JAXBContext}
	 * @throws IOException
	 *             if an error occur when the {@link JAXBContext} try to generate the schema
	 */
	public static <T> void classToXsdFile(Class<T> classToBeBound, File xsdOutputFile)
		throws JAXBException, IOException
	{
		WriteFileExtensions.writeStringToFile(xsdOutputFile, classToXsdString(classToBeBound),
			"UTF-8");
	}

	/**
	 * Converts the given java class objects into the given xsd file
	 *
	 * @param xsdOutputFile
	 *            the xsd file to write the result
	 * @param classesToBeBound
	 *            the java class objects
	 * @throws JAXBException
	 *             if an error occurs by creating a new instance of the {@link JAXBContext}
	 * @throws IOException
	 *             if an error occur when the {@link JAXBContext} try to generate the schema
	 */
	public static void classesToXsdFile(File xsdOutputFile, Class<?>... classesToBeBound)
		throws JAXBException, IOException
	{
		WriteFileExtensions.writeStringToFile(xsdOutputFile, classesToXsdString(classesToBeBound),
			"UTF-8");
	}

}
