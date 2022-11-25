package com.molynew.ridespark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
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

public class MainActivity extends AppCompatActivity {
    List<Ride> rides = new ArrayList<>();
    private static final int MY_SOCKET_TIMEOUT_MS = 9000;
    private RecyclerView recyclerView;
    private RideRecyclerViewAdapter RideRecyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.ride_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        getRides();
    }

    void getRides(){
        String url = "https://ridespark.cf/api/rides";
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest
                jsonArrayRequest
                = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response)
                    {
                        // creating a new json object and
                        // getting each object from our json array.
                        for (int i = 0; i < response.length(); i++) {

                            try {
                                // we are getting each json object.
                                JSONObject responseObj = response.getJSONObject(i);
                                String id = responseObj.getString("_id");
                                String route=responseObj.getString("route");
                                String destination=responseObj.getString("destination");
                                String meetingPoint=responseObj.getString("meeting_point");
                                String date=responseObj.getString("date");
                                String time= responseObj.getString("time");
                                String status=responseObj.getString("status");
                                String user=responseObj.getString("user");
                                String createdAt=responseObj.getString("created_at");
                                String updateAt=responseObj.getString("updated_at");

                                rides.add(new Ride(id,route,destination,meetingPoint,date,time,status,user,createdAt,updateAt));

                            } catch (JSONException e) {
                                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                                e.printStackTrace();

                            }
                        }
                        RideRecyclerViewAdapter = new RideRecyclerViewAdapter(rides,MainActivity.this);
                        recyclerView.setAdapter(RideRecyclerViewAdapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                        Log.e("error", "onErrorResponse: "+error.toString());
                    }
                });


        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(jsonArrayRequest);
    }
}