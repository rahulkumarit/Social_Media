package com.doctorappoinment.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.doctorappoinment.R
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            initComponents()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun initComponents() {
        btnLogin.setOnClickListener {
            if (isValidData()) {
                val intent = Intent(this, MainActivitity::class.java)
                startActivity(intent)
            }
        }

        txtSign.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }


    }

    private fun isValidData(): Boolean {
        if (edtFirstName.text.toString().isEmpty()) {
            Toast.makeText(this, "Enter User Name..", Toast.LENGTH_SHORT).show()
            return false
        } else if (editTextPassword.text.toString().isEmpty()) {
            Toast.makeText(this, "Enter Password..", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }
    }


}
