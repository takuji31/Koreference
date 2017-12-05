package jp.takuji31.koreference

import jp.takuji31.koreference.property.*
import java.util.*

/**
 * Created by takuji on 2015/08/09.
 */
fun stringPreference(default: String = "", key: String? = null): StringKoreferenceProperty.NonNull {
    return StringKoreferenceProperty.NonNull(default, key)
}

fun nullableStringPreference(default: String? = null, key: String? = null): StringKoreferenceProperty.Nullable {
    return StringKoreferenceProperty.Nullable(default, key)
}

fun intPreference(default: Int = -1, key: String? = null): IntKoreferenceProperty.Raw {
    return IntKoreferenceProperty.Raw(default, key)
}

fun longPreference(default: Long = -1L, key: String? = null): LongKoreferenceProperty.Raw {
    return LongKoreferenceProperty.Raw(default, key)
}

fun floatPreference(default: Float = -1.0f, key: String? = null): FloatKoreferenceProperty.Raw {
    return FloatKoreferenceProperty.Raw(default, key)
}

fun booleanPreference(default: Boolean = false, key: String? = null): BooleanKoreferenceProperty.Raw {
    return BooleanKoreferenceProperty.Raw(default, key)
}

fun stringSetPreference(default: Set<String> = HashSet<String>(), key: String? = null): StringSetKoreferenceProperty.NonNull {
    return StringSetKoreferenceProperty.NonNull(default, key)
}

fun nullableStringSetPreference(default: Set<String>? = null, key: String? = null): StringSetKoreferenceProperty.Nullable {
    return StringSetKoreferenceProperty.Nullable(default, key)
}
