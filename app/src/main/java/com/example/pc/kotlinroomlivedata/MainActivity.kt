package com.example.pc.kotlinroomlivedata
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import romlivedata.UserData
import romlivedata.UserDatabase

class MainActivity : AppCompatActivity() {

    private var mDb: UserDatabase? = null
    private lateinit var mDbWorkerThread: DbWorkerThread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDbWorkerThread = DbWorkerThread("dbWorkerThread")
        mDbWorkerThread.start()
        mDb= UserDatabase.getInstance(this)

        insert_row.setOnClickListener {

            var userdata= UserData()
            userdata.name=name.text.toString()
            userdata.email=email.text.toString()
            userdata.phone=phone.text.toString()
            userdata.address=address.text.toString()
            insertUserDataInDb(userdata)


        }


        view_data.setOnClickListener {

            val intent=Intent(this,DataListActivity::class.java)
            startActivity(intent)

        }

    }

    override fun onDestroy() {

        UserDatabase.destroyInstance()
        mDbWorkerThread.quit()
        super.onDestroy()

    }

    private fun insertUserDataInDb(userData: UserData) {
        val task = Runnable {
            mDb?.userDao()?.insert(userData)
            Log.d("inser","Insert Sucessfully")
        }
        mDbWorkerThread.postTask(task)
    }
}
