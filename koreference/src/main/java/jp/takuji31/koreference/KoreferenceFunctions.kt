package jp.takuji31.koreference

import jp.takuji31.koreference.converter.ValueConverters
import jp.takuji31.koreference.observable.enableObservableSupport
import jp.takuji31.koreference.property.*


fun KoreferenceModel.stringPreference(default: String = "", key: String? = null): KoreferencePropertyProvider<String?, String> {
    return StringKoreferenceProperty.NonNull(default, key).enableObservableSupport()
}

fun KoreferenceModel.nullableStringPreference(default: String? = null, key: String? = null): KoreferencePropertyProvider<String?, String?> {
    return StringKoreferenceProperty.Nullable(default, key).enableObservableSupport()
}

fun KoreferenceModel.intPreference(default: Int = -1, key: String? = null): KoreferencePropertyProvider<Int, Int> {
    return IntKoreferenceProperty.Raw(default, key).enableObservableSupport()
}

fun KoreferenceModel.longPreference(default: Long = -1L, key: String? = null): KoreferencePropertyProvider<Long, Long> {
    return LongKoreferenceProperty.Raw(default, key).enableObservableSupport()
}

fun KoreferenceModel.floatPreference(default: Float = -1.0f, key: String? = null): KoreferencePropertyProvider<Float, Float> {
    return FloatKoreferenceProperty.Raw(default, key).enableObservableSupport()
}

fun KoreferenceModel.booleanPreference(default: Boolean = false, key: String? = null): KoreferencePropertyProvider<Boolean, Boolean> {
    return BooleanKoreferenceProperty.Raw(default, key).enableObservableSupport()
}

fun KoreferenceModel.stringSetPreference(default: Set<String> = hashSetOf(), key: String? = null): KoreferencePropertyProvider<Set<String>?, Set<String>> {
    return StringSetKoreferenceProperty.NonNull(default, key).enableObservableSupport()
}

fun KoreferenceModel.nullableStringSetPreference(default: Set<String>? = null, key: String? = null): KoreferencePropertyProvider<Set<String>?, Set<String>?> {
    return StringSetKoreferenceProperty.Nullable(default, key).enableObservableSupport()
}

inline fun <reified T: Enum<T>> KoreferenceModel.enumPreference(default: T, key: String? = null) : KoreferencePropertyProvider<String?, T> {
    return EnumKoreferenceProperty(default, key, ValueConverters.nonNullEnum()).enableObservableSupport()
}

inline fun <reified T: Enum<T>> KoreferenceModel.nullableEnumPreference(default: T? = null, key: String? = null) : KoreferencePropertyProvider<String?, T?> {
    return NullableEnumKoreferenceProperty(default, key, ValueConverters.nullableEnum()).enableObservableSupport()
}

