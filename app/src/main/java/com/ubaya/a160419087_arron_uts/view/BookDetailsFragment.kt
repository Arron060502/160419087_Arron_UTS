package com.ubaya.a160419087_arron_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ubaya.a160419087_arron_uts.R
import com.ubaya.a160419087_arron_uts.viewModel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_book_details.*

/**
 * A simple [Fragment] subclass.
 * Use the [BookDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookDetailsFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.booksLiveData.observe(viewLifecycleOwner) {
            editId.setText(it.id)
            editName.setText(it.name)
            editDate.setText(it.dor)
            editWriter.setText(it.writer)
        }
    }


}