package com.example.myapplication.feedback;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.viewholder>{

    private List<FeedbackModel> feedbackModels;

    public FeedbackAdapter(List<FeedbackModel> feedbackModels) {
        this.feedbackModels = feedbackModels;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feedback_item, parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        holder.setData(feedbackModels.get(position).getName(),
                feedbackModels.get(position).getEmail(),
                feedbackModels.get(position).getFeedback()
                );

    }

    @Override
    public int getItemCount() {
        return feedbackModels.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        private TextView name, email, feed;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.Name);
            email = itemView.findViewById(R.id.Email);
            feed = itemView.findViewById(R.id.Feedback);
        }

        private void setData(final String name, final String email, final String feed){
            this.name.setText("Name: "+ name);
            this.email.setText("Email: "+ email);
            this.feed.setText("Feedback: "+ feed);

        }
    }

}
