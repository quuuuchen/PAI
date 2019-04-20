package com.zip.pai_test;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Message;
import android.os.health.TimerStat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import static android.support.constraint.Constraints.TAG;

public class HomeFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v= inflater.inflate(R.layout.fragment_home,null);
        final View btnShowDialog = v.findViewById(R.id.show_alert);

        final View newv =inflater.inflate(R.layout.alertdialog_entry,null);
        final TextView  timer= (TextView)newv.findViewById(R.id.timer);
        btnShowDialog.setOnClickListener(new View.OnClickListener(){



            @Override
            public void onClick(View v) {
                // time format yyyy-MM-dd kk:mm:ss
                Calendar mCal = Calendar.getInstance();
                CharSequence s = DateFormat.format("kk:mm", mCal.getTime());

                final AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setTitle("進場時間   "+s);
                alert.setPositiveButton("我知道了", null);
                final View item = LayoutInflater.from(getContext()).inflate(R.layout.alertdialog_entry, null);
                alert.setView(item);

                alert.show();
                Log.d("home","asd");

                //Timer
                new CountDownTimer(30000, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        timer.setText("timimg"+ (30-(millisUntilFinished/1000)));
                    }
                    @Override
                    public void onFinish() {
                        //info.setVisibility(View.GONE);
                    }
                }.start();

                // customize view in alertdialog




            }
        });
        return v;
    }

//    public void ntf(View view){
////        Calendar mCal = Calendar.getInstance();
////        CharSequence s = DateFormat.format("yyyy-MM-dd kk:mm:ss", mCal.getTime());
//        new AlertDialog.Builder(getActivity())
//                .setTitle("進場通知")
//                .setMessage("進場時間")
//                .setMessage("Cyberport Three Car Park")
//                .setPositiveButton("我知道了", null)
//                .show();
//
//    }


}
