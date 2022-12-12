package com.example.heroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


private lateinit var recyclerView: RecyclerView
private lateinit var heroList:ArrayList<Hero>
private lateinit var recycleAdapter: RecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        heroList= ArrayList()

        heroList.add(Hero(R.drawable.sm,"Super man",
            "Superman, birth name Kal-El and adopted name Clark Kent, is a Kryptonian and the premiere superhero on Earth, often considered the first among equals of the founding members of the Justice League. In his civilian life he is employed as a professional reporter and resides in Metropolis.",
            R.drawable.sm_bgnd))
        heroList.add(Hero(R.drawable.ww,"Wonder Woman",
            "Wonder Woman, known also as Diana of Themyscira, was the princess of the Amazons and one of the original seven founders of the Justice League. Wonder Woman was from Themyscira. She was exiled after bringing outsiders to Themyscira, but was later welcomed back and made ambassador for her home."
            ,R.drawable.ww_bgn))
        heroList.add(Hero(R.drawable.bm,"Batman",
            "Bruce Wayne is a wealthy industrialist and philanthropist who, native to Gotham City, served as the President and CEO of Wayne Enterprises. Under the alias Batman, he secretly fought crime and injustice as a masked vigilante for many years and was a founding member of the Justice League, though he only ever operated as a part-timer. Following the deterioration of his health which forced him to retire from crime-fighting however, he passed down his mantle to a teenager named Terry McGinnis whom he mentored from then on."
            ,R.drawable.bm_bgnd))
        heroList.add(Hero(R.drawable.fl,"Flash",
            "The Flash, real name Wally West, was a young, popular superhero from Central City and a founding member of the Justice League. Apart from his vast speed powers, Wally's most significant quality was his approachability, that many said made him the heart of the Justice League. In his civilian life, Wally works as a forensic scientist with the Central City Police Department."
            ,R.drawable.fl_bgnd))
        heroList.add(Hero(R.drawable.hg,"Hawkgirl",
            "Shayera Hol, formerly known on Earth as Hawkgirl, is one of the founding members of the Justice League and a former member of the Thanagarian military. She played a key role in the Thanagarian invasion on both sides. Hawkgirl is a fiery and considerably aggressive person who exhibits a wild temperament but nonetheless fights on the side of good."
            ,R.drawable.hg_bgnd))
        heroList.add(Hero(R.drawable.gl,"Green Lantern",
            "John Stewart was recruited by the Green Lantern Corps and trained for ten years, before returning shortly after Abin Sur's death. He became a founding member of the Justice League. He is also the father of future JLU member Warhawk"
            ,R.drawable.gl_bgnd))
        heroList.add(Hero(R.drawable.jj,"J'onn J'onzz",
            "J'onn J'onzz was the last Martian and one of the founding members of the Justice League. J'onn can be seen as the true founder of the Justice League, having telepathically reached out to each of the founding members, except for Batman, who nonetheless followed Superman's lead, and gathered them together."
            ,R.drawable.jj_bgnd))

        recycleAdapter= RecycleAdapter(heroList)
        recyclerView.adapter=recycleAdapter

        recycleAdapter.onItemClick={
            val intent=Intent(this,DetailedActivity::class.java)
            intent.putExtra("hero",it)
            startActivity(intent)
        }


    }
}