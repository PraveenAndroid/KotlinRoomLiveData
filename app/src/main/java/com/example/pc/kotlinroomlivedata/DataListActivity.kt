package com.example.pc.kotlinroomlivedata
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_data_list.*
import romlivedata.UserDatabase

class DataListActivity:AppCompatActivity() {

    private var mDb: UserDatabase? = null
    private lateinit var mDbWorkerThread: DbWorkerThread
    lateinit var myCustomAdapter: UserdataAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_list)

        

        mDbWorkerThread= DbWorkerThread("dbWorkerThread1")
        mDbWorkerThread.start()
        mDb= UserDatabase.getInstance(this)

        //

        data_list.layoutManager = LinearLayoutManager(this)
        data_list.setHasFixedSize(true)




    }

    override fun onResume() {
        super.onResume()
        getUserDataInDb()
    }


    private fun getUserDataInDb() {
        val task = Runnable {

            val data=  mDb?.userDao()?.getAll()

            //Log.d("data",data.size+"")
            myCustomAdapter= UserdataAdapter(this,data)
            data_list.adapter=myCustomAdapter



        }
        mDbWorkerThread.postTask(task)
    }

}