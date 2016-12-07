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
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.DetailTipsActivity;
import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.R;
import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.adapter.TipsAdapter;
import id.sch.smktelkom_mlg.project.xiirpl203132333.dapurnusantara.model.Tips;


/**
 * Created by USER on 17/11/2016.
 */


public class TipsFragment extends Fragment implements TipsAdapter.ITipsAdapter {

    public static final String TIPS = "tips";
    ArrayList<Tips> mList = new ArrayList<>();
    TipsAdapter mAdapter;
    ArrayList<Tips> mListAll = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFilter = new ArrayList<>();
    String mQuery;

    public TipsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    private void filData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.tips);
        //String[] arDeskripsi = resources.getStringArray(R.array.place_desc);
        TypedArray a = resources.obtainTypedArray(R.array.tips_picture);
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
            mList.add(new Tips(arJudul[i], /*arDeskripsi[i] */ arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tips, container, false);


        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new TipsAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        filData();

        // Inflate the layout for this fragment
        return rootView;
    }

    private void doFilter(String query) {
        if (!isFiltered) {
            mListAll.clear();
            mListAll.addAll(mList);
            isFiltered = true;
        }
        mList.clear();
        if (query == null || query.isEmpty()) {
            mList.addAll(mListAll);
            isFiltered = false;
        } else {
            mListMapFilter.clear();
            for (int i = 0; i < mListAll.size(); i++) {
                Tips tips = mListAll.get(i);
                if (tips.judul.toLowerCase().contains(query)) {
                    mList.add(tips);
                    mListMapFilter.add(i);
                }

            }
        }
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView sv = new SearchView(((MainActivity) getActivity()).getSupportActionBar().getThemedContext());
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, sv);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mQuery = newText.toLowerCase();
                doFilter(mQuery);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case R.id.action_search:
                // Do Activity menu item stuff here
                return true;


            default:
                break;
        }
        return false;
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
        Intent intent = new Intent(getActivity(), DetailTipsActivity.class);
        intent.putExtra(TIPS, mList.get(pos));
        startActivity(intent);

    }
}