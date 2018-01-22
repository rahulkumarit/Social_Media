package com.doctorappoinment.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.doctorappoinment.MyDividerItemDecoration
import com.doctorappoinment.R
import com.doctorappoinment.activities.MainActivitity
import com.doctorappoinment.adapters.CustomAdapter
import com.doctorappoinment.models.DoctorAppoitmentModel
import com.rnd.kotlintest.interfaces.ItemClickListeners
import kotlinx.android.synthetic.main.toolbar.*
import java.util.*

/**
 * Created by Devrepublic-14 on 1/11/2018.
 */
class DoctorListFragmenent : BaseFragment(), ItemClickListeners {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater?.inflate(R.layout.activity_doctor_appointment, container, false)
        try {
            val rv = view?.findViewById<View>(R.id.rvDoctorList) as RecyclerView
            val users = ArrayList<DoctorAppoitmentModel>()
            for (i in 1..5) {
                users.add(DoctorAppoitmentModel("Rahul Kumar:" + i, "M.B.B.S ,Diploma in urology", "Urology", "AppoloName", "Statelite, Ahemdabad", "INR 500", "MON-WED :10AM to 1 PM"))
            }
            rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rv.addItemDecoration(MyDividerItemDecoration(context, LinearLayoutManager.VERTICAL, 0));
            val adapter = CustomAdapter(context, users, this)
            rv.adapter = adapter

            initCoponents()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        activity.imgBack.visibility = View.GONE
        activity.imgMenu.visibility = View.VISIBLE
        activity.txtTitle.setText("Doctor Appoitment")
        return view
    }

    override fun initCoponents() {

    }

    override fun onClickView(pos: Int, view: View) {
        val Mainactivity = activity as MainActivitity
        Mainactivity.replaceFragment(DetailsFragment(), "DetailsFragment")
    }

}