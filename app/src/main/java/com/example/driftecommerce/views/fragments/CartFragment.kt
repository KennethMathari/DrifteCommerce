package com.example.driftecommerce.views.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.driftecommerce.R
import com.example.driftecommerce.databinding.FragmentCartBinding
import com.example.driftecommerce.viewmodel.CartViewModel
import com.example.driftecommerce.views.adapter.CartAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CartFragment : Fragment(R.layout.fragment_cart) {

    @Inject lateinit var cartViewModel: CartViewModel
    private lateinit var cartBinding: FragmentCartBinding
    private lateinit var cartAdapter: CartAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cartBinding = FragmentCartBinding.bind(view)
        //get cart items from viewmodel
        cartViewModel.getCartProducts()

        initObserver()
    }

    private fun initObserver() {
        cartViewModel.cartProducts.observe(viewLifecycleOwner) { cartProducts ->
            cartAdapter = CartAdapter()
            cartBinding?.cartRecyclerView?.apply {
                setHasFixedSize(true)
                adapter = cartAdapter
                cartAdapter.submitList(cartProducts)
            }
        }

        cartViewModel.cartTotal.observe(viewLifecycleOwner){
            cartBinding.cartTotalTV.text = it.toString()
        }
    }


}