package com.example.myapplication.set;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.question.QuestionsActivity;

import java.util.List;

public class GridAdapter extends BaseAdapter {

    public List<String> sets;
    private String category;
    private GridLinstener linstener;

    public GridAdapter(List<String> sets, String category, GridLinstener linstener) {
        this.sets = sets;
        this.category = category;
        this.linstener = linstener;
    }

    @Override
    public int getCount() {
        return sets.size() +1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertview, final ViewGroup parent) {
        View view;

        if(convertview == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.set_item, parent, false);

        }else {
            view = convertview;
        }

        if(position == 0){
            ((TextView)view.findViewById(R.id.textview)).setText(String.valueOf("+"));
        }else {
            ((TextView)view.findViewById(R.id.textview)).setText(String.valueOf(position));
        }



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position == 0){
                    //add code
                    linstener.addSet();
                }else {

                    Intent questionIntent = new Intent(parent.getContext(), QuestionsActivity.class);
                    questionIntent.putExtra("category", category);
                    questionIntent.putExtra("setId", sets.get(position -1));
                    parent.getContext().startActivity(questionIntent);
                }
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (position != 0) {
                    linstener.onLongClick(sets.get(position -1), position);
                }
                return false;
            }
        });

        return view;
    }

    public interface GridLinstener{
        public void addSet();
        void onLongClick(String setId, int position);
    }
}
