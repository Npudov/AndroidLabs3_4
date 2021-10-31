package com.example.androidlabs3_4

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.androidlabs3_4.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toFirst.setOnClickListener {
            toFirst()
        }
        binding.toSecond.setOnClickListener {
            toSecond()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.about) {
            startActivity(Intent(this, AboutActivity::class.java))
            true
        }
        else {
            return super.onOptionsItemSelected(item)
        }
    }

    private fun toFirst() {
        startActivity(Intent(this, MainActivity::class.java).setFlags(FLAG_ACTIVITY_CLEAR_TOP))
    }

    private fun toSecond() {
        finish()
    }
}