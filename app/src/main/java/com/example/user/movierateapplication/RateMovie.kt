package com.example.user.movierateapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_rate_movie.*

class RateMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_movie)
            var movieDetails = applicationContext as Movie
            textView5.setText("Enter your review for the movie: " +movieDetails.getMovieName())
        }

    override fun onBackPressed() {
        val intent = Intent(this, ViewMovie::class.java)
        startActivity(intent)
        super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.ratemovie,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.rateMenu){
            var movieDetails = applicationContext as Movie
            val ptMovieRate = findViewById<EditText>(R.id.ratingComments)
            val movieRate: String? = ptMovieRate.text.toString()
            if(movieRate.isNullOrEmpty()){
                ptMovieRate.setError("Please enter a rating")
            }
            else {
                movieDetails.setMovieStar(ratingStarBar.rating)
                movieDetails.setMovieRatings(ratingComments.text.toString())
                val intent = Intent(this, ViewMovie::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}


