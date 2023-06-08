package com.example.proyectmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar


var txtNombre: EditText? =null;
var txtEmail: EditText? =null;
var txtPassword: EditText? =null;
var txtConfircontra: EditText? =null;

class Signup : AppCompatActivity() {

    private var passwordShowin:Boolean=false;
    private var conPasswordShowin:Boolean=false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val signUpButton: AppCompatButton =findViewById(R.id.btnlogin)

        txtNombre=findViewById(R.id.emailEditText);

        txtConfircontra=findViewById(R.id.passwordEditText3);
        txtPassword=findViewById(R.id.passwordEditText2);
        txtEmail=findViewById(R.id.passwordEditText);

    }

    fun clickbtninsertar(view: View){
        val nombre = txtNombre?.text.toString().trim()
        val email = txtEmail?.text.toString().trim()
        val password = txtPassword?.text.toString().trim()
        val confirmarPassword = txtConfircontra?.text.toString().trim()
        if(nombre.isEmpty()||email.isEmpty()||password.isEmpty()){

            Snackbar.make(view,"Porfavor completa los campos", Snackbar.LENGTH_LONG).show()

        }
        if (password!=confirmarPassword){
            Snackbar.make(view," las contraseñas no coinciden", Snackbar.LENGTH_LONG).show()


        }
        val url="http://192.168.43.167/android_distribuidora/insertar.php"
        val queue = Volley.newRequestQueue(this)
        var resultadoPost = object : StringRequest(
            Request.Method.POST,url,
            Response.Listener<String> { response ->
                Snackbar.make(view, "Felicidades Usuario agregado exitosamente", Snackbar.LENGTH_LONG).show()
            }, Response.ErrorListener { error ->
                //Toast.makeText(this, "Error $error", Toast.LENGTH_LONG).show()
                Snackbar.make(view, "Error $error", Snackbar.LENGTH_LONG).show()
            }){
            override fun getParams(): MutableMap<String, String>? {
                val parametros= HashMap<String,String>()
                parametros.put("name",txtNombre?.text.toString())
                parametros.put("email",txtEmail?.text.toString())
                parametros.put("password", txtPassword?.text.toString())
                return parametros
            }
        }
        queue.add(resultadoPost)

    }

}