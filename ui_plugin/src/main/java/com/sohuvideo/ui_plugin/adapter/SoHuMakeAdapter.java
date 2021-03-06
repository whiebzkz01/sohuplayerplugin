package com.sohuvideo.ui_plugin.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sohu.lib.net.util.SohuImageView;
import com.sohu.lib.utils.StringUtils;
import com.sohuvideo.ui_plugin.manager.NetRequestManager;
import com.sohuvideo.ui_plugin.model.SohuProduce;
import com.sohuvideo.ui_plugin.player.PlayVideoHelper;
import com.sohuvideo.ui_plugin.R;
import com.sohuvideo.ui_plugin.utils.BitmapUtil;
import com.sohuvideo.ui_plugin.utils.DpiUtil;
import com.sohuvideo.ui_plugin.utils.LayoutConstants;

import java.util.ArrayList;
import java.util.List;


public class SoHuMakeAdapter extends BaseAdapter {
    private static final int ITEM_NUM_ROW_HOR = 2;

    private Context mContext;
    private List<SohuProduce> videos;

    private int margin;
    protected Bitmap mDefaultBitmap = null;

    public SoHuMakeAdapter(Context cn) {
        mContext = cn;
        videos = new ArrayList<SohuProduce>();
        margin = DpiUtil.dipToPx(cn, 5);
    }

    @Override
    public int getCount() {
        if (videos == null || videos.isEmpty()) {
            return 0;
        }
        int dataSize = videos.size();
        if (dataSize % ITEM_NUM_ROW_HOR == 0) {
            return dataSize / ITEM_NUM_ROW_HOR;
        } else {
            return dataSize / ITEM_NUM_ROW_HOR + 1;
        }
    }

    @Override
    public Object getItem(int position) {
        if (videos != null)
            return videos.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
        {
            ViewGroup convertViewGroup = null;
            View[] convertViewItemArr = null;
            ViewHolder[] holderArr = null;
            if (convertView == null || convertView.getTag() == null) {
                convertViewItemArr = new View[ITEM_NUM_ROW_HOR];
                holderArr = new ViewHolder[ITEM_NUM_ROW_HOR];
                convertViewGroup = (ViewGroup) View.inflate(mContext,
                        R.layout.sohumake_listview_item, null);
                LinearLayout.LayoutParams paramsItemView = new LinearLayout.LayoutParams(
                        0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
                paramsItemView.leftMargin = margin;
                for (int i = 0; i < ITEM_NUM_ROW_HOR; i++) {
                    holderArr[i] = new ViewHolder();
                    convertViewItemArr[i] = creatOrUpdateConvertView(holderArr[i]);
                    setLayoutParams(convertViewItemArr[i]);
                    convertViewGroup.addView(convertViewItemArr[i], paramsItemView);
                }
                convertViewGroup.setTag(holderArr);
                convertView = convertViewGroup;
            } else {
                holderArr = (ViewHolder[]) convertView.getTag();
            }

            if (holderArr != null) {
                int len = holderArr.length;
                for (int i = 0; i < len; i++) {
                    final int dataIndex = position * ITEM_NUM_ROW_HOR + i;
                    if (dataIndex >= videos.size()) {
                        holderArr[i].ll.setVisibility(View.INVISIBLE);
                        holderArr[i].ll.setOnClickListener(null);
                    } else {
                        fillHolderData(dataIndex, holderArr[i]);
                        holderArr[i].ll.setVisibility(View.VISIBLE);
                        holderArr[i].ll.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                PlayVideoHelper.playSohuOnlineVideo(mContext,videos.get(dataIndex).getAid(),
                                        videos.get(dataIndex).getVid(),1,0 ,PlayVideoHelper.TYPE_FOR_SOHU);
                            }
                        });
                    }
                }

            }
            return convertView;
        }

    private void setLayoutParams( View view) {
        View viewById = view.findViewById(R.id.id_sohumake_iv);
        viewById.getLayoutParams().width = LayoutConstants.sHorVideoImgWidth;
        viewById.getLayoutParams().height = LayoutConstants.sHorVideoImgHeight;
    }


    private void fillHolderData(int dataIndex, ViewHolder viewHolder) {
        SohuProduce soHuProduce = videos.get(dataIndex);
        viewHolder.tv_name.setText(soHuProduce.getVideo_name());
        viewHolder.tv_info.setText(soHuProduce.getAlbum_name());
        viewHolder.tv_tip.setText(soHuProduce.getTip());
        String imgUrl = soHuProduce.getHor_w8_pic();
        if (StringUtils.isEmpty(imgUrl)) {
            imgUrl = soHuProduce.getHor_high_pic();
        }
        if (StringUtils.isEmpty(imgUrl)) {
            imgUrl = soHuProduce.getVer_high_pic();
        }
        viewHolder.iv.setTag(imgUrl);
        NetRequestManager.getRequestManager().displayImage(imgUrl, viewHolder.iv,
                getDefaultBitmap());
    }


    private Bitmap getDefaultBitmap() {
        if (mDefaultBitmap == null && mContext != null) {
            mDefaultBitmap = getBitmap(mContext, getDefaultBkId());
        }
        return mDefaultBitmap;
    }

    private Bitmap getBitmap(Context mContext2, int defaultBkId) {
        return BitmapUtil.getBitmapFromResource(mContext2, defaultBkId);
    }

    private int getDefaultBkId() {
        return R.drawable.video_item_default_img;
    }

    /**
     * init
     *
     * @param holder
     * @return
     */
    private View creatOrUpdateConvertView(ViewHolder holder) {
        View convertView;
        convertView = View.inflate(mContext, R.layout.adapter_sohumake, null);
        holder.ll = (LinearLayout) convertView.findViewById(R.id.id_item_sohumake_list);
        holder.tv_tip = (TextView) convertView.findViewById(R.id.id_sohumake_tip_tv);
        holder.iv = (SohuImageView) convertView.findViewById(R.id.id_sohumake_iv);
        holder.tv_name = (TextView) convertView
                .findViewById(R.id.id_sohumake_tv);
        holder.tv_info = (TextView) convertView
                .findViewById(R.id.id_sohumake_info_tv);
        convertView.setTag(holder);
        return convertView;
    }

    private static class ViewHolder {
        public LinearLayout ll;
        public SohuImageView iv;
        public TextView tv_tip;
        public TextView tv_name;
        public TextView tv_info;
    }

    public void addDatas(List<SohuProduce> videos) {
        if (this.videos != null) {
            this.videos.addAll(videos);
            notifyDataSetChanged();
        }
    }
}
