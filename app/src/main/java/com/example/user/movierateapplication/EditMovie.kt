package com.example.user.movierateapplication
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
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
        val id = intent.getIntExtra("position",0)
        val movieAL = applicationContext as MovieArrayList
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
                ptMovieDesc.setError("Field empty")
            }
            if(ptMovieName.text.isNullOrEmpty()){
                ptMovieName.setError("Field empty")
            }
            if(ptReleaseDate.text.isNullOrEmpty()){
                ptReleaseDate.setError("Field empty")
            }
            if(!ptMovieDesc.text.isNullOrEmpty() && !ptMovieName.text.isNullOrEmpty() && !ptReleaseDate.text.isNullOrEmpty()){
                val id = intent.getIntExtra("position",0)
                val radioLangGroup = findViewById<RadioGroup>(R.id.rgLang)
                val idSelected = radioLangGroup.checkedRadioButtonId
                val radioLangText = findViewById<RadioButton>(idSelected).text
                val movieAL = applicationContext as MovieArrayList
                val editedMovie = movieAL.getMovies()[id]
                editedMovie.setMovieDesc(ptMovieDesc.text.toString())
                editedMovie.setMovieName(ptMovieName.text.toString())
                editedMovie.setMovieDate(ptReleaseDate.text.toString())
                editedMovie.setMovieDate(radioLangText.toString())
                if(cbAudience.isChecked){
                    editedMovie.setMovieSuitable(false)
                    if(cbLanguage.isChecked){
                        editedMovie.setMovieStrongLang(true)
                    }
                    if(cbViolence.isChecked){
                        editedMovie.setMovieViolence(true)
                    }
                }
                val intent = Intent(this,LandingPage::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}