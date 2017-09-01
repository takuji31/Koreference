package jp.takuji31.koreference.observable

import android.content.SharedPreferences
import io.reactivex.Observable
import io.reactivex.Single
import jp.takuji31.koreference.KoreferenceModel
import kotlin.reflect.KProperty1

inline fun <reified T : KoreferenceModel, reified R> T.getValueAsSingle(property: KProperty1<T, R>): Single<R> {
    getKoreferencePropertyKey(this, property)
    return Single.fromCallable {
        property.get(this)
    }
}

inline fun <reified T : KoreferenceModel, reified R> T.observe(property: KProperty1<T, R>): Observable<R> {
    val key = getKoreferencePropertyKey(this, property)
    return Observable.create { emitter ->
        val initialiValue = property.get(this)

        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, changedKey ->
            if (changedKey == key) {
                emitter.onNext(property.get(this))
            }
        }
        emitter.onNext(initialiValue)
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
        emitter.setCancellable {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
        }
    }
}

fun <T : KoreferenceModel, R> getKoreferencePropertyKey(receiver: T, property: KProperty1<T, R>): String {
    return receiver.propertyToKeyMap[property.name] ?: throw IllegalArgumentException("${receiver::class.qualifiedName}.${property.name} is not Koreference delegate property")
}
