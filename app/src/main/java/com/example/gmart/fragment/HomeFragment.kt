package com.example.gmart.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.models.SlideModel
import com.example.gmart.MainActivity
import com.example.gmart.adapter.RecyclerProdCategory
import com.example.gmart.adapter.RecyclerSpecialForYou
import com.example.gmart.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    val imageSlideList=ArrayList<SlideModel>()
    lateinit var viewModel: HomeFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
     val binding=FragmentHomeBinding.inflate(inflater,container,false)
viewModel=ViewModelProvider(this)[HomeFragmentViewModel::class.java]
        viewModel.getBanners().observe(viewLifecycleOwner){
            binding.imageSlider.setImageList(it)
        }
        viewModel.getCategories().observe(viewLifecycleOwner){
            binding.RecViewCat.layoutManager=LinearLayoutManager(this.requireContext(),LinearLayoutManager.HORIZONTAL,false)
            binding.RecViewCat.adapter=RecyclerProdCategory(this.requireContext(),it)
        }

        viewModel.getProducts().observe(viewLifecycleOwner){prodList->
            binding.recViewSpecialForYou.layoutManager=GridLayoutManager(this.requireContext(),2)
            binding.recViewSpecialForYou.adapter=RecyclerSpecialForYou(this.requireContext(),prodList)
        }

        return binding.root
    }
}