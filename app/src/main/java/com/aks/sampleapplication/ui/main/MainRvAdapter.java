package com.aks.sampleapplication.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aks.sampleapplication.R;
import com.aks.sampleapplication.data.BaseUserData;

import java.util.List;

public class MainRvAdapter extends RecyclerView.Adapter<MainRvAdapter.ViewHolder> {
    private final Context context;
    private final RvInterface rvInterface;
    private List<BaseUserData> userDataList;

    public MainRvAdapter(Context context, RvInterface rvInterface, List<BaseUserData> userDataList) {
        this.context = context;
        this.rvInterface = rvInterface;
        this.userDataList = userDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_users, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(userDataList.get(position).getUsername());
        holder.tvMessage.setText(userDataList.get(position).getLastMessage().getMessage());
        holder.tvMessageReceivedTime.setText(userDataList.get(position).getLastMessage().getTime());
        holder.llUsersItem.setOnClickListener(v -> {
            rvInterface.onClickItem(position);
        });
    }

    @Override
    public int getItemCount() {
        return userDataList.size();
    }

    public void updateData(List<BaseUserData> userDataList) {
        this.userDataList = userDataList;
    }

    public interface RvInterface {
        void onClickItem(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvMessage;
        TextView tvMessageReceivedTime;
        LinearLayout llUsersItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessageReceivedTime = itemView.findViewById(R.id.tvMessageReceivedTime);
            tvName = itemView.findViewById(R.id.tvName);
            tvMessage = itemView.findViewById(R.id.tvMessage);
            llUsersItem = itemView.findViewById(R.id.llUsersItem);
        }
    }
}
