package br.com.test.topiandroid.fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import br.com.test.topiandroid.R;
import br.com.test.topiandroid.adapter.RepositoryAdapter;
import br.com.test.topiandroid.utils.HttpHandler;

public class RepositoryFragment extends BaseFragment {
    private String TAG = RepositoryFragment.class.getName();
    private RecyclerView languageRecyclerView;
    private RecyclerView.Adapter languageRecyclerAdapter;
    private RecyclerView.LayoutManager languageLayoutManager;

    ArrayList<HashMap<String, String>> repositoryList;
    private ProgressDialog pDialog;
    protected ListView repositoriesListView;
    private String url;

    private int language;

    public static RepositoryFragment newInstance(int language) {
        Bundle args = new Bundle();
        args.putInt("language", language);
        RepositoryFragment repositoryFragment = new RepositoryFragment();
        repositoryFragment.setArguments(args);
        return repositoryFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            this.language = getArguments().getInt("language");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_languages, container, false);

        repositoryList = new ArrayList<>();
        //repositoriesListView = (ListView) view.findViewById(R.id.repositories_list_view);
        languageRecyclerView = view.findViewById(R.id.languages_recycler_view);
        url = "https://api.github.com/search/repositories?q=language:" + getString(language) + "&sort=stars&page=1";
        new GetRepositories().execute(url);
        return view;
    }

    //AsyncTask
    private class GetRepositories extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (repositoryList != null) {
                repositoryList.clear();
            }

            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Buscando repositorios...");
            pDialog.show();
        }

        @Override
        protected Void doInBackground(String... param) {
            HttpHandler hh = new HttpHandler();
            String jsonStringObject = hh.callService(param[0]);

            Log.e(TAG, "Resposta recebida: " + jsonStringObject);

            if(jsonStringObject != null){


                try {
                    JSONObject jsonObject = new JSONObject(jsonStringObject);
                    JSONArray repositories = jsonObject.getJSONArray("items");


                    for (int i = 0; i < repositories.length(); i++) {
                        Log.e(TAG, "Repository: " + repositories.getJSONObject(i));
                        JSONObject jsonRepository = repositories.getJSONObject(i);

                        String fullName = jsonRepository.getString("full_name");
                        String numberOfStars = jsonRepository.getString("stargazers_count");
                        String numberOfForks = jsonRepository.getString("forks_count");

                        HashMap<String, String> repository = new HashMap<>();
                        repository.put("full_name", fullName);
                        repository.put("number_of_stars", numberOfStars);
                        repository.put("number_of_forks", numberOfForks);

                        repositoryList.add(repository);
                    }

                } catch (final JSONException e) {
                    Log.e(TAG, "Erro ao converter JSON: " + e.getMessage());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), "Erro ao converter JSON: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }


            } else {
                Log.e(TAG, "Não foi possível obter o JSON do servidor.");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), "Não foi possível obter o JSON do servidor.", Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if (pDialog.isShowing()) {
              pDialog.dismiss();
            }

            if (getActivity() != null) {
                //ListAdapter adapter = new SimpleAdapter(getActivity(), repositoryList, R.layout.repository_list_item, new String[]{"full_name", "number_of_stars", "number_of_forks"}, new int[]{R.id.full_name, R.id.number_of_stars, R.id.number_of_forks});
                //repositoriesListView.setAdapter(adapter);
                languageLayoutManager = new LinearLayoutManager(getActivity());
                languageRecyclerView.setLayoutManager(languageLayoutManager);

                languageRecyclerAdapter = new RepositoryAdapter(repositoryList);
                languageRecyclerView.setAdapter(languageRecyclerAdapter);

                languageRecyclerView.addItemDecoration(
                        new DividerItemDecoration(
                                getActivity(), DividerItemDecoration.VERTICAL
                        )
                );
            }

        }
    }
}
