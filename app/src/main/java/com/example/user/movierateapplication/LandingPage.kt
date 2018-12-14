package com.example.user.movierateapplication

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import kotlinx.android.synthetic.main.activity_landing_page.*

class LandingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        //private lateinit var listView ListView
        val movieAL = applicationContext as MovieArrayList
        //listView = findViewById<ListView>(R.id.movie_list_view)
        if(movieAL.getMovies().isNotEmpty()){
            val adpt = movieAdapter(this,movieAL.getMovies())
            movie_list_view.adapter = adpt
        }
        //val recipeList = Recipe.getRecipes
        registerForContextMenu(movie_list_view)
    }

    class movieAdapter(private val context: Context, private val dataSource: ArrayList<Movie>): BaseAdapter() {
        private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun getCount(): Int {
            return dataSource.size
        }

        //2
        override fun getItem(position: Int): Any {
            return dataSource[position]
        }

        //3
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        //4
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            // Get view for row item
            val rowView = inflater.inflate(R.layout.list_item_movie, parent, false)
            val titleTextView = rowView.findViewById(R.id.movie_list_title) as TextView
            val movieImg = rowView.findViewById(R.id.movieImage) as ImageView
            val movie = getItem(position) as Movie
            titleTextView.text = movie.getMovieName()
            return rowView
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if(v?.id == R.id.movie_list_view){
            menu?.add(1,1001,1,"Edit")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
        if(item?.itemId == 1001){
            val intent = Intent(this, EditMovie::class.java)
            intent.putExtra("position",info.id)
            startActivity(intent)
        }

        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.landingmovie,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.redirect2add){
            val intent = Intent(this, AddMovie::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

}