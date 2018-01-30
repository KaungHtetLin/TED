package net.kaunghtetlin.ted.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
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
import net.kaunghtetlin.ted.data.models.TalksModel;
import net.kaunghtetlin.ted.data.vos.TalksVO;
import net.kaunghtetlin.ted.mvp.presenters.TalksPresenter;
import net.kaunghtetlin.ted.mvp.views.TalksView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

public class TalksFragment extends Fragment implements TalksView{

    @BindView(R.id.rv_talks)
    SmartRecyclerView rvTalks;

    @BindView(R.id.vp_empty_talks)
    EmptyViewPod vpEmptyTalks;

    TalksAdapter mTalksAdapter;
    TalksModel mTalksModel;
    TalksPresenter mTalksPresenter;

    public static TalksFragment newInstance() {
        TalksFragment fragment = new TalksFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_talks, container, false);
        ButterKnife.bind(this, view);
        mTalksPresenter=new TalksPresenter();
        mTalksPresenter.onCreate(this);

        rvTalks.setEmptyView(vpEmptyTalks);
        rvTalks.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));

        mTalksAdapter = new TalksAdapter(getContext());
        rvTalks.setAdapter(mTalksAdapter);

        mTalksModel = ViewModelProviders.of(this).get(TalksModel.class);
        mTalksModel.initDatabase(container.getContext());
        mTalksModel.getTalks().observe(this, new Observer<List<TalksVO>>() {
            @Override
            public void onChanged(@Nullable List<TalksVO> talksVOs) {
                mTalksAdapter.setNewData(talksVOs);
            }
        });

/*

        mSmartScrollListener = new SmartScrollListener(new SmartScrollListener.OnSmartScrollListener() {
            @Override
            public void onListEndReach() {
                Snackbar.make(rvTalks, "Loading News Data.", Snackbar.LENGTH_LONG).show();
                swipeRefreshLayout.setRefreshing(true);
//                MovieModel.getObjInstance().loadMoreMovies(getContext());
                mPlaylistsPresenter.onMovieListEndReach(getContext());
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                MovieModel.getObjInstance().forceRefresMovie(getContext());
                mPlaylistsPresenter.onForceRefresh(getContext());
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
//        mTalksPresenter = new TalksPresenter();
        mTalksPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mTalksPresenter.onStop();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mTalksPresenter.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mTalksPresenter.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mTalksPresenter.onResume();
    }

    @Override
    public void displayTalksLists(List<TalksVO> talksVOS) {

    }
}
