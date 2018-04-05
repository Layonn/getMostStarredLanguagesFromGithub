package br.com.test.topiandroid.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.test.topiandroid.R;

public class RepositoryHolder extends RecyclerView.ViewHolder {
    public TextView fullName;
    public TextView numberOfStars;
    public TextView numberOfForks;

    public RepositoryHolder(View itemView) {
        super(itemView);
        fullName = (TextView) itemView.findViewById(R.id.full_name);
        numberOfStars = (TextView) itemView.findViewById(R.id.number_of_stars);
        numberOfForks = (TextView) itemView.findViewById(R.id.number_of_forks);
    }
}
