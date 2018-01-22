package com.doctorappoinment.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import com.doctorappoinment.R
import com.doctorappoinment.fragments.BaseFragment
import com.doctorappoinment.fragments.BookAppoitmentFragment
import com.doctorappoinment.fragments.DetailsFragment
import com.doctorappoinment.fragments.DoctorListFragmenent

/**
 * Created by Devrepublic-14 on 1/10/2018.
 */

class MainActivitity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_main)
        try {
            initComponents()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun initComponents() {
        replaceFragment(DoctorListFragmenent(), "DoctorListFragmenent")
    }

    private fun getCurrentFragment(): Fragment {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.fragments.size > 0) {
            return fragmentManager.fragments[0]
        } else {
            return DoctorListFragmenent()
        }
    }

    fun removeFragmnet() {
        val fragmentManager = supportFragmentManager
        fragmentManager.popBackStack()
    }


    override fun onBackPressed() {
        val fragment = getCurrentFragment() as BaseFragment
        if (fragment is BookAppoitmentFragment) {
            removeFragmnet()
        } else if (fragment is DetailsFragment) {
            removeFragmnet()
        } else {
//            PopuUtils.showConfirmationDailogs(this@MainActivity, getString(R.string.cather_app), getString(R.string.are_you_sure_want_exit_from_app), this)
             Toast.makeText(this, "Exit from Main..", Toast.LENGTH_SHORT).show()
            finish()
        }


    }


}