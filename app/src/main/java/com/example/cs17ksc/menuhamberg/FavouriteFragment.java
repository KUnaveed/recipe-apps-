package com.example.cs17ksc.menuhamberg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cs17ksc on 24/01/2019.
 */

public class FavouriteFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favourite_fragment,container, false);
    }
}
