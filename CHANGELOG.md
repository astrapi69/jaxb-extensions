## Change log
----------------------

Version 2.1-SNAPSHOT
-------------

ADDED:

- new methods in class ClassToXsdExtensions that can save the xsd to a given file

CHANGED:

- update of gradle to new version 8.4-rc-2
- moved test dependency file-worker to project dependency

Version 2
-------------

CHANGED:

- update of JDK to newer version 17
- update of gradle to new version 8.4-rc-1
- update of test dependency file-worker to new minor version 17

Version 1.3
-------------

ADDED:

- new extension class that converts a java class object to an xsd string
- new test dependency test-object in version 7.2

CHANGED:

- update of gradle to new version 8.3
- update of lombok to new version 1.18.30
- update of gradle-plugin dependency of 'io.freefair.gradle:lombok-plugin' in version 8.3
- update of gradle plugin dependency com.github.ben-manes.versions.gradle.plugin to new minor version 0.48.0
- update of gradle-plugin dependency 'org.ajoberstar.grgit:grgit-gradle' to new version 5.2.0
- update of gradle-plugin dependency of 'com.diffplug.spotless:spotless-plugin-gradle' in version 6.21.0
- update of dependency jakarta.xml.bind-api to new version 4.0.1
- update of dependency jaxb-runtime to new version 4.0.3
- update of dependency silly-io to new minor version 2.2
- update of test dependency crypt-api to new minor version 8.6
- update of test dependency crypt-data to new minor version 8.5
- update of test dependency 'com.github.meanbeanlib:meanbean' to new version 3.0.0-M9
- update of test dependency file-worker to new minor version 11.6
- update of test dependency junit-jupiter-api to new minor version 5.10.0

Version 1.2
-------------

ADDED:

- new module-info.java file for module description
- all required package-info.java files
- new converter class that transforms a xml file to a java object
- new extension class that transforms a xml file to a java object

CHANGED:

- update of gradle to new version 7.6-rc-2
- update of gradle plugin dependency com.github.ben-manes.versions.gradle.plugin to new minor version 0.43.0
- update of gradle-plugin dependency of 'io.freefair.gradle:lombok-plugin' in version 6.5.1
- update of gradle-plugin dependency of 'com.diffplug.spotless:spotless-plugin-gradle' in version 6.11.0
- update of dependency xml-api to new minor version 1.4
- update of dependency checksum-up to new minor version 2.2
- update of dependency jaxb-runtime to new version 4.0.1
- update of test dependency file-worker to new minor version 11.5.1
- update of test dependency junit-jupiter-api to new minor version 5.9.1

Version 1.1
-------------

CHANGED:

- update of old jaxb dependencies to the new long term dependencies:
- update and replaced from javax.xml.bind:jaxb-api to new jakarta.xml.bind:jakarta.xml.bind-api
- update and replaced from com.sun.xml.bind:jaxb-core and com.sun.xml.bind:jaxb-impl to new org.glassfish.jaxb:
  jaxb-runtime

Version 1
-------------

ADDED:

- new CHANGELOG.md file created

Notable links:
[keep a changelog](http://keepachangelog.com/en/1.0.0/) Don’t let your friends dump git logs into changelogs
