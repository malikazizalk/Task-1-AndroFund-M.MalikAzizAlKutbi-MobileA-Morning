package com.example.tugas_fundamental_as_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    //menggunaka private karna dia hanya digunakan di classnya sendiri
    //inisialisasi komponen xml dengan variable agar bisa berinteraksi dengan bagian xml nya
    private lateinit var inputRegisterUsername:EditText
    private lateinit var inputRegisterPassword:EditText
    private lateinit var inputRegisterEmail:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //inisalisasikan variable di atas dengan id agar dapat berinteraksi dengan xml nya
        inputRegisterUsername = findViewById(R.id.input_register_username)
        inputRegisterPassword = findViewById(R.id.input_register_password)
        inputRegisterEmail = findViewById(R.id.input_register_email)

        val btnRegister: Button = findViewById(R.id.btn_Register)
        btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_Register -> {

                //membuat paket dengan bundle untuk mengirim data register
                val sendRegisterData = Bundle()
                sendRegisterData.putString("usernameValue", inputRegisterUsername.text.toString())
                sendRegisterData.putString("passwordValue", inputRegisterPassword.text.toString())

                val keLogin = Intent(this@RegisterActivity, LoginActivity::class.java)
                //mengirim paket bundle di atas
                keLogin.putExtras(sendRegisterData)
                startActivity(keLogin)
            }
        }
    }
}