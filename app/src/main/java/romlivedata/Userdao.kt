package romlivedata
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

//Each DAO includes methods that offer abstract access to your app’s database.

@Dao
interface Userdao {

    @Query("SELECT * from UserData")
    fun getAll(): LiveData<List<UserData>>

    @Query("SELECT * from UserDepartment")
    fun getDepaermentList(): LiveData<List<UserDepartment>>

    @Insert(onConflict = REPLACE)
    fun insert(userdata: UserData)

    @Insert(onConflict = REPLACE)
    fun insertDepart(userdepart: UserDepartment)

    @Query("DELETE from UserData")
    fun deleteAll()
}