package br.com.fundatec.myapplication.home.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.myapplication.databinding.ListItemBinding
import br.com.fundatec.myapplication.character.data.response.CharacterResponse

class ListItemViewHolder(
    private val binding: ListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(character: CharacterResponse) {
        //binding.tvUrl.text = character.image
        binding.tvName.text = character.name
    }
}