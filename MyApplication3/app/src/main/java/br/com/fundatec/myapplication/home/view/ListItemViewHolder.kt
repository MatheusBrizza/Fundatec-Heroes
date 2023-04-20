package br.com.fundatec.myapplication.home.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.myapplication.databinding.ListItemBinding
import br.com.fundatec.myapplication.character.data.response.CharacterResponse
import com.bumptech.glide.Glide

class ListItemViewHolder(
    private val binding: ListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(character: CharacterResponse) {
        Glide.with(itemView.context)
            .load(character.image)
            .into(binding.ivUrl)
        binding.tvName.text = character.name
    }
}