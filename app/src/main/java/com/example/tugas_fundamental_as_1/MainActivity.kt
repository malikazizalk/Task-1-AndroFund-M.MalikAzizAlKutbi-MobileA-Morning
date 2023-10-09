package com.example.tugas_fundamental_as_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //
    private lateinit var welcomeUser: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //
        welcomeUser = findViewById(R.id.home_welcome)


        //mendapatkan nila / get dari parcelize
        val username = intent.getParcelableExtra<DataUser>("DataUser")?.username
        val password = intent.getParcelableExtra<DataUser>("DataUser")?.password

        //menampilkan data
        welcomeUser.text = "Hai user '$username', selalu ingat '$password' adalah password anda"

        val btnLogout: Button = findViewById(R.id.btn_Logout)
        btnLogout.setOnClickListener(this)

        //insialisasi btn fragment
        val btnFragment: Button = findViewById(R.id.btn_fragment)
        btnFragment.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_Logout -> {
//                val message = "Hallo"
//                val intent = Intent()
//                intent.action = Intent.ACTION_SEND
//                intent.putExtra(Intent.EXTRA_TEXT, message)
//                intent.type = "text/plain"
                val logoutUser = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(logoutUser)
            }
            R.id.btn_fragment -> {
                val fragmentSection = Intent(this@MainActivity, DarkActivity::class.java)
                startActivity(fragmentSection)
            }
        }
    }
}