package com.williangoncalves.mybooks.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.williangoncalves.mybooks.databinding.ItemBookBinding;
import com.williangoncalves.mybooks.entity.BookEntity;
import com.williangoncalves.mybooks.ui.listener.BookListener;
import com.williangoncalves.mybooks.ui.viewholder.BookViewHolder;

import java.util.ArrayList;
import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BookViewHolder> {

    private List<BookEntity> booksList = new ArrayList<>();
    private BookListener listener;

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBookBinding view = ItemBookBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);

        return new BookViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bind(booksList.get(position));
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

    public void updateBooks(List<BookEntity> books) {
        booksList = books;
    }

    public void attachListener(BookListener bookListener) {
        listener = bookListener;
    }
}
