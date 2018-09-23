package romlivedata
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

// By default Room uses the class name as the table name. but you can use custom name

@Entity(tableName = "UserData",indices = arrayOf(Index(value = arrayOf("name"),unique = true)))
data class UserData(@PrimaryKey(autoGenerate = true) var id:Int?,
                    @ColumnInfo(name="name")var name:String,
                    @ColumnInfo(name="email")var email:String,
                    @ColumnInfo(name="phone")var phone:String,
                    @ColumnInfo(name="address")var address:String)
{
    constructor():this(null,"","","","")
}

//Each Entity, must define at least 1 primary key.
// You need to annotate the field with PrimaryKey annotation