package com.example.aadpracticeproject;

import android.app.DownloadManager;
import android.os.Bundle;
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
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SkilliqFragment extends Fragment {
    private static String url = "https://gadsapi.herokuapp.com/api/skilliq";
    List<TopIQ> mTopIQS;
    private RecyclerView mTopIQRecyclerList;
    private TopIqFragmentRecyclerAdapter mTopIqFragmentRecyclerAdapter;
    private LinearLayoutManager mTopIQLinearLayoutManager;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.fragment_skilliq, container, false);

        mTopIQS = new ArrayList<>();

        getIQLearners(root);
        mTopIQRecyclerList = root.findViewById(R.id.top_iq_lists);
        mTopIQLinearLayoutManager = new LinearLayoutManager(getContext());


        return root;
    }

    private void getIQLearners(View root) {
        RequestQueue queue = Volley.newRequestQueue(root.getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject iqlearners = response.getJSONObject(i);

                        TopIQ topIQ = new TopIQ();
                        topIQ.setName(iqlearners.getString("name").toString());
                        topIQ.setHours(iqlearners.getInt("score"));
                        topIQ.setCountry(iqlearners.getString("country").toString());

                        mTopIQS.add(topIQ);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    mTopIQRecyclerList.setLayoutManager(mTopIQLinearLayoutManager);

                    mTopIqFragmentRecyclerAdapter = new TopIqFragmentRecyclerAdapter(getContext(),mTopIQS);
                    mTopIQRecyclerList.setAdapter(mTopIqFragmentRecyclerAdapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(jsonArrayRequest);
    }


}