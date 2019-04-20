package com.zip.pai_test;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ListFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, null);

        final TextView mTextField = (TextView)view.findViewById(R.id.timer_test);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("seconds remaining: " + (31-(millisUntilFinished / 1000)));
            }

            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();


//        RecyclerView recyclerView = getView().findViewById(R.id.recycler);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        functions = context.getResources().getStringArray(R.array.functions);
//        FunctionAdapter adapter = new FunctionAdapter(getActivity());
//        recyclerView.setAdapter(adapter);

        return view;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        //recycler
//        RecyclerView recyclerView =getView().findViewById(R.id.recycler);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        FunctionAdapter adapter = new FunctionAdapter();
//        recyclerView.setAdapter(adapter);
//
//    }
    }
}
