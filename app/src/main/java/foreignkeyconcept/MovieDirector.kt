package foreignkeyconcept
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import com.example.pc.kotlinroomlivedata.R
import kotlinx.android.synthetic.main.activity_movie_director.*
import romlivedata.Director
import romlivedata.Movie

class MovieDirector:AppCompatActivity() {

    lateinit var model: MovieDirectorViewModel
    var list: List<Director>? = null
    var movielist: List<Movie>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_director)

        model=ViewModelProviders.of(this).get(MovieDirectorViewModel::class.java);


        insert_director_record.setOnClickListener {

            val director=Director()
            director.fullName=director_name.text.toString()
            director.age=director_age.text.toString().toInt()
            model.insertDirector(director)
            Log.d("insert","insert director sucessfully")
        }

        model.getAllDirector.observe(this, object :  Observer<List<Director>> {

            override fun onChanged(t: List<Director>?) {

                list= t!!

                Log.d("data","the id is ${list!!.get(0).id} and name is ${list!!.size}" )
            }

        })

        model.getAllMovie.observe(this, object : Observer<List<Movie>> {
            override fun onChanged(t: List<Movie>?) {

                movielist=t!!
                Log.d("movieSize","the movie size is ${t?.size}");
            }

        })





         view_director_record.setOnClickListener {


             model.deleteMoviewById(movielist?.get(0)?.mid!!)
             //model.deleteAllDirector()

          }

        /*
        *
        *
        */

        insert_movie.setOnClickListener {

            val movie=Movie()
            movie.title=movie_title.text.toString();
            movie.directorId=2
            model.insertMoview(movie)
            Log.d("movie","Insert Movie Sucessfully")

          }

        view_movie_detail.setOnClickListener {

            model.getAllMovie.observe(this, object : Observer<List<Movie>> {
                override fun onChanged(t: List<Movie>?) {

                    Log.d("movieSize","the movie size is ${t?.size}");
                }

            })
        }

        }

    override fun onResume() {
        super.onResume()
    }

    }


