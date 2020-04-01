package com.diabin.festec.example.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.diabin.festec.example.R;
import com.diabin.festec.example.adapter.RecommendedAdapter;
import com.diabin.festec.example.api.PersonalProtocol;
import com.diabin.festec.example.base.BaseFragment;
import com.diabin.festec.example.bean.BaseBean;
import com.diabin.festec.example.bean.CarouselBean;
import com.diabin.festec.example.bean.HomeCategoryBean;
import com.diabin.festec.example.bean.RecommendedBean;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecommendedFragment extends BaseFragment {

    @BindView(R.id.recommendedRlv)
    RecyclerView recommendedRlv;
    @BindView(R.id.recommendedSrl)
    SwipeRefreshLayout recommendedSrl;

    private HomeCategoryBean bean;

    private List<HomeCategoryBean.PageInfoBean.ListBean> pageInfoBeans;

    private RecommendedAdapter recommendedAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    private static final String TAG = "RecommendedFragment";

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_recommended;
    }

    @Override
    protected void onFragmentLoad() {
        HomeCategoryBean.PageInfoBean.ListBean listBean = new HomeCategoryBean.PageInfoBean.ListBean();
        listBean.type = 0;
        recommendedSrl.setOnRefreshListener(() -> recommendedSrl.post(() -> {
            recommendedSrl.setRefreshing(true);
            iniData();
//            iniDataTwo();
        }));
    }

    @Override
    protected void onFragmentLoadStop() {
        recommendedSrl.setRefreshing(false);
    }

    private void iniData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://front.video.zhangdanling.cn/front/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        PersonalProtocol personalProtocol = retrofit.create(PersonalProtocol.class);
        Call<BaseBean<HomeCategoryBean>> call = personalProtocol.homeData(2, "", 10, 10);
        call.enqueue(new Callback<BaseBean<HomeCategoryBean>>() {
            @Override
            public void onResponse(Call<BaseBean<HomeCategoryBean>> call, Response<BaseBean<HomeCategoryBean>> response) {
                //数据请求成功
                recommendedSrl.setRefreshing(false);
                if (response.body() != null) {
                    initRecycler(response);
                    Toast.makeText(getContext(), "请求成功", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BaseBean<HomeCategoryBean>> call, Throwable t) {
                //数据请求失败
                recommendedSrl.setRefreshing(false);
                Log.d(TAG, t.getMessage());
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecycler(Response<BaseBean<HomeCategoryBean>> response) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recommendedRlv.setLayoutManager(linearLayoutManager);
        pageInfoBeans = response.body().getResult().getPageInfo().getList();
        recommendedAdapter = new RecommendedAdapter(getContext(),pageInfoBeans);
        recommendedRlv.setAdapter(recommendedAdapter);
        recommendedAdapter.notifyDataSetChanged();
    }


//    private void iniDataTwo() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://front.video.zhangdanling.cn/front/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//
//        PersonalProtocol personalProtocol = retrofit.create(PersonalProtocol.class);
//        Call<BaseBean<HomeCategoryBean>> call = personalProtocol.homeData(1, "", 10, 10);
//        call.enqueue(new Callback<BaseBean<HomeCategoryBean>>() {
//            @Override
//            public void onResponse(Call<BaseBean<HomeCategoryBean>> call, Response<BaseBean<HomeCategoryBean>> response) {
//                //数据请求成功
//                recommendedSrl.setRefreshing(false);
//                if (response.body().getResult() != null) {
//                    for (int i = 0; i < response.body().getResult().getPageInfo().getList().size(); i++) {
//                        Log.d(TAG, String.valueOf(response.body().getResult().getPageInfo().getList().get(i).getTitle()));
//                        Log.d(TAG, String.valueOf(response.body().getResult().getPageInfo().getList().get(i).getIconPath()));
//                    }
//                    initRecycler(response);
//                }
//                Toast.makeText(getContext(), "请求成功", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<BaseBean<HomeCategoryBean>> call, Throwable t) {
//                //数据请求失败
//                recommendedSrl.setRefreshing(false);
//                Log.d(TAG, t.getMessage());
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

}
