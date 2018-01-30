package net.kaunghtetlin.ted.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.kaunghtetlin.ted.R;
import net.kaunghtetlin.ted.data.vos.TalksVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

public class TalksViewHolder extends BaseViewHolder<TalksVO> {

    @BindView(R.id.tv_talks_title)
    TextView tvTalksTitle;

    @BindView(R.id.tv_talks_speaker_name)
    TextView tvTalksSpeakerName;

    @BindView(R.id.iv_talks)
    ImageView ivTalks;

    @BindView(R.id.tv_talks_time)
    TextView tvTalksTime;

    private TalksVO mTalks;

    public TalksViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    @Override
    public void setData(TalksVO data) {
        mTalks =data;
    }

    @Override
    public void bind(Context context) {
        if(mTalks !=null){
            tvTalksTitle.setText(mTalks.getTitle());
            tvTalksSpeakerName.setText(mTalks.getSpeaker().getSpeakerName());

            int mins= mTalks.getDuriationInSec()/60;
            int sec=mTalks.getDuriationInSec()%60;

            tvTalksTime.setText(""+mins+":"+sec);

            if (mTalks.getImageUrl() != null) {
                Glide.with(context)
                        .load(mTalks.getImageUrl())
                        .into(ivTalks);
            }
        }
    }
}
