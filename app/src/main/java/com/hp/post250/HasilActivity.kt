package com.hp.post250

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hp.post250.MainActivity.Companion.DATA_JK
import com.hp.post250.MainActivity.Companion.DATA_NAMA
import com.hp.post250.MainActivity.Companion.DATA_UMUR
import com.hp.post250.MainActivity.Companion.DATA_USERNAME
import com.hp.post250.databinding.ActivityHasilBinding
import com.hp.post250.databinding.ActivityMainBinding

class HasilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHasilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHasilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama = intent.getStringExtra(MainActivity.DATA_NAMA)
        val username = intent.getStringExtra(MainActivity.DATA_USERNAME)
        val umur = intent.getStringExtra(MainActivity.DATA_UMUR)
        val jk = intent.getStringExtra(MainActivity.DATA_JK)

        binding.apply {
            hasiloutput1.text = nama
            hasiloutput2.text = username
            hasiloutput3.text = umur
            hasiloutput4.text = jk
        }
    }
}
