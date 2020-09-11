package com.example.aadpracticeproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopLearnerFragmentRecyclerAdapter extends RecyclerView.Adapter<TopLearnerFragmentRecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    List<TopLearners> mTopLearners;

    public TopLearnerFragmentRecyclerAdapter(Context context,List<TopLearners> topLearners) {
        mContext = context;
        mTopLearners = topLearners;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.toplearner_list,parent,false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String learningHours = " learning hours";
        holder.mTextName.setText(mTopLearners.get(position).getName());
        holder.mTextHour.setText(mTopLearners.get(position).getHours()+learningHours);
        holder.mTextCountry.setText(mTopLearners.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return mTopLearners.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView mTextName;
        public final TextView mTextHour;
        public final TextView mTextCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextName = (TextView) itemView.findViewById(R.id.text_name_learner);
            mTextHour = (TextView) itemView.findViewById(R.id.text_hours_learner);
            mTextCountry = (TextView) itemView.findViewById(R.id.text_country_learner);
        }
    }
}
