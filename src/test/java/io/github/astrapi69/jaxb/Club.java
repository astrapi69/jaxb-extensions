package io.github.astrapi69.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(namespace = "io.github.astrapi69.jaxb")
@XmlAccessorType(XmlAccessType.FIELD)
public class Club
{
	@XmlElementWrapper(name = "personList")
	@XmlElement(name = "person")
	List<Person> personsList;
	private String name;
	private String location;

}
