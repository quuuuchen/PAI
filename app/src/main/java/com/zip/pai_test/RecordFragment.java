package com.zip.pai_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class RecordFragment extends Fragment {

    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view= inflater.inflate(R.layout.fragment_record,null);

        // 在fragment中建立intent 參考 https://www.youtube.com/watch?v=TY-2Cx4IW9A
        final FloatingActionButton BtnAch =view.findViewById(R.id.ButtomAch);
        BtnAch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() ,AchievementActivity.class);
                startActivity(intent);
                Log.d("RecordFragment","toachiement");
            }
        });

        View SeeDetail =view.findViewById(R.id.see_detail);
        SeeDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity() ,RecordDetailActivity.class);
                startActivity(intent1);
                Log.d("RecordFragment","torecorddetail");
                ImageView newicon = view.findViewById(R.id.newicon);
                newicon.setVisibility(View.GONE);
            }
        });

        return view;
    }
/*
    public void achievement(View view){   //onclick時傳入值的規範，需傳入View view
        Log.d("RecordFragment","InAchievement");
        Intent intent = new Intent(getActivity() ,AchievementActivity.class);
        startActivity(intent);

    }
*/
}
