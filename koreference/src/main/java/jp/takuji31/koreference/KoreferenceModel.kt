package jp.takuji31.koreference

import android.content.Context
import android.content.SharedPreferences
import kotlin.reflect.KProperty0

/**
 * Created by takuji on 2015/10/30.
 */
abstract class KoreferenceModel(val sharedPreferences: SharedPreferences) {

    internal var transactionEditor: SharedPreferences.Editor? = null


    internal val propertyNameToKeyMap: MutableMap<String, String> = mutableMapOf()

    internal val propertyMap: MutableMap<String, KoreferenceProperty<*, *>> = mutableMapOf()

    constructor(context: Context, name: String, mode: Int) : this(sharedPreferences = context.getSharedPreferences(name, mode))

    constructor(context: Context, name: String) : this(context = context, name = name, mode = Context.MODE_PRIVATE)

    internal fun getKoreferencePropertyKey(property: KProperty0<*>): String {
        return propertyNameToKeyMap[property.name] ?: throw IllegalArgumentException("Cannot observe ${this.javaClass.kotlin.qualifiedName}.${property.name}. You must call KoreferenceProperty.enableObservableSupport()")
    }
}
