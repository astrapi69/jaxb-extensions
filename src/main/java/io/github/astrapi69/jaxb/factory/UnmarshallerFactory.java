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
package io.github.astrapi69.jaxb.factory;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

/**
 * The factory class {@link UnmarshallerFactory} for creating {@link Unmarshaller} objects for
 * serializing java beans to xml string
 */
public class UnmarshallerFactory
{

	/**
	 * Factory method for create a new {@link Unmarshaller} object
	 *
	 * @param clazz
	 *            the {@link Class} object
	 * @return the new created {@link Unmarshaller} object
	 *
	 * @throws JAXBException
	 *             is thrown if an error was encountered while creating the {@code JAXBContext}
	 */
	public static Unmarshaller newUnmarshaller(Class clazz) throws JAXBException
	{
		return newUnmarshaller(null, clazz);
	}

	/**
	 * Factory method for create a new {@link Unmarshaller} object
	 *
	 * @param context
	 *            the {@link JAXBContext} object
	 * @return the new created {@link Unmarshaller} object
	 *
	 * @throws JAXBException
	 *             is thrown if an error was encountered while creating the {@code JAXBContext}
	 */
	public static Unmarshaller newUnmarshaller(JAXBContext context) throws JAXBException
	{
		return context.createUnmarshaller();
	}

	/**
	 * Factory method for create a new {@link Unmarshaller} object
	 *
	 * @param context
	 *            the {@link JAXBContext} object
	 * @param clazz
	 *            the {@link Class} object
	 * @return the new created {@link Unmarshaller} object
	 *
	 * @throws JAXBException
	 *             is thrown if an error was encountered while creating the {@code JAXBContext}
	 */
	public static Unmarshaller newUnmarshaller(JAXBContext context, Class clazz)
		throws JAXBException
	{
		if (context != null)
		{
			return newUnmarshaller(context);
		}
		return newUnmarshaller(JAXBContext.newInstance(clazz));
	}

}
