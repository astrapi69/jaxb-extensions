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

import java.io.IOException;

import io.github.astrapi69.jaxb.schema.XsdSchemaOutputResolver;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

/**
 * The class {@link ClassToXsdExtensions} provides methods for convert java class objects to xsd
 * string objects
 */
public class ClassToXsdExtensions
{

	/**
	 * Converts the given java class objects to xsd string
	 *
	 * @param classesToBeBound
	 *            the java class objects
	 * @return the xsd string
	 */
	public static String classToXsd(Class<?>... classesToBeBound) throws JAXBException, IOException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);
		XsdSchemaOutputResolver schemaOutputResolver = new XsdSchemaOutputResolver();
		jaxbContext.generateSchema(schemaOutputResolver);
		return schemaOutputResolver.getResult();
	}
}
