package net.kaunghtetlin.ted.mvp.views;

import net.kaunghtetlin.ted.data.vos.PlaylistsVO;

import java.util.List;

/**
 * Created by Kaung Htet Lin on 1/27/2018.
 */

public interface PlaylistsView {
    void displayPlayLists(List<PlaylistsVO> playlistsVOS);
}
