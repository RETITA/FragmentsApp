package com.example.retita.myfragmentsapp.Controllers.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.retita.myfragmentsapp.R;


public class MainFragment extends Fragment implements View.OnClickListener {

    //2 - Declare callback

    private OnButtonClickedListener mCallback;


    // 1 - Declare our interface that will be implemented by any container activity

    public interface OnButtonClickedListener {

        public void onButtonClicked(View view);

    }


    public MainFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout of MainFragment

        View result=inflater.inflate(R.layout.fragment_main, container, false);

        //Set onClickListener to button "SHOW ME DETAILS"

        // Set onClickListener to buttons

        result.findViewById(R.id.fragment_main_button_happy).setOnClickListener(this);

        result.findViewById(R.id.fragment_main_button_sad).setOnClickListener(this);

        result.findViewById(R.id.fragment_main_button_horrible).setOnClickListener(this);


        return result;
    }

    @Override

    public void onAttach(Context context) {

        super.onAttach(context);


        // 4 - Call the method that creating callback after being attached to parent activity

        this.createCallbackToParentActivity();

    }

    // 3 - Create callback to parent activity

    private void createCallbackToParentActivity(){

        try {

            //Parent activity will automatically subscribe to callback

            mCallback = (OnButtonClickedListener) getActivity();

        } catch (ClassCastException e) {

            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");

        }

    }


    @Override

    public void onClick(View v) {

        //Here is handled the button click
        mCallback.onButtonClicked(v);

    }

}
