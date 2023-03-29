package tayeb.shahbakhsh.note

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tayeb.shahbakhsh.note.databinding.RecyclerLayoutBinding

class NotesAdapter(private val context: Context) :
    RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: RecyclerLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(RecyclerLayoutBinding.inflate(LayoutInflater.from(context), parent, false))

    override fun getItemCount(): Int = 30

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }


}