package jp.takuji31.koreference.observable

import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.KoreferenceProperty
import jp.takuji31.koreference.property.KoreferencePropertyProvider
import kotlin.reflect.KProperty

class KoreferenceObservablePropertyProvider<P, M>(
        private val koreferenceProperty: KoreferenceProperty<P, M>
) : KoreferencePropertyProvider<P, M> {

    override operator fun provideDelegate(thisRef: KoreferenceModel, prop: KProperty<*>) : KoreferenceProperty<P, M> {
        val propertyName = prop.name
        val key = koreferenceProperty.preferenceKey ?: propertyName

        thisRef.propertyNameToKeyMap[propertyName] = key
        thisRef.propertyMap[key] = koreferenceProperty

        return koreferenceProperty
    }
}