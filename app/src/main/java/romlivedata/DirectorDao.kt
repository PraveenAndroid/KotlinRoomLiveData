package romlivedata
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface DirectorDao {

    @Query("SELECT * from director")
    fun getAllDirector(): LiveData<List<Director>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDirector(directorDetail: Director)

    @Delete()
    fun deleteDirector(directordetail: Director)

    @Update()
    fun updateDirector(directordetail: Director)


    @Query("DELETE from director")
    fun deleteAllDirector()

    @Query("DELETE FROM movie WHERE directorId = :dId")
    fun deleteDirectorByQuery(dId: Int?): Int
}