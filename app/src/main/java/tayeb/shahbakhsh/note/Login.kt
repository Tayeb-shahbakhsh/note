package tayeb.shahbakhsh.note

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import tayeb.shahbakhsh.note.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usernameEditText = binding.usernameEditText.text
        val passwordEditText = binding.passwordEditText.text

        binding.signinButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            if (usernameEditText.isNotBlank() || passwordEditText.isNotBlank()) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "لطفا مقادیر لازم را به درستی پر کنید!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}