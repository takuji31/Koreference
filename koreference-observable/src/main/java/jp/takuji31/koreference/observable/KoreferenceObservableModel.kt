package jp.takuji31.koreference.observable

import android.content.Context
import android.content.SharedPreferences
import jp.takuji31.koreference.KoreferenceModel
import kotlin.reflect.KProperty0

/**
 * Created by takuji on 2015/10/30.
 */
abstract class KoreferenceObservableModel : KoreferenceModel {

    internal val propertyToKeyMap : MutableMap<String, String> = mutableMapOf()

    constructor(sharedPreferences: SharedPreferences) : super(sharedPreferences)

    constructor(context: Context, name: String, mode: Int) : super(context, name, mode)

    constructor(context: Context, name: String) : super(context, name)

    internal fun getKoreferencePropertyKey(property: KProperty0<*>): String {
        return propertyToKeyMap[property.name] ?: throw IllegalArgumentException("Cannot observe ${this.javaClass.kotlin.qualifiedName}.${property.name}. You must call KoreferenceProperty.enableObservableSupport()")
    }
}