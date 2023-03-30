package tayeb.shahbakhsh.note

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tayeb.shahbakhsh.note.databinding.RecyclerLayoutBinding
import tayeb.shahbakhsh.note.model.Note

class NotesAdapter(private val context: Context, val notes: MutableList<Note>) :
    RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding: RecyclerLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(RecyclerLayoutBinding.inflate(LayoutInflater.from(context), parent, false))

    override fun getItemCount(): Int = notes.size
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.titleTextView.text = notes[position].title
        holder.binding.captionTextView.text = notes[position].caption
        holder.binding.dateTextView.text = notes[position].date
    }


}