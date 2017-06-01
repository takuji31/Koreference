package jp.takuji31.koreference.observable

import android.content.SharedPreferences
import android.text.TextUtils
import io.reactivex.Observable
import io.reactivex.Single
import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.KoreferenceProperty
import kotlin.reflect.KProperty1

inline fun <reified T : KoreferenceModel, reified R> T.getValueAsSingle(property: KProperty1<T, R>): Single<R> = Single.fromCallable {
    checkKoreferenceProperty(this, property)
    property.get(this)
}

inline fun <reified T : KoreferenceModel, reified R> T.observe(property: KProperty1<T, R>): Observable<R> {
    var koreferenceProperty = checkKoreferenceProperty(this, property)
    return Observable.create { emitter ->
        val initialiValue = property.get(this)
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            val name = koreferenceProperty.name ?: property.name
            if (TextUtils.equals(key, name)) {
                emitter.onNext(property.get(this))
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
    return property.getDelegate(receiver) as? KoreferenceProperty<T, R>
            ?: throw IllegalArgumentException("${receiver::class.qualifiedName}.${property.name} is not Koreference delegate property")
}
