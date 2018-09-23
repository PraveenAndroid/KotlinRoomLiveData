package roomwithlivedata
import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import romlivedata.*

/**
 * Created by pc on 8/22/2018.
 */

class UserRepositiory internal constructor(application: Application) {

    var allData: LiveData<List<UserData>>
    var getDeapartmentDetail:LiveData<List<UserDepartment>>
    var userDetailDao: Userdao
    var moviedao:MovieDao
    var directorDao:DirectorDao

    /*
    * all movie list
    */

    var allmovieList:LiveData<List<Movie>>

    /*
    * all Director list
    */

    var alldirectorList:LiveData<List<Director>>

    /*
    *
    */

    init {

        val database = UserDatabase.getInstance(application)
        userDetailDao = database!!.userDao()
        allData = userDetailDao.getAll()
        getDeapartmentDetail=userDetailDao.getDepaermentList()

        /*
        * movie dao declaration
        */
        moviedao=database.movieDao()
        allmovieList=moviedao.getAllMovie()

        /*
        * director dao declaration
        */

        directorDao=database.directorDao()
        alldirectorList=directorDao.getAllDirector()


    }

    /*
    *
    */

    fun insert(userDetail: UserData) {

        InsertRecod(userDetailDao).execute(userDetail)
    }

    fun insertDepartment(userDepartment: UserDepartment) {

        InsertDepartment(userDetailDao).execute(userDepartment)
    }

    /*
    *
    *Movie Operation defined here
    */

    fun insertMoview(movieInsert:Movie)
    {
        InsertMoview(moviedao).execute(movieInsert)
    }
    fun deleteMoview(movieDelete:Movie)
    {
        DeleteMoview(moviedao).execute(movieDelete)
    }
    fun updateMoview(movieUpdate:Movie)
    {
        UpdateMoview(moviedao).execute(movieUpdate)
    }

    fun deleteAllMoview()
    {
        moviedao.deleteAllMovie()
        DeleteAllMovies(moviedao).execute()
    }
    fun deleteMoviewBuQuery(mid:Int)
    {
        DeleteMoviewByQuery(moviedao).execute(mid)
    }

   /*
   *
   *Director Operation defined here
   */

    fun insertDirector(directorInsert:Director)
    {
        InsertDirector(directorDao).execute(directorInsert)
    }
    fun deleteDirector(directorDelete:Director)
    {
        DeleteDirector(directorDao).execute(directorDelete)
    }
    fun updateDirector(directorUpdate:Director)
    {
        UpdateDirector(directorDao).execute(directorUpdate)
    }


    fun deleteAllDirector()
    {

        DeleteAllDirector(directorDao).execute()

    }

    fun deleteDirectorwByQuery(did:Int)
    {

        DeleteSingleDirector(directorDao).execute(did)
    }




    /*
    *
    */

    class InsertRecod(var userDetailDao: Userdao) : AsyncTask<UserData, Void, Void>() {

        override fun doInBackground(vararg userDetails: UserData): Void? {
            userDetailDao.insert(userDetails[0])
            return null
        }
    }

    class InsertDepartment(var userDetailDao: Userdao) : AsyncTask<UserDepartment, Void, Void>() {

        override fun doInBackground(vararg userdeaprt: UserDepartment): Void? {

            userDetailDao.insertDepart(userdeaprt[0])
            return null
        }
    }

    /*
    *
    *  Movie database Operation
    */

   class  InsertMoview(var moviedao: MovieDao): AsyncTask<Movie, Void, Void>() {
       override fun doInBackground(vararg p0: Movie): Void? {

           moviedao.insertMoview(p0[0])
           return null
       }
    }
    class  DeleteMoview(var moviedao: MovieDao): AsyncTask<Movie, Void, Void>() {
        override fun doInBackground(vararg p0: Movie): Void? {

            moviedao.deleteMoview(p0[0])
            return null
        }
    }
    class  UpdateMoview(var moviedao: MovieDao): AsyncTask<Movie, Void, Void>() {
        override fun doInBackground(vararg p0: Movie): Void? {

            moviedao.updateMoview(p0[0])
            return null
        }
    }

    class  DeleteMoviewByQuery(var moviedao: MovieDao): AsyncTask<Int, Void, Void>() {

        override fun doInBackground(vararg p0: Int?): Void? {
            moviedao.deleteMovieByQuery(p0[0]!!)
            return null
        }
    }
    class  DeleteAllMovies(var moviedao: MovieDao): AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg p0: Void?): Void? {
            moviedao.deleteAllMovie()
            return null
        }
    }


    /*
     *
     *   Director Database Operation
     */

    class  InsertDirector(var directorDao: DirectorDao): AsyncTask<Director, Void, Void>() {
        override fun doInBackground(vararg p0: Director): Void? {
            directorDao.insertDirector(p0[0])
            return null
        }
    }
    class  DeleteDirector(var directorDao: DirectorDao): AsyncTask<Director, Void, Void>() {
        override fun doInBackground(vararg p0: Director): Void? {

            directorDao.deleteDirector(p0[0])
            return null
        }
    }
    class  UpdateDirector(var directorDao: DirectorDao): AsyncTask<Director, Void, Void>() {
        override fun doInBackground(vararg p0: Director): Void? {

            directorDao.updateDirector(p0[0])
            return null
        }
    }

}

    class DeleteSingleDirector(var directorDao: DirectorDao): AsyncTask<Int, Void, Void>() {
        override fun doInBackground(vararg p0: Int?): Void? {
            directorDao.deleteDirectorByQuery(p0[0])
            return null
        }
    }
    class DeleteAllDirector(var directorDao: DirectorDao): AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg p0: Void): Void? {
            directorDao.deleteAllDirector()
            return null
        }
}


