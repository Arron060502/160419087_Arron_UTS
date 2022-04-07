package com.ubaya.a160419087_arron_uts.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.a160419087_arron_uts.model.Books
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.log

class ListViewModel(application: Application) : AndroidViewModel(application) {
    val booksLiveData=MutableLiveData<ArrayList<Books>> ()
    val booksLoadErrorLiveData = MutableLiveData<Boolean>()
    val loadingLiveData = MutableLiveData<Boolean>()
    val TAG  = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh(){
        /*
        booksLiveData.value =  arrayListOf(
            Books("16055","Harry Potter","1998/03/28","5718444778","http://dummyimage.com/75x100" +
                    ".jpg/cc0000/ffffff"),

            Books("13312","Fun Girl","1994/12/14","3925444073","http://dummyimage.com/75x100" +
                    ".jpg/5fa2dd/ffffff"),

            Books("11204","The Hunger Games","1994/10/07","6827808747","http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1")
        )

         */
        booksLoadErrorLiveData.value = false
        loadingLiveData.value = true
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php"
        val stringRequest= StringRequest(
            Request.Method.GET,url,
            {
               val sType = object :TypeToken<ArrayList<Books>>(){}.type
                val result = Gson().fromJson<ArrayList<Books>>(it,sType)
                booksLiveData.value= result
                loadingLiveData.value = false
                Log.d("ShowVolley",it)

            },
            {
               loadingLiveData.value = false
                booksLoadErrorLiveData.value = true
                Log.d("errorVolley", it.toString())
            }
        ).apply {
            tag = "TAG"
        }
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}