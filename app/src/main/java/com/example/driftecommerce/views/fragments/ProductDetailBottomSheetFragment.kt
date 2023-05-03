package com.example.driftecommerce.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.driftecommerce.R
import com.example.driftecommerce.data.network.models.Product
import com.example.driftecommerce.databinding.FragmentProductDetailBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso


class ProductDetailBottomSheetFragment(private val item: Product) :
    BottomSheetDialogFragment(R.layout.fragment_product_detail_bottom_sheet) {

    private lateinit var productDetailBottomSheetBinding: FragmentProductDetailBottomSheetBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productDetailBottomSheetBinding = FragmentProductDetailBottomSheetBinding.bind(view)

        productDetailBottomSheetBinding.apply {
            productName.text = item.name
            productPrice.text = item.price.toString()
            Picasso.get().load(item?.imageUrl).into(imageView)
        }
    }
}