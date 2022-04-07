package com.ubaya.a160419087_arron_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.a160419087_arron_uts.viewModel.ListViewModel
import kotlinx.android.synthetic.main.fragment_book_list.*

/**
 * A simple [Fragment] subclass.
 * Use the [BookListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookListFragment : Fragment() {
private lateinit var viewModel : ListViewModel
private  val booksListAdapater = BooksListAdapater(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.ubaya.a160419087_arron_uts.R.layout.fragment_book_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel= ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = booksListAdapater

        observeViewModel()

        refershLayout.setOnRefreshListener {
            recView.visibility = View.GONE
            textError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refershLayout.isRefreshing = false
        }

    }

    private fun observeViewModel() {
        viewModel.booksLiveData.observe(viewLifecycleOwner){
            booksListAdapater.updateBooksList(it)
        }
        viewModel.booksLoadErrorLiveData.observe(viewLifecycleOwner){
            textError.visibility = if (it) View.VISIBLE else View.GONE
        }
        viewModel.loadingLiveData.observe(viewLifecycleOwner){
            if(it){
                recView.visibility = View.GONE
                progressLoad.visibility = View.VISIBLE
            } else{
                recView.visibility = View.VISIBLE
                progressLoad.visibility = View.GONE
            }
        }
    }

}