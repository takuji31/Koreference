package jp.takuji31.koreference.converter

/**
 * Created by takuji on 2017/12/05.
 */
object ValueConverters {
    fun <T: Any?> raw() : ValueConverter<T, T> = ValueConverter.Raw()
    fun <T: Any> nonNull(defaultValue: T): ValueConverter<T?, T> = ValueConverter.NonNull(defaultValue)
}