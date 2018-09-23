package romlivedata
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

//The class should be abstract and should extend RoomDatabase.

@Database(entities = arrayOf(UserData::class,UserDepartment::class,Movie::class,Director::class),version = 3)
abstract  class UserDatabase: RoomDatabase(){

    abstract fun userDao(): Userdao
    abstract fun movieDao(): MovieDao
    abstract fun directorDao(): DirectorDao

    companion object {

        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase? {
            if (INSTANCE == null) {
                synchronized(UserDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserDatabase::class.java, "userdatbase.db")
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {

            INSTANCE = null
        }
    }

}