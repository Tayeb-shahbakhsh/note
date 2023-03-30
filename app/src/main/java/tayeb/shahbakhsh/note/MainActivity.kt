package tayeb.shahbakhsh.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import tayeb.shahbakhsh.note.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.notesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = NotesAdapter(this@MainActivity)
        }

        val bottomSheet = binding.addNoteBottomSheet
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        bottomSheetBehavior.isHideable = true
        bottomSheetBehavior.isDraggable = true
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        var hidden = true
        binding.addNoteFab.setOnClickListener {
            hidden = !hidden
            if (hidden) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                binding.dimBackgroundView.visibility = View.GONE
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                binding.dimBackgroundView.visibility = View.VISIBLE
            }
        }
    }
}