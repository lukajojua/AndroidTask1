package dev.shanker.lukajojua

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var tvName : TextView
    private lateinit var tvEmail : TextView
    private lateinit var tvPhoneNumber : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initViews()
        init()
    }

    private fun initViews() {
        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        tvPhoneNumber = findViewById(R.id.tvPhoneNumber)
    }

    private fun init() {
        val user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.USER_OBJECT, User::class.java)
        } else {
            intent.getParcelableExtra(Constants.USER_OBJECT)
        }

        tvName.text = getString(R.string.name_title, user?.name)
        tvEmail.text = getString(R.string.email_title, user?.email)
        tvPhoneNumber.text = getString(R.string.phone_number_title, user?.phoneNumber)
    }
}