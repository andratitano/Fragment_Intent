package com.andra.fragment_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) { }

        getFragment(PageFragment())
        button_act.setOnClickListener {
            var fragment = supportFragmentManager.findFragmentById(page.id) as PageFragment
            fragment.toastFragment()
        }
    }

    fun toastActivity() {
        Toast.makeText(this, "Toast ini Tampil di Fragment, Dijalankan dari Activity", Toast.LENGTH_SHORT).show()
    }

    private fun getFragment(pageFragment: PageFragment) {
        supportFragmentManager.beginTransaction()
            .replace(page.id, pageFragment)
            .commit()
    }

}