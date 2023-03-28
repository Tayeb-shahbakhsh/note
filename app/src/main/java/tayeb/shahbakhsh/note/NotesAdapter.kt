package tayeb.shahbakhsh.note

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val context: Context): RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = 30

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }


}