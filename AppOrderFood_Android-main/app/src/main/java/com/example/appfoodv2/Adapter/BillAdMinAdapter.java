package com.example.appfoodv2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfoodv2.Model.BillModels;
import com.example.appfoodv2.Presenter.SetOnItemClick;

import com.example.appfoodv2.View.Bill.ContentBillAdMinActivity;
import com.example.appfoodv2.R;


import java.text.NumberFormat;
import java.util.ArrayList;

public class BillAdMinAdapter extends RecyclerView.Adapter<BillAdMinAdapter.ViewHodler> {
    private Context context;
    private ArrayList<BillModels> arrayList;
    private  int type = 0;

    public BillAdMinAdapter(Context context, ArrayList<BillModels> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    public BillAdMinAdapter(Context context, ArrayList<BillModels> arrayList, int type) {
        this.context = context;
        this.arrayList = arrayList;
        this.type= type;
    }

    @NonNull
    @Override
    public BillAdMinAdapter.ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(type==0 || type==5){
             view = LayoutInflater.from(context).inflate(R.layout.dong_hoadon,parent,false);
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.dong_giohang,parent,false);
        }


        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillAdMinAdapter.ViewHodler holder, int position) {

        BillModels sanPhamModels = arrayList.get(position);

        holder.txthoten.setText("Họ tên : "+sanPhamModels.getHoten());
        holder.txtdiachi.setText("Địa chỉ : "+sanPhamModels.getDiachi());
        holder.txtsdt.setText("Số điện thoại : "+sanPhamModels.getSdt());
        holder.txttongtien.setText("Tổng tiền :"+NumberFormat.getInstance().format(sanPhamModels.getTongtien()) +" Đ");
        holder.txtngaydat.setText(sanPhamModels.getNgaydat());

        holder.SetOnItem(new SetOnItemClick() {
            @Override
            public void SetItemClick(View view, int pos) {
                Intent intent = new Intent(context, ContentBillAdMinActivity.class);
                intent.putExtra("HD",sanPhamModels);
                intent.putExtra("TYPE",type);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView txthoten,txtsdt,txtdiachi,txtngaydat,txttongtien;
        SetOnItemClick itemClick;

        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            txthoten= itemView.findViewById(R.id.txthoten);
            txtsdt= itemView.findViewById(R.id.txtsdt);
            txtdiachi= itemView.findViewById(R.id.txtdiachi);
            txtngaydat= itemView.findViewById(R.id.txtngaydat);
            txttongtien= itemView.findViewById(R.id.txttongtien);

            itemView.setOnClickListener(this);
        }
        public  void  SetOnItem(SetOnItemClick itemClick){
            this.itemClick = itemClick;
        }

        @Override
        public void onClick(View v) {
            itemClick.SetItemClick(v,getAdapterPosition());
        }
    }
}
