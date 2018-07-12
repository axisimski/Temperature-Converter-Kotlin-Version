package com.example.axisimski.tempconvkt


/*Converter class contains two functions which perform C->F and F->C conversions
Functions take in and return doubles.*/
class ConverterClass{


    public fun c_to_f_fun(degC:Double):Double {

        val degF_double: Double=degC*(1.8)+32
        val temp: String="%.4f".format(degF_double)
        val degF:Double=temp.toDouble()
        return degF
    }

    public fun f_to_c_fun(degF:Double):Double {

        val degC_double: Double=(degF-32)/(1.8)

        val temp: String = "%.4f".format(degC_double)
        val degC:Double=temp.toDouble()
        return degC
    }

}