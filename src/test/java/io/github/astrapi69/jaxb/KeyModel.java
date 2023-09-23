package io.github.astrapi69.jaxb;

import io.github.astrapi69.crypt.api.key.KeyType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@RequiredArgsConstructor
@SuperBuilder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KeyModel
{
	@NonNull
	KeyType keyType;
	@NonNull
	byte[] encoded;
	@NonNull
	String algorithm;
}