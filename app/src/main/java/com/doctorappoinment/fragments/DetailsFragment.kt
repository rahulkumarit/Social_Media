package com.doctorappoinment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.doctorappoinment.R
import com.doctorappoinment.activities.MainActivitity
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by Devrepublic-14 on 1/11/2018.
 */
class DetailsFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater?.inflate(R.layout.details_fragment, container, false)
        val btnAppointment = view?.findViewById<View>(R.id.btnAppointment) as Button

        activity.imgMenu.visibility = View.GONE
        activity.imgBack.visibility = View.VISIBLE
        activity.txtTitle.setText("Dr. Srivatav")

        val Mainactivity=  activity as MainActivitity

        btnAppointment.setOnClickListener {
           /* val ft = activity.supportFragmentManager.beginTransaction()
            ft.replace(R.id.mainCantainer, BookAppoitmentFragment(), "DoctorListFragmenent")
            ft.addToBackStack(tag)
            ft.commit()*/

            Mainactivity.replaceFragment(BookAppoitmentFragment(), "DoctorListFragmenent")

        }

        activity.imgBack.setOnClickListener {
           /* val ft = activity.supportFragmentManager.beginTransaction()
            ft.replace(R.id.mainCantainer, DoctorListFragmenent(), "DoctorListFragmenent")
            ft.addToBackStack(tag)
            ft.commit()*/

            Mainactivity.replaceFragment(DoctorListFragmenent(), "DoctorListFragmenent")

        }

        return view

    }

    override fun initCoponents() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}