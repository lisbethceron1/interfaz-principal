package com.example.interfazprincipal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity(), ViewPagerAdapter.OnItemSelected {
    private lateinit var boardList: List<Board>
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.viewPager)

        boardList = listOf(
            Board(
                fondo = R.color.AZUL,
                imagen = R.drawable.uno,
                titulo = "lorem ipsum",
                descripcion = "holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

            ),
            Board(
                fondo = R.color.black,
                imagen = R.drawable.dos,
                titulo = "lorem ipsum",
                descripcion = "holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

            ),
            Board(
                fondo = R.color.black,
                imagen = R.drawable.tres,
                titulo = "lorem ipsum",
                descripcion = "holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

            ),
            Board(
                fondo = R.color.black,
                imagen = R.drawable.cuatro,
                titulo = "lorem ipsum",
                descripcion = "holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

            )

        )
        val adapter = ViewPagerAdapter(boardList, this)

        viewPager.adapter = adapter
    }

    override fun onClickListener(position: Int) {
        if (position == (boardList.size - 1)) {
            Toast.makeText(this, "board finish", Toast.LENGTH_SHORT).show()
        } else {
            viewPager.setCurrentItem((position + 1), true)
        }
    }
}