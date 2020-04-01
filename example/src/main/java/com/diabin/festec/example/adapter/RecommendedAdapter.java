package com.diabin.festec.example.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.diabin.festec.example.R;
import com.diabin.festec.example.bean.CarouselBean;
import com.diabin.festec.example.bean.HomeCategoryBean;
import com.diabin.festec.example.bean.RecommendedBean;
import com.diabin.festec.example.utils.BannerUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecommendedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    private List<HomeCategoryBean.PageInfoBean.ListBean> mlist;//adapter的数据源

    private Context mContext;

    public RecommendedAdapter(Context context, List<HomeCategoryBean.PageInfoBean.ListBean> mlist) {
        this.mContext = context;
        this.mlist = mlist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new CarouselViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_carousel, parent, false));
        } else {
            return new ClassificationViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recommended, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ClassificationViewHolder) {
            ((ClassificationViewHolder) holder).textView.setText(mlist.get(position).getTitle());
            ((ClassificationViewHolder) holder).textView.setOnClickListener(view ->
                    Toast.makeText(mContext, "1", Toast.LENGTH_SHORT).show());

            for (int i = 0; i < mlist.size(); i++) {
                Log.d("TAG--+", mlist.get(i).getTitle());
            }

            Log.d("TAG---", mlist.get(position).getTitle());
        } else if (holder instanceof CarouselViewHolder) {
            list_path = new ArrayList<>();
            list_title = new ArrayList<>();
            for (int i = 0; i < mlist.size(); i++) {
                list_title.add(mlist.get(i).getTitle());
                list_path.add(mlist.get(i).getIconPath());
            }
            ((CarouselViewHolder) holder).homeBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                    .setImageLoader(new BannerUtils())
                    .setBannerTitles(list_title)
                    .setImages(list_path)
                    .setDelayTime(3000)
                    .isAutoPlay(true)
                    .setIndicatorGravity(BannerConfig.CENTER)
                    .start();
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();

    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return 1;
        }else{
            //position 》0就是轮播图了，你在这里改啊你这里有几个数据啊
            return 0;
        }
    }

    public class ClassificationViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        private final View mView;

        public ClassificationViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            textView = itemView.findViewById(R.id.itemTvName);

        }
    }

    public class CarouselViewHolder extends RecyclerView.ViewHolder {
        Banner homeBanner;
        private final View mView;

        public CarouselViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            homeBanner = itemView.findViewById(R.id.home_banner);

        }
    }
}
