package br.com.fundatec.myapplication.home.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.myapplication.databinding.ListItemBinding

class ListItemViewHolder (
    private val binding: ListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(name: String) {
        binding.tvName.text = name
    }
}