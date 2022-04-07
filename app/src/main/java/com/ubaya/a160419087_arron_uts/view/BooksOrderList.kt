package com.ubaya.a160419087_arron_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ubaya.a160419087_arron_uts.R


/**
 * A simple [Fragment] subclass.
 * Use the [BooksOrderList.newInstance] factory method to
 * create an instance of this fragment.
 */
class BooksOrderList : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_books_order_list, container, false)
    }


}