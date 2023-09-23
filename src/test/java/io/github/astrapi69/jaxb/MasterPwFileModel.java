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
package io.github.astrapi69.jaxb;

import java.io.File;
import java.security.PrivateKey;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * The bean class {@link MasterPwFileModel} is for holding the sign in data
 */
@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@XmlRootElement(namespace = "io.github.astrapi69.jaxb")
@XmlAccessorType(XmlAccessType.FIELD)
public class MasterPwFileModel
{

	/** The encrypted data file for the application. */
	File applicationFile;

	/** The currently selected key file path */
	String selectedApplicationFilePath;

	/** The key file paths for the combo box */
	List<String> applicationFilePaths;

	/** The private key */
	PrivateKey privateKey;

	/** The key file. */
	File keyFile;

	/** The currently selected key file path */
	String selectedKeyFilePath;

	/** The key file paths for the combo box */
	List<String> keyFilePaths;

	/** The master password char array. */
	char[] masterPw;

	/** The repeat of the master password char array. */
	char[] repeatPw;

	/** The minimum length for the password. */
	int minPasswordLength;

	/** The flag if the master password is displayed in plain text. */
	boolean showMasterPw;

	/** The flag if the key file will be used in the authentication. */
	boolean withKeyFile;

	/** The flag if the a new application file will be created. */
	boolean newApplicationFile;

	/** The flag if the master password will be used in the authentication. */
	boolean withMasterPw;

}
