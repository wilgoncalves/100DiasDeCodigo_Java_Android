package com.williangoncalves.aprendaingls.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.williangoncalves.aprendaingls.R;

public class BichosFragment extends Fragment implements View.OnClickListener {

    private ImageButton imageButtonDog, imageButtonCat, imageButtonLion,
                        imageButtonMonkey, imageButtonSheep, imageButtonCow;

    private MediaPlayer mediaPlayer;

    public BichosFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        imageButtonDog = view.findViewById(R.id.imageButtonDog);
        imageButtonCat = view.findViewById(R.id.imageButtonCat);
        imageButtonLion = view.findViewById(R.id.imageButtonLion);
        imageButtonMonkey = view.findViewById(R.id.imageButtonMonkey);
        imageButtonSheep = view.findViewById(R.id.imageButtonSheep);
        imageButtonCow = view.findViewById(R.id.imageButtonCow);

        imageButtonDog.setOnClickListener(this);
        imageButtonCat.setOnClickListener(this);
        imageButtonLion.setOnClickListener(this);
        imageButtonMonkey.setOnClickListener(this);
        imageButtonSheep.setOnClickListener(this);
        imageButtonCow.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.imageButtonDog) {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
            tocarSom();
        } else if (view.getId() == R.id.imageButtonCat) {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
            tocarSom();
        } else if (view.getId() == R.id.imageButtonLion) {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
            tocarSom();
        } else if (view.getId() == R.id.imageButtonMonkey) {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
            tocarSom();
        } else if (view.getId() == R.id.imageButtonSheep) {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
            tocarSom();
        } else {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
            tocarSom();
        }
    }

    public void tocarSom() {

        if (mediaPlayer != null) {
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}