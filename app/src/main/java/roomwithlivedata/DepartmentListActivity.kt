package roomwithlivedata
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.pc.kotlinroomlivedata.R
import kotlinx.android.synthetic.main.activity_data_list.*
import romlivedata.UserData
import romlivedata.UserDepartment
import roomwithlivedata.adapter.UserDepartmentAdapter

class DepartmentListActivity:AppCompatActivity() {

    lateinit var userDepartmentAdapter:UserDepartmentAdapter
    lateinit var userDetailViewModel: UserDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_list)

        data_list.layoutManager = LinearLayoutManager(this)
        data_list.setHasFixedSize(true)


        userDetailViewModel=ViewModelProviders.of(this).get(UserDetailViewModel::class.java)
        userDetailViewModel.userDepartment.observe(this, object : Observer<List<UserDepartment>> {



            override fun onChanged(t: List<UserDepartment>?) {

                userDepartmentAdapter.setUser(t!!)
            }


        })

    }

    override fun onResume() {
        super.onResume()
        userDepartmentAdapter= UserDepartmentAdapter(this)
        data_list.setAdapter(userDepartmentAdapter)

    }
}