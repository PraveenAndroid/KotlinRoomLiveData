package roomwithlivedata
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.pc.kotlinroomlivedata.R
import romlivedata.UserData
import kotlinx.android.synthetic.main.activity_main.*

class TestActivity :AppCompatActivity() {

    lateinit var userDetailViewModel: UserDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userDetailViewModel = ViewModelProviders.of(this).get(UserDetailViewModel::class.java)


        insert_row.setOnClickListener {

            var userdata= UserData()
            userdata.name=name.text.toString()
            userdata.email=email.text.toString()
            userdata.phone=phone.text.toString()
            userdata.address=address.text.toString()




            userDetailViewModel.insert(userdata)
        }

        view_data.setOnClickListener {

            val intent= Intent(this, ListActivity::class.java)
            startActivity(intent)

        }
    }
}