@file:Suppress("DEPRECATION")

package com.example.yuseitoriya.runoutofbusinesscards

//名刺に記載する情報を編集するActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_edit.*


class EditActivity : AppCompatActivity() {

    //データの取得とボタンが押された時の処理を行うメソッド
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val pref = PreferenceManager.getDefaultSharedPreferences(this).apply {
            //スコープ関数applyを用いたメソッドチェーンをしない場合は下記のように記述
            //val company = pref.getString("company", "")

            //スコープ関数applyを用いるがthisを省略しない書き方
            //val company = this.getString("company", "")

            //thisを省略して簡潔に
            val company = getString("company", "")
            val postal = getString("postal", "")
            val address = getString("address", "")
            val tel = getString("tel", "")
            val fax = getString("fax", "")
            val email = getString("email", "")
            val url = getString("url", "")
            val position = getString("position", "")
            val name = getString("name", "")

            companyEdit.setText(company)
            postalEdit.setText(postal)
            addressEdit.setText(address)
            telEdit.setText(tel)
            faxEdit.setText(fax)
            emailEdit.setText(email)
            urlEdit.setText(url)
            positionEdit.setText(position)
            nameEdit.setText(name)
        }
        //保存ボタンが押された時の処理
        saveButton.setOnClickListener(){
            saveDate()
            finish()
        }

        //キャンセルボタンが押された時の処理
        cancelButton.setOnClickListener(){
            finish()
        }

    }

    //名刺に記載する情報を保存するメソッド
    private fun saveDate(){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.putString("company", companyEdit.text.toString())
            .putString("postal", postalEdit.text.toString())
            .putString("address", addressEdit.text.toString())
            .putString("tel", telEdit.text.toString())
            .putString("fax", faxEdit.text.toString())
            .putString("email", emailEdit.text.toString())
            .putString("url", urlEdit.text.toString())
            .putString("position", positionEdit.text.toString())
            .putString("name", nameEdit.text.toString())
            .apply()
    }
}
