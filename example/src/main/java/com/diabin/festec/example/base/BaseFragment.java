package com.diabin.festec.example.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;

/**
 * 懒加载基类
 */
public abstract class BaseFragment extends Fragment {

    private View rootView;

    private static final String TAG = "BaseFragment";

    private boolean isViewCreated = false; // 用来判断视图是否创建
    private boolean currentVisibleState = false; // 当前可见状态
    private boolean isDataInitiated; // 是否加载过数据

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null){
            rootView = inflater.inflate(getLayoutRes(),container,false);
        }
        ButterKnife.bind(this, rootView);
        initView(rootView);
        isViewCreated = true;
        // 第一次启动时加载 分发事件
        if (getUserVisibleHint()){
            dispatchUserVisibleHint(true);
        }
        Log.d(TAG,"onCreateView");
        return rootView;
    }

    public void initView(View view){

    }

    protected abstract int getLayoutRes();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewCreated = true;
    }

    /**
     * 判断fragment是否可见
     * setUserVisibleHint 在Fragment创建时会先被调用一次，传入isVisibleToUser = false;
     * 如果当Fragment可见,那么setUserVisibleHint会被再次调用，传入isVisibleToUser = true;
     * 如果Fragment从可见到不可见，那么setUserVisibleHint也会被调用 传入isVisibleToUser = false;
     * 总结：setUserVisibleHint()除了Fragment的可见状态发生变化时会被回调外，在new Fragment()时也会被回调
     * 如果我们需要在 Fragment 可见与不可见时干点事，用这个的话就会有多余的回调了，那么就需要重新封装一个
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG,"setUserVisibleHint");
        // 只有在视图创建了才去分发事件，否则会报空指针
        if (isViewCreated) {
            // 如果Fragment可见则分发事件,从不可见到可见的判断
            if (isVisibleToUser == true && !currentVisibleState) {
                dispatchUserVisibleHint(true);
            } else if (isVisibleToUser == false && currentVisibleState){ // 从可见到不可见的判断
                dispatchUserVisibleHint(false);
            }
        }
    }

    /**
     * 分发事件：是否加载数据的事件
     * @param isVisible
     */
    private void dispatchUserVisibleHint(boolean isVisible){
        if (currentVisibleState == isVisible){ // 如果分发事件是相同的则返回
            return;
        }
        currentVisibleState = isVisible;
        if (isVisible){
            onFragmentLoad();
        }else {
            onFragmentLoadStop();
        }
    }

    /**
     * 子View加载数据
     */
    protected abstract void onFragmentLoad();

    /**
     * 停止加载数据
     */
    protected abstract void onFragmentLoadStop();


    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
        // 当从Activity回到这Fragment(从不可见到可见)时则分发一个true
        if(!currentVisibleState && getUserVisibleHint()){
            dispatchUserVisibleHint(true);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
        // 当Fragment跳转到Activity时Fragment生命周期进入onPause
        // 如果当前页面可见则分发
        if(currentVisibleState && getUserVisibleHint()){
            dispatchUserVisibleHint(false);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG,"onDestroyView");
        // 调用该周期时需要给所有的变量复位
        isViewCreated = false;
        currentVisibleState = false;
    }
}
