package net.kaunghtetlin.ted.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.kaunghtetlin.ted.R;
import net.kaunghtetlin.ted.adapters.TedPagerAdapter;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

public class TedPagerFragment extends Fragment {


    private TedPagerAdapter mTEDPagerAdapter;

    public static TedPagerFragment newInstance() {
        TedPagerFragment fragment = new TedPagerFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTEDPagerAdapter = new TedPagerAdapter(getActivity().getSupportFragmentManager());
        mTEDPagerAdapter.addTab(TalksFragment.newInstance(), "Talks");
        mTEDPagerAdapter.addTab(PlaylistsFragment.newInstance(), "PlayLists");
        mTEDPagerAdapter.addTab(PodcastsFragment.newInstance(), "Podcasts");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_pager_ted, container, false);

        TabLayout t1Ted=rootView.findViewById(R.id.tl_ted);
        ViewPager pagerTed=rootView.findViewById(R.id.pager_ted);

        pagerTed.setAdapter(mTEDPagerAdapter);
        pagerTed.setOffscreenPageLimit(mTEDPagerAdapter.getCount());
//        pagerTed.setOff

        t1Ted.setupWithViewPager(pagerTed);

        return rootView;
    }
}

