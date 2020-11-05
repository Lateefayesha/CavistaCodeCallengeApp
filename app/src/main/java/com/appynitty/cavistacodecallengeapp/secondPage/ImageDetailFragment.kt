package com.appynitty.cavistacodecallengeapp.secondPage

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.appynitty.cavistacodecallengeapp.R
import com.appynitty.cavistacodecallengeapp.databinding.FragmentImageDetailBinding
import com.appynitty.cavistacodecallengeapp.home.model.HomeModel
import com.appynitty.cavistacodecallengeapp.secondPage.viewModel.SecondViewModel
import com.google.gson.Gson


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ImageDetailFragment : Fragment(), View.OnClickListener {
    private  lateinit var homeDataViewModel: SecondViewModel
      private  var homeModel: HomeModel?=null

    private lateinit var binding: FragmentImageDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

//        return inflater.inflate(R.layout.fragment_second, container, false)


        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_image_detail, container, false)
        binding.btnSubmit.setOnClickListener(this)
        Log.d("onCreateView", "onCreateView: "+Gson().toJson(homeModel))
        Log.d("ImageDetailFragment", "onCreateView Called: ")


        return binding.getRoot()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeModel = arguments?.getParcelable<HomeModel>(getString(R.string.argument_home_model))!!
        homeModel?.let { setUpViewModel(it) }
        (activity as AppCompatActivity).supportActionBar?.title = homeModel?.getTitle()
        Log.d("onViewCreated", "onViewCreated: "+Gson().toJson(homeModel))
        Log.d("ImageDetailFragment", "onViewCreated Called: ")

    }


    fun setUpViewModel(homeModel: HomeModel) {
//        homeDataViewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
     homeDataViewModel=   ViewModelProvider.AndroidViewModelFactory.getInstance(
            activity?.applicationContext as Application
        ).create(SecondViewModel::class.java)
        Log.d("setUpViewModel", "setUpViewModel: "+Gson().toJson(homeModel))
        homeDataViewModel.setModel(homeModel)

    }

    override fun onClick(p0: View?) {
        homeDataViewModel.onSubmitClicked()

    }


}