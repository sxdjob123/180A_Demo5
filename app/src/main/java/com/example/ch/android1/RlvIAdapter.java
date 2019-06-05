package com.example.ch.android1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ch.android1.bean.IBean;

import java.util.ArrayList;

/**
 * Created by 76165
 * on 2019/6/5
 */
public class RlvIAdapter extends RecyclerView.Adapter<RlvIAdapter.ViewHolder> {
    private Context context;
    private ArrayList<IBean.ResultsEntity> resultsEntities;

    public RlvIAdapter(Context context, ArrayList<IBean.ResultsEntity> resultsEntities) {
        this.context = context;
        this.resultsEntities = resultsEntities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tv.setText(resultsEntities.get(i).getCreatedAt());
        Glide.with(context)
                .load(resultsEntities.get(i).getUrl())
                .apply(new RequestOptions().circleCrop())
                .into(viewHolder.iv);
    }

    @Override
    public int getItemCount() {
        return resultsEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
