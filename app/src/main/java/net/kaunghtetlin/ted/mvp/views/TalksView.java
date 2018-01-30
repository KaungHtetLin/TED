package net.kaunghtetlin.ted.mvp.views;

import net.kaunghtetlin.ted.data.vos.TalksVO;

import java.util.List;

/**
 * Created by Kaung Htet Lin on 1/27/2018.
 */

public interface TalksView {
    void displayTalksLists(List<TalksVO> talksVOS);
}
