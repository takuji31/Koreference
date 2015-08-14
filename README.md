# Koreference
Android SharedPreference delegate property for Kotlin

## Installation

TBD

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
