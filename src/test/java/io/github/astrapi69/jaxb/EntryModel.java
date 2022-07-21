package io.github.astrapi69.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@XmlRootElement(namespace = "io.github.astrapi69.jaxb")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntryModel
{
	UUID id;
	String title;
	String userName;
	String password;
	String url;
	String notes;
	boolean expirable;
	@XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
	LocalDateTime expires;
	String icon;
}
