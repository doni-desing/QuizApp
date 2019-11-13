package com.example.lession.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lession1.R;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<HisoryModel> modelList;

    public HistoryAdapter(List<HisoryModel> modelList){
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.difficulty.setText(modelList.get(position).getDifficulty());
        holder.category.setText(modelList.get(position).getCategory());
        holder.answer.setText(modelList.get(position).getAnswer());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {

        TextView difficulty, category, data, answer;


        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            difficulty = itemView.findViewById(R.id.difficulty);
            category = itemView.findViewById(R.id.category_mi);
            data = itemView.findViewById(R.id.data);
            answer = itemView.findViewById(R.id.answer);

            }
        }
    }

