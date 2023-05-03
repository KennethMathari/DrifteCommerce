package com.example.driftecommerce.views.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.driftecommerce.R
import com.example.driftecommerce.data.network.models.Product
import com.example.driftecommerce.databinding.FragmentProductListBinding
import com.example.driftecommerce.viewmodel.ProductListViewModel
import com.example.driftecommerce.views.adapter.ProductListAdapter

class ProductListFragment : Fragment(R.layout.fragment_product_list),
    ProductListAdapter.OnItemClickListener {

    private lateinit var productListBinding: FragmentProductListBinding

    private lateinit var productListAdapter: ProductListAdapter
    private val productListViewModel = ProductListViewModel()

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

    override fun onItemClick(item: Product) {
        Toast.makeText(requireContext(), "Item clicked: ${item.name}", Toast.LENGTH_SHORT).show()
    }

}