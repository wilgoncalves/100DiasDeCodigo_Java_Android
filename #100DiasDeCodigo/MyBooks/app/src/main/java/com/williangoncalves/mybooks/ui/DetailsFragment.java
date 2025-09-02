package com.williangoncalves.mybooks.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.williangoncalves.mybooks.viewmodel.DetailsViewModel;
import com.williangoncalves.mybooks.databinding.FragmentDetailsBinding;

public class DetailsFragment extends Fragment {

    private DetailsViewModel viewModel;
    private FragmentDetailsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle b) {
        viewModel = new ViewModelProvider(this).get(DetailsViewModel.class);
        binding = FragmentDetailsBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}