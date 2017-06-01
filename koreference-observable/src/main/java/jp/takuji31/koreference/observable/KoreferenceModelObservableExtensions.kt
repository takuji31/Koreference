package jp.takuji31.koreference.observable

import android.content.SharedPreferences
import android.text.TextUtils
import io.reactivex.Observable
import io.reactivex.Single
import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.KoreferenceProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.jvm.isAccessible

inline fun <reified T : KoreferenceModel, reified R> T.getValueAsSingle(property: KProperty1<T, R>): Single<R> {
    checkKoreferenceProperty(this, property)
    return Single.fromCallable {
        getValueFromProperty(property)
    }
}

fun <R, T : KoreferenceModel> T.getValueFromProperty(property: KProperty1<T, R>): R {
    val accessible = property.isAccessible
    property.isAccessible = true
    val value = property.get(this)
    property.isAccessible = accessible
    return value
}

inline fun <reified T : KoreferenceModel, reified R> T.observe(property: KProperty1<T, R>): Observable<R> {
    val koreferenceProperty = checkKoreferenceProperty(this, property)
    val propertyName = koreferenceProperty.name ?: property.name
    return Observable.create { emitter ->
        val initialiValue = getValueFromProperty(property)

        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            if (TextUtils.equals(key, propertyName)) {
                emitter.onNext(getValueFromProperty(property))
            }
        }
        emitter.onNext(initialiValue)
        this.registerOnSharedPreferenceChangeListener(listener)
        emitter.setCancellable {
            this.unregisterOnSharedPreferenceChangeListener(listener)
        }
    }
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : KoreferenceModel, reified R> checkKoreferenceProperty(receiver: T, property: KProperty1<T, R>): KoreferenceProperty<T, R> {
    val accessible = property.isAccessible
    property.isAccessible = true
    val koreferenceProperty = property.getDelegate(receiver) as? KoreferenceProperty<T, R>
    property.isAccessible = accessible
    koreferenceProperty ?: throw IllegalArgumentException("${receiver::class.qualifiedName}.${property.name} is not Koreference delegate property")
    return koreferenceProperty
}
