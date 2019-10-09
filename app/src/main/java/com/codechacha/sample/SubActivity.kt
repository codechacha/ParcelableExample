package com.codechacha.sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    private val TAG = "SubActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val myData = intent?.getParcelableExtra<MyData>(MainActivity.INTENT_EXTRA_MY_DATA)
        val text = "MyData{${myData?.name}, ${myData?.version}, ${myData?.lastModified}}"
        textView.text = text
        Log.d(TAG, "Received: $text")
    }

}