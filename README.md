## Configuration for the mobile apps to use

This package contains configuration used by the mobile apps.

Please read the instructions below before changing any configurations.

### Configuration Types

This package contains two sets of configurations:

* `Production`, which is used both in the Production app, as well as the Scenarios app.
* `Scenarios`, which are additional configuration only available in the Scenarios app.

When changing or adding new configurations, ensure that they are scoped correctly, as embedding internal configurations in the
production app could lead to unwanted data disclosure. 

### Changing configurations (iOS)

To change configurations, update the configuration used by iOS _in code_ in the relevant file:

  * [Production](/Sources/ProductionConfiguration/ProductionConfigurations)
  * [Scenarios](/Sources/ScenariosConfiguration/ScenariosConfigurations)
  
Then, from the root of the root of the repository run

```zsh
swift run config
```

This will update the json files that are used by Android. Unit tests on the CI will ensure iOS and Android configuration are in sync.

### Changing configurations (Android)

The Android configuration has to be updated in code as well and can be found here:

  * [Production](/android/production/src/main/kotlin)
  * [Scenarios](/android/scenarios/src/main/kotlin)
  
Before the packages can be published, authentication details for uploading to GitHub packages have to be added to your global gradle.properties file:

  *  **gpr.user** is your Github username
  *  **gpr.key**  is a personal access token [issued by GitHub](https://github.com/settings/tokens). For the scope, use at least read:packages and write:packages.
  
To publish the packages, run

```zsh
gradlew publish
```

Now the updated packages *uk.nhs.covid19.configuration-production* and *uk.nhs.covid19.configuration-scenarios* are available in [this project's package repository](https://github.com/nhsx/covid-19-app-configuration-public/packages).

### Why configurations work in this way?

In Xcode 11, SwiftPM doesn’t support embedded assets. This limitation is resolved in Xcode 12 that is currently in beta.

At the same time, this process also provides the security features we need out of the box. Namely, this way the configuration is
not accessible by just looking inside the unzipped the ipa files. Rather, it will require analysis of the binary itself.

We will revisit the configuration changing process Xcode 12 release to see if we want to achieve the same result in a different way.

## PLEASE READ REGARDING MAVEN PACKAGES

Currently we are having a technical issue making the maven packages available in GitHub. For the time being please do the following:

#### Local Publish Configuration Package

./gradlew publishToMavenLocal

#### Edit Android App Source

edit `build.gradle` and add `mavenLocal()` in the *two* `repositories` definitions

it looks like

```
repositories {
  mavenLocal()
  google()
  ...
```

