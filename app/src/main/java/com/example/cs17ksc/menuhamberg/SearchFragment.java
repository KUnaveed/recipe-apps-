package com.example.cs17ksc.menuhamberg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static android.R.layout.simple_spinner_dropdown_item;

/**
 * Created by cs17ksc on 24/01/2019.
 */

public class SearchFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);

        Spinner spinner = (Spinner)view.findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return view;
    }

}
