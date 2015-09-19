# Koreference
Android SharedPreference delegate property for Kotlin

## Installation

In your build.gradle
```gradle
repositories {
    jcenter()
}
dependencies {
    compile 'jp.takuji31.koreference:koreference:0.2.0'
    // optional: gson support
    compile 'jp.takuji31.koreference:koreference-gson:0.2.0'
}
```

## Usage

Create preference model

```kotlin
public class PreferenceModel(pref : SharedPreferences) : SharedPreferences by pref {
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

Create model instance and set propety!

```kotlin
val model = TestPreferenceModel(pref = context.getSharedPreferences("test", Context.MODE_PRIVATE))

// Set value
model.stringValue = "new value"
model.intValue = 12345
model.longValue = 12345678901234L
model.floatValue = 1234.5678f
model.boolValue = false
model.stringSetValue = setOf("foo", "bar")

// SharedPreference methods can use directly!
model.edit().clear().apply()
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
