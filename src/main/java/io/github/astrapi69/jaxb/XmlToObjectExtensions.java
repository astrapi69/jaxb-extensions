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

import java.io.StringReader;

import javax.xml.bind.Unmarshaller;

import lombok.NonNull;
import io.github.astrapi69.jaxb.factory.UnmarshallerFactory;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;

/**
 * The class {@link XmlToObjectExtensions} provides methods for convert xml string objects to java
 * objects
 */
public class XmlToObjectExtensions
{

	/**
	 * Creates from the given xml string a java object.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param xmlString
	 *            the xml as string object
	 * @return the xml string
	 */
	public static <T> T toObject(final @NonNull String xmlString, final @NonNull Class<T> clazz)
	{
		Unmarshaller unmarshaller = RuntimeExceptionDecorator
			.decorate(() -> UnmarshallerFactory.newUnmarshaller(clazz));
		return (T)RuntimeExceptionDecorator
			.decorate(() -> unmarshaller.unmarshal(new StringReader(xmlString)));
	}

}
