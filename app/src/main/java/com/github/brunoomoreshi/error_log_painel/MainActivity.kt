package com.github.brunoomoreshi.error_log_painel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var clicks :Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setLogListeners()
        val currentThread = Thread.currentThread()
        currentThread.setUncaughtExceptionHandler { _, throwable ->
            val x = throwable.message
            val cause = throwable.cause
        }
    }

    private fun setLogListeners() {
        var debugBTN = findViewById<Button>(R.id.btDebug)
        debugBTN?.setOnClickListener{Log.i("click", "Clicado em Debug")}
        var errorBTN = findViewById<Button>(R.id.btError)
        var message:String = ""
        var inputTXT = findViewById<TextView>(R.id.et_LogText)
        try {
            val list = listOf<Int>(2,1,4)
            //Aqui é deixado um valor acima do index da lista para dar erro de propósito.
            val a = list[6]
            message = "Sobrevivi ao try"
        }catch (e: IndexOutOfBoundsException){
            val x = 0
        }
        finally {
            inputTXT?.setText(message)
            inputTXT.setHint(message)
        }
        var infoBTN = findViewById<Button>(R.id.btInfo)
        var warningBTN = findViewById<Button>(R.id.btWarning)
        var verboseBTN = findViewById<Button>(R.id.btVerbose)
        infoBTN?.setOnClickListener{Log.i("click", "Clicado em Info")}
        warningBTN?.setOnClickListener{Log.i("click", "Clicado em Warning")}
        verboseBTN?.setOnClickListener{Log.i("click", "Clicado em Verbose")}


    }
}