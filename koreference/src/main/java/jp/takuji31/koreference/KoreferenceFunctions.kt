package jp.takuji31.koreference

import jp.takuji31.koreference.converter.ValueConverters
import jp.takuji31.koreference.property.toPropertyProvider
import jp.takuji31.koreference.property.*


fun KoreferenceModel.stringPreference(default: String = "", key: String? = null): PropertyProvider<String> {
    return StringKoreferenceProperty.NonNull(default, key).toPropertyProvider()
}

fun KoreferenceModel.nullableStringPreference(default: String? = null, key: String? = null): PropertyProvider<String?> {
    return StringKoreferenceProperty.Nullable(default, key).toPropertyProvider()
}

fun KoreferenceModel.intPreference(default: Int = -1, key: String? = null): PropertyProvider<Int> {
    return IntKoreferenceProperty.Raw(default, key).toPropertyProvider()
}

fun KoreferenceModel.longPreference(default: Long = -1L, key: String? = null): PropertyProvider<Long> {
    return LongKoreferenceProperty.Raw(default, key).toPropertyProvider()
}

fun KoreferenceModel.floatPreference(default: Float = -1.0f, key: String? = null): PropertyProvider<Float> {
    return FloatKoreferenceProperty.Raw(default, key).toPropertyProvider()
}

fun KoreferenceModel.booleanPreference(default: Boolean = false, key: String? = null): PropertyProvider<Boolean> {
    return BooleanKoreferenceProperty.Raw(default, key).toPropertyProvider()
}

fun KoreferenceModel.stringSetPreference(default: Set<String> = hashSetOf(), key: String? = null): PropertyProvider<Set<String>> {
    return StringSetKoreferenceProperty.NonNull(default, key).toPropertyProvider()
}

fun KoreferenceModel.nullableStringSetPreference(default: Set<String>? = null, key: String? = null): PropertyProvider<Set<String>?> {
    return StringSetKoreferenceProperty.Nullable(default, key).toPropertyProvider()
}

inline fun <reified T: Enum<T>> KoreferenceModel.enumPreference(default: T, key: String? = null) : PropertyProvider<T> {
    return EnumKoreferenceProperty(default, key, ValueConverters.nonNullEnum()).toPropertyProvider()
}

inline fun <reified T: Enum<T>> KoreferenceModel.nullableEnumPreference(default: T? = null, key: String? = null) : PropertyProvider<T?> {
    return NullableEnumKoreferenceProperty(default, key, ValueConverters.nullableEnum()).toPropertyProvider()
}

