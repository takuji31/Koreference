package jp.takuji31.koreference.converter

/**
 * Created by takuji on 2017/12/05.
 */
object ValueConverters {
    fun <T: Any?> raw() : ValueConverter<T, T> = ValueConverter.Raw()
    fun <T: Any> nonNull(defaultValue: T): ValueConverter<T?, T> = ValueConverter.NonNull(defaultValue)

    inline fun <reified T: Enum<T>> nonNullEnum() : ValueConverter<String, T> {
        return NonNullEnumValueConverter(decoder = { name ->
            enumValueOf<T>(name)
        })
    }

    inline fun <reified T: Enum<T>> nullableEnum() : ValueConverter<String?, T?> {
        return NullableEnumValueConverter(decoder = { nameOrNull ->
            nameOrNull?.let { name -> enumValueOf<T>(name) }
        })
    }
}