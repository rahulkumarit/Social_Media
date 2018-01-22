package com.doctorappoinment.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.doctorappoinment.R
import com.doctorappoinment.models.DoctorAppoitmentModel
import com.rnd.kotlintest.interfaces.ItemClickListeners
import kotlinx.android.synthetic.main.doctor_list.view.*

/**
 * Created by Devrepublic-14 on 10/31/2017.
 */

class CustomAdapter(val context: Context, val userList: ArrayList<DoctorAppoitmentModel>, val itemClick: ItemClickListeners) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val doctorAppoitment: DoctorAppoitmentModel = userList[position]

        holder?.txtDocName?.text = doctorAppoitment.name
        holder?.txtSatus?.text = doctorAppoitment.status
        holder?.txtDegree?.text = doctorAppoitment.degree
        holder?.txtHospitalName?.text = doctorAppoitment.hospitalName
        holder?.txtAddress?.text = doctorAppoitment.address
        holder?.txtFees?.text = doctorAppoitment.fees
        holder?.txtTimeTable?.text = doctorAppoitment.timeScedule

        holder?.btnBook?.setOnClickListener {
            itemClick.onClickView(position, holder?.btnBook)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.doctor_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtDocName = view.txtDocName
        val txtSatus = view.txtSatus
        val txtDegree = view.txtDegree
        val txtHospitalName = view.txtHospitalName
        val txtAddress = view.txtAddress
        val txtFees = view.txtRs
        val txtTimeTable = view.txtTimeTable
        val btnBook = view.btnBook
    }

}