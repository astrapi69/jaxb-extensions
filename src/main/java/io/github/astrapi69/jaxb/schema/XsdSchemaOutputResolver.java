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
package io.github.astrapi69.jaxb.schema;

import io.github.astrapi69.io.StringOutputStream;
import jakarta.xml.bind.SchemaOutputResolver;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class XsdSchemaOutputResolver extends SchemaOutputResolver
{

	String result;
	StringOutputStream outputStream = new StringOutputStream();

	@Override
	public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException
	{

		StreamResult streamResult = new StreamResult(outputStream);
		streamResult.setSystemId(suggestedFileName);
		this.result = outputStream.toString();
		return streamResult;
	}

	public String getResult()
	{
		this.result = outputStream.toString();
		return this.result;
	}
}
