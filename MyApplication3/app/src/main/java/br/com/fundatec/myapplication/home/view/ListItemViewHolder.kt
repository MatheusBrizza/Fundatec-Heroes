package br.com.fundatec.myapplication.home.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.myapplication.databinding.ListItemBinding

class ListItemViewHolder (
    private val binding: ListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(name: String) {
        binding.tvName.text = name
        //TODO: criar objeto de character com view que vai ser a representação do que vai retornar da APi que vou salvar na tela de criar personagem
    }
}