package com.aks.sampleapplication.ui.second;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aks.sampleapplication.R;
import com.aks.sampleapplication.data.MessageDetails;
import com.bumptech.glide.Glide;

import java.util.List;

public class RvSecondAdapter extends RecyclerView.Adapter<RvSecondAdapter.ViewHolder> {
    Context context;
    List<MessageDetails> messageDetailsList;
    String avatarUrl;

    public RvSecondAdapter(Context context, List<MessageDetails> messageDetailsList, String avatarUrl) {
        this.context = context;
        this.messageDetailsList = messageDetailsList;
        this.avatarUrl = avatarUrl;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_chats, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (messageDetailsList.get(position).getSendBy().equals("true")) {
            holder.llSenderLayout.setVisibility(View.VISIBLE);
            holder.llReceiverLayout.setVisibility(View.GONE);
            holder.tvSenderMessage.setText(messageDetailsList.get(position).getMessage());
            holder.tvSenderTime.setText(messageDetailsList.get(position).getTime());
            Glide.with(context).load(avatarUrl).into(holder.imSender);
        } else {
            holder.llSenderLayout.setVisibility(View.GONE);
            holder.llReceiverLayout.setVisibility(View.VISIBLE);
            holder.tvReceiverMessage.setText(messageDetailsList.get(position).getMessage());
            holder.tvReceiverTime.setText(messageDetailsList.get(position).getTime());
            Glide.with(context).load("https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/597.jpg").into(holder.imReceiver);
        }
    }

    @Override
    public int getItemCount() {
        return messageDetailsList.size();
    }

    public void updateAdapter(List<MessageDetails> messageDetails) {
        this.messageDetailsList = messageDetails;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llSenderLayout, llReceiverLayout;
        TextView tvSenderMessage, tvSenderTime, tvReceiverMessage, tvReceiverTime;
        ImageView imSender, imReceiver;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            llSenderLayout = itemView.findViewById(R.id.llSenderLayout);
            llReceiverLayout = itemView.findViewById(R.id.llReceiverLayout);
            tvSenderMessage = itemView.findViewById(R.id.tvSenderMessage);
            tvSenderTime = itemView.findViewById(R.id.tvSenderTime);
            imSender = itemView.findViewById(R.id.imSender);
            tvReceiverMessage = itemView.findViewById(R.id.tvReceiverMessage);
            tvReceiverTime = itemView.findViewById(R.id.tvReceiverTime);
            imReceiver = itemView.findViewById(R.id.imReceiver);
        }
    }
}
