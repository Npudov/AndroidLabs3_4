package com.example.androidlabs3_4

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlabs3_4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toFirst.setOnClickListener {
            toFirst()
        }
        binding.toSecond.setOnClickListener {
            toSecond()
        }
        binding.toThird.setOnClickListener {
            toThird()
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
        } else {
            return super.onOptionsItemSelected(item)
        }
    }

    private fun toFirst() {
        finish()
    }

    private fun toSecond() {
        startActivity(Intent(this, SecondActivity::class.java).setFlags(FLAG_ACTIVITY_SINGLE_TOP))
    }

    private fun toThird() {
        startActivity(Intent(this, ThirdActivity::class.java))
    }
}