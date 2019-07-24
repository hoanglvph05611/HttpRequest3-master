package com.d.httprequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.d.httprequest.adapter.PostAdapter;
import com.d.httprequest.model.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private PostAdapter mPostAdapter;
    private ArrayList<Post>  mPostList;
  //  private RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPostList = new ArrayList<>();
       // mRequestQueue = Volley.newRequestQueue(this);
//        parseJSON();
    }
    public void httpGet(View view) {

        mPostAdapter = new PostAdapter(MainActivity.this,mPostList);
        mRecyclerView.setAdapter(mPostAdapter);

        HttpGetTask httpGetTask = new HttpGetTask(new HttpGetTask.IDone() {
            @Override
            public void done(List<Post> a) {
                mPostList.addAll(a);
                mPostAdapter.notifyDataSetChanged();
            }
        });

        httpGetTask.execute("http://asian.dotplays.com/wp-json/wp/v2/posts");



    }
//    private void parseJSON() {
//        String url = "http://asian.dotplays.com/wp-json/wp/v2/posts";
//
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            JSONArray jsonArray = new JSONArray(response);
//
//
//                            for (int i = 0; i < jsonArray.length(); i++) {
//
//                                JSONObject post = jsonArray.getJSONObject(i);
//
//                                int mId = post.getInt("id");
//                                Log.e("id", String.valueOf(mId));
//                                String mDate = post.getString("date");
//                                Log.e("date", mDate);
//                                JSONObject title = post.getJSONObject("title");
//                                String redered = title.getString("rendered");
//                                Log.e("readered", redered);
//
//                                mPostList.add(new Post(mId, mDate, redered));
//                            }
//
//                            mPostAdapter = new PostAdapter(MainActivity.this, mPostList);
//                            mRecyclerView.setAdapter(mPostAdapter);
//                         //   mPostAdapter.setOnItemClickListener(MainActivity.this);
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//
//        mRequestQueue.add(request);
//    }



//    public void httpPost(View view) {
//
//        HttpPostTask httpPostTask = new HttpPostTask();
//
//        httpPostTask.equals("http://dev.parduota.com/api/search/");
//
//    }
}
