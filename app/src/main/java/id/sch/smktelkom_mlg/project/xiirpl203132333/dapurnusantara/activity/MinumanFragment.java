package id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.DetailMinumanActivity;
import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.R;
import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.adapter.MinumanAdapter;
import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.model.Minuman;


/**
 * Created by USER on 17/11/2016.
 */


public class MinumanFragment extends Fragment implements MinumanAdapter.IMinumanAdapter {

    public static final String MINUMAN = "minuman";
    ArrayList<Minuman> mList = new ArrayList<>();
    MinumanAdapter mAdapter;
    ArrayList<Minuman> mListAll = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFilter = new ArrayList<>();
    String mQuery;

    public MinumanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    private void filData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.minuman);
        //String[] arLokasi = resources.getStringArray(R.array.place_locations);
        // String[] arDeskripsi = resources.getStringArray(R.array.place_desc);
        TypedArray a = resources.obtainTypedArray(R.array.minuman_picture);
        String[] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            BitmapDrawable bd = (BitmapDrawable) a.getDrawable(i);
            RoundedBitmapDrawable rbd =
                    RoundedBitmapDrawableFactory.create(getResources(), bd.getBitmap());
            rbd.setCircular(true);
            int id = a.getResourceId(i, 0);
            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + resources.getResourcePackageName(id) + '/'
                    + resources.getResourceTypeName(id) + '/'
                    + resources.getResourceEntryName(id);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Minuman(arJudul[i], /*arDeskripsi[i] , arLokasi[i],*/ arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_minuman, container, false);


        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MinumanAdapter(this, mList);
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

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(getActivity(), DetailMinumanActivity.class);
        intent.putExtra(MINUMAN, mList.get(pos));
        startActivity(intent);
    }
}