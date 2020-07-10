package com.weaponreviewsteps;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Preliminary extends Fragment {



    private Map<String, String> keywords = new HashMap<String, String>();

    View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.preliminary, container, false);
        setRetainInstance(true);
        view = inflater.inflate(R.layout.preliminary, container, false);



        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {


                } catch (Exception e) {
                    System.out.println("----------------------------" + e + "-----------------------");
                }
            }
        }, 5000);


        return root;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        UnderlineKeywords(view.findViewById(R.id.section_labelPrelim));


    }


    //region ----Standard Functions----
    //-----------------------------------------------------------------------------------------------------------------

    public void UnderlineKeywords(View tView){



        String[] tags = getResources().getStringArray(R.array.Definitions);
        for(String key : tags){

            String[] splitTag = key.split(":");

            keywords.put(splitTag[0], splitTag[1]);
            System.out.println(splitTag[0] + "   " + splitTag[1]);

        }

        SpannableString ss = new SpannableString(((TextView) tView).getText().toString());
        //iterate through each keyword and make them clickable
        for(final Map.Entry<String, String> entry : keywords.entrySet()){


            System.out.println("Searching for: " + entry.getKey());

            String searchableString = ((TextView)tView).getText().toString();
            int lastIndex = 0;

            while(lastIndex != -1) {


                if(lastIndex == 0) lastIndex = -1;

                lastIndex = searchableString.indexOf(entry.getKey(), lastIndex + 1);

                System.out.println(lastIndex);

                try {

                    ClickableSpan clickableSpan = new ClickableSpan() {
                        @Override
                        public void onClick(View textView) {
                            ShowPopup(entry.getKey(), entry.getValue());
                        }

                        @Override
                        public void updateDrawState(TextPaint ds) {
                            super.updateDrawState(ds);
                            ds.setUnderlineText(false);
                        }
                    };

                    System.out.println("-----------------" + lastIndex + " : " + entry.getKey().length() + " : " + (lastIndex + entry.getKey().length()));

                    ss.setSpan(clickableSpan, lastIndex, lastIndex + entry.getKey().length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

                    TextView textView = (TextView) tView;
                    textView.setText(ss);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    textView.setHighlightColor(Color.TRANSPARENT);
                    System.out.println("Found " + entry.getKey());
                }

                catch(Exception e){

                    System.out.println("-----------------"+e+"-----------------------");
                    break;

                }
            }
        }
    }

    public void ShowPopup(String title, String content) {


        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setMessage(content);
        dialog.setTitle(title);

        dialog.setPositiveButton("Okay",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        // Toast.makeText(getApplicationContext(), null, Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }






    //-----------------------------------------------------------------------------------------------------------------
    //endregion
}
