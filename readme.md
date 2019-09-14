java-library
---------------------------------

A grouping of Gradle dependencies and utility classes I find myself including in most of my libraries.

<br/>

### Adding this to your project

In your `build.gradle` file:
* Under `repositories`
    * Add `maven { url "https://jitpack.io" }`, making sure it's the _last_ repo declared
* Under `dependencies`
    * Add `compile 'com.github.todd-elvers:java-library:1.0.0'`
