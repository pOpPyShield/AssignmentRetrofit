package com.example.assignment75;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ContentsOfUserAdapter extends RecyclerView.Adapter<ContentsOfUserAdapter.ContentsOfUserViewHolder>{
    private Context mContext;
    private ArrayList<ContentsOfUser> mExampleList;
    public ContentsOfUserAdapter(Context context, ArrayList<ContentsOfUser> exampleList) {
        this.mContext = context;
        this.mExampleList = exampleList;
    }

    @NonNull
    @NotNull
    @Override
    public ContentsOfUserViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.mContext).inflate(R.layout.example_items_user, parent, false);
        return new ContentsOfUserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ContentsOfUserViewHolder holder, int position) {
        ContentsOfUser currentItem = mExampleList.get(position);
        String usrName = currentItem.getTitle();
        String numberOfContents = currentItem.getBody();
        holder.usrTitle_TextView.setText(usrName);
        holder.usr_Contents.setText(numberOfContents);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    public class ContentsOfUserViewHolder extends RecyclerView.ViewHolder {
        public TextView usrTitle_TextView;
        public TextView usr_Contents;

        public ContentsOfUserViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            usrTitle_TextView = itemView.findViewById(R.id.Title);
            usr_Contents = itemView.findViewById(R.id.Body);
        }
    }
}
