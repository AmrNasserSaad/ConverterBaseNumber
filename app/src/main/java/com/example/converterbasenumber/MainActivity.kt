package com.example.converterbasenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    lateinit var clearButton: Button
    lateinit var editText_decimal: EditText
    lateinit var editText_binary: EditText
    lateinit var editText_octal: EditText
    lateinit var editText_hexa: EditText

    var bin :String  = ""
    var dec :Long  = 0
    var oct :String  = ""
    var hex :String  = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initVeiw()
        addCallBack()
        clearButton.setOnClickListener{ clearInput() }
    }



    private fun addCallBack() {
        editText_binary.addTextChangedListener{text->
                  var newDec = text.toString().toLongOrNull(2)
                  if(newDec != null && newDec != dec)
                  {
                      dec = newDec !!
                      oct = dec.toString(8)
                      hex= dec.toString(16)

                      editText_decimal.setText(dec.toString())
                      editText_hexa.setText(hex)
                      editText_octal.setText(oct)
                  }
                  if(newDec == null  && text!!.isNotEmpty()){
                      val e = "please Enter only 0 or 1"
                      Toast.makeText(this, e, Toast.LENGTH_SHORT).show()
                  }

            }
        editText_octal.addTextChangedListener{text->
                val newDec = text.toString().toLongOrNull(8)
                if (newDec != null && newDec != dec)
                {
                    dec = newDec!!
                    bin = dec.toString(2)
                    hex= dec.toString(16)

                    editText_decimal.setText(dec.toString())
                    editText_hexa.setText(hex)
                    editText_binary.setText(bin)
                }
                if(newDec == null && text!!.isNotEmpty()){
                    val e = "please Enter only digit between 0 and 7"
                    Toast.makeText(this, e, Toast.LENGTH_SHORT).show()
                }

            }
        editText_decimal.addTextChangedListener{text->
                var newDec = text.toString().toLongOrNull()
                if (newDec != null && newDec != dec)
                {
                    dec = newDec!!
                    bin = dec.toString(2)
                    oct= dec.toString(8)
                    hex = dec.toString(16)

                    editText_binary.setText(bin)
                    editText_hexa.setText(hex)
                    editText_octal.setText(oct)
                }
                if(newDec == null && text!!.isNotEmpty()){
                    val e = "please Enter only digit between 0 and 9"
                    Toast.makeText(this, e, Toast.LENGTH_SHORT).show()
                }

            }
        editText_hexa.addTextChangedListener{text->
                var newDec = text.toString().toLongOrNull(16)
                if (newDec != null && newDec != dec)
                {
                    dec = newDec!!
                    oct = dec.toString(8)
                    bin= dec.toString(2)

                    editText_decimal.setText(dec.toString())
                    editText_binary.setText(bin)
                    editText_octal.setText(oct)
                }
                if(newDec == null && text!!.isNotEmpty()){
                    val e = "please Enter only digit between 0 and 9 and char A to F"
                    Toast.makeText(this, e, Toast.LENGTH_SHORT).show()
                }

            }

        }

    private fun initVeiw() {

        clearButton=findViewById(R.id.button_clear)
        editText_decimal=findViewById(R.id.editText_decimal)
        editText_binary=findViewById(R.id.editText_binary)
        editText_octal=findViewById(R.id.editText_octal)
        editText_hexa=findViewById(R.id.editText_hex)

    }


   private fun clearInput() {
        editText_hexa.text.clear()
        editText_decimal.text.clear()
        editText_binary.text.clear()
        editText_octal.text.clear()
    }

}