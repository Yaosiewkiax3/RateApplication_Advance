package com.example.user.movierateapplication
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_edit_movie.*

class EditMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_movie)

        cbAudience.setOnCheckedChangeListener { checkbox, isChecked ->
            if (isChecked) {
                cbReasons.visibility = View.VISIBLE
            } else {
                cbReasons.visibility = View.INVISIBLE
            }
        }
        val movieAL = applicationContext as MovieArrayList
        val id = intent.getIntExtra("position",0)
        val movieDetails = movieAL.getMovies()[id]
        ptMovieName.setText(movieDetails.getMovieName())
        ptMovieDesc.setText(movieDetails.getMovieDesc())
        ptReleaseDate.setText(movieDetails.getMovieDate())
        when(movieDetails.getMovieLang()){
            "English" -> radioButtonEng.isChecked=true
            "Chinese" -> radioButtonChi.isChecked=true
            "Malay" -> radioButtonMal.isChecked=true
            "Tamil" -> radioButtonTam.isChecked=true
        }
        ptReleaseDate.setText(movieDetails.getMovieDate())
        if(!movieDetails.getMovieSuitable()){
            cbAudience.isChecked=true
            if(movieDetails.getMovieStrongLang()){
                cbLanguage.isChecked=true
            }
            if(movieDetails.getMovieViolence()){
                cbViolence.isChecked=true
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.editmovie,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.saveMovie){
            if(ptMovieDesc.text.isNullOrEmpty()){
                ptMovieDesc.setError("")
            }
        }
        return super.onOptionsItemSelected(item)
    }
}