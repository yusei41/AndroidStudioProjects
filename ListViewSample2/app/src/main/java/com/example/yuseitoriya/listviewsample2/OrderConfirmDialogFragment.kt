package com.example.yuseitoriya.listviewsample2

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

//ダイアログを作成するクラス

class OrderConfirmDialogFragment : DialogFragment(){
    override fun onCreateDialog (savedInstanceState: Bundle?) : Dialog {
        //ダイアログビルダを生成
        val builder = AlertDialog.Builder(activity)
        //ダイアログのタイトルを設定
        builder.setTitle(R.string.dialog_title)
        //ダイアログのメッセージを設定
        builder.setMessage(R.string.dialog_msg)
        //Positive Button を設定
        builder.setPositiveButton(R.string.dialog_btn_ok, DialogButtonClickListener())
        //Negative Button を設定
        builder.setNegativeButton(R.string.dialog_btn_ng, DialogButtonClickListener())
        //Neutral Button を設定
        builder.setNeutralButton(R.string.dialog_btn_nu, DialogButtonClickListener())
        //ダイアログオブジェクトを生成し、リターン
        val dialog = builder.create()
        return dialog
    }

    //ダイアログのアクションボタンがタップされた時の処理が記述されたメンバクラス
    private inner class DialogButtonClickListener : DialogInterface.OnClickListener{
        override fun onClick(dialog: DialogInterface?, which: Int) {
            //トーストメッセージ用の文字列変数を用意
            var msg = ""
            //タップされたアクションボタンで処理を分ける
            when(which){
                //Positive Button が押されたら、注文用のメッセージを格納
                DialogInterface.BUTTON_POSITIVE -> msg = getString(R.string.dialog_ok_toast)
                //Negative Button が押されたら、キャンセル用のメッセージを格納
                DialogInterface.BUTTON_NEGATIVE -> msg = getString(R.string.dialog_ng_toast)
                //Neutral Button が押されたら、問い合わせ用のメッセージを格納
                DialogInterface.BUTTON_NEUTRAL -> msg = getString(R.string.dialog_nu_toast)
            }
            //トーストの表示
            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
        }
    }
}