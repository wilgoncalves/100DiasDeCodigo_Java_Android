package com.williangoncalves.mybooks.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.williangoncalves.mybooks.R;
import com.williangoncalves.mybooks.databinding.FragmentFavoriteBinding;
import com.williangoncalves.mybooks.entity.BookEntity;
import com.williangoncalves.mybooks.helper.BookConstants;
import com.williangoncalves.mybooks.ui.adapter.BooksAdapter;
import com.williangoncalves.mybooks.ui.listener.BookListener;
import com.williangoncalves.mybooks.viewmodel.FavoriteViewModel;

import java.util.List;

public class FavoriteFragment extends Fragment {

    private FragmentFavoriteBinding binding;
    FavoriteViewModel viewModel;
    private final BooksAdapter adapter = new BooksAdapter();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle b) {
        viewModel = new ViewModelProvider(this).get(FavoriteViewModel.class);
        binding = FragmentFavoriteBinding.inflate(inflater, container, false);

        binding.recyclerviewFavoriteBooks.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerviewFavoriteBooks.setAdapter(adapter);

        setObservers();
        attachListener();

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.getBooks();
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
                adapter.updateBooks(bookEntities);
                showEmptyList(bookEntities.isEmpty());
            }
        });
    }

    private void showEmptyList(boolean isEmpty) {
        binding.recyclerviewFavoriteBooks.setVisibility(isEmpty ? View.GONE : View.VISIBLE);
        binding.textviewNoBooks.setVisibility(isEmpty ? View.VISIBLE : View.GONE);
        binding.imageviewNoBooks.setVisibility(isEmpty ? View.VISIBLE : View.GONE);

    }

    private void attachListener() {
        BookListener listener = new BookListener() {
            @Override
            public void onClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(BookConstants.BOOK_ID, id);

                NavHostFragment.findNavController(FavoriteFragment.this)
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