package com.appynitty.cavistacodecallengeapp.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.appynitty.cavistacodecallengeapp.R;
import com.appynitty.cavistacodecallengeapp.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

     //   View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        setUpViewModel();
        return binding.getRoot();
    }

    private void setUpViewModel() {
         HomeViewModel model = new HomeViewModel(this);
             binding.setViewModel(model);

    }
}