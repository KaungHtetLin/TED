package net.kaunghtetlin.ted.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.kaunghtetlin.ted.R;
import net.kaunghtetlin.ted.data.vos.PodcastsVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

public class PodcastsViewHolder extends BaseViewHolder<PodcastsVO> {

    @BindView(R.id.iv_podcasts)
    ImageView ivPodcasts;

    @BindView(R.id.tv_podcasts_title)
    TextView tvPodcastsTitle;

    @BindView(R.id.tv_podcasts_details)
    TextView tvPodcastsDetails;

    private PodcastsVO mPodcasts;

    public PodcastsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(PodcastsVO data) {
        mPodcasts=data;
    }

    @Override
    public void bind(Context context) {
        if(mPodcasts!=null){
            tvPodcastsTitle.setText(mPodcasts.getTitle());

            tvPodcastsDetails.setText(mPodcasts.getDescription());

            Glide.with(context)
                    .load(mPodcasts.getImageUrl())
                    .into(ivPodcasts);
        }
    }
}
