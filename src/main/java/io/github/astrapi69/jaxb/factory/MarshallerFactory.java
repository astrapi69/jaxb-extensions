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

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import lombok.NonNull;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;

/**
 * The factory class {@link MarshallerFactory} for creating {@link Marshaller} objects for
 * serializing java beans to xml string
 */
public class MarshallerFactory
{

	public static Marshaller getMarshaller(final @NonNull Class clazz) throws JAXBException
	{
		return getMarshaller(null, clazz);
	}

	public static Marshaller getMarshaller(JAXBContext context, final @NonNull Class clazz) throws JAXBException
	{
		return getMarshaller(context, clazz, null);
	}

	public static <T> Marshaller getMarshaller(final @NonNull T object) throws JAXBException
	{
		return getMarshaller(object.getClass());
	}

	public static <T> Marshaller getPrettyPrintMarshaller(final @NonNull T object)
	{
		Map<String, Object> marshallerProperties = new HashMap<>();
		marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		Marshaller marshaller = RuntimeExceptionDecorator.decorate(() -> MarshallerFactory
			.addProperties(MarshallerFactory.getMarshaller(object), marshallerProperties));
		return RuntimeExceptionDecorator
			.decorate(() -> MarshallerFactory.addProperties(marshaller, marshallerProperties));
	}

	public static Marshaller getMarshaller(JAXBContext context, final @NonNull Class clazz,
		Map<String, Object> marshallerProperties) throws JAXBException
	{
		JAXBContext newContext;
		if (context != null)
		{
			newContext = context;
		}
		else
		{
			newContext = JAXBContext.newInstance(clazz);
		}
		Marshaller marshaller = newContext.createMarshaller();
		return addProperties(marshaller, marshallerProperties);
	}

	public static Marshaller addProperties(final @NonNull Marshaller marshaller,
		Map<String, Object> marshallerProperties) throws PropertyException
	{
		if (marshallerProperties != null && !marshallerProperties.isEmpty())
		{
			for (Map.Entry<String, Object> entry : marshallerProperties.entrySet())
			{
				marshaller.setProperty(entry.getKey(), entry.getValue());
			}
		}
		return marshaller;
	}

}
