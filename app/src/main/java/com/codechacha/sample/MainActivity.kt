package com.codechacha.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val INTENT_EXTRA_MY_DATA = "intent_extra_my_data"
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        marshallUnmarshallBtn.setOnClickListener {
            val myData = MyData("myDatabase", 1, 20191009)
            val p1 = Parcel.obtain()
            p1.writeValue(myData)
            Log.d(TAG, "origin MyData{${myData?.name}," +
                    " ${myData?.version}, ${myData?.lastModified}}")

            val bytes: ByteArray = p1.marshall()

            val p2 = Parcel.obtain()
            p2.unmarshall(bytes, 0, bytes.size)
            p2.setDataPosition(0)

            val delivered: MyData = p2.readValue(MyData::class.java.classLoader) as MyData
            Log.d(TAG, "delivered MyData{${delivered?.name}," +
                    " ${delivered?.version}, ${delivered?.lastModified}}")
        }

        startBtn.setOnClickListener {
            val myData = MyData("myDatabase", 1, 20191009)
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra(INTENT_EXTRA_MY_DATA, myData)
            startActivity(intent)
        }
    }
}
