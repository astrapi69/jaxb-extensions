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
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import io.github.astrapi69.xml.api.ObjectToXml;
import lombok.NonNull;

import javax.xml.bind.Marshaller;
import java.util.HashMap;
import java.util.Map;

/**
 * The class {@link ObjectToXmlConverter} provides a single method for convert an object to a xml
 * string
 */
public class ObjectToXmlConverter implements ObjectToXml
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> String toXml(final @NonNull T object)
	{
		Class<T> tClass = (Class<T>)object.getClass();
		Map<String, Object> marshallerProperties = new HashMap<>();
		marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		Marshaller marshaller = RuntimeExceptionDecorator
			.decorate(() -> MarshallerFactory.getMarshaller(null, tClass, marshallerProperties));
		StringOutputStream outputStream = new StringOutputStream();
		RuntimeExceptionDecorator.decorate(() -> marshaller.marshal(object, outputStream));
		String xmlString = outputStream.toString();
		return xmlString;
	}
}
