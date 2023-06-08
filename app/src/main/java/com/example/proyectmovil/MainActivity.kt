import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectmovil.R
import com.example.proyectmovil.Signup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickBtnRegister(view: View) {
        // Lógica para el botón de registro
        // Por ejemplo, abrir una nueva actividad de registro
        val intent = Intent(this, Signup::class.java)
        startActivity(intent)
    }

    fun clickBtnEntrar(view: View) {
        // Lógica para el botón de inicio de sesión
        // Por ejemplo, verificar las credenciales ingresadas por el usuario
        val email = "example@example.com" // Obtener el email ingresado por el usuario desde un EditText
        val password = "password123" // Obtener la contraseña ingresada por el usuario desde un EditText

        // Verificar las credenciales (esto es solo un ejemplo)
        if (email == "example@example.com" && password == "password123") {
            // Inicio de sesión exitoso
            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()

            // Aquí puedes realizar alguna acción adicional, como mostrar otra actividad o realizar una operación

        } else {
            // Credenciales incorrectas
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
        }
    }
}
