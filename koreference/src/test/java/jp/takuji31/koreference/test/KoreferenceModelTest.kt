package jp.takuji31.koreference.test

import android.content.Context
import android.content.SharedPreferences
import androidx.test.core.app.ApplicationProvider
import jp.takuji31.koreference.bulk
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import kotlin.test.assertEquals

@RunWith(RobolectricTestRunner::class)
class KoreferenceModelTest {
    val context: Context by lazy {
        ApplicationProvider.getApplicationContext()
    }

    val pref: SharedPreferences by lazy {
        context.getSharedPreferences("koreference", Context.MODE_PRIVATE)
    }

    @Before
    fun setup() {
        pref.edit().clear().apply()
    }

    @After
    fun teardown() {
        pref.edit().clear().apply()
    }

    @Test
    fun testBulk() {
        val model = TestKoreferenceModel(pref = pref)

        model.bulk {
            stringValue = "Bulk string"
            intValue = 23456
            longValue = 234567890L
            floatValue = 2345.6789f
            boolValue = true
            stringSetValue = setOf("bulk", "string")
        }


        assertEquals(model.stringValue, "Bulk string", "String new value")
        assertEquals(model.intValue, 23456, "Int new value")
        assertEquals(model.longValue, 234567890L, "Long new value")
        assertEquals(model.floatValue, 2345.6789f, "Float new value")
        assertEquals(model.boolValue, true, "Boolean new value")
        assertEquals(model.stringSetValue, setOf("bulk", "string"), "String set default value")
    }

    @Test(expected = IllegalStateException::class)
    fun testNestedBulk() {
        val model = TestKoreferenceModel(pref = pref)

        model.bulk {
            bulk {
                stringValue = "Bulk string"
                intValue = 23456
                longValue = 234567890L
                floatValue = 2345.6789f
                boolValue = true
                stringSetValue = setOf("bulk", "string")
            }
        }
    }
}
