import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectmovil.R

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var signUpButton: TextView
    private lateinit var forgotPasswordText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.btnlogin)
        signUpButton = findViewById(R.id.signUpBtn)
        forgotPasswordText = findViewById(R.id.textView3)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Aquí puedes realizar la lógica de autenticación con el correo electrónico y la contraseña
            if (validateCredentials(email, password)) {
                // Si las credenciales son válidas, realiza la autenticación o el inicio de sesión
                loginUser(email, password)
            } else {
                // Si las credenciales no son válidas, muestra un mensaje de error
                showToast("Invalid email or password")
            }
        }

        signUpButton.setOnClickListener {
            // Aquí puedes implementar la lógica para abrir la actividad de registro de usuarios
            // Por ejemplo, puedes iniciar una nueva actividad SignUpActivity
        }

        forgotPasswordText.setOnClickListener {
            // Aquí puedes implementar la lógica para abrir la actividad de restablecimiento de contraseña
            // Por ejemplo, puedes iniciar una nueva actividad ForgotPasswordActivity
        }
    }

    private fun validateCredentials(email: String, password: String): Boolean {
        // Aquí puedes implementar la lógica de validación de las credenciales
        // Por ejemplo, puedes verificar si el formato del correo es válido y si la contraseña cumple con ciertos requisitos

        // Validar el formato del correo electrónico
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        val isValidEmail = email.matches(emailPattern.toRegex())

        // Validar la longitud de la contraseña
        val isValidPassword = password.length >= 6

        // Devolver true si las credenciales son válidas, de lo contrario, devolver false
        return isValidEmail && isValidPassword
    }

    private fun loginUser(email: String, password: String) {
        // Aquí puedes implementar la lógica para autenticar al usuario utilizando el correo electrónico y la contraseña
        // Por ejemplo, puedes usar Firebase Authentication u otros servicios de autenticación

        // Simulación de inicio de sesión exitoso
        if (email == "example@example.com" && password == "password") {
            // Mostrar mensaje de éxito
            showToast("Login successful")

            // Aquí puedes realizar acciones adicionales, como guardar el estado de inicio de sesión o navegar a otra actividad
        } else {
            // Mostrar mensaje de error en caso de inicio de sesión fallido
            showToast("Login failed")
        }
    }

    private fun showToast(message: String) {
        // Método de utilidad para mostrar un mensaje de toast
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

