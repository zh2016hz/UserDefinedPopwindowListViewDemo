package com.example.z.userdefinepopwindowlistdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private MyView mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgress = (MyView) findViewById(R.id.progress);
        handle();
    }

    private void handle() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    for (int i = 0; i < 100; i++) {
                        Thread.sleep(200);
                        mProgress.setProgress(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
/*
package com.itheima26.view1;

        import java.util.ArrayList;
        import java.util.List;

        import com.itheima26.view1.MainActivity.ViewHolder;

        import android.content.Context;
        import android.graphics.drawable.ColorDrawable;
        import android.util.AttributeSet;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.View.OnClickListener;
        import android.widget.AdapterView;
        import android.widget.BaseAdapter;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.PopupWindow;
        import android.widget.RelativeLayout;
        import android.widget.TextView;
        import android.widget.AdapterView.OnItemClickListener;

public class SpinnerView extends RelativeLayout {

    private ImageView mArrow;
    private EditText mEdit;
    private PopupWindow mPopupWindow;

    private List<String> mDataList;

    */
/**
     * 布局里面调用
     * @param context
     * @param attrs
     *//*

    public SpinnerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //初始化布局
        LayoutInflater.from(getContext()).inflate(R.layout.view_spinner, this);

        mockData();
        initView();
        initEvent();
    }

    */
/**
     * 代码new控件
     * @param context
     *//*

    public SpinnerView(Context context) {
        this(context, null);
    }

    private void mockData() {
        mDataList = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            mDataList.add(String.valueOf(i));
        }
    }

    private void initEvent() {
        mArrow.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                showPopupWindow();
            }
        });
    }

    protected void showPopupWindow() {
        //只创建一次popupwindow
        if (mPopupWindow == null) {
            int width = mEdit.getWidth();
            int height = 300;
            mPopupWindow = new PopupWindow(width, height);

//			TextView tv = new TextView(this);
//			tv.setBackgroundColor(Color.BLUE);
            ListView listView = new ListView(getContext());
            listView.setAdapter(mAdapter);
            //给listView设置背景
            listView.setBackgroundResource(R.drawable.listview_background);
            listView.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    //2. 点击列表选项，在编辑框中显示内容
                    String data = mDataList.get(position);
                    mEdit.setText(data);
                    //设置光标到末尾
                    mEdit.setSelection(data.length());
                    mPopupWindow.dismiss();
                }
            });


            mPopupWindow.setContentView(listView);

            //让popupwindow消失
            mPopupWindow.setOutsideTouchable(true);
            //只有设置背景之后，popupwindow内部才会处理触摸事件，然popupwindow消失
            mPopupWindow.setBackgroundDrawable(new ColorDrawable());

            //设置焦点
            mPopupWindow.setFocusable(true);

        }

        //弹出popupwindow
        mPopupWindow.showAsDropDown(mEdit);
    }

    private void initView() {
        mArrow = (ImageView) findViewById(R.id.arrow);
        mEdit = (EditText) findViewById(R.id.edit);
    }

    private BaseAdapter mAdapter = new BaseAdapter() {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder vh = null;
            if (convertView == null) {
//				View.inflate(context, resource, root)
                convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.list_item, null);
                vh = new ViewHolder(convertView);
                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            //刷新id
            final String data = mDataList.get(position);
            vh.mId.setText(data);
            vh.mDelete.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    //将点击位置的数据移除，并且刷新列表
                    mDataList.remove(data);
                    notifyDataSetChanged();
                }
            });

            return convertView;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int getCount() {
            return mDataList.size();
        }
    };

    public class ViewHolder {
        TextView mId;
        ImageView mDelete;

        public ViewHolder(View root) {
            mId = (TextView) root.findViewById(R.id.user_id);
            mDelete = (ImageView) root.findViewById(R.id.delete);
        }
    }

}
*/
