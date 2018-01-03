package jp.takuji31.koreference.converter

/**
 * Created by takuji on 2017/12/05.
 */
object ValueConverters {
    fun <T: Any?> raw() : ValueConverter<T, T> = ValueConverter.Raw()
    fun <T: Any> nonNull(defaultValue: T): ValueConverter<T?, T> = ValueConverter.NonNull(defaultValue)

//    inline fun <reified T: Enum<T>> enum() : ValueConverter<String?, T> {
//        val klass = T::class
//        return object : ValueConverter<String?, T> {
//            override fun toPreferenceValue(value: T): String? {
//                Enum
//            }
//
//            override fun toModelValue(value: String?): T {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//        }
//    }
}