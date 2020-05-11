package com.example.sinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {
TextView showCountTextView;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View fragmentFisrLayout = inflater.inflate(R.layout.fragment_first,container,false);
        //Get the count text view
        showCountTextView = fragmentFisrLayout.findViewById(R.id.textview_first);
        return fragmentFisrLayout;
    }
    private void countMe(View view){
        //Get the value of the text view
        String countString  =  showCountTextView.getText().toString();
        // Convert value to a number and increment it
        Integer count = Integer.parseInt(countString);
        count++;
        //Display the new value in text view
        showCountTextView.setText(count.toString());
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.sex_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Toast mysex = Toast.makeText(getActivity(),"Hello Sexy",Toast.LENGTH_SHORT);
              mysex.show();
            }
        }); view.findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    countMe(view);
                }
        });view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentCount = Integer.parseInt(showCountTextView.getText().toString());
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount);
                NavHostFragment.findNavController(FirstFragment.this).navigate(action);
            }
        });
    }
}
