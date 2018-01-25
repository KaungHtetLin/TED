package net.kaunghtetlin.ted.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.kaunghtetlin.ted.R;
import net.kaunghtetlin.ted.adapters.PlaylistsAdapter;
import net.kaunghtetlin.ted.components.EmptyViewPod;
import net.kaunghtetlin.ted.components.SmartRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

public class PlaylistsFragment extends Fragment {

    @BindView(R.id.rv_playlists)
    SmartRecyclerView rvPlaylists;

    @BindView(R.id.vp_empty_playlists)
    EmptyViewPod vpEmptyPlaylists;

    PlaylistsAdapter mPlaylistsAdapter;

    public static PlaylistsFragment newInstance() {
        PlaylistsFragment fragment = new PlaylistsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playlists, container, false);
        ButterKnife.bind(this, view);

        rvPlaylists.setEmptyView(vpEmptyPlaylists);
        rvPlaylists.setLayoutManager(new GridLayoutManager(getContext(),2));
//        rvPlaylists.setLayoutManager(new LinearLayoutManager(getContext(),
//                LinearLayoutManager.VERTICAL, false));

        mPlaylistsAdapter = new PlaylistsAdapter(getContext());
        rvPlaylists.setAdapter(mPlaylistsAdapter);

        return view;
    }
}
