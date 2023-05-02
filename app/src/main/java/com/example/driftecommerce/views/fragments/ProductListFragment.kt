package com.example.driftecommerce.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.driftecommerce.R
import com.example.driftecommerce.databinding.FragmentProductListBinding
import com.example.driftecommerce.viewmodel.ProductListViewModel

class ProductListFragment : Fragment(R.layout.fragment_product_list) {

    private var _productListBinding: FragmentProductListBinding? = null
    private val productListBinding get() = _productListBinding

    private val viewModel = ProductListViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _productListBinding = FragmentProductListBinding.inflate(inflater, container, false)
        return productListBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getProductsList()
    }


    override fun onDestroy() {
        super.onDestroy()
        _productListBinding = null
    }

}