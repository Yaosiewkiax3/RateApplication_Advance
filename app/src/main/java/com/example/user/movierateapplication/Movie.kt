package com.example.user.movierateapplication

import android.app.Application
import java.util.*

class Movie : Application(){
    var name:String=""
    var desc:String=""
    var lang:String=""
    var date:String=""
    var suitable:Boolean=true
    var violence:Boolean=false
    var strongLang:Boolean=false
    var ratings:String?=null
    var star:Float= 0.0f

    fun getMovieName():String{
        return name
    }

    fun setMovieName(mName:String){
        this.name = mName
    }

    fun getMovieDesc():String{
        return desc
    }

    fun setMovieDesc(mDesc:String){
        this.desc = mDesc
    }

    fun getMovieLang():String{
        return lang
    }

    fun setMovieLang(mLang:String){
        this.lang = mLang
    }

    fun getMovieDate():String{
        return date
    }

    fun setMovieDate(mDate:String){
        this.date = mDate
    }

    fun getMovieSuitable():Boolean{
        return suitable
    }

    fun setMovieSuitable(mSuit:Boolean){

        this.suitable = mSuit
    }

    fun getMovieViolence():Boolean{
        return violence
    }

    fun setMovieViolence(mVio:Boolean){
        this.violence = mVio
    }

    fun getMovieStrongLang():Boolean{
        return strongLang
    }

    fun setMovieStrongLang(sLang:Boolean){
        this.strongLang = sLang
    }

    fun getMovieRatings():String?{
        return ratings
    }

    fun setMovieRatings(mRatings:String?){
        this.ratings = mRatings
    }

    fun getMovieStar():Float{
        return star
    }

    fun setMovieStar(mStar:Float){
        this.star = mStar
    }
}