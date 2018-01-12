package jp.takuji31.koreference.property

import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.KoreferenceProperty
import kotlin.reflect.KProperty

/**
 * KoreferencePropertyProvider
 */
interface KoreferencePropertyProvider<P, M> {
    operator fun provideDelegate(thisRef: KoreferenceModel, prop: KProperty<*>): KoreferenceProperty<P, M>
}