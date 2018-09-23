package roomwithlivedata
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.pc.kotlinroomlivedata.R
import kotlinx.android.synthetic.main.activity_launcher.*

class LauncherActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        user_detail.setOnClickListener {

            val intent=Intent(this,TestActivity::class.java)
            startActivity(intent)
        }

        department_detail.setOnClickListener {

            val intent=Intent(this,UserDepartmentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
    }
}