package com.example.marina.abiturnure.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Marina on 01.09.2017.
 */

public class AbstractTabFragment extends Fragment {

    private String title;
    protected View view;
    protected Context context;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
