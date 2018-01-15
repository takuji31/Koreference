package jp.takuji31.koreference.property

import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.KoreferenceProperty
import kotlin.reflect.KProperty

/**
 * PropertyProvider
 */
interface PropertyProvider<P, M> {
    operator fun provideDelegate(thisRef: KoreferenceModel, prop: KProperty<*>): KoreferenceProperty<P, M>
}

class DefaultPropertyProvider<P, M>(
        private val koreferenceProperty: KoreferenceProperty<P, M>
) : PropertyProvider<P, M> {

    override operator fun provideDelegate(thisRef: KoreferenceModel, prop: KProperty<*>) : KoreferenceProperty<P, M> {
        val propertyName = prop.name
        val key = koreferenceProperty.preferenceKey ?: propertyName

        thisRef.propertyNameToKeyMap[propertyName] = key
        thisRef.propertyMap[key] = koreferenceProperty

        return koreferenceProperty
    }
}

fun <P, M> KoreferenceProperty<P, M>.toPropertyProvider(): PropertyProvider<P, M>
        = DefaultPropertyProvider(this)