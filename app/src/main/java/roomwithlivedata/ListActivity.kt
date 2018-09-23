package roomwithlivedata
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.pc.kotlinroomlivedata.R
import romlivedata.UserData
import kotlinx.android.synthetic.main.activity_data_list.*
import roomwithlivedata.adapter.UserListAdapter

class ListActivity :AppCompatActivity() {

    lateinit var myCustomAdapter: UserListAdapter
    lateinit var userDetailViewModel: UserDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_list)

        //

        data_list.layoutManager = LinearLayoutManager(this)
        data_list.setHasFixedSize(true)

        userDetailViewModel = ViewModelProviders.of(this).get(UserDetailViewModel::class.java)

        userDetailViewModel.userData.observe(this, object : Observer<List<UserData>> {

            override fun onChanged(userDetails: List<UserData>?) {

                Log.d("data", userDetails!!.size.toString())
                myCustomAdapter.setUser(userDetails!!)
            }
        })
    }

    override fun onResume() {
        super.onResume()

        myCustomAdapter = UserListAdapter(this)
        data_list.setAdapter(myCustomAdapter)
    }
}


