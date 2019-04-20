package com.zip.pai_test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ListFragment extends Fragment {
    String[] functions =null;
    private View view;
    public RecyclerView recyclerView;
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, null);

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
