package romlivedata
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "user")
class User(@PrimaryKey(autoGenerate = true)var user_id:Int?,
           @ColumnInfo(name = "user_name")var user_name:String,
           @ColumnInfo(name = "user_pass")var user_pass:String,
           @ColumnInfo(name = "user_email")var user_email:String,
           @ColumnInfo(name = "user_mobile")var user_mobile:String,
           @ColumnInfo(name = "user_add")var user_add:String) {

    constructor():this(null,"","","","","")
}

