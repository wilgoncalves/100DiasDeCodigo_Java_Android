package com.williangoncalves.mybooks.ui.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.williangoncalves.mybooks.R;
import com.williangoncalves.mybooks.databinding.ItemBookBinding;
import com.williangoncalves.mybooks.entity.BookEntity;
import com.williangoncalves.mybooks.ui.listener.BookListener;

public class BookViewHolder extends RecyclerView.ViewHolder {

    private final ItemBookBinding item;
    private final BookListener listener;

    public BookViewHolder(@NonNull ItemBookBinding itemView, BookListener bookListener) {
        super(itemView.getRoot());
        item = itemView;
        listener = bookListener;
    }

    public void bind(BookEntity book) {
        item.textviewTitle.setText(book.getTitle());
        item.textviewAuthor.setText(book.getAuthor());
        item.textviewGenre.setText(book.getGenre());
        updateFavoriteIcon(book);
        setGenreBackgroundColor(book);

        item.textviewTitle.setOnClickListener(v -> listener.onClick(book.getId()));
        item.textviewAuthor.setOnClickListener(v -> listener.onClick(book.getId()));
        item.imageviewFavorite.setOnClickListener(v -> listener.onFavoriteClick(book.getId()));
    }

    private void updateFavoriteIcon(BookEntity book) {
        if (book.isFavorite()) {
            item.imageviewFavorite.setImageResource(R.drawable.ic_favorite);
        } else {
            item.imageviewFavorite.setImageResource(R.drawable.ic_favorite_empty);
        }
    }

    private void setGenreBackgroundColor(BookEntity book) {
        if (book.getGenre().equals("Fantasia")) {
            item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_fantasy);
        } else if (book.getGenre().equals("Terror")) {
            item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_red);
        } else {
            item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_teal);
        }
    }
}


