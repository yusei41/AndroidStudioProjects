package com.example.yuseitoriya.acceleget

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

/*
    ＜加速度センサーの値を取得する方法＞
    MainActivityで加速度センサーの値を取得します。
    MainActivityクラスは、AppCompatActivityクラスを継承(extends)するだけでなく、
    SensorEventListenerインターフェースを実装(implements)します。
    SensorEventListenerインターフェースを実装したクラスは、抽象メソッドのonAccuracyChanged()とonSensorChanged()を実装する必要がある。
 */
class MainActivity : AppCompatActivity(), SensorEventListener {

    /*
       onAccuracyChanged()メソッドはセンサーの精度が変更されると呼び出されます。
       引数のaccuracyがセンサーの精度です。
    */
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    /*
        onSensorChanged()メソッドはセンサーの値が変更されるたびに呼び出されるが、
        そのためにはregisterListener()メソッドでセンサーからの更新情報を受信できるようにSensorEventListenerを登録します
     */
    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null) return
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER){
            txt01.text = "X軸 :${event.values[0]}¥nY軸 :${event.values[1]}¥nZ軸 :${event.values[2]}"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume(){
        super.onResume()
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    override fun onPause(){
        super.onPause()
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.unregisterListener(this)
    }
}
