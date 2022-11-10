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

import io.github.astrapi69.jaxb.factory.UnmarshallerFactory;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import jakarta.xml.bind.Unmarshaller;
import lombok.NonNull;

import java.io.File;

/**
 * The class {@link XmlFileToObjectExtensions} provides methods for convert xml File to java objects
 */
public class XmlFileToObjectExtensions
{

	/**
	 * Transforms the given xml {@link File} object to an object of the given class type
	 *
	 * @param <T>
	 *            the generic type of the argument object class type
	 * @param xmlFile
	 *            the xml file
	 * @param clazz
	 *            the class from the class type of the object that will be returned
	 * @return the object
	 */
	public static <T> T toObject(final @NonNull File xmlFile, final @NonNull Class<T> clazz)
	{
		Unmarshaller unmarshaller = RuntimeExceptionDecorator
			.decorate(() -> UnmarshallerFactory.newUnmarshaller(clazz));
		return (T)RuntimeExceptionDecorator.decorate(() -> unmarshaller.unmarshal(xmlFile));
	}

}
