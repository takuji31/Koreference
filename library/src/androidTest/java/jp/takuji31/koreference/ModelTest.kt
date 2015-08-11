package jp.takuji31.koreference

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.test.AndroidTestCase
import org.junit
import org.junit.runner.RunWith
import java.util.*
import kotlin.properties.Delegates
import kotlin.test.*

/**
 * Created by takuji on 2015/08/10.
 */
RunWith(AndroidJUnit4::class)
public class ModelTest {
    val context: Context by Delegates.lazy {
        InstrumentationRegistry.getTargetContext()
    }

    junit.Before
    fun setup() {
    }

    junit.After
    fun teardown() {
    }

    junit.Test
    fun testDefaultValue() {
        removePreferenceFile()
        val pref = context.getSharedPreferences("test", Context.MODE_PRIVATE)
        pref.edit().clear().commit()
        val model = TestPreferenceModel(pref = pref)
        assertEquals(model.stringValue, "default value", "String default value")
        assertEquals(model.intValue, 256, "Int default value")
        assertEquals(model.longValue, 256L, "Long default value")
        assertEquals(model.floatValue, 12.34f, "Float default value")
        assertEquals(model.boolValue, true, "Boolean default value")
        assertEquals(model.stringSetValue, HashSet<String>(), "String set default value")
    }

    private fun removePreferenceFile() {
    }

    junit.Test
    fun testSetValue() {
        removePreferenceFile()
        val pref = context.getSharedPreferences("test", Context.MODE_PRIVATE)
        pref.edit().clear().commit()
        val model = TestPreferenceModel(pref = pref)

        model.stringValue = "new value"
        model.intValue = 12345
        model.longValue = 12345678901234L
        model.floatValue = 1234.5678f
        model.boolValue = false
        model.stringSetValue = HashSet<String>(Arrays.asList("foo", "bar"))

        assertEquals(model.stringValue, "new value", "String new value")
        assertEquals(model.intValue, 12345, "Int new value")
        assertEquals(model.longValue, 12345678901234L, "Long new value")
        assertEquals(model.floatValue, 1234.5678f, "Float new value")
        assertEquals(model.boolValue, false, "Boolean new value")
        assertEquals(model.stringSetValue, HashSet<String>(Arrays.asList("foo", "bar")), "String set default value")
    }
}
