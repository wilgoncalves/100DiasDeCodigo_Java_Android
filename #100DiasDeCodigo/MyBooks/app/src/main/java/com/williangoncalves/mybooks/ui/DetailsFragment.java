package com.williangoncalves.mybooks.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.williangoncalves.mybooks.R;
import com.williangoncalves.mybooks.entity.BookEntity;
import com.williangoncalves.mybooks.helper.BookConstants;
import com.williangoncalves.mybooks.viewmodel.DetailsViewModel;
import com.williangoncalves.mybooks.databinding.FragmentDetailsBinding;

public class DetailsFragment extends Fragment {

    private DetailsViewModel viewModel;
    private FragmentDetailsBinding binding;
    private int bookId = 0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle b) {
        viewModel = new ViewModelProvider(this).get(DetailsViewModel.class);
        binding = FragmentDetailsBinding.inflate(inflater, container, false);

        bookId = getArguments() != null ? getArguments().getInt(BookConstants.BOOK_ID) : 0;
        viewModel.getBookById(bookId);

        setObservers();
        setListeners();

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setObservers() {
        viewModel.book.observe(getViewLifecycleOwner(), new Observer<BookEntity>() {
            @Override
            public void onChanged(BookEntity book) {
                binding.textviewTitle.setText(book.getTitle());
                binding.textviewAuthorValue.setText(book.getAuthor());
                binding.textviewGenreValue.setText(book.getGenre());
                binding.checkboxFavorite.setChecked(book.isFavorite());

                setGenreBackgroundColor(book);
            }
        });

        viewModel.bookDeleted.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Toast.makeText(getContext(), R.string.msg_removed_successfully, Toast.LENGTH_SHORT).show();
                    requireActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });
    }

    private void setListeners() {
        binding.checkboxFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.toggleFavoriteStatus(bookId);
            }
        });

        binding.imageviewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        binding.buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRemove();
            }
        });
    }

    private void handleRemove() {
        Context context = getContext();
        if (context != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage(R.string.dialog_message_delete_item)
                    .setPositiveButton(R.string.dialog_positive_button_yes,
                            (dialog, which) -> viewModel.delete(bookId))
                    .setNegativeButton(R.string.dialog_negative_button_no,
                            (dialog, which) -> dialog.dismiss());
            builder.create().show();
        }
    }

    private void setGenreBackgroundColor(BookEntity book) {
        if (book.getGenre().equals("Fantasia")) {
            binding.textviewGenreValue.setBackgroundResource(R.drawable.rounded_label_fantasy);
        } else if (book.getGenre().equals("Terror")) {
            binding.textviewGenreValue.setBackgroundResource(R.drawable.rounded_label_red);
        } else {
            binding.textviewGenreValue.setBackgroundResource(R.drawable.rounded_label_teal);
        }
    }
}