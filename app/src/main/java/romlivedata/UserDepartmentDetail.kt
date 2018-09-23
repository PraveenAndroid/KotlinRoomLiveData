package romlivedata
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "UserDepartmentDetail")
class UserDepartmentDetail(@PrimaryKey(autoGenerate = true) var id:Int?,
                           @ColumnInfo(name = "depart_name")var depart_name:String,
                           @ColumnInfo(name = "depart_type")var depart_type:String,
                           @ColumnInfo(name = "depart_detail")var depart_detail:String)
{
    constructor():this(null,"","","")
}