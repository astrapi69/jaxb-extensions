package io.github.astrapi69.jaxb;

import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import lombok.NonNull;

import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlToObjectExtensions
{
	public static <T> T toObject(final @NonNull String xmlString, final @NonNull Class<T> clazz)
	{
		Unmarshaller unmarshaller = RuntimeExceptionDecorator
			.decorate(() -> UnmarshallerFactory.getUnmarshaller(clazz));
		T object = (T)RuntimeExceptionDecorator
			.decorate(() -> unmarshaller.unmarshal(new StringReader(xmlString)));
		return object;
	}
}
