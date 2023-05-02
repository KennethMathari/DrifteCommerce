package com.example.driftecommerce.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.driftecommerce.data.network.models.Product
import com.example.driftecommerce.databinding.ProductListItemBinding
import com.squareup.picasso.Picasso

class ProductListAdapter(private val productsList:  List<Product?>?):
        RecyclerView.Adapter<ProductListAdapter.ViewHolder>(){

    class ViewHolder(private val binding: ProductListItemBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bindItems(productItems: Product?){
            binding.productName.text = productItems?.name
            binding.productPrice.text = productItems?.price.toString()
            Picasso.get().load(productItems?.imageUrl).into(binding.productImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding: ProductListItemBinding =
            ProductListItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(productsList?.get(position))
    }

    override fun getItemCount(): Int {
        return productsList?.size ?: 0
    }

}

