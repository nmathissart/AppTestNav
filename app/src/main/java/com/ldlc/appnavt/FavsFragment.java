package com.ldlc.appnavt;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavsFragment extends Fragment {
    public FavsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favs, container, false);

        Button button = (Button) view.findViewById(R.id.button);
        TextView textview = (TextView) view.findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textview.setVisibility(View.VISIBLE);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
