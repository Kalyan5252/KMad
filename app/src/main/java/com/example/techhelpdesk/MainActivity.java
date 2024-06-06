package com.example.techhelpdesk;

import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class MainActivity extends AppCompatActivity {
    TextView data;
    private RequestQueue requestQueue;

//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("https://your-api-base-url/") // Replace with your base URL
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//    ApiService apiService = retrofit.create(ApiService.class);

//    MyData data1 = new MyData("value1", "value2");
//    Call<ResponseBody> call = apiService.postData(data1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = findViewById(R.id.trail);
        // Get the RequestQueue instance
        requestQueue = Volley.newRequestQueue(this);

        // Define the API endpoint URL
        String url = "https://madapi-psi.vercel.app/api/users"; // Replace with your actual API URL

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("key1", "value1");
            jsonObject.put("key2", "value2");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        // Create a JsonObjectRequest for GET request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @OptIn(markerClass = UnstableApi.class) @Override
                    public void onResponse(JSONObject response) {
                        // Handle successful response
                        try {
                            // Parse the JSON response
//                            int totalProducts = response.getInt("totalProducts");
//                            Log.d("Total Products", String.valueOf(totalProducts));
//
//                            JSONArray productsArray = response.getJSONArray("products");
//
//                            // Assuming there's at least one product (check if productsArray.length() > 0 for safety)
//                            JSONObject firstProduct = productsArray.getJSONObject(0);
//                            JSONObject user = response.getJSONObject("user");
                            String message = response.getString("message");
                            Log.d("MEssage is:",message);
//                            Log.d
                            // Extract product name
//                            String userName = user.getString("userName");
//                            Log.d("User Name", userName);
//                            data.setText(userName);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            // Handle JSON parsing error
                        }
                    }
                },
                new Response.ErrorListener() {
                    @OptIn(markerClass = UnstableApi.class) @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle API call error
                        Log.e("API Error", error.getMessage());
                    }
                }
        );

        // Add the request to the queue
        requestQueue.add(jsonObjectRequest);
    }
}