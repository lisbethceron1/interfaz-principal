package com.example.interfazprincipal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    private lateinit var boardList: List<Board>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boardList = listOf(
            Board(
                fondo = R.color.black,
                imagen = R.drawable.uno,
                titulo = "lorem ipsummm",
                descripcion = "holaaaaaaaaaaaaaaaaaaaaaaaaaaa"

            ),
            Board(
                fondo = R.color.black,
                imagen = R.drawable.dos,
                titulo = "lorem ipsummm",
                descripcion = "holaaaaaaaaaaaaaaaaaaaaaaaaaaa"

            ),
            Board(
                fondo = R.color.black,
                imagen = R.drawable.tres,
                titulo = "lorem ipsummm",
                descripcion = "holaaaaaaaaaaaaaaaaaaaaaaaaaaa"

            ),
            Board(
                fondo = R.color.black,
                imagen = R.drawable.cuatro,
                titulo = "lorem ipsummm",
                descripcion = "holaaaaaaaaaaaaaaaaaaaaaaaaaaa"

            )

        )
        val adapter = ViewPagerAdapter(boardList)
        viewPager.adapter = adapter
    }
}