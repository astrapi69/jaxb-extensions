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

import io.github.astrapi69.io.StringOutputStream;
import io.github.astrapi69.jaxb.factory.MarshallerFactory;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import jakarta.xml.bind.Marshaller;
import lombok.NonNull;

import java.io.File;

/**
 * The class {@link ObjectToXmlExtensions} provides methods for convert java objects to xml string
 * objects
 */
public class ObjectToXmlExtensions
{

	/**
	 * Converts the given object to a xml string
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param object
	 *            the object to convert to xml
	 * @return the xml string
	 */
	public static <T> String toXml(final @NonNull T object)
	{
		Marshaller marshaller = MarshallerFactory.newPrettyPrintMarshaller(object);
		StringOutputStream outputStream = new StringOutputStream();
		RuntimeExceptionDecorator.decorate(() -> marshaller.marshal(object, outputStream));
		return outputStream.toString();
	}

	/**
	 * Converts the given object to a xml string and write it to the given file object
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param object
	 *            the object to convert to xml
	 * @param file
	 *            the file object
	 */
	public static <T> void toXml(final @NonNull T object, final @NonNull File file)
	{
		Marshaller marshaller = MarshallerFactory.newPrettyPrintMarshaller(object);
		RuntimeExceptionDecorator.decorate(() -> marshaller.marshal(object, file));
	}
}
