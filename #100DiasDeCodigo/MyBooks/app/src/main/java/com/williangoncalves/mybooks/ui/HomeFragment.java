package com.williangoncalves.mybooks.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.williangoncalves.mybooks.R;
import com.williangoncalves.mybooks.databinding.FragmentHomeBinding;
import com.williangoncalves.mybooks.entity.BookEntity;
import com.williangoncalves.mybooks.helper.BookConstants;
import com.williangoncalves.mybooks.ui.adapter.BooksAdapter;
import com.williangoncalves.mybooks.ui.listener.BookListener;
import com.williangoncalves.mybooks.viewmodel.HomeViewModel;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;
    private final BooksAdapter adapter = new BooksAdapter();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle b) {

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        viewModel.getBooks();

        // Layout:
        binding.recyclerviewBooks.setLayoutManager(new LinearLayoutManager(getContext()));
        // Adapter:
        binding.recyclerviewBooks.setAdapter(adapter);

        setObservers();
        attachListener();

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setObservers() {
        viewModel.books.observe(getViewLifecycleOwner(), new Observer<List<BookEntity>>() {
            @Override
            public void onChanged(List<BookEntity> bookEntities) {
                // lista - bookEntities
                adapter.updateBooks(bookEntities);
            }
        });
    }

    private void attachListener() {
        BookListener listener = new BookListener() {
            @Override
            public void onClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(BookConstants.BOOK_ID, id);

                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.navigation_details, bundle);
            }

            @Override
            public void onFavoriteClick(int id) {
                viewModel.toggleFavoriteStatus(id);
            }
        };

        adapter.attachListener(listener);
    }
}