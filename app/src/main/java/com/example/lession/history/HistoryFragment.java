package com.example.lession.history;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lession1.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {

    private HistoryViewModel mViewModel;
    private RecyclerView recyclerView;
    private HistoryAdapter historyAdapter;

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.history_fragment, container, false);

        List<HisoryModel> models =  new ArrayList<>();
        models.add(new HisoryModel("Category: Mixed", "correct answer 8/10", "Difficulty: hard", 3));
        models.add(new HisoryModel("Category: Mixed", "correct answer 8/10", "Difficulty: hard", 3));
        models.add(new HisoryModel("Category: Mixed", "correct answer 8/10", "Difficulty: hard", 3));
        models.add(new HisoryModel("Category: Mixed", "correct answer 8/10", "Difficulty: hard", 3));
        models.add(new HisoryModel("Category: Mixed", "correct answer 8/10", "Difficulty: hard", 3));
        models.add(new HisoryModel("Category: Mixed", "correct answer 8/10", "Difficulty: hard", 3));
        models.add(new HisoryModel("Category: Mixed", "correct answer 8/10", "Difficulty: hard", 3));
        models.add(new HisoryModel("Category: Mixed", "correct answer 8/10", "Difficulty: hard", 3));
        models.add(new HisoryModel("Category: Mixed", "correct answer 8/10", "Difficulty: hard", 3));
        models.add(new HisoryModel("Category: Mixed", "correct answer 8/10", "Difficulty: hard", 3));
        models.add(new HisoryModel("Category: Mixed", "correct answer 8/10", "Difficulty: hard", 3));
        models.add(new HisoryModel("Category: Mixed", "correct answer 8/10", "Difficulty: hard", 3));
        models.add(new HisoryModel("Category: Mixed", "correct answer 8/10", "Difficulty: hard", 3));
        models.add(new HisoryModel("Category: Mixed", "correct answer 8/10", "Difficulty: hard", 3));
        models.add(new HisoryModel("Category: Mixed", "correct answer 8/10", "Difficulty: hard", 3));

        historyAdapter = new HistoryAdapter(models);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(historyAdapter);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
