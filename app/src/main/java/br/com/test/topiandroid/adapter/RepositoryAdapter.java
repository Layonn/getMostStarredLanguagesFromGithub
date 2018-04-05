package br.com.test.topiandroid.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;
import java.util.Locale;

import br.com.test.topiandroid.R;
import br.com.test.topiandroid.model.Repository;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryHolder> {

    private final List<Repository> repositoryList;

    public RepositoryAdapter(List<Repository> repositoryList) {
        this.repositoryList = repositoryList;
    }

    @Override
    public RepositoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RepositoryHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.repository_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RepositoryHolder holder, int position) {
        holder.fullName.setText(String.format(Locale.getDefault(), "%s, %s - %s",
                repositoryList.get(position).getFullName(),
                repositoryList.get(position).getNumberOfForks(),
                repositoryList.get(position).getNumberOfStars()));
    }

    @Override
    public int getItemCount() {
        return repositoryList != null ? repositoryList.size() : 0;
    }
}
