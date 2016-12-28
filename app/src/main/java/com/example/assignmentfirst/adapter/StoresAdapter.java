package com.example.assignmentfirst.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.assignmentfirst.R;
import com.example.assignmentfirst.pojos.StoreData;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by User on 12/23/2016.
 */

public class StoresAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    java.util.ArrayList<StoreData> arrayList;
    Context context;


    public StoresAdapter(Context activity, java.util.ArrayList<StoreData> teamMembers) {
        arrayList = teamMembers;
        context  = activity;
    }
//
//    @Override
//    public Character getCharacterForElement(int element) {
//        Character c = arrayList.get(element).getName().charAt(0);
//        if(Character.isDigit(c)){
//            c = '#';
//        }
//        return c;
//    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
                ViewGroup vGroupText2 = (ViewGroup) mInflater.inflate(R.layout.row_item, parent, false);
                ViewHolderMember text1 = new ViewHolderMember(vGroupText2);
                return text1;


    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof ViewHolderMember){

            ((ViewHolderMember) holder).tvName.setText(arrayList.get(position).getName());
            ((ViewHolderMember) holder).tvContact.setText(arrayList.get(position).getStreetAddress());
        }
    }



    @Override
    public int getItemCount() {
        return null != arrayList ? arrayList.size() : 0;
    }



    class ViewHolderMember extends RecyclerView.ViewHolder {
        public TextView tvName,tvContact;

        public ViewHolderMember(View view) {
            super(view);
             tvName = (TextView) view.findViewById(R.id.tv_name);
             tvContact = (TextView) view.findViewById(R.id.tv_contact);
        }


    }



}
