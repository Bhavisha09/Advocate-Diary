package com.example.advocatediary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<DataClass> dataList;
    public MyAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.reccaseNo.setText(dataList.get(position).getDatacaseNo());
        holder.recclientName.setText(dataList.get(position).getDataclientName());
        holder.reccaseType.setText(dataList.get(position).getDatacaseType());
        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Case No", dataList.get(holder.getAdapterPosition()).getDatacaseNo());
                intent.putExtra("Client Name", dataList.get(holder.getAdapterPosition()).getDataclientName());
                intent.putExtra("Key",dataList.get(holder.getAdapterPosition()).getkey());
                intent.putExtra("Case Type", dataList.get(holder.getAdapterPosition()).getDatacaseType());
                intent.putExtra("Opponent Name", dataList.get(holder.getAdapterPosition()).getDataoppName());
                intent.putExtra("Filing Date", dataList.get(holder.getAdapterPosition()).getDatafilingDate());
                intent.putExtra("Judge Name", dataList.get(holder.getAdapterPosition()).getDatajudgeName());
                intent.putExtra("Area", dataList.get(holder.getAdapterPosition()).getDataareaCase());
                intent.putExtra("Charge", dataList.get(holder.getAdapterPosition()).getDatachargeAmount());                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    public void searchDataList(ArrayList<DataClass> searchList){
        dataList = searchList;
        notifyDataSetChanged();
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{
    ImageView recImage;
    TextView reccaseNo, recclientName,reccaseType ;
    CardView recCard;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        reccaseNo = itemView.findViewById(R.id.reccaseNo);
        recclientName = itemView.findViewById(R.id.recclientName);
        reccaseType = itemView.findViewById(R.id.reccaseType);
    }
}