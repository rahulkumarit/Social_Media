package com.doctorappoinment.activities

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import com.doctorappoinment.R
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by Devrepublic-14 on 1/9/2018.
 */
class SignUpActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        try {
            initComponents()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun initComponents() {
        //setDatePicker in textview
        imgBack.visibility = View.VISIBLE
        imgMenu.visibility = View.GONE
        txtTitle.setText("Doctor Appoitment")
          imgBack.setOnClickListener {
            finish()
        }

        txtBirthDay.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear,
                                                         dayOfMonth ->
                        txtBirthDay.setText(dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    }, Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH)
            datePickerDialog.show()
        }

        btnSignUp.setOnClickListener {
            startActivity(Intent(this, MainActivitity::class.java))

        }
    }

}
