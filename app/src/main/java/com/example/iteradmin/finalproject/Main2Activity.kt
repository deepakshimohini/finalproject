package com.example.iteradmin.finalproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.textclassifier.TextLinks
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val e= findViewById<EditText>(R.id.city)
        val b=findViewById<Button>(R.id.weather)

        val p= findViewById<TextView>(R.id.reports)

        b.setOnClickListener {
            val str=e.text.toString()
            val url ="https://api.openweathermap.org/data/2.5/weather?q=gujrat,India&appid=31bd1ee53b7e4a352d903efaf9b7aaaf"
       val queue=Volley.newRequestQueue(this)
            val jsonObjectRequest:JsonObjectRequest =
                    JsonObjectRequest(Request.Method.GET, url,null,
                           Response.Listener {
                               response ->
                               val coord:JSONObject= response.getJSONObject("coord")
val weather:JSONArray=response.getJSONArray("weather")
                               val name:String=response.getString("name")
                               val report:String="latitude:"+coord.get("lat")+"longitude:"+coord.getString("lon")+
                               "\n description:"+weather.getJSONObject(0).getString("description")+"\n name:"+name

                        p.text=report

                           },
                            Response.ErrorListener {

                            }
            )

        }
    }
}
