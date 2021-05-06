package edu.bo.examenmovilmauricioguevara

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_books_list.view.*

class BookListAdapter(val items: ArrayList<Book>, val context: Context): RecyclerView.Adapter<BookListAdapter.BookListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activity_books_list, parent, false)
        return BookListViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        val book = items.get(position)
        holder.itemView.txtTittle.text = book.title
        holder.itemView.txtIsbn.text = book.isbn
        holder.itemView.txtAuthor.text = book.author
        holder.itemView.txtDate.text = book.date
        holder.itemView.txtPages.text = book.pages
        holder.itemView.txtDescription.text = book.description
        val picasso = Picasso.get()
        picasso.load(book.photoURL).into(holder.itemView.ImageViewBook)
    }

    class BookListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}