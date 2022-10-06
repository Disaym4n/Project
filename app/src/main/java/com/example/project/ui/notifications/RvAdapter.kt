package com.example.project.ui.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.RvItemsBinding

class RvAdapter : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {

    private val items = mutableListOf<RvItems>()

    inner class RvViewHolder(private val binding: RvItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItems(item: RvItems) {
            binding.image.setImageResource(item.image)
            binding.name.text = item.name
            binding.description.text = item.description
            binding.timeDuration.text = item.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(
            RvItemsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    fun setUpItems(rvItems: List<RvItems>){
        items.clear()
        items.addAll(rvItems)
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        val item = items[position]
        holder.bindItems(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}