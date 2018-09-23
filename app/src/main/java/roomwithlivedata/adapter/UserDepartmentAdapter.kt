package roomwithlivedata.adapter
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pc.kotlinroomlivedata.R
import kotlinx.android.synthetic.main.inflate_department.view.*
import romlivedata.UserDepartment

class UserDepartmentAdapter(var context:Context) : RecyclerView.Adapter<UserDepartmentAdapter.MyViewHolder>() {

    var userDepartment: List<UserDepartment>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var v = LayoutInflater.from(context).inflate(R.layout.inflate_department, parent!!, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {

        userDepartment?.let {

            return userDepartment!!.size
        }
        return 0

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.field_name?.text=userDepartment?.get(position)?.name
        holder.field_depart_name?.text=userDepartment?.get(position)?.depart_name
        holder.field_depart_type?.text=userDepartment?.get(position)?.depart_type
    }

    fun setUser(t: List<UserDepartment>) {

        this.userDepartment=t
        notifyDataSetChanged()
    }


    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
    {

       val field_name=itemView?.field_name
       val field_depart_name=itemView?.field_depart_name
       val field_depart_type=itemView?.field_depart_type

    }
}