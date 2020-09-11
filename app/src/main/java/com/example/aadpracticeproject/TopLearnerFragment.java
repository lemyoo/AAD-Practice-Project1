package com.example.aadpracticeproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TopLearnerFragment extends Fragment {
    private static String url = "https://gadsapi.herokuapp.com/api/hours";
    List<TopLearners> mTopLearners;
    private RecyclerView mTopLearnerRecyclerList;
    private LinearLayoutManager mTopLearnerLinearLayoutManager;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_toplearner, container, false);

        mTopLearners = new ArrayList<>();
        getLearners(root);


        mTopLearnerRecyclerList = root.findViewById(R.id.top_learner_lists);
        mTopLearnerLinearLayoutManager = new LinearLayoutManager(getContext());


        return root;
    }

    private void getLearners(View root) {
        RequestQueue queue = Volley.newRequestQueue(root.getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject learners = response.getJSONObject(i);

                        TopLearners topLearners = new TopLearners();
                        topLearners.setName(learners.getString("name").toString());
                        topLearners.setHours(learners.getInt("hours"));
                        topLearners.setCountry(learners.getString("country").toString());

                        mTopLearners.add(topLearners);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    mTopLearnerRecyclerList.setLayoutManager(mTopLearnerLinearLayoutManager);

                    TopLearnerFragmentRecyclerAdapter topLearnerFragmentRecyclerAdapter = new TopLearnerFragmentRecyclerAdapter(getContext(),mTopLearners);
                    mTopLearnerRecyclerList.setAdapter(topLearnerFragmentRecyclerAdapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("TAG", "onErrorResponse: "+error);
            }
        });
        queue.add(jsonArrayRequest);
    }


}