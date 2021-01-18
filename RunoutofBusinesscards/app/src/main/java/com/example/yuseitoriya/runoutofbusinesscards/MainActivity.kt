@file:Suppress("DEPRECATION")

package com.example.yuseitoriya.runoutofbusinesscards

//名刺を表示するActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        PreferenceManager.getDefaultSharedPreferences(this).apply {
            val company = getString("company", "")
            val postal = getString("postal", "")
            val address = getString("address", "")
            val tel = getString("tel", "")
            val fax = getString("fax", "")
            val email = getString("email" , "")
            val url = getString("url", "")
            val position = getString("position", "")
            val name = getString("name", "")

            companyText.text = company
            postalText.text = postal
            addressText.text = address
            telText.text = "TEL:" + tel
            faxText.text = "FAX:" + fax
            emailText.text = email
            urlText.text = url
            positionText.text = position
            nameText.text = name
        }
    }

    //メニューを表示する
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.edit -> {
                //Kotlinではクラス名::class.javaでクラスのインスタンスを取得する
                val intent = Intent(this, EditActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
