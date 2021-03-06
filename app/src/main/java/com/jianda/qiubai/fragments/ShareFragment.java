package com.jianda.qiubai.fragments;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.jianda.qiubai.MainActivity;
import com.jianda.qiubai.R;
import com.jianda.qiubai.adapters.ItemAdapter;
import com.jianda.qiubai.adapters.ShakeAdapter;
import com.jianda.qiubai.utils.Item;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShareFragment extends Fragment implements Callback {
    private ListView listView;
    private ItemAdapter adapter;
    private Call call;
    private List<Item> list;
    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public ShareFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_share, container, false);

        listView = (ListView)view.findViewById(R.id.qiushi_list);
        adapter = new ItemAdapter(context);
        listView.setAdapter(adapter);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://m2.qiushibaike.com/article/list/suggest?page=").get().build();
        call = client.newCall(request);
        call.enqueue(this);
        return view;
    }


    @Override
    public void onFailure(Request request, IOException e) {
        e.printStackTrace();
    }

    @Override
    public void onResponse(Response response) throws IOException {
        final String s = response.body().string();
        try {
            JSONObject object = new JSONObject(s);
            JSONArray items = object.getJSONArray("items");
            list = new ArrayList<>();
            for (int i = 0; i < items.length(); i++) {
                list.add(new Item(items.getJSONObject(i)));
            }
//            adapter.addAll(list);
            new AsyncTaskShare().execute();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onStop() {
        super.onStop();
        call.cancel();
    }

    private class AsyncTaskShare extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... params) {
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            adapter.addAll(list);
        }
    }
}
