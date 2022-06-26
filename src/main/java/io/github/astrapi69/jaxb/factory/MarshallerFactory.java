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

import lombok.NonNull;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;

/**
 * The factory class {@link MarshallerFactory} for creating {@link Marshaller} objects for
 * serializing java beans to xml string
 */
public class MarshallerFactory
{

	/**
	 * Factory method for create a new {@link Marshaller} object
	 * 
	 * @param clazz
	 *            the {@link Class} object
	 * @return the new created {@link Marshaller} object
	 *
	 * @throws JAXBException
	 *             is thrown if an error was encountered while creating the {@code JAXBContext}
	 */
	public static Marshaller newMarshaller(final @NonNull Class clazz) throws JAXBException
	{
		return newMarshaller(null, clazz);
	}

	/**
	 * Factory method for create a new {@link Marshaller} object
	 *
	 * @param context
	 *            the {@link JAXBContext} object
	 * @param clazz
	 *            the {@link Class} object
	 * @return the new created {@link Marshaller} object
	 *
	 * @throws JAXBException
	 *             is thrown if an error was encountered while creating the {@code JAXBContext}
	 */
	public static Marshaller newMarshaller(JAXBContext context, final @NonNull Class clazz)
		throws JAXBException
	{
		return newMarshaller(context, clazz, null);
	}

	/**
	 * Factory method for create a new {@link Marshaller} object
	 *
	 * @param <T>
	 *            the generic type of the given object
	 * @param object
	 *            the generic object
	 * @return the new created {@link Marshaller} object
	 *
	 * @throws JAXBException
	 *             is thrown if an error was encountered while creating the {@code JAXBContext}
	 */
	public static <T> Marshaller newMarshaller(final @NonNull T object) throws JAXBException
	{
		return newMarshaller(object.getClass());
	}

	/**
	 * Factory method for create a new {@link Marshaller} object that can make a pretty print of the
	 * xml output
	 *
	 * @param <T>
	 *            the generic type of the given object
	 * @param object
	 *            the generic object
	 * @return the new created {@link Marshaller} object
	 */
	public static <T> Marshaller newPrettyPrintMarshaller(final @NonNull T object)
	{
		Map<String, Object> marshallerProperties = new HashMap<>();
		marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		Marshaller marshaller = RuntimeExceptionDecorator.decorate(() -> MarshallerFactory
			.addProperties(MarshallerFactory.newMarshaller(object), marshallerProperties));
		return RuntimeExceptionDecorator
			.decorate(() -> MarshallerFactory.addProperties(marshaller, marshallerProperties));
	}

	/**
	 * Factory method for create a new {@link Marshaller} object
	 *
	 * @param context
	 *            the {@link JAXBContext} object
	 * @param clazz
	 *            the {@link Class} object
	 * @param marshallerProperties
	 *            the {@link Map} object with the marshaller properties
	 * @return the new created {@link Marshaller} object
	 *
	 * @throws JAXBException
	 *             is thrown if an error was encountered while creating the {@code JAXBContext}
	 */
	public static Marshaller newMarshaller(JAXBContext context, final @NonNull Class clazz,
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

	/**
	 * Add the given marshaller properties to the given {@link Marshaller} object
	 *
	 * @param marshaller
	 *            the {@link Marshaller} object
	 * @param marshallerProperties
	 *            the {@link Map} object with the marshaller properties
	 * @return the new {@link Marshaller} object with the given marshaller properties
	 * @throws PropertyException
	 *             is thrown if there is an error processing the given property or value
	 */
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
