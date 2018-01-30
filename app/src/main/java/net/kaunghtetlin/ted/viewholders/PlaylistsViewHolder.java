package net.kaunghtetlin.ted.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.kaunghtetlin.ted.R;
import net.kaunghtetlin.ted.data.vos.PlaylistsVO;
import net.kaunghtetlin.ted.data.vos.TalksVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

public class PlaylistsViewHolder extends BaseViewHolder<PlaylistsVO> {

    @BindView(R.id.tv_playlists_title)
    TextView tvPlayListTitle;

    @BindView(R.id.tv_playlists_talk_count)
    TextView tvPlayListTalkCount;

    @BindView(R.id.tv_playlists_time)
    TextView tvPlayListsTime;

    @BindView(R.id.iv_playlists)
    ImageView ivPlaylists;

    private PlaylistsVO mPlaylists;

    public PlaylistsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    @Override
    public void setData(PlaylistsVO data) {
        mPlaylists = data;
    }

    @Override
    public void bind(Context context) {
        if (mPlaylists != null) {
            tvPlayListTitle.setText(mPlaylists.getTitle());
            tvPlayListTalkCount.setText(""+mPlaylists.getTotalTalks()+" Talks");

            int totalSec = 0;

            for (TalksVO talks : mPlaylists.getTalksInPlayList()) {
                totalSec+=talks.getDuriationInSec();
            }

            int hours= totalSec/3600;
            int mins = (totalSec%3600)/60;
            int sec  = (totalSec%3600)%60;

            tvPlayListsTime.setText(""+hours+":"+mins+":"+sec);

            if (mPlaylists.getImageUrl() != null) {
                Glide.with(context)
                        .load(mPlaylists.getImageUrl())
                        .into(ivPlaylists);
            }
        }
    }
}
