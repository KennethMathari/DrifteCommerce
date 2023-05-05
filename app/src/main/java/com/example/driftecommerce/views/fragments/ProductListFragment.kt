package com.example.driftecommerce.views.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.driftecommerce.R
import com.example.driftecommerce.data.network.models.Product
import com.example.driftecommerce.databinding.FragmentProductListBinding
import com.example.driftecommerce.domain.ProductDomain
import com.example.driftecommerce.viewmodel.ProductListViewModel
import com.example.driftecommerce.views.adapter.ProductListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProductListFragment : Fragment(R.layout.fragment_product_list),
    ProductListAdapter.OnItemClickListener {
    @Inject lateinit var productListViewModel: ProductListViewModel

    private lateinit var productListBinding: FragmentProductListBinding

    private lateinit var productListAdapter: ProductListAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productListBinding = FragmentProductListBinding.bind(view)
        //Get Product List from ViewModel
        productListViewModel.getProductsList()
        initObserver()
    }

    private fun initObserver() {
        productListViewModel.productsList.observe(viewLifecycleOwner) { productList ->
            productListAdapter = ProductListAdapter(this)
            productListBinding?.productsRecyclerView?.apply {
                setHasFixedSize(true)
                adapter = productListAdapter
                productListAdapter.submitList(productList)
            }

        }
    }

    override fun onItemClick(item: ProductDomain) {
        //Display bottom sheet dialog
        ProductDetailBottomSheetFragment(item)
            .show(requireActivity().supportFragmentManager, "ProductDetailBottomSheetFragment")
    }

}