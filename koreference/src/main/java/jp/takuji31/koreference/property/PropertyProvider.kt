package jp.takuji31.koreference.property

import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.KoreferenceProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * PropertyProvider
 */
interface PropertyProvider<M> {
    operator fun <R: KoreferenceModel> provideDelegate(thisRef: R, prop: KProperty<*>): ReadWriteProperty<R, M>
}

class DefaultPropertyProvider<M>(
        private val koreferenceProperty: KoreferenceProperty<*, M>
) : PropertyProvider<M> {

    override operator fun <R: KoreferenceModel> provideDelegate(thisRef: R, prop: KProperty<*>) : ReadWriteProperty<R, M> {
        val propertyName = prop.name
        val key = koreferenceProperty.preferenceKey ?: propertyName

        thisRef.propertyNameToKeyMap[propertyName] = key
        thisRef.propertyMap[key] = koreferenceProperty

        return KoreferenceReadWriteProperty(koreferenceProperty, key)
    }
}

fun <P, M> KoreferenceProperty<P, M>.toPropertyProvider(): PropertyProvider<M>
        = DefaultPropertyProvider(this)