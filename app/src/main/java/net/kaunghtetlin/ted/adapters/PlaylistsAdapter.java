package net.kaunghtetlin.ted.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import net.kaunghtetlin.ted.R;
import net.kaunghtetlin.ted.data.vos.PlaylistsVO;
import net.kaunghtetlin.ted.viewholders.PlaylistsViewHolder;
import net.kaunghtetlin.ted.viewholders.TalksViewHolder;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

public class PlaylistsAdapter extends BaseRecyclerAdapter<PlaylistsViewHolder,PlaylistsVO> {

    public PlaylistsAdapter(Context context) {
        super(context);
    }

    @Override
    public PlaylistsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View playlistsScreenView = mLayoutInflator.inflate(R.layout.view_item_playlists, parent, false);
        return new PlaylistsViewHolder(playlistsScreenView);
    }

    @Override
    public void onBindViewHolder(PlaylistsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 16;
    }
}
