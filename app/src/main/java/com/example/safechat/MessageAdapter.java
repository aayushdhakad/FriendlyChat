package com.example.safechat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<FriendlyMessage> {
    public MessageAdapter(@NonNull Context context, int resource, @NonNull List<FriendlyMessage> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_message,parent,false);
        }
        ImageView mImageView = (ImageView)convertView.findViewById(R.id.imageView);
        TextView messageTextView = (TextView)convertView.findViewById(R.id.textView);
        TextView authorTextView = (TextView)convertView.findViewById(R.id.textView2);
        FriendlyMessage message = getItem(position);
        if(message.getPhotoUrl()!=null){
            messageTextView.setVisibility(View.GONE);
            mImageView.setVisibility(View.VISIBLE);
            Glide.with(mImageView.getContext()).load(message.getPhotoUrl()).into(mImageView);
        }
        else{
            messageTextView.setVisibility(View.VISIBLE);
            mImageView.setVisibility(View.VISIBLE);
            messageTextView.setText(message.getText());
        }
        authorTextView.setText(message.getName());
        return convertView;
    }
}
