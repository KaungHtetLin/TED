package net.kaunghtetlin.ted.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import net.kaunghtetlin.ted.R;
import net.kaunghtetlin.ted.data.vos.PodcastsVO;
import net.kaunghtetlin.ted.viewholders.PodcastsViewHolder;
import net.kaunghtetlin.ted.viewholders.TalksViewHolder;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

public class PodcastsAdapter extends BaseRecyclerAdapter<PodcastsViewHolder,PodcastsVO> {

    public PodcastsAdapter(Context context) {
        super(context);
    }

    @Override
    public PodcastsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View podcastsScreenView = mLayoutInflator.inflate(R.layout.view_items_podcasts, parent, false);
        return new PodcastsViewHolder(podcastsScreenView);
    }

    @Override
    public void onBindViewHolder(PodcastsViewHolder holder, int position) {
        //super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return 16;
    }
}
