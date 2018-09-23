package romlivedata
import android.arch.persistence.room.*
@Entity(tableName = "movie",
                foreignKeys = arrayOf(ForeignKey(entity = Director::class,
                parentColumns = arrayOf("did"),
                childColumns = arrayOf("directorId"),onDelete = ForeignKey.CASCADE)
        ))
class Movie(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "mid") var mid: Int?,
             @ColumnInfo(name = "title") var title: String,
             @ColumnInfo(name = "directorId") var directorId: Int?) {
    constructor() : this(null, "", null)

}