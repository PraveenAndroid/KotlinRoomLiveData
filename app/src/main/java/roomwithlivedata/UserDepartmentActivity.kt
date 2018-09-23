package roomwithlivedata
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.pc.kotlinroomlivedata.R
import kotlinx.android.synthetic.main.activity_user_department.*
import romlivedata.UserDepartment

class UserDepartmentActivity:AppCompatActivity() {

    lateinit var userDetailViewModel: UserDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_department)

        userDetailViewModel = ViewModelProviders.of(this).get(UserDetailViewModel::class.java)
   //     userDetailViewModel = ViewModelProviders.of(this).get(UserDetailViewModel::class.java)


        submit.setOnClickListener {

            val depart=UserDepartment()
            depart.name=name.text.toString()
            depart.depart_name=depart_name.text.toString()
            depart.depart_type=depart_type.text.toString()
            depart.depart_detail=depart_detail.text.toString()

            userDetailViewModel.insertDepartment(depart)

        }

        view_department.setOnClickListener {

            val intent=Intent(this,DepartmentListActivity::class.java)
            startActivity(intent)
        }
    }
}