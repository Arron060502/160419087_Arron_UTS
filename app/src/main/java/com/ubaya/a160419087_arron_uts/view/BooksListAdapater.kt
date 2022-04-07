package com.ubaya.a160419087_arron_uts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.a160419087_arron_uts.R
import com.ubaya.a160419087_arron_uts.model.Books
import kotlinx.android.synthetic.main.book_list_item.view.*

class BooksListAdapater(val booksList: ArrayList<Books>) : RecyclerView
.Adapter<BooksListAdapater.BooksViewHolder>() {
    class BooksViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.book_list_item, parent,false)
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val books = booksList[position]
        with(holder.view){
            textID.text = books.id
            textBookName.text = books.name
            buttonDetails.setOnClickListener{
                val action = BookListFragmentDirections.actionBooksDetails()
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    override fun getItemCount() = booksList.size

    fun updateBooksList(newBooksList: ArrayList<Books>){
        booksList.clear()
        booksList.addAll(newBooksList)
        notifyDataSetChanged()
    }
}