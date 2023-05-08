package com.example.driftecommerce.views.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.driftecommerce.R
import com.example.driftecommerce.databinding.FragmentProductDetailBottomSheetBinding
import com.example.driftecommerce.domain.ProductDomain
import com.example.driftecommerce.utils.ProgressBar.showProgress
import com.example.driftecommerce.viewmodel.ProductDetailBottomSheetViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ProductDetailBottomSheetFragment(private val item: ProductDomain) :
    BottomSheetDialogFragment(R.layout.fragment_product_detail_bottom_sheet) {

    @Inject
    lateinit var productDetailBottomSheetViewModel: ProductDetailBottomSheetViewModel
    private lateinit var productDetailBottomSheetBinding: FragmentProductDetailBottomSheetBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productDetailBottomSheetBinding = FragmentProductDetailBottomSheetBinding.bind(view)

        productDetailBottomSheetBinding.apply {
            productName.text = item.name
            productPrice.text = item.price.toString()
            Picasso.get().load(item.imageUrl).into(imageView)
            btnCart.setOnClickListener {
                // Show progress bar on button
                btnCart.showProgress()
                // Save productDetail to cart Room database
                productDetailBottomSheetViewModel.saveProductToCart(item)
                // Show toast message
                Toast.makeText(requireContext(), "${item.name} added to cart", Toast.LENGTH_SHORT)
                    .show()
                // Dismiss bottom sheet dialog
                dismiss()
            }
        }
    }

}