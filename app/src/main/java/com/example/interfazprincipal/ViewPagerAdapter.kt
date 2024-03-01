package com.example.interfazprincipal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class ViewPagerAdapter(): RecyclerView.Adapter<ViewPagerAdapter.BoardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.board_item, parent, false)
        return BoardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return boardList.size
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(boardList[position])
    }

    inner class  BoardViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        private val contenedor = itemView.Container
        private val imagen = itemView.imageView
        private val titulo = itemView.textView_titulo
        private val descripcion = itemView.textView_descripcion
        private val boton = itemView.button_siguiente


        fun bind(board: Board)= with(itemView){
         contenedor.background = ContextCompat.getDrawable(context, board.fondo)
         imagen.setImageResource(board.imagen)
         titulo.text = board.titulo
         descripcion.text = board.descripcion

            if (adapterPosition.equals(boardList.size - 1)){
                boton.text = "Finalizar"
            }
        }

    }

}