package com.example.driftecommerce.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.driftecommerce.databinding.CartListItemBinding
import com.example.driftecommerce.domain.ProductDomain
import com.squareup.picasso.Picasso

class CartAdapter :
    ListAdapter<ProductDomain, CartAdapter.CartViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding: CartListItemBinding =
            CartListItemBinding.inflate(layoutInflater, parent, false)
        return CartViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bindItems(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<ProductDomain>() {
        override fun areItemsTheSame(oldItem: ProductDomain, newItem: ProductDomain): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductDomain, newItem: ProductDomain): Boolean {
            return oldItem == newItem
        }

    }

    inner class CartViewHolder(private val cartListItemBinding: CartListItemBinding) :
        RecyclerView.ViewHolder(cartListItemBinding.root) {

        fun bindItems(cartItems: ProductDomain?) {
            cartListItemBinding.apply {
                productName.text = cartItems?.name
                productPrice.text = cartItems?.price.toString()
                Picasso.get().load(cartItems?.imageUrl).into(productImage)
            }
        }
    }


}






