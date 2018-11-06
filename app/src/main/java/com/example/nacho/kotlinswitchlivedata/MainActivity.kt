package com.example.nacho.kotlinswitchlivedata

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Create a LiveData with a String
    val trabajo: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val apruebas: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val numero: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val nameObserver = Observer<String> { newName ->
        txt.text = newName + " tienes trabajo"

    }
    val nameObserver1 = Observer<String> { newName ->
        txt1.text = newName + " apruebas"

    }
    val nameObserver2 = Observer<String> { newName ->
        txt2.text = newName

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        trabajo.observe(this, nameObserver )
        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                trabajo.postValue("Si")
            }
            else{
                trabajo.postValue("No")
            }
        }

        apruebas.observe(this, nameObserver1)
        switch2.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                apruebas.postValue("Si")
            }
            else{
                apruebas.postValue("No")
            }
        }
  numero.observe(this, nameObserver2)
        editText.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                txt2.setText(s)
            }
        })
    }

}
