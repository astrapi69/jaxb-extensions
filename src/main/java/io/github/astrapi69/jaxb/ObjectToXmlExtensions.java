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
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.Marshaller;

import lombok.NonNull;
import io.github.astrapi69.io.StringOutputStream;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;

public class ObjectToXmlExtensions
{

	public static <T> String toXml(final @NonNull T object)
	{
		Marshaller marshaller = getMarshaller(object);
		StringOutputStream outputStream = new StringOutputStream();
		RuntimeExceptionDecorator.decorate(() -> marshaller.marshal(object, outputStream));
		return outputStream.toString();
	}

	private static <T> Marshaller getMarshaller(final @NonNull T object)
	{
		Map<String, Object> marshallerProperties = new HashMap<>();
		marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		Marshaller marshaller = RuntimeExceptionDecorator.decorate(() -> MarshallerFactory
			.addProperties(MarshallerFactory.getMarshaller(object), marshallerProperties));
		return RuntimeExceptionDecorator
			.decorate(() -> MarshallerFactory.addProperties(marshaller, marshallerProperties));
	}

	/**
	 * Converts the given object to a xml string
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param object
	 *            the object to convert to xml
	 */
	public static <T> void toXml(final @NonNull T object, final @NonNull File file)
	{
		Marshaller marshaller = getMarshaller(object);
		RuntimeExceptionDecorator.decorate(() -> marshaller.marshal(object, file));
	}
}
