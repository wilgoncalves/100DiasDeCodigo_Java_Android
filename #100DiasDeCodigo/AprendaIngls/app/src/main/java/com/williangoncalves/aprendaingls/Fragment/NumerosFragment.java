package com.williangoncalves.aprendaingls.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.williangoncalves.aprendaingls.R;

public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageButton imageButtonOne, imageButtonTwo, imageButtonThree,
                        imageButtonFour, imageButtonFive, imageButtonSix;

    private MediaPlayer mediaPlayer;

    public NumerosFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        imageButtonOne = view.findViewById(R.id.imageButtonOne);
        imageButtonTwo = view.findViewById(R.id.imageButtonTwo);
        imageButtonThree = view.findViewById(R.id.imageButtonThree);
        imageButtonFour = view.findViewById(R.id.imageButtonFour);
        imageButtonFive = view.findViewById(R.id.imageButtonFive);
        imageButtonSix = view.findViewById(R.id.imageButtonSix);

        imageButtonOne.setOnClickListener(this);
        imageButtonTwo.setOnClickListener(this);
        imageButtonThree.setOnClickListener(this);
        imageButtonFour.setOnClickListener(this);
        imageButtonFive.setOnClickListener(this);
        imageButtonSix.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.imageButtonOne) {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
            tocarSom();
        } else if (view.getId() == R.id.imageButtonTwo) {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
            tocarSom();
        } else if (view.getId() == R.id.imageButtonThree) {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
            tocarSom();
        } else if (view.getId() == R.id.imageButtonFour) {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
            tocarSom();
        } else if (view.getId() == R.id.imageButtonFive) {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
            tocarSom();
        } else {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
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