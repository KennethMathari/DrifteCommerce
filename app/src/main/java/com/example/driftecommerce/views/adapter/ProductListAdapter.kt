package com.example.driftecommerce.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.driftecommerce.data.network.models.Product
import com.example.driftecommerce.databinding.ProductListItemBinding
import com.squareup.picasso.Picasso

class ProductListAdapter(private val listener: OnItemClickListener) :
    ListAdapter<Product, ProductListAdapter.ProductListViewHolder>(DiffCallback()) {

    inner class ProductListViewHolder(private val binding: ProductListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItems(productItems: Product?, listener: OnItemClickListener) {
            binding.apply {
                productName.text = productItems?.name
                productPrice.text = productItems?.price.toString()
                Picasso.get().load(productItems?.imageUrl).into(productImage)
                root.setOnClickListener {
                    if (productItems != null) {
                        listener.onItemClick(productItems)
                    }
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: Product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding: ProductListItemBinding =
            ProductListItemBinding.inflate(layoutInflater, parent, false)
        return ProductListViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.bindItems(getItem(position), listener)
    }

    class DiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }

}

