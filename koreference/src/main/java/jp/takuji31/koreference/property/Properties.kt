package jp.takuji31.koreference.property

import jp.takuji31.koreference.KoreferenceProperty
import jp.takuji31.koreference.converter.ValueConverter
import jp.takuji31.koreference.converter.ValueConverters
import jp.takuji31.koreference.store.Store
import jp.takuji31.koreference.store.Stores

/**
 * Created by takuji on 2017/12/05.
 */
open class BooleanKoreferenceProperty<T: Any>(
        defaultValue: T,
        preferenceKey: String?,
        valueConverter: ValueConverter<Boolean, T>
) : KoreferenceProperty<Boolean, T>(defaultValue, preferenceKey, valueConverter) {
    override val store: Store<Boolean> = Stores.Boolean

    class Raw(defaultValue: Boolean, preferenceKey: String?) : BooleanKoreferenceProperty<Boolean>(defaultValue, preferenceKey, ValueConverters.raw())
}

open class FloatKoreferenceProperty<T: Any>(
        defaultValue: T,
        preferenceKey: String?,
        valueConverter: ValueConverter<Float, T>
) : KoreferenceProperty<Float, T>(defaultValue, preferenceKey, valueConverter) {
    override val store: Store<Float> = Stores.Float

    class Raw(defaultValue: Float, preferenceKey: String?) : FloatKoreferenceProperty<Float>(defaultValue, preferenceKey, ValueConverters.raw())
}

open class IntKoreferenceProperty<T: Any>(
        defaultValue: T,
        preferenceKey: String?,
        valueConverter: ValueConverter<Int, T>
) : KoreferenceProperty<Int, T>(defaultValue, preferenceKey, valueConverter) {
    override val store: Store<Int> = Stores.Int
    class Raw(defaultValue: Int, preferenceKey: String?) : IntKoreferenceProperty<Int>(defaultValue, preferenceKey, ValueConverters.raw())
}

open class LongKoreferenceProperty<T: Any>(
        defaultValue: T,
        preferenceKey: String?,
        valueConverter: ValueConverter<Long, T>
) : KoreferenceProperty<Long, T>(defaultValue, preferenceKey, valueConverter) {
    override val store: Store<Long> = Stores.Long

    class Raw(defaultValue: Long, preferenceKey: String?) : LongKoreferenceProperty<Long>(defaultValue, preferenceKey, ValueConverters.raw())
}

open class StringKoreferenceProperty<T: Any?>(
        defaultValue: T,
        preferenceKey: String?,
        valueConverter: ValueConverter<String?, T>
) : KoreferenceProperty<String?, T>(defaultValue, preferenceKey, valueConverter) {
    override val store: Store<String?> = Stores.String

    class Nullable(defaultValue: String?, preferenceKey: String?) : StringKoreferenceProperty<String?>(defaultValue, preferenceKey, ValueConverters.raw())
    class NonNull(defaultValue: String, preferenceKey: String?) : StringKoreferenceProperty<String>(defaultValue, preferenceKey, ValueConverters.nonNull(defaultValue))
}

open class StringSetKoreferenceProperty<T: Any?>(
        defaultValue: T,
        preferenceKey: String?,
        valueConverter: ValueConverter<Set<String>?, T>
) : KoreferenceProperty<Set<String>?, T>(defaultValue, preferenceKey, valueConverter) {
    override val store: Store<Set<String>?> = Stores.StringSet

    class Nullable(defaultValue: Set<String>?, preferenceKey: String?) : StringSetKoreferenceProperty<Set<String>?>(defaultValue, preferenceKey, ValueConverters.raw())
    class NonNull(defaultValue: Set<String>, preferenceKey: String?) : StringSetKoreferenceProperty<Set<String>>(defaultValue, preferenceKey, ValueConverters.nonNull(defaultValue))
}

class EnumKoreferenceProperty<T: Enum<T>>(
        defaultValue: T,
        preferenceKey: String?,
        valueConverter: ValueConverter<String?, T>
) : StringKoreferenceProperty<T>(defaultValue, preferenceKey, valueConverter)

class NullableEnumKoreferenceProperty<T: Enum<T>>(
        defaultValue: T?,
        preferenceKey: String?,
        valueConverter: ValueConverter<String?, T?>
) : StringKoreferenceProperty<T?>(defaultValue, preferenceKey, valueConverter)

