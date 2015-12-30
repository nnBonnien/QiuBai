package com.jianda.qiubai.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jianda.qiubai.R;
import com.jianda.qiubai.utils.CircleTransform;
import com.jianda.qiubai.utils.Item;
import com.jianda.qiubai.utils.Video;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.jianda.qiubai.utils.Url.getIconURL;


/**
 * Created by Administrator on 15-12-30.
 */
public class VideoAdapter extends BaseAdapter {
    private Context context;
    private List<Video> list;

    public VideoAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.video_item,parent,false);
            convertView.setTag(new ViewHolder(convertView));
        }
        Video video = list.get(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();

        if(video.getUserName() != null){
            holder.nameText.setText(video.getUserName());
            Picasso.with(context)
                    .load(getIconURL(video.getUserId(), video.getUserIcon()))
                    .transform(new CircleTransform())
                    .into(holder.iconImage);
        }else {
            holder.nameText.setText("匿名用户");
            holder.iconImage.setImageResource(R.drawable.ab_ic_logo);
        }
        holder.content.setText(video.getContent());
        holder.contentImage.setVisibility(View.VISIBLE);
        Picasso.with(context)
                .load(video.getImage())
                .resize(parent.getWidth(), 0)
//                    .fit()      //匹配
                .placeholder(R.drawable.notification_icon)
                .error(R.drawable.pinfo_bigcover_failed)
                .into(holder.contentImage);

        if(video.getType() != null) {
            switch (video.getType()) {
                case "hot":
                    holder.type.setText("热门");
                    holder.imageType.setImageResource(R.drawable.ic_rss_hot);
                    break;
                case "fresh":
                    holder.type.setText("新鲜");
                    holder.imageType.setImageResource(R.drawable.fresh);
                    break;
            }
        }
        holder.interste.setText("好笑" + (video.getUp() + video.getDown()));
        holder.mark.setText(".评论" + video.getComments());
        holder.share.setText(".分享" + video.getShare());
        return convertView;
    }




    public void addAll(Collection<? extends Video> collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }

    private static class ViewHolder{
        private ImageView contentImage;
        private TextView nameText;
        private TextView content;
        private ImageView iconImage;
        private TextView interste;
        private TextView mark;
        private TextView share;
        private TextView type;
        private ImageView imageType;

        public ViewHolder(View itemView) {
            iconImage = (ImageView) itemView.findViewById(R.id.user_icon);
            contentImage = (ImageView) itemView.findViewById(R.id.image_content);
            content = (TextView) itemView.findViewById(R.id.content);
            nameText = (TextView) itemView.findViewById(R.id.user_name);
            interste = (TextView)itemView.findViewById(R.id.txt_interste);
            mark = (TextView) itemView.findViewById(R.id.txt_mark);
            share = (TextView) itemView.findViewById(R.id.txt_share);
            type = (TextView) itemView.findViewById(R.id.type);
            imageType = (ImageView)itemView.findViewById(R.id.iamge_type);
        }
    }
}

