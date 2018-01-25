package net.kaunghtetlin.ted.fragments;

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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

public class PodcastsFragment extends Fragment {

    @BindView(R.id.rv_podcasts)
    SmartRecyclerView rvPodcasts;

    @BindView(R.id.vp_empty_podcasts)
    EmptyViewPod vpEmptyPodcasts;

    PodcastsAdapter mPodcastsAdapter;

    public static PodcastsFragment newInstance() {
        PodcastsFragment fragment = new PodcastsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_podcasts, container, false);
        ButterKnife.bind(this, view);

        rvPodcasts.setEmptyView(vpEmptyPodcasts);
        rvPodcasts.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));

        mPodcastsAdapter = new PodcastsAdapter(getContext());
        rvPodcasts.setAdapter(mPodcastsAdapter);

        return view;
    }
}
