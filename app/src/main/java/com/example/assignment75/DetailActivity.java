package com.example.assignment75;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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

import static com.example.assignment75.MainActivity.USR_ID;

public class DetailActivity extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private ArrayList<ContentsOfUser> mDetailList;
    private RecyclerView mRecyclerView;
    private ContentsOfUserAdapter mExampleAdapter;
    private String getIdIntent;
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.detail_activity);
        
        mRecyclerView = findViewById(R.id.recycle_view_content);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mDetailList= new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        Intent iin = getIntent();
        getIdIntent = iin.getStringExtra(USR_ID);
        System.out.println(getIdIntent);
        parseJSon();
    }

    private void parseJSon()  {
        String url = "https://jsonplaceholder.typicode.com/posts?userId=" + getIdIntent;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {

                    for(int i = 0; i<response.length();i++) {
                        JSONObject jr = response.getJSONObject(i);
                        String userName = jr.getString("title");
                        String email = jr.getString("body");

                        mDetailList.add(new ContentsOfUser(getIdIntent, userName, email));
                    }
                    mExampleAdapter = new ContentsOfUserAdapter(DetailActivity.this, mDetailList);
                    mRecyclerView.setAdapter(mExampleAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mRequestQueue.add(request);

    }


}
