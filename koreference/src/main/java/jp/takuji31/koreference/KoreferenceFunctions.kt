package jp.takuji31.koreference

import jp.takuji31.koreference.property.*


fun KoreferenceModel.stringPreference(default: String = "", key: String? = null): StringKoreferenceProperty.NonNull {
    return StringKoreferenceProperty.NonNull(default, key)
}

fun KoreferenceModel.nullableStringPreference(default: String? = null, key: String? = null): StringKoreferenceProperty.Nullable {
    return StringKoreferenceProperty.Nullable(default, key)
}

fun KoreferenceModel.intPreference(default: Int = -1, key: String? = null): IntKoreferenceProperty.Raw {
    return IntKoreferenceProperty.Raw(default, key)
}

fun KoreferenceModel.longPreference(default: Long = -1L, key: String? = null): LongKoreferenceProperty.Raw {
    return LongKoreferenceProperty.Raw(default, key)
}

fun KoreferenceModel.floatPreference(default: Float = -1.0f, key: String? = null): FloatKoreferenceProperty.Raw {
    return FloatKoreferenceProperty.Raw(default, key)
}

fun KoreferenceModel.booleanPreference(default: Boolean = false, key: String? = null): BooleanKoreferenceProperty.Raw {
    return BooleanKoreferenceProperty.Raw(default, key)
}

fun KoreferenceModel.stringSetPreference(default: Set<String> = hashSetOf(), key: String? = null): StringSetKoreferenceProperty.NonNull {
    return StringSetKoreferenceProperty.NonNull(default, key)
}

fun KoreferenceModel.nullableStringSetPreference(default: Set<String>? = null, key: String? = null): StringSetKoreferenceProperty.Nullable {
    return StringSetKoreferenceProperty.Nullable(default, key)
}