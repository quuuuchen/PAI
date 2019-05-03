package com.zip.pai_test;

import android.content.DialogInterface;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static android.support.constraint.Constraints.TAG;

public class HomeFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v= inflater.inflate(R.layout.fragment_home,null);
        final View btnShowDialog = v.findViewById(R.id.viewHR1);
        final View btnShowDialog3 = v.findViewById(R.id.viewHR3);
        final View btnShowDialog2 = v.findViewById(R.id.viewHR2);

        final View newv =inflater.inflate(R.layout.alertdialog_entry,null);
        final TextView timer = (TextView)v.findViewById((R.id.newtext4));
        //final TextView  timer= (TextView)newv.findViewById(R.id.timer);


        //入場後的即時訊息
        final TextView TV1 =(TextView)v.findViewById(R.id.newtext2);
        final TextView TV2 =(TextView)v.findViewById(R.id.newtext1);
        final TextView TV3 =(TextView)v.findViewById(R.id.newtext3);
        final TextView TV4 =(TextView)v.findViewById(R.id.newtext4);
        final ImageView IM1 = v.findViewById(R.id.imageView39);
        final ImageView IM2 = v.findViewById(R.id.imageView40);


        //入場前原先資訊
        final TextView DTV1 =(TextView)v.findViewById(R.id.textView5);
        final TextView DTV2 =(TextView)v.findViewById(R.id.textView9);
        final TextView DTV3 =(TextView)v.findViewById(R.id.textView4);
        final TextView DTV4 =(TextView)v.findViewById(R.id.textView8);
        final TextView DTV5 =(TextView)v.findViewById(R.id.textView42);


        final EditText et = (EditText)newv.findViewById(R.id.editText);
        final TextView wh = v.findViewById(R.id.where);
       // final Button wh = (Button) v.findViewById(R.id.button11);



        //入場輸入車牌彈跳視窗
        btnShowDialog.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // time format yyyy-MM-dd kk:mm:ss
                Calendar mCal = Calendar.getInstance();
                final CharSequence s = DateFormat.format("kk:mm", mCal.getTime());
                final CharSequence s1 = DateFormat.format("yyyy-MM-dd kk:mm", mCal.getTime());

                final AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setTitle("進場時間   "+s);
                alert.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TV2.setText("您的愛車 ZIP-168 正在停車計費");
                        TV2.setTextSize(12);
                        String et2 = et.getText().toString();
                        TV3.setText("數碼港三座停車場 車位 89");
                        TV3.setTextSize(16);
                        wh.setVisibility(View.VISIBLE);
                        wh.setText("在哪裡?");
                        wh.setTextSize(12);
                        TV1.setText(s1+"進場");
                        TV1.setTextSize(12);
                        TV1.setVisibility(View.VISIBLE);
                        TV2.setVisibility(View.VISIBLE);
                        TV3.setVisibility(View.VISIBLE);
                        TV4.setVisibility(View.VISIBLE);
                        IM1.setVisibility(View.VISIBLE);
                        IM2.setVisibility(View.VISIBLE);
                        wh.setVisibility(View.VISIBLE);

                        DTV1.setVisibility(View.GONE);
                        DTV2.setVisibility(View.GONE);
                        DTV3.setVisibility(View.GONE);
                        DTV4.setVisibility(View.GONE);
                        DTV5.setVisibility(View.GONE);
                    }
                });

                // customize view in alertdialog
                final View item = LayoutInflater.from(getContext()).inflate(R.layout.alertdialog_entry, null);
                alert.setView(item);


                alert.show();
                Log.d("home","asd");

                //Timer
                new CountDownTimer(300000, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        //timer.setText("timimg"+ (30-(millisUntilFinished/1000)));

                        timer.setText("00:00:"+ (299-(millisUntilFinished/1000)));
                        if(millisUntilFinished/1000<240){
                            timer.setText("00:01:"+(239-(millisUntilFinished/1000)));
                        }
                        if(millisUntilFinished/1000<180){
                            timer.setText("00:02:"+(179-(millisUntilFinished/1000)));
                        }
                        if(millisUntilFinished/1000<120){
                            timer.setText("00:03:"+(119-(millisUntilFinished/1000)));
                        }
                        if(millisUntilFinished/1000<60){
                            timer.setText("00:04:"+(59-(millisUntilFinished/1000)));
                        }
                        //alert.setMessage("time"+(30-(millisUntilFinished/1000)));


                    }

                    public void onFinish() {
                        timer.setText("Times up");


                    }
                }.start();

            }
        });
        //牽車提醒
        btnShowDialog2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                final View item = LayoutInflater.from(getContext()).inflate(R.layout.alertdialog_timeup, null);
                alert.setView(item);
                alert.setTitle("牽車提醒");
                alert.setPositiveButton("好",null);
                alert.show();
            }
        });



        //出場認證彈跳視窗
        btnShowDialog3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //final AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setPositiveButton("取消",null);
                final AlertDialog alert = alertDialogBuilder.create();

                // customize view in alertdialog
                final View item = LayoutInflater.from(getContext()).inflate(R.layout.alertdialog_exit, null);
                alert.setView(item);

                alert.show();
                Log.d("home","asd");

                //Timer
                new CountDownTimer(18000, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }
                    @Override
                    public void onFinish() {
                        alert.cancel();
                        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                        final View item = LayoutInflater.from(getContext()).inflate(R.layout.alertdialog_exit_ok, null);
                        alert.setView(item);
                        alert.setPositiveButton("確認",null);
                        alert.show();

                        TV1.setVisibility(View.GONE);
                        TV2.setVisibility(View.GONE);
                        TV3.setVisibility(View.GONE);
                        TV4.setVisibility(View.GONE);
                        wh.setVisibility(View.GONE);
                        IM1.setVisibility(View.GONE);
                        IM2.setVisibility(View.GONE);

                        DTV1.setVisibility(View.VISIBLE);
                        DTV2.setVisibility(View.VISIBLE);
                        DTV3.setVisibility(View.VISIBLE);
                        DTV4.setVisibility(View.VISIBLE);
                        DTV5.setVisibility(View.VISIBLE);
                    }
                }.start();

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
