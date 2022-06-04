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

	/**
	 * Converts the given object to a xml string
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param object
	 *            the object to convert to xml
	 * @return the xml string from the given object
	 */
	public static <T> void toXml(final @NonNull T object, final @NonNull File file)
	{
		Class<T> tClass = (Class<T>)object.getClass();
		Map<String, Object> marshallerProperties = new HashMap<>();
		marshallerProperties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		Marshaller marshaller = RuntimeExceptionDecorator
			.decorate(() -> MarshallerFactory.getMarshaller(null, tClass, marshallerProperties));
		RuntimeExceptionDecorator.decorate(() -> marshaller.marshal(object, file));
	}
}
