package com.diabin.festec.example.fragment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.diabin.festec.example.R;
import com.diabin.festec.example.base.BaseFragment;

import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MainFragment extends BaseFragment {

    private TextView tvName;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public void initView(View view) {
        tvName = view.findViewById(R.id.mainFragmentTv);
        swipeRefreshLayout = view.findViewById(R.id.mainFragmentSrl);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_main;
    }

    @Override
    protected void onFragmentLoad() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                tvName.setVisibility(View.VISIBLE);
                if (tvName.getVisibility()==View.VISIBLE){
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });
    }

    @Override
    protected void onFragmentLoadStop() {
        tvName.setVisibility(View.GONE);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}
