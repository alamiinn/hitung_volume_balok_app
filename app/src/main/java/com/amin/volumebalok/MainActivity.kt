package com.amin.volumebalok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etPanjang: EditText
    private lateinit var etLebar: EditText
    private lateinit var etTinggi: EditText
    private lateinit var btnHitung: Button
    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etLebar = findViewById(R.id.et_lebar)
        etPanjang = findViewById(R.id.et_panjang)
        etTinggi = findViewById(R.id.et_tinggi)
        btnHitung = findViewById(R.id.btn_hitung)
        tvResult = findViewById(R.id.tv_result)

        btnHitung.setOnClickListener(this)

        if (savedInstanceState !=null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_hitung){
            val inputPanjang = etPanjang.text.toString().trim()
            val inputLebar = etLebar.text.toString().trim()
            val inputTinggi = etTinggi.text.toString().trim()

            var isEmptyFields = false

            if (inputPanjang.isEmpty()){
                isEmptyFields = true
                etPanjang.error = "Field ini tidak boleh kosong"
            }
            if (inputLebar.isEmpty()){
                isEmptyFields = true
                etLebar.error = "Field ini tidak boleh kosong"
            }
            if (inputTinggi.isEmpty()){
                isEmptyFields = true
                etTinggi.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyFields){
                val volume = inputPanjang.toDouble() * inputLebar.toDouble() * inputTinggi.toDouble()
                tvResult.text = volume.toString()
            }
        }
    }
}