package com.example.aadpracticeproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopIqFragmentRecyclerAdapter extends RecyclerView.Adapter<TopIqFragmentRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    List<TopIQ> mTopIQS;

    public TopIqFragmentRecyclerAdapter(Context context, List<TopIQ> topIQS) {
        mContext = context;
        mTopIQS = topIQS;
        mLayoutInflater = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.top_iq_list,parent,false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String learningIQ = " skill IQ Score";
        holder.mTextName.setText(mTopIQS.get(position).getName());
        holder.mTextHour.setText(mTopIQS.get(position).getHours()+ learningIQ);
        holder.mTextCountry.setText(mTopIQS.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return mTopIQS.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView mTextName;
        public final TextView mTextHour;
        public final TextView mTextCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextName = (TextView) itemView.findViewById(R.id.text_name_iq);
            mTextHour = (TextView) itemView.findViewById(R.id.text_hours_iq);
            mTextCountry = (TextView) itemView.findViewById(R.id.text_country_iq);
        }
    }
}
