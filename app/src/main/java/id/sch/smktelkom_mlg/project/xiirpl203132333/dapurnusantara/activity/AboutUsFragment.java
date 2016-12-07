package id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.R;
import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.adapter.AboutAdapter;
import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.model.About;


/**
 * Created by USER on 17/11/2016.
 */


public class AboutUsFragment extends Fragment {


    ArrayList<About> mList = new ArrayList<>();
    AboutAdapter mAdapter;

    public AboutUsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    private void filData() {
        Resources resources = getResources();
        String[] arNama = resources.getStringArray(R.array.nama);
        String[] arAbsen = resources.getStringArray(R.array.absen);
        //  TypedArray a = resources.obtainTypedArray(R.array.tips_picture);
        // String[] arFoto = new String[a.length()];
        for (int i = 0; i < arNama.length; i++) {
            mList.add(new About(arNama[i], arAbsen[i]));
        }
        mAdapter.notifyDataSetChanged();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_aboutus, container, false);


        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AboutAdapter(mList);
        recyclerView.setAdapter(mAdapter);

        filData();

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}