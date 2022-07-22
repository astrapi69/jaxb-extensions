package io.github.astrapi69.jaxb;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate>
{
	public LocalDate unmarshal(String localDateAsString) throws Exception
	{
		return LocalDate.parse(localDateAsString);
	}

	public String marshal(LocalDate localDate) throws Exception
	{
		return localDate.toString();
	}
}
