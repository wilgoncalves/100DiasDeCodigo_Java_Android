package com.williangoncalves.mybooks.ui.viewholder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.williangoncalves.mybooks.R;
import com.williangoncalves.mybooks.databinding.ItemBookBinding;
import com.williangoncalves.mybooks.entity.BookEntity;

public class BookViewHolder extends RecyclerView.ViewHolder {

    private final ItemBookBinding item;

    public BookViewHolder(@NonNull ItemBookBinding itemView) {
        super(itemView.getRoot());
        item = itemView;
    }

    public void bind(BookEntity book) {
        item.textviewTitle.setText(book.getTitle());
        item.textviewAuthor.setText(book.getAuthor());
        item.textviewGenre.setText(book.getGenre());

        updateFavoriteIcon(book);
    }

    private void updateFavoriteIcon(BookEntity book) {
        if (book.isFavorite()) {
            item.imageviewFavorite.setImageResource(R.drawable.ic_favorite);
        } else {
            item.imageviewFavorite.setImageResource(R.drawable.ic_favorite_empty);
        }
    }
}


