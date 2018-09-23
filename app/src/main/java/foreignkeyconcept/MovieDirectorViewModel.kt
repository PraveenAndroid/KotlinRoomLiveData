package foreignkeyconcept
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import romlivedata.Director
import romlivedata.Movie
import roomwithlivedata.UserRepositiory

class MovieDirectorViewModel(application:Application):AndroidViewModel(application) {

    var userRepositiory: UserRepositiory
    var getAllMovie:LiveData<List<Movie>>
    var getAllDirector:LiveData<List<Director>>



    init {
        userRepositiory= UserRepositiory(application)
        getAllMovie=userRepositiory.allmovieList
        getAllDirector=userRepositiory.alldirectorList
    }

    fun insertMoview(movie:Movie)
    {
        userRepositiory.insertMoview(movie)
    }

    fun deleteMoview(movie:Movie)
    {
        userRepositiory.deleteMoview(movie)
    }

    fun updateMoview(movie:Movie)
    {
        userRepositiory.updateMoview(movie)
    }

    fun deleteAllMoview()
    {
        userRepositiory.deleteAllMoview()
    }

    fun deleteMoviewById(mid:Int)
    {
        userRepositiory.deleteMoviewBuQuery(mid)
    }

    /*
    *
    */
    fun insertDirector(director:Director)
    {
        userRepositiory.insertDirector(director)
    }

    fun deleteDirector(director:Director)
    {
        userRepositiory.deleteDirector(director)
    }

    fun updateDirector(director:Director)
    {
        userRepositiory.updateDirector(director)
    }

    fun deleteAllDirector()
    {
        userRepositiory.deleteAllDirector()
    }

    fun deleteDirectoryById(did:Int)
    {
        userRepositiory.deleteDirectorwByQuery(did)
    }
}