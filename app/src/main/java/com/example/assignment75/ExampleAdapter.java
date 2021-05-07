package com.example.assignment75;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int posistion);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleList) {
        this.mContext = context;
        this.mExampleList = exampleList;
    }

    @NonNull
    @NotNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.mContext).inflate(R.layout.example_items, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);
        String usrName = currentItem.getUsrName();
        String numberOfContents = currentItem.getEmail();
        holder.usrId_TextView.setText(usrName);
        holder.usrId_Contents.setText(numberOfContents);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView usrId_TextView;
        public TextView usrId_Contents;
        public ExampleViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            usrId_TextView = itemView.findViewById(R.id.user_Name);
            usrId_Contents = itemView.findViewById(R.id.number_Of_Contents);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null) {
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
