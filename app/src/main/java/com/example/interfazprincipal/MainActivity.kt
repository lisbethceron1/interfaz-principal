package com.example.interfazprincipal

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity(), ViewPagerAdapter.OnItemSelected {
    private lateinit var boardList: List<Board>
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val controller = window.insetsController
            controller?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        boardList = listOf(
            Board(
                fondo = R.color.AZUL,
                imagen = R.drawable.logopngblanco__2_,
                titulo = "",
                descripcion = "Descubre una nueva forma de aprender con  clases personalizadas y flexibilidad total, te ofrecemos la oportunidad de crecer académicamente a tu ritmo y conveniencia. En Educatio, nos esforzamos por proporcionarte una experiencia educativa sin igual."
            ),
            Board(
                fondo = R.color.AZUL,
                imagen = R.drawable.dos,
                titulo = "Clases Personalizadas",
                descripcion = "Nuestras clases personalizadas permiten a los estudiantes aprender a su propio ritmo, recibir retroalimentación específica y utilizar recursos adaptados a sus necesidades, lo que aumenta su confianza y maximiza su potencial académico."
            ),
            Board(
                fondo = R.color.AZUL,
                imagen = R.drawable.tres,
                titulo = "Modalidad Virtual o Presencial",
                descripcion = "Ofrecemos opciones flexibles de clases virtuales y presenciales para adaptarnos al estilo de vida de cada estudiante. Las clases virtuales brindan conveniencia, mientras que las presenciales ofrecen una experiencia más interactiva."
            ),
            Board(
                fondo = R.color.AZUL,
                imagen = R.drawable.cuatro,
                titulo = "Contraoferta",
                descripcion = "En nuestra plataforma, los estudiantes tienen la libertad de publicar sus requisitos de clase y recibir múltiples ofertas de instructores. Esta modalidad única permite a los estudiantes comparar precios, ubicaciones y condiciones de enseñanza antes de comprometerse."
            )
        )

        adapter = ViewPagerAdapter(boardList, this)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                adapter.updateIndicators(position)
            }
        })

    }

    override fun onClickListener(position: Int) {
        if (position == (boardList.size - 1)) {
            Toast.makeText(this, "Board finish", Toast.LENGTH_SHORT).show()
        } else {
            viewPager.setCurrentItem((position + 1), true)
        }
    }

    override fun onResume() {
        super.onResume()
        // Asegurarse de actualizar los indicadores cuando la actividad se reanuda
        adapter.updateIndicators(viewPager.currentItem)
    }
}