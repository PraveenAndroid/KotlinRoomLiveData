package roomwithlivedata.adapter
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pc.kotlinroomlivedata.R
import romlivedata.UserData
import kotlinx.android.synthetic.main.inflate_list.view.*

class UserListAdapter(var context: Context) : RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {

     var userDetails: List<UserData>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var v = LayoutInflater.from(context).inflate(R.layout.inflate_list, parent!!, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {

        userDetails?.let {
            return  userDetails!!.size
        }

        return 0

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

         holder.name?.text= userDetails?.get(position)?.name
         holder.email?.text= userDetails?.get(position)?.email
         holder.phone?.text= userDetails?.get(position)?.phone
         holder.address?.text= userDetails?.get(position)?.address


    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
    {

        val name=itemView?.name
        val email=itemView?.email
        val phone=itemView?.phone
        val address=itemView?.address

    }

    fun setUser(userDetails: List<UserData>) {
        this.userDetails = userDetails
        notifyDataSetChanged()
    }

}