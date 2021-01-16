package com.example.yuseitoriyahighandlow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val tag ="high and low"
    private var yourCard = 0 //プレイヤーのカード番号
    private var androidCard = 0//コンピューターのカード番号
    private var hitCount = 0 //あたりの数
    private var loseCount = 0 //はずれの数
    private var  gameStart = false //ゲームが開始されたかどうかを判定
    private var answered = false //出された問題に答えたかどうかを判定

    //onCreateメソッドは、アクティビティの生成時に呼び出される。ここでアクティビティの初期化を行う。
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Highボタンが押された時の処理
        highButton.setOnClickListener{
            if ((gameStart && !answered)){
                highAndLow('h')
            }
        }

        //Lowボタンが押された時の処理
        lowButton.setOnClickListener{
            if ((gameStart && !answered)){
                highAndLow('l')
            }
        }

        //次へボタンが押された時の処理
        nextButton.setOnClickListener{
            if (gameStart) {
                drawCard()
            }
        }
    }

    private fun highAndLow(answer: Char){
        showAndroidCard()
        answered = true
        val balance = androidCard - yourCard
        if (balance == 0){
            // when even do nothing
        } else if ((balance > 0 && answer == 'h')){
            hitCount++
            hitText.text = getString(R.string.hit_text) + hitCount
        } else if ((balance < 0 && answer == 'l')){
            hitCount++
            hitText.text = getString(R.string.hit_text) + hitCount
        } else{
            loseCount++
            loseText.text = getString(R.string.lose_text) + loseCount
        }

        if (hitCount == 5){
            resultText.text = "あなたの勝ちです"
            gameStart = false
        }else if (loseCount == 5){
            resultText.text = "あなたの負けです"
            gameStart = false
        }else{
            //do nothing
        }
    }

    private fun showAndroidCard(){
        when (androidCard){
            1 -> androidCardImage.setImageResource(R.drawable.c01)
            2 -> androidCardImage.setImageResource(R.drawable.c02)
            3 -> androidCardImage.setImageResource(R.drawable.c03)
            4 -> androidCardImage.setImageResource(R.drawable.c04)
            5 -> androidCardImage.setImageResource(R.drawable.c05)
            6 -> androidCardImage.setImageResource(R.drawable.c06)
            7 -> androidCardImage.setImageResource(R.drawable.c07)
            8 -> androidCardImage.setImageResource(R.drawable.c08)
            9 -> androidCardImage.setImageResource(R.drawable.c09)
            10 -> androidCardImage.setImageResource(R.drawable.c10)
            11 -> androidCardImage.setImageResource(R.drawable.c11)
            12 -> androidCardImage.setImageResource(R.drawable.c12)
            13 -> androidCardImage.setImageResource(R.drawable.c13)
        }
    }

    override fun onResume() {
        super.onResume()
        hitCount = 0
        loseCount = 0
        hitText.text = getString(R.string.hit_text)
        loseText.text = getString(R.string.lose_text)
        gameStart = true
        drawCard() //drawCard()メソッドを呼び出す
    }

    private fun drawCard(){
        yourCardImage.setImageResource(R.drawable.z02)
        androidCardImage.setImageResource(R.drawable.z01)

        yourCard = (1..13).random()         //IntRange.random()で乱数を生成
        Log.d(tag,"You:" + yourCard) //ログを表示させる（プログラムが思った通りに動いているかを確認するため。＊Logcatにて確認可）
        when (yourCard) {
            1 -> yourCardImage.setImageResource(R.drawable.d01)
            2 -> yourCardImage.setImageResource(R.drawable.d02)
            3 -> yourCardImage.setImageResource(R.drawable.d03)
            4 -> yourCardImage.setImageResource(R.drawable.d04)
            5 -> yourCardImage.setImageResource(R.drawable.d05)
            6 -> yourCardImage.setImageResource(R.drawable.d06)
            7 -> yourCardImage.setImageResource(R.drawable.d07)
            8 -> yourCardImage.setImageResource(R.drawable.d08)
            9 -> yourCardImage.setImageResource(R.drawable.d09)
            10 -> yourCardImage.setImageResource(R.drawable.d10)
            11 -> yourCardImage.setImageResource(R.drawable.d11)
            12 -> yourCardImage.setImageResource(R.drawable.d12)
            13 -> yourCardImage.setImageResource(R.drawable.d13)
        }
        androidCard = (1..13).random()
        Log.d(tag,"android:" + androidCard)
        answered = false
    }
}
