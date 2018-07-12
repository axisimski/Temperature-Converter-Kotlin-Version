package com.example.axisimski.tempconvkt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var input_edt: EditText;
    private lateinit var output_tv: TextView;
    private lateinit var convert_btn: Button;
    private lateinit var radioGroup: RadioGroup
    private lateinit var radio_btn_FtoC: RadioButton
    private lateinit var radio_btn_CtoF: RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize variables
        input_edt=findViewById(R.id.input_edt)
        output_tv=findViewById(R.id.output_tv)
        convert_btn=findViewById(R.id.convert_btn)
        radioGroup=findViewById(R.id.radioGroup)
        radio_btn_CtoF=findViewById(R.id.c2f_rb)
        radio_btn_FtoC=findViewById(R.id.f2c_rb)

        /*Set onClickListener for the convert button.
        Call convert() onClick()*/
        convert_btn.setOnClickListener {convert()}
    }
    //==============================================================================================end onCreate()

    /*Convert contents of the input EditText() from C->F or F->C depending on which radioButton is
    checked.

    Check for invalid temperatures such as Below -273 for C and 467 for F is below absolute zero so the user
    is warned and no conversion occurs.*/
    private fun convert(){

        /*If the user has left the input blank: prompt for input*/
        if(input_edt.text.toString().equals("")) {
            Toast.makeText(applicationContext, "Please Enter Temperature", Toast.LENGTH_SHORT).show()
        }
        else {
            val input: Double = input_edt.text.toString().toDouble()
            val con = ConverterClass()

            /*Check input length: large numbers can cause app to crash*/
            if (input_edt.text.length > 14) {
                Toast.makeText(applicationContext, "\"" +
                        "Please enter a temperature less than 13 digits\"", Toast.LENGTH_SHORT).show()
            }
            //------------------------------------------------------------------------------------------end error checking

            /*Check which radio button is checked and execute subsequent conversion
         after checking for temperatures below absolute zero.*/
            else {

                if (!c2f_rb.isChecked() && !f2c_rb.isChecked()) {
                    Toast.makeText(applicationContext,"Please select F° → C° or C° → F°", Toast.LENGTH_SHORT).show()
                 } else if (radio_btn_CtoF.isChecked) {

                    if (input_edt.text.toString().toDouble() < -273.15) {
                        Toast.makeText(applicationContext,"The temperature you've entered is below absolute zero",
                                Toast.LENGTH_SHORT).show()
                    } else {

                        val out_deg: String = con.c_to_f_fun(input).toString() + " F°"
                        output_tv.setText(out_deg)
                    }

                } else if (radio_btn_FtoC.isChecked) {

                    if (input_edt.text.toString().toDouble() < -459.67) {
                        Toast.makeText(applicationContext,"The temperature you've entered is below absolute zero",
                                Toast.LENGTH_SHORT).show()
                    } else {

                        val out_deg: String = con.f_to_c_fun(input).toString() + " C°"
                        output_tv.setText(out_deg)
                    }
                }
            }
        }//-----------------------------------------------------------------------------------------end of no error()


    }
    //==============================================================================================end convert()


}//end class{}
