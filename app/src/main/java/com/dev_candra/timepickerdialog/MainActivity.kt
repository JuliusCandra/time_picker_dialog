package com.dev_candra.timepickerdialog

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Aksi()
    }

    private fun Aksi(){
        btn1.apply {
            setOnClickListener {
                val time = Calendar.getInstance()
                val timePickerDialog = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    time.set(Calendar.HOUR_OF_DAY,hourOfDay)
                    time.set(Calendar.MINUTE,minute)
                    teks1.apply {
                        text = SimpleDateFormat("HH:mm").format(time.time)
                    }
                }
                TimePickerDialog(this@MainActivity,timePickerDialog,time.get(Calendar.HOUR_OF_DAY),time.get(Calendar.MINUTE),true).show()
            }
        }
    }
}
