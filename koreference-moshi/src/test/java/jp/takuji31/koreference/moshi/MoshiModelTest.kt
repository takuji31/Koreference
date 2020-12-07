package jp.takuji31.koreference.moshi

import android.content.Context
import android.content.SharedPreferences
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import kotlin.test.assertEquals
import kotlin.test.assertNull

@RunWith(RobolectricTestRunner::class)
class MoshiModelTest {
    val context: Context by lazy(LazyThreadSafetyMode.NONE) {
        RuntimeEnvironment.application
    }

    val pref: SharedPreferences by lazy(LazyThreadSafetyMode.NONE) {
        context.getSharedPreferences("test", Context.MODE_PRIVATE)
    }

    @Before
    fun setup() {
        pref.edit().clear().apply()
    }

    @After
    fun teardown() {
    }

    @Test
    fun testMoshiModel() {
        val model = MoshiTestModel(pref = pref, moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build())

        assertEquals(model.person, Person("Taro", "Yamada"), "Person default value")
        assertNull(model.nullablePerson, "Nullable person default value")

        model.person = Person("Hanako", "Suzuki")
        model.nullablePerson = Person("Jiro", "Sato")

        assertEquals(model.person, Person("Hanako", "Suzuki"), "Person new value")
        assertEquals(model.nullablePerson, Person("Jiro", "Sato"), "Nullable person new value")
    }
}
