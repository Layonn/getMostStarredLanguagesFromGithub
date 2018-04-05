package br.com.test.topiandroid.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.test.topiandroid.R;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryHolder> {

    ArrayList<HashMap<String, String>> repositoryList;

    public RepositoryAdapter(ArrayList<HashMap<String, String>> repositoryList) {
        this.repositoryList = repositoryList;
    }

    @Override
    public RepositoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RepositoryHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.repository_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RepositoryHolder holder, int position) {
        holder.fullName.setText(repositoryList.indexOf("full_name"));
        holder.numberOfStars.setText(repositoryList.indexOf("number_of_stars"));
        holder.numberOfForks.setText(repositoryList.indexOf("number_of_forks"));
    }

    @Override
    public int getItemCount() {
        return repositoryList != null ? repositoryList.size() : 0;
    }
}
