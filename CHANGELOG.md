## Change log
----------------------

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
