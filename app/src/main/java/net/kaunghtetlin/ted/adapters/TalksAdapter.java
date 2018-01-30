package net.kaunghtetlin.ted.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import net.kaunghtetlin.ted.R;
import net.kaunghtetlin.ted.data.vos.TalksVO;
import net.kaunghtetlin.ted.viewholders.TalksViewHolder;

/**
 * Created by Kaung Htet Lin on 1/24/2018.
 */

public class TalksAdapter extends BaseRecyclerAdapter<TalksViewHolder,TalksVO> {

    public TalksAdapter(Context context) {
        super(context);
    }

    @Override
    public TalksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View talksScreenView = mLayoutInflator.inflate(R.layout.view_item_talks, parent, false);
        return new TalksViewHolder(talksScreenView);
    }
}
