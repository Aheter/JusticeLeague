package com.example.heroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)


        val hero=intent.getParcelableExtra<Hero>("hero")
        if(hero!=null){
           val titleShow : TextView =findViewById(R.id.detailedActivityTv1)
           val descriptionShow : TextView =findViewById(R.id.detailedActivityTv2)
           val imageShow : ImageView =findViewById(R.id.detailedActivityIv)
           val bgndShow=findViewById<LinearLayout>(R.id.mainLayout)

            titleShow.text= hero.title
            descriptionShow.text=hero.description
            imageShow.setImageResource(hero.image)
            bgndShow.setBackgroundResource(hero.bgnd)
        }
        val exitBtn = findViewById<Button>(R.id.exitBtn)
        exitBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)}





    }
}