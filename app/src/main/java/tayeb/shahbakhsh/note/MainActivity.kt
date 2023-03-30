package tayeb.shahbakhsh.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.floatingactionbutton.FloatingActionButton
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

        var bottomSheetIsHidden = true
        binding.addNoteFab.setOnClickListener {
            bottomSheetIsHidden = !bottomSheetIsHidden
            if (bottomSheetIsHidden) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                binding.dimBackgroundView.visibility = View.GONE
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                binding.dimBackgroundView.visibility = View.VISIBLE
            }

            animateFab(binding.addNoteFab, bottomSheetIsHidden)
        }
    }

    private fun animateFab(fab: FloatingActionButton, bottomSheetIsHidden: Boolean) {
        val springAnim = SpringAnimation(fab, SpringAnimation.ROTATION)
        val springForce = SpringForce()
        if (!bottomSheetIsHidden) {
            springForce.finalPosition = 225f
            springAnim.spring = springForce
            springForce.dampingRatio = SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY
            springForce.stiffness = SpringForce.STIFFNESS_LOW
            springAnim.start()
        } else {
            springForce.finalPosition = 0f
            springAnim.spring = springForce
            springForce.stiffness = SpringForce.STIFFNESS_LOW
            springForce.dampingRatio = SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY
            springAnim.start()
        }
    }

}
