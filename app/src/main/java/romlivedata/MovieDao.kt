package romlivedata
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface MovieDao {

    @Query("SELECT * from movie")
    fun getAllMovie(): LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMoview(moviedetail: Movie)

    @Delete()
    fun deleteMoview(moviedetail: Movie)

    @Update()
    fun updateMoview(moviedetail: Movie)

    @Query("DELETE from movie")
    fun deleteAllMovie()

    @Query("DELETE FROM movie WHERE mid = :mId")
    fun deleteMovieByQuery(mId: Int): Int

    @Query("SELECT * FROM movie WHERE mid = :mid")
    fun getMovieNameById(mid:Int):Movie;
}