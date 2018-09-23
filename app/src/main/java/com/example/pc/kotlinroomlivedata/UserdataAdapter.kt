package com.example.pc.kotlinroomlivedata
import android.arch.lifecycle.LiveData
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.inflate_list.view.*
import romlivedata.UserData

class UserdataAdapter(var context:Context, var data: LiveData<List<UserData>>?) : RecyclerView.Adapter<UserdataAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {


        var v = LayoutInflater.from(context).inflate(R.layout.inflate_list, parent!!, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        //return data.size
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

       // holder.name.text= data?.get(position)?.name
       // holder.email.text= data?.get(position)?.email
        //holder.phone.text= data?.get(position)?.phone
       // holder.address.text= data?.get(position)?.address
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name=itemView.name
        val email=itemView.email
        val phone=itemView.phone
        val address=itemView.address
    }

}
