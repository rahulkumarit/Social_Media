package com.doctorappoinment.activities

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.doctorappoinment.R

/**
 * Created by Devrepublic-14 on 1/9/2018.
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun initComponents()

    public fun replaceFragment(fragment: Fragment, tag: String) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.mainCantainer, fragment)
        ft.addToBackStack(tag)
        ft.commit()
    }


}