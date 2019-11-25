package com.example.lession.quiz.recyclerView;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lession.model.Quiztions;
import com.example.lession1.R;

import java.util.ArrayList;
import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {
    private List<Quiztions> mQuestions = new ArrayList<>();
    private QuizViewHolder.Listener mListener;
    private Quiztions question;


    public QuizAdapter(QuizViewHolder.Listener listener) {
        this.mListener = listener;
    }

    public void setQuestions(List<Quiztions> questions) {
        mQuestions.clear();
        mQuestions.addAll(questions);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quiz_recucler_view, parent, false);
        return new QuizViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        holder.onBind(mQuestions.get(position));
    }

    @Override
    public int getItemCount() {
        return mQuestions.size();
    }

    public static class QuizViewHolder extends RecyclerView.ViewHolder {

        ProgressBar progressBar;
        TextView name, progressTv, quiestions;
        Button btn1, btn2, btn3, btn4, btnSkip;

        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.bar1);
            progressTv = itemView.findViewById(R.id.tv_progress);
            quiestions = itemView.findViewById(R.id.quistions);
            progressBar = itemView.findViewById(R.id.progress_quiz);
            btn1 = itemView.findViewById(R.id.btn_1);
            btn2 = itemView.findViewById(R.id.btn_2);
            btn3 = itemView.findViewById(R.id.btn_3);
            btn4 = itemView.findViewById(R.id.btn_4);
            btnSkip = itemView.findViewById(R.id.btn_skip);

        }

        void onBind(Quiztions question) {
            quiestions.setText(question.getQuiestion());
            btn1.setText(question.getCorrectAnswer());
//            name.setText(question.getCategory());
//            name.setText(question.getCategory());
//            btn2.setText(question.getIncorrectAnswers());
//            btn3.setText(question.getIncorrectAnswers());
//            btn4.setText(question.getIncorrectAnswers());

        }

        public interface Listener {
            void onAnswerClick(int questionPosition, int answerPosition);

        }
    }
}
