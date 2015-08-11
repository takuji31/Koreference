package jp.takuji31.koreference.gson

/**
 * Created by takuji on 2015/08/09.
 */
public object KoreferenceGson {
    protected open  fun toModelValue(value : String, default : T) : T {
        throw UnsupportedOperationException()
    }

    protected open fun toPreferenceValue(value : T) : String {
        throw UnsupportedOperationException()
    }

    class GsonPreferenceDelegate<GM>(val klass : Class<GM>, def : GM) : AbstractPreferenceDelegate<GM>(def) {
        val gson : Gson by Delegates.lazy {
            val builder = GsonBuilder()
            builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            builder.create()
        }
        override fun toModelValue(value: String, default: GM): GM {
            if (value == "") {
                return default
            }
            return gson.fromJson(value, klass)
        }

        override fun toPreferenceValue(value: GM): String {
            return gson.toJson(value)
        }
    }
    class GsonListPreferenceDelegate<GM>(val klass : Class<GM>, def : List<GM>) : AbstractPreferenceDelegate<List<GM>>(def) {
        val gson : Gson by Delegates.lazy {
            val builder = GsonBuilder()
            builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            builder.create()
        }

        override fun toModelValue(value: String, default: List<GM>): List<GM> {
            if (value == "") {
                return default
            }
            val json = gson.fromJson<List<GM>>(value) ?: default
            return ArrayList(json)
        }

        override fun toPreferenceValue(value: List<GM>): String {
            return gson.toJson(value)
        }
    }

}