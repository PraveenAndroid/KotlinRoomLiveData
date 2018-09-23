package roomwithlivedata
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.util.Log
import romlivedata.UserData
import romlivedata.UserDepartment

/**
 * Created by pc on 8/22/2018.
 */

class UserDetailViewModel(application: Application) : AndroidViewModel(application) {

    var userRepositiory: UserRepositiory
    var userData: LiveData<List<UserData>>
    var userDepartment : LiveData<List<UserDepartment>>

    init {

        userRepositiory = UserRepositiory(application)
        userData = userRepositiory.allData
        userDepartment=userRepositiory.getDeapartmentDetail
    }

    fun insert(userDetail: UserData) {
        userRepositiory.insert(userDetail)
        Log.d("inser","Insert Sucessfully")
    }

    fun insertDepartment(userdepart:UserDepartment)
    {
        userRepositiory.insertDepartment(userdepart)
        Log.d("inser","Insert Sucessfully")
    }
}
