package romlivedata
import android.arch.persistence.room.*
@Entity(tableName = "director", indices  = arrayOf(Index(value = arrayOf("full_name"),unique = true)))
class Director(@PrimaryKey(autoGenerate = true)
               @ColumnInfo(name = "did")var id:Int?,
               @ColumnInfo(name = "full_name") var fullName: String,
               @Ignore@ColumnInfo(name = "age")var age:Int?)
    {
       constructor():this(null,"",null)

    }