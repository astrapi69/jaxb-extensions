package io.github.astrapi69.jaxb;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDateTime;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime>
{
	public LocalDateTime unmarshal(String localDateTimeAsString) throws Exception
	{
		return LocalDateTime.parse(localDateTimeAsString);
	}

	public String marshal(LocalDateTime localDateTime) throws Exception
	{
		return localDateTime.toString();
	}
}
