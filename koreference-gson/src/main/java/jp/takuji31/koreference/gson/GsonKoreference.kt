package jp.takuji31.koreference.gson

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import jp.takuji31.koreference.StringKoreference
import java.lang.reflect.Type
import kotlin.properties.Delegates

/**
 * Created by takuji on 2015/08/09.
 */
public class GsonKoreference<T>(val gson: Gson = Gson(), name: String? = null) : StringKoreference<T>("", name) {
    val typeToken : Type by Delegates.lazy {
        object : TypeToken<T>() {} .getType()
    }

    override fun getModelValue(prefValue: String): T {
        return gson.fromJson(prefValue, typeToken)
    }

    override fun getPreferenceValue(value: T): String {
        return gson.toJson(value)
    }
}
