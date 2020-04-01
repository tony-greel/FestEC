package com.diabin.festec.example.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diabin.festec.example.R;
import com.diabin.festec.example.base.BaseFragment;

public class MyFragment extends BaseFragment {



    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_my;
    }

    @Override
    protected void onFragmentLoad() {

    }

    @Override
    protected void onFragmentLoadStop() {

    }
}
