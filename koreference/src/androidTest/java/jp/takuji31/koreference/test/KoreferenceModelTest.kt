package jp.takuji31.koreference.test

import android.content.Context
import android.content.SharedPreferences
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import jp.takuji31.koreference.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.assertNull

/**
 * Created by takuji on 2015/08/10.
 */
@RunWith(AndroidJUnit4::class)
public class KoreferenceModelTest {
    val context: Context by lazy() {
        InstrumentationRegistry.getTargetContext()
    }

    val pref: SharedPreferences by lazy() {
        context.getSharedPreferences("koreference", Context.MODE_PRIVATE)
    }

    @Before
    fun setup() {
        pref.edit().clear().commit()
    }

    @After
    fun teardown() {
        pref.edit().clear().commit()
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

    @Test
    fun testTransactionCommit() {
        val model = TestKoreferenceModel(pref = pref)

        model.transaction {
            stringValue = "Transaction string"
            intValue = 234567
            longValue = 2345678901L
            floatValue = 2345.67891f
            boolValue = false
            stringSetValue = setOf("transaction", "string")

            transactionCommit
        }



        assertEquals(model.stringValue, "Transaction string", "String new value")
        assertEquals(model.intValue, 234567, "Int new value")
        assertEquals(model.longValue, 2345678901L, "Long new value")
        assertEquals(model.floatValue, 2345.67891f, "Float new value")
        assertEquals(model.boolValue, false, "Boolean new value")
        assertEquals(model.stringSetValue, setOf("transaction", "string"), "String set new value")
    }

    @Test
    fun testTransactionApply() {
        val model = TestKoreferenceModel(pref = pref)

        model.transaction {
            stringValue = "Transaction string"
            intValue = 234567
            longValue = 2345678901L
            floatValue = 2345.67891f
            boolValue = false
            stringSetValue = setOf("transaction", "string")

            transactionApply
        }



        assertEquals(model.stringValue, "Transaction string", "String new value")
        assertEquals(model.intValue, 234567, "Int new value")
        assertEquals(model.longValue, 2345678901L, "Long new value")
        assertEquals(model.floatValue, 2345.67891f, "Float new value")
        assertEquals(model.boolValue, false, "Boolean new value")
        assertEquals(model.stringSetValue, setOf("transaction", "string"), "String set new value")
    }

    @Test
    fun testTransactionDiscard() {
        val model = TestKoreferenceModel(pref = pref)
        model.transaction {
            stringValue = "Transaction string"
            intValue = 234567
            longValue = 2345678901L
            floatValue = 2345.67891f
            boolValue = false
            stringSetValue = setOf("transaction", "string")

            transactionDiscard
        }
        assertEquals(model.stringValue, "default value", "String default value")
        assertEquals(model.intValue, 256, "Int default value")
        assertEquals(model.longValue, 256L, "Long default value")
        assertEquals(model.floatValue, 12.34f, "Float default value")
        assertEquals(model.boolValue, true, "Boolean default value")
        assertEquals(model.stringSetValue, setOf<String>(), "String set default value")
    }
}
