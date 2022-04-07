package com.ubaya.a160419087_arron_uts.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.a160419087_arron_uts.model.Books

class DetailViewModel : ViewModel() {
    val booksLiveData = MutableLiveData<Books>()

    fun fetch(){
        booksLiveData.value = Books("16055","Harry Potter","1998/03/28","5718444778","http://dummyimage.com/75x100" +
                ".jpg/cc0000/ffffff")

    }
}