package com.example.sunxiaodong.immersivesystemui.immersive;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sunxiaodong.immersivesystemui.DividerItemDecoration;
import com.example.sunxiaodong.immersivesystemui.R;
import com.example.sunxiaodong.immersivesystemui.util.ScreenUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunxiaodong on 16/7/11.
 */
public class ImmersiveActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TestAdapter mTestAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersive);
//        MDStatusBarCompat.setImageTransparent(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setBackgroundColor(Color.parseColor("#45BCFF"));

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.parseColor("#E6E6E6"));
        drawable.setSize(ScreenUtil.getScreenW(this), 1);
        itemDecoration.setDividerDrawable(drawable);
        mRecyclerView.addItemDecoration(itemDecoration);

        mTestAdapter = new TestAdapter();
        mRecyclerView.setAdapter(mTestAdapter);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i + "");
        }
        mTestAdapter.update(list);
    }

    class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<String> mList = new ArrayList<>();

        public void update(List<String> list) {
            mList.clear();
            mList.addAll(list);
            notifyDataSetChanged();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            RecyclerView.ViewHolder holder = null;
            TextView itemText = new TextView(context);
            ViewGroup.LayoutParams itemTextParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 240);
            itemText.setLayoutParams(itemTextParams);
            itemText.setIncludeFontPadding(false);
            itemText.setTextSize(TypedValue.COMPLEX_UNIT_PX, 54);
            itemText.setTextColor(Color.parseColor("#878787"));
            itemText.setGravity(Gravity.CENTER);
            holder = new ItemViewHolder(itemText);
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ItemViewHolder)holder).textView.setText(mList.get(position));
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class ItemViewHolder extends RecyclerView.ViewHolder {

            public TextView textView;

            public ItemViewHolder(TextView itemView) {
                super(itemView);
                textView = itemView;
            }

        }

    }

}
