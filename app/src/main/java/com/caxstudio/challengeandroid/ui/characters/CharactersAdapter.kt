package com.caxstudio.challengeandroid.ui.characters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.caxstudio.challengeandroid.data.model.character.Result
import com.caxstudio.challengeandroid.databinding.ItemLayoutResultBinding
import com.caxstudio.challengeandroid.di.GlideApp

class CharactersAdapter(
    val onItemClicked: (Int, Result) -> Unit
) : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {

    private var resultList: MutableList<Result> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val itemView =
            ItemLayoutResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharactersViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val resultItem = resultList[position]
        holder.bind(resultItem)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateResults(episodeList: MutableList<Result>) {
        this.resultList = episodeList
        notifyDataSetChanged()
    }

    inner class CharactersViewHolder(private val binding: ItemLayoutResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Result) {
            //Populate item
            binding.name.text = item.name

            // Glide generated API from AppGlideModule.
            GlideApp.with(binding.root)
                // Here you specify which image should be loaded by providing Uri.
                .load(item.image)
                .apply(RequestOptions.circleCropTransform()).into(binding.characterProfileImage)

            //Click on item
            binding.itemLayoutResult.setOnClickListener {
                onItemClicked.invoke(
                    adapterPosition,
                    item
                )
            }
        }
    }
}

