package com.example.user.movierateapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_view_movie.*
import com.example.user.movierateapplication.Movie
class ViewMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_movie)

//        val movieDetails = Movie("VenomSSS","When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego \"Venom\" to save his life","English","03-10-2018",true, null,null)
        val movieAL = applicationContext as MovieArrayList
        val id = intent.getIntExtra("position",0)
        val movieDetails = movieAL.getMovies()[id]
        tvTitle.text = movieDetails.getMovieName()
        tvDesc.text = movieDetails.getMovieDesc()
        tvLanguage.text = movieDetails.getMovieLang()
        tvDate.text = movieDetails.getMovieDate()
        if(!movieDetails.getMovieRatings().isNullOrBlank()){
            tvAddReview.text = movieDetails.getMovieRatings()
            ratingBar.rating = movieDetails.getMovieStar()
            ratingBar.visibility = VISIBLE
            tvNoReviews.visibility = GONE
            ratingBar.setIsIndicator(true)
        }
        if(movieDetails.getMovieSuitable()){
            tvSuitable.text = "Yes"
        }
        else{
            if(movieDetails.getMovieViolence()){
                tvSuitable.text = "No(Violence)"
            }
            else if(movieDetails.getMovieStrongLang()){
                tvSuitable.text = "No(language)"
            }
            else if(movieDetails.getMovieStrongLang() && movieDetails.getMovieViolence()){
                tvSuitable.text = "No(Violence and language)"
            }
            else{
                tvSuitable.text = "No"
            }
        }
//        tvSuitable.text = movieDetails.getMovieSuitable().toString()

        registerForContextMenu(tvAddReview)
        }


    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if(v?.id == R.id.tvAddReview){
            menu?.add(1,1001,1,"Add Review")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == 1001){
            val intent = Intent(this, RateMovie::class.java)
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }

    override fun onBackPressed() {
        val intent = Intent(this, LandingPage::class.java)
        startActivity(intent)
        super.onBackPressed()
    }
}


