package net.kaunghtetlin.ted.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.kaunghtetlin.ted.R;
import net.kaunghtetlin.ted.adapters.TalksAdapter;
import net.kaunghtetlin.ted.components.EmptyViewPod;
import net.kaunghtetlin.ted.components.SmartRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

public class TalksFragment extends Fragment {

    @BindView(R.id.rv_talks)
    SmartRecyclerView rvTalks;

    @BindView(R.id.vp_empty_talks)
    EmptyViewPod vpEmptyTalks;

    TalksAdapter mTalksAdapter;

    public static TalksFragment newInstance() {
        TalksFragment fragment = new TalksFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_talks, container, false);
        ButterKnife.bind(this, view);

        rvTalks.setEmptyView(vpEmptyTalks);
        rvTalks.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));

        mTalksAdapter = new TalksAdapter(getContext());
        rvTalks.setAdapter(mTalksAdapter);
/*

        mSmartScrollListener = new SmartScrollListener(new SmartScrollListener.OnSmartScrollListener() {
            @Override
            public void onListEndReach() {
                Snackbar.make(rvTalks, "Loading News Data.", Snackbar.LENGTH_LONG).show();
                swipeRefreshLayout.setRefreshing(true);
//                MovieModel.getObjInstance().loadMoreMovies(getContext());
                mPresenter.onMovieListEndReach(getContext());
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                MovieModel.getObjInstance().forceRefresMovie(getContext());
                mPresenter.onForceRefresh(getContext());
            }
        });

        rvTalks.addOnScrollListener(mSmartScrollListener);
*/

        /*rvNews.setEmptyView(vpEmptyNews);
        rvNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
        newsAdapter = new NewsAdapter(getApplicationContext(), this);
        rvNews.setAdapter(newsAdapter);
*/
        return view;
    }
}
