# Koreference
[![Circle CI](https://circleci.com/gh/takuji31/Koreference/tree/master.svg?style=svg)](https://circleci.com/gh/takuji31/Koreference/tree/master) [![](https://jitpack.io/v/takuji31/Koreference.svg)](https://jitpack.io/#takuji31/Koreference)

Android SharedPreference delegate property for Kotlin

## Installation

In your build.gradle
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    compile 'com.github.takuji31.Koreference:koreference:1.4.2'
    // optional: gson support
    compile 'com.github.takuji31.Koreference:koreference-gson:1.4.2'
    // optional: RxJava2 observable support
    compile 'com.github.takuji31.Koreference:koreference-observable:1.4.2'
}
```
## Get started

Create your preference model

```kotlin
class MyPreferences(context : Context) : KoreferenceModel(context = context, name = "my_preferences") {
	var name : String by stringPreference("noname")
	var age : int by intPreference(17)
}
```

You can also use other constructors

```kotlin
class MyPreferences(sharefPreferences : SharedPreferences) : KoreferenceModel(sharefPreferences = sharefPreferences)
// or
class MyPreferences(context : Context) : KoreferenceModel(context = context, name = "my_preferences", mode = Context.MODE_PRIVATE)
```

Create model instance and set/get value

```kotlin
val pref = MyPreferences(context = this)

// set values
pref.name = "takuji31"
pref.age = 28

// this is same
pref.bulk {
    name = "takuji31"
    age = 28
}

val name = pref.name //takuji31
val age = pref.age //28
```

## Preference delegate properies

Koreference has basic delegate properties

```kotlin
public class PreferenceModel(sharefPreferences : SharedPreferences) : KoreferenceModel(sharedPreferences = sharefPreferences) {
  var stringValue : String by stringPreference("default value")
  var intValue : Int by intPreference(256)
  var longValue : Long by longPreference(256L)
  var floatValue : Float by floatPreference(12.34f)
  var boolValue : Boolean by booleanPreference(true)
  var stringSetValue : Set<String> by stringSetPreference(setOf())
  
  // Nullable support
  var stringValue : String? by nullableStringPreference()
  var stringSetValue : Set<String>? by nullableStringSetPreference()
}
```

## Custom properties

You can create custom properties.

Default properties are example.

```
//TODO write sample codes
```

## License

```
Copyright (C) 2015 Takuji Nishibayashi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
