package com.fada21.android.recyclerviewplayground;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

public class ColorSqauresAdapter extends RecyclerView.Adapter<ColorSqauresAdapter.ViewHolder> {


    private final List<Integer> data;

    public ColorSqauresAdapter(List<Integer> colorList) {
        data = colorList == null ? Collections.EMPTY_LIST : colorList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.square, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.getView().setBackgroundColor(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final View view;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView.findViewById(R.id.box);
        }

        public View getView() {
            return view;
        }
    }
}
