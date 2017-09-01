package jp.takuji31.koreference

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

abstract class KoreferencePropertyProvider<P, M>(
        val key: String? = null,
        val defaultValue: M
) {
    operator fun provideDelegate(thisRef: KoreferenceModel, prop: KProperty<*>) : ReadWriteProperty<KoreferenceModel, M> {
        val propertyName = prop.name
        val key = key ?: propertyName

        thisRef.propertyToKeyMap[propertyName] = key

        return createDelegate(key, defaultValue)
    }

    abstract fun createDelegate(key: String, defaultValue: M) : KoreferenceProperty<P, M>
}