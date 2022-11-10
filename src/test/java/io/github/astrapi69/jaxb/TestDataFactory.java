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

import io.github.astrapi69.file.search.PathFinder;

import java.io.File;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestDataFactory
{

	public static MasterPwFileModel newMasterPwFileModel()
	{

		File applicationFile;

		applicationFile = new File(PathFinder.getSrcTestResourcesDir(), "club-jaxb.xml");

		// @formatter:on
		return MasterPwFileModel.builder().applicationFile(applicationFile).build();
		// @formatter:off
    }

    public static EntryModel newEntryModel() {
        // @formatter:on
		return EntryModel.builder().id(UUID.fromString("37c2aa6f-08d2-4007-9f79-b61275dd3aaa"))
			.title("Foo").userName("Anton").password("isEncrypted").icon("favicon.ico")
			.url("https://astrapi69.github.io/").notes("Some notes").expirable(true)
			.expires(LocalDateTime.of(2035, Month.AUGUST, 28, 16, 30)).build();
		// @formatter:off
    }

    public static Club newClub() {
        List<Person> persons = new ArrayList<>();

        persons.add(Person.builder().name("Lea").gender("woman").married(Boolean.FALSE)
                .nickname("princess").build());

        persons.add(Person.builder().name("Luke").gender("man").married(Boolean.FALSE)
                .nickname("wannabejedi").build());

        Club company = new Club();
        company.setPersonsList(persons);
        company.setLocation("Greece/Katerini");
        company.setName("StarPiece");
        return company;
    }


    public static Company newCompany() {
        List<Employee> employees = new ArrayList<>();

        Employee employee1 = new Employee();
        employee1.setGender("woman");
        employee1.setId("1");
        employee1.setName("Lea");
        employee1.setMarried(Boolean.FALSE);
        employees.add(employee1);

        Employee employee2 = new Employee();
        employee2.setGender("man");
        employee2.setId("2");
        employee2.setName("Luke");
        employee2.setMarried(Boolean.FALSE);
        employees.add(employee2);

        Company company = new Company();
        company.setEmployeeList(employees);
        company.setLocation("Greece/Katerini");
        company.setName("StarPiece");
        return company;
    }
}
