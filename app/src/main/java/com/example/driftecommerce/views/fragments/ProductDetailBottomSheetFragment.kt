package com.example.driftecommerce.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.driftecommerce.DriftApplication
import com.example.driftecommerce.R
import com.example.driftecommerce.data.local.database.DriftDatabase
import com.example.driftecommerce.data.network.models.Product
import com.example.driftecommerce.databinding.FragmentProductDetailBottomSheetBinding
import com.example.driftecommerce.domain.ProductDomain
import com.example.driftecommerce.viewmodel.ProductDetailBottomSheetViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso
import toEntity


class ProductDetailBottomSheetFragment(private val item: ProductDomain) :
    BottomSheetDialogFragment(R.layout.fragment_product_detail_bottom_sheet) {

    private lateinit var productDetailBottomSheetBinding: FragmentProductDetailBottomSheetBinding
    private lateinit var productDetailBottomSheetViewModel : ProductDetailBottomSheetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productDetailBottomSheetViewModel = ViewModelProvider(this)[ProductDetailBottomSheetViewModel::class.java]


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productDetailBottomSheetBinding = FragmentProductDetailBottomSheetBinding.bind(view)

        productDetailBottomSheetBinding.apply {
            productName.text = item.name
            productPrice.text = item.price.toString()
            Picasso.get().load(item?.imageUrl).into(imageView)
            btnCart.setOnClickListener {
                // Save productDetail to cart Room database
                productDetailBottomSheetViewModel.saveProductToCart(item)

            }
        }
    }
}