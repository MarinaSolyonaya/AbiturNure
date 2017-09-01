package com.example.marina.abiturnure.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marina.abiturnure.R;

/**
 * Created by Marina on 31.08.2017.
 */

public class BlogFragment extends AbstractTabFragment{

    private static final int LAYOUT = R.layout.fragment_example;
    private static final int TITLE = R.string.tab_item_blog;


    public void setContext(Context context) {
        this.context = context;
    }

    public  static BlogFragment getInstance(Context context){
        Bundle args = new Bundle();
        BlogFragment fragment = new BlogFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_blog));
        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container,false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
