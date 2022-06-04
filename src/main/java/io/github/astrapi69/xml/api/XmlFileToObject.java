package io.github.astrapi69.xml.api;

import java.io.File;

import lombok.NonNull;

public interface XmlFileToObject
{
	/**
	 * Transformes the given xml string to an Object of type T.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param xmlFile
	 *            the xml file
	 * @param clazz
	 *            the class from the object that will be returned
	 * @return the Object.
	 */
	<T> T toObject(final @NonNull File xmlFile, final @NonNull Class<T> clazz);
}
