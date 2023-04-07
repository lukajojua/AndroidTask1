package dev.shanker.lukajojua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import dev.shanker.lukajojua.Constants.USER_OBJECT

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etPhoneNumber: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        init()
    }

    private fun initViews() {
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        btnRegister = findViewById(R.id.btnRegister)
    }

    private fun init() {
        btnRegister.setOnClickListener {
            if (!validateFields()) {
                Toast.makeText(this, "Fill the missing fields", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val name = etName.text.trim().toString()
            val email = etEmail.text.trim().toString()
            val password = etPassword.text.trim().toString()
            val phoneNumber = etPhoneNumber.text.trim().toString()

            val user = User(name, email, password, phoneNumber)

            launchActivityWithUser(user)
        }
    }

    private fun validateFields(): Boolean {
        return etName.text.toString().isNotEmpty() &&
                etEmail.text.toString().isNotEmpty() &&
                etPassword.text.toString().isNotEmpty() &&
                etPhoneNumber.text.toString().isNotEmpty()
    }

    private fun launchActivityWithUser(data: User) {
        Intent(this, SecondActivity::class.java).apply {
            putExtra(USER_OBJECT, data)
            startActivity(this)
        }
    }
}