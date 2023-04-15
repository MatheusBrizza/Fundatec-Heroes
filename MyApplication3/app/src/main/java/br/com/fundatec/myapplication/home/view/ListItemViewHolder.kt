package br.com.fundatec.myapplication.home.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.myapplication.databinding.ListItemBinding
import br.com.fundatec.myapplication.character.data.Character

class ListItemViewHolder (
    private val binding: ListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(character : Character) {
        binding.tvUrl.text = character.url
        binding.tvName.text = character.name
    }
}