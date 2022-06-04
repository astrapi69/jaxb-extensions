package io.github.astrapi69.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@XmlRootElement(name = "person")
@XmlType(propOrder = { "name", "gender", "married", "nickname" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Person
{
	/**
	 * The name.
	 */
	private String name;

	/**
	 * The about.
	 */
	private String gender;

	/**
	 * The married flag.
	 */
	private Boolean married;

	/**
	 * The nickname.
	 */
	private String nickname;

}
