package com.example.z.userdefinepopwindowlistdemo;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by z on 2018/4/10.
 */

public class HHH extends RelativeLayout {
    private EditText mEditText;
    private ImageView mSelectIcon;
    private ArrayList<String> al = new ArrayList<>();
    public HHH(Context context) {
        this(context,null);
    }

    public HHH(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(getContext())
                .inflate(R.layout.activity_main1, this);
        initView();
        initEvent();
        initData();
    }

    private void initData() {
        for (int i = 0; i < 40; i++) {
            al.add("我是第 " + i + " 个联系人");
        }
    }

    private void initEvent() {
        mEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int width = mEditText.getWidth();
                int height = 1200;
                final PopupWindow popupWindow = new PopupWindow(width, height);
             /*   TextView textView = new TextView(MainActivity.this);
                textView.setBackgroundColor(Color.RED);*/
                ListView listView = new ListView(getContext());
                listView.setAdapter(new ContactAdapter());
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        mEditText.setText(al.get(position));
                        mEditText.setSelection(al.get(position).length());
                        popupWindow.dismiss();
                    }
                });
                popupWindow.setContentView(listView);
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(mEditText);
            }
        });
    }

    private void initView() {
        mEditText = (EditText) findViewById(R.id.edit_text);
        mSelectIcon = (ImageView) findViewById(R.id.select_icons);
    }

    private class ContactAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return al == null ? 0 : al.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder vh;
            if (convertView != null) {
                vh = (ViewHolder) convertView.getTag();
            } else {
//                convertView = View.inflate(MainActivity.this, R.layout.contact_item, null);
                convertView=    LayoutInflater.from(getContext())
                        .inflate(R.layout.contact_item, null);
                vh = new ViewHolder(convertView);
                convertView.setTag(vh);
            }
            vh.contact.setText(al.get(position));
            vh.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    al.remove(position);
                    notifyDataSetChanged();
                }
            });

            return convertView;
        }
    }

    class ViewHolder {
        TextView contact;
        ImageView delete;

        private ViewHolder(View view) {
            delete = (ImageView) view.findViewById(R.id.delete);
            contact = (TextView) view.findViewById(R.id.contect_info);
        }
    }

}
