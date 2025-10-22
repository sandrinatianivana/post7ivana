package com.hp.post250

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hp.post250.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val DATA_NAMA = "data_nama"
        const val DATA_USERNAME = "data_username"
        const val DATA_UMUR = "data_umur"
        const val DATA_JK = "data_jk"
    }

    private lateinit var binding: ActivityMainBinding
    private var jk = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            tombolsubmit.setOnClickListener {
                val nama = isinama.text.toString()
                val username = isiusername.text.toString()
                val umur = isiumur.text.toString()

                jk = when {
                    rdb1.isChecked -> "Laki-Laki"
                    rdb2.isChecked -> "Perempuan"
                    else -> ""
                }

                if (isipassword.text.toString() != isipassword.text.toString()) {
                    Toast.makeText(this@MainActivity, "Password Does Not Match!!!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val intent = Intent(this@MainActivity, HasilActivity::class.java)
                intent.putExtra(DATA_NAMA, nama)
                intent.putExtra(DATA_USERNAME, username)
                intent.putExtra(DATA_UMUR, umur)
                intent.putExtra(DATA_JK, jk)
                startActivity(intent)
            }
        }
    }
}
