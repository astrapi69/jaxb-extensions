# Overview

<div style="text-align: center">

[![Java CI with Gradle](https://github.com/astrapi69/jaxb-extensions/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/jaxb-extensions/actions/workflows/gradle.yml)
[![Coverage Status](https://codecov.io/gh/astrapi69/jaxb-extensions/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/jaxb-extensions)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/jaxb-extensions.svg?style=flat)](https://github.com/astrapi69/jaxb-extensions/issues)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/jaxb-extensions/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/jaxb-extensions)
[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/jaxb-extensions.svg)](http://www.javadoc.io/doc/io.github.astrapi69/jaxb-extensions)
[![MIT License](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/jaxb-extensions?branch=develop)](https://hitsofcode.com/github/astrapi69/jaxb-extensions/view?branch=develop)
[![Lines Of Code](https://tokei.rs/b1/github/astrapi69/jaxb-extensions)](https://github.com/astrapi69/jaxb-extensions)

</div>

Jaxb extension classes.

> Please support this project by simply putting a Github <!-- Place this tag where you want the button to render. -->
<a class="github-button" href="https://github.com/astrapi69/jaxb-extensions" data-icon="octicon-star" aria-label="Star astrapi69/jaxb-extensions on GitHub">
> Star ⭐</a>
>
> Share this library with friends on Twitter and everywhere else you can
>
> If you love this
> project [![donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

## Note

No animals were harmed in the making of this library.

## License

The source code comes under the liberal MIT License, making jaxb-extensions great for all types of applications.

## gradle dependency

Replace the variable ${latestVersion} with the current latest version: [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/jaxb-extensions/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/jaxb-extensions)

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of jaxb-extensions:

define version in file gradle.properties

```
jaxbExtensionsVersion=${latestVersion}
```

or in build.gradle ext area

```
    jaxbExtensionsVersion = "${latestVersion}"
```

then add the dependency to the dependencies area

```
    implementation("io.github.astrapi69:jaxb-extensions:$jaxbExtensionsVersion")
```

## Maven dependency

Maven dependency is now on sonatype.
Check
out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~io.github.astrapi69~jaxb-extensions~~~)
for latest snapshots and releases.

Add the following maven dependency to your project `pom.xml` if you want to import the core
functionality of jaxb-extensions:

Than you can add the dependency to your dependencies:

    <properties>
            ...
        <!-- jaxb-extensions version -->
        <jaxb-extensions.version>${latestVersion}</jaxb-extensions.version>
            ...
    </properties>
            ...
        <dependencies>
            ...
            <!-- jaxb-extensions DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>jaxb-extensions</artifactId>
                <version>${jaxb-extensions.version}</version>
            </dependency>
            ...
        </dependencies>

## Support this project

If jaxb-extensions is useful to you, a star on [GitHub](https://github.com/astrapi69/jaxb-extensions) helps others find it.
Sharing it or reporting a bug helps just as much.

If you would like to contribute financially, the channels are on the repository's Sponsor button, which
reads [.github/FUNDING.yml](.github/FUNDING.yml): GitHub Sponsors, Liberapay, Ko-fi and PayPal.

## Semantic Versioning

The versions of jaxb-extensions are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning you can visit
the [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## Want to Help and improve it? ###

The source code for jaxb-extensions are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/jaxb-extensions/fork](https://github.com/astrapi69/jaxb-extensions/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/jaxb-extensions/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the jaxb-extensions developers with your questions, concerns, comments, bug reports, or
feature requests.

- Feature requests, questions and bug reports can be reported at
  the [issues page](https://github.com/astrapi69/jaxb-extensions/issues).

## Git hooks

The repository's git hooks live in `.githooks`: `commit-msg` where present, and `pre-commit`, which refuses a
commit whose files Spotless would format. Activate them once per clone or worktree:

```bash
git config core.hooksPath .githooks
```
