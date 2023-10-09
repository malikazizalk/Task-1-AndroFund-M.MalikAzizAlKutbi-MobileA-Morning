package com.example.tugas_fundamental_as_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tugas_fundamental_as_1.R.id.btn_create_account

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    //menggunaka private karna dia hanya digunakan di classnya sendiri
    //inisialisasi komponen xml dengan variable agar bisa berinteraksi dengan bagian xml nya
    private lateinit var inputLoginUsername:EditText
    private lateinit var inputLoginPassword:EditText

    //menampilkan hidtory kita pernah login
    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data:Intent? = result.data
            val returnString:String? = data?.getStringExtra("history")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //inisalisasikan variable di atas dengan id agar dapat berinteraksi dengan xml nya
        inputLoginUsername = findViewById(R.id.input_login_username)
        inputLoginPassword = findViewById(R.id.input_login_password)

        //panggil bundle yang bernilai intent extra untuk merubah layar dan mengambil data dari register
        val bundle = intent.extras

        //membuat kondisi jika bundle bernilai null atau tidak berubah layar dan menapung data maka akan force close secara otomatis
        if (bundle != null) {
            //dan jika sebaliknnya maka eksekusi inputloginusername
            inputLoginUsername.setText(bundle.getString("usernameValue"))//key adl nama variable penyimpan data yg di ambil dari register
            inputLoginPassword.setText(bundle.getString("passwordValue"))
        }

        //membuat variable btnLogin dengan memanggil id di xml agar btn bisa di klik
        val btnLogin: Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(this)

        //membuat variable btnCreateAccount dengan memanggil id di xml agar btn bisa di klik
        val btnCreateAccount: Button = findViewById(btn_create_account)
        btnCreateAccount.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){ //ketika view yg berisi id tsb di klik
            R.id.btn_login -> { //maka cari id btn_login (yg di xml)
                //yang mana tampilan awalnya akan ada di halaman LoginActivity
                //yang jika btn_login di klik maka akan di pindahkan ke halaman MainActivity
                val keHome = Intent(this@LoginActivity, MainActivity::class.java)

                //pemanggilan data dengan class parcelize agar inputan di login dapat terbawa ke laman home
                keHome.putExtra("DataUser",DataUser(inputLoginUsername.text.toString(), inputLoginPassword.text.toString()))

                startActivity(keHome)//untuk menjalankan kondisi yang ada di atas
            }
        }

        when(v.id){
            R.id.btn_create_account -> {
                val keRegister = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(keRegister)
            }
        }
    }
}