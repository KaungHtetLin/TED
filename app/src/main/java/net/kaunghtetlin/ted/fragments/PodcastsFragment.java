package net.kaunghtetlin.ted.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.kaunghtetlin.ted.R;
import net.kaunghtetlin.ted.adapters.PodcastsAdapter;
import net.kaunghtetlin.ted.components.EmptyViewPod;
import net.kaunghtetlin.ted.components.SmartRecyclerView;
import net.kaunghtetlin.ted.data.models.PodcastsModel;
import net.kaunghtetlin.ted.data.vos.PodcastsVO;
import net.kaunghtetlin.ted.mvp.presenters.PodcastsPresenter;
import net.kaunghtetlin.ted.mvp.views.PodcastsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

public class PodcastsFragment extends Fragment implements PodcastsView{

    @BindView(R.id.rv_podcasts)
    SmartRecyclerView rvPodcasts;

    @BindView(R.id.vp_empty_podcasts)
    EmptyViewPod vpEmptyPodcasts;

    PodcastsAdapter mPodcastsAdapter;
    PodcastsModel mPodcastsModel;
    PodcastsPresenter mPodcastsPresenter;

    public static PodcastsFragment newInstance() {
        PodcastsFragment fragment = new PodcastsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_podcasts, container, false);
        ButterKnife.bind(this, view);
        mPodcastsPresenter=new PodcastsPresenter();
        mPodcastsPresenter.onCreate(this);

        rvPodcasts.setEmptyView(vpEmptyPodcasts);
        rvPodcasts.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));

        mPodcastsAdapter = new PodcastsAdapter(getContext());
        rvPodcasts.setAdapter(mPodcastsAdapter);

        mPodcastsModel = ViewModelProviders.of(this).get(PodcastsModel.class);
        mPodcastsModel.initDatabase(container.getContext());
        mPodcastsModel.getPodcastsList().observe(this, new Observer<List<PodcastsVO>>() {
            @Override
            public void onChanged(@Nullable List<PodcastsVO> podcastsVOS) {
                mPodcastsAdapter.setNewData(podcastsVOS);
            }
        });

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();

        mPodcastsPresenter = new PodcastsPresenter();
        mPodcastsPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPodcastsPresenter.onStop();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mPodcastsPresenter.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPodcastsPresenter.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPodcastsPresenter.onResume();
    }

    @Override
    public void displayPodcastsLists(List<PodcastsVO> podcastsVOS) {

    }
}
