package net.kaunghtetlin.ted.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.kaunghtetlin.ted.R;
import net.kaunghtetlin.ted.adapters.PlaylistsAdapter;
import net.kaunghtetlin.ted.components.EmptyViewPod;
import net.kaunghtetlin.ted.components.SmartRecyclerView;
import net.kaunghtetlin.ted.data.models.PlayListsModel;
import net.kaunghtetlin.ted.data.vos.PlaylistsVO;
import net.kaunghtetlin.ted.mvp.presenters.PlaylistsPresenter;
import net.kaunghtetlin.ted.mvp.views.PlaylistsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

public class PlaylistsFragment extends Fragment implements PlaylistsView {

    @BindView(R.id.rv_playlists)
    SmartRecyclerView rvPlaylists;

    @BindView(R.id.vp_empty_playlists)
    EmptyViewPod vpEmptyPlaylists;

    PlaylistsAdapter mPlaylistsAdapter;
    PlayListsModel mPlaylistModel;

    PlaylistsPresenter mPlaylistsPresenter;

    public static PlaylistsFragment newInstance() {
        PlaylistsFragment fragment = new PlaylistsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playlists, container, false);
        ButterKnife.bind(this, view);
        mPlaylistsPresenter = new PlaylistsPresenter();
        mPlaylistsPresenter.onCreate(this);

        rvPlaylists.setEmptyView(vpEmptyPlaylists);
        rvPlaylists.setLayoutManager(new GridLayoutManager(getContext(), 2));
//        rvPlaylists.setLayoutManager(new LinearLayoutManager(getContext(),
//                LinearLayoutManager.VERTICAL, false));

        mPlaylistsAdapter = new PlaylistsAdapter(getContext());
        rvPlaylists.setAdapter(mPlaylistsAdapter);

        mPlaylistModel = ViewModelProviders.of(this).get(PlayListsModel.class);
        mPlaylistModel.initDatabase(container.getContext());
        mPlaylistModel.getPlayLists().observe(this, new Observer<List<PlaylistsVO>>() {
            @Override
            public void onChanged(@Nullable List<PlaylistsVO> playlistsVOS) {
                mPlaylistsAdapter.setNewData(playlistsVOS);
            }
        });

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        mPlaylistsPresenter = new PlaylistsPresenter();
        mPlaylistsPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPlaylistsPresenter.onStop();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlaylistsPresenter.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPlaylistsPresenter.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPlaylistsPresenter.onResume();
    }


    @Override
    public void displayPlayLists(List<PlaylistsVO> playlistsVOS) {

    }
}
