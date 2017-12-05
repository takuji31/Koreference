package jp.takuji31.koreference.observable

import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.KoreferenceProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class KoreferenceObservablePropertyProvider<P, M>(
        private val koreferenceProperty: KoreferenceProperty<P, M>
) {
    operator fun provideDelegate(thisRef: KoreferenceObservableModel, prop: KProperty<*>) : ReadWriteProperty<KoreferenceObservableModel, M> {
        val propertyName = prop.name
        val key = koreferenceProperty.preferenceKey ?: propertyName

        thisRef.propertyToKeyMap[propertyName] = key

        return koreferenceProperty
    }
}