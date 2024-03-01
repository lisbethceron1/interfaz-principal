package com.example.interfazprincipal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView

class ViewPagerAdapter(
    private val boardList: List<Board>,
    private val onItemSelected: OnItemSelected
) : RecyclerView.Adapter<ViewPagerAdapter.BoardViewHolder>() {

    private val indicators = mutableListOf<View>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.board_item, parent, false)
        val viewHolder = BoardViewHolder(view, onItemSelected)
        val indicator1 = view.findViewById<View>(R.id.indicator1)
        val indicator2 = view.findViewById<View>(R.id.indicator2)
        val indicator3 = view.findViewById<View>(R.id.indicator3)
        val indicator4 = view.findViewById<View>(R.id.indicator4)
        indicators.addAll(listOf(indicator1, indicator2, indicator3, indicator4))
        return viewHolder
    }


    override fun getItemCount(): Int {
        return boardList.size
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(boardList[position])
        updateIndicators(position)
    }

    inner class BoardViewHolder(
        itemView: View,
        private val onItemSelected: OnItemSelected
    ) : RecyclerView.ViewHolder(itemView) {

        private val contenedor = itemView.findViewById<View>(R.id.container)
        private val imagen = itemView.findViewById<View>(R.id.imageView)
        private val titulo = itemView.findViewById<TextView>(R.id.textView_titulo)
        private val descripcion = itemView.findViewById<TextView>(R.id.textView_descripcion)
        private val boton = itemView.findViewById<TextView>(R.id.button_siguiente)

        fun bind(board: Board) {
            contenedor.background = ContextCompat.getDrawable(itemView.context, board.fondo)
            imagen.setBackgroundResource(board.imagen) // Use setBackgroundResource instead of setImageResource if 'imagen' is an image background resource
            titulo.text = board.titulo
            descripcion.text = board.descripcion

            if (adapterPosition == boardList.size - 1) { // Use '==' instead of '.equals'
                boton.text = "Finalizar"
            }
            boton.setOnClickListener {
                onItemSelected?.onClickListener(adapterPosition)
            }

        }
    }

    interface OnItemSelected {
        fun onClickListener(position: Int)
    }

    fun updateIndicators(currentPosition: Int) {
        indicators.forEachIndexed { index, view ->
            view.background = ContextCompat.getDrawable(view.context, if (index == currentPosition) R.drawable.circle_active else R.drawable.circle_inactive)
        }
    }
}