package com.example.appfoodv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.example.appfoodv2.Model.ProductModels;
import com.example.appfoodv2.Presenter.SetOnItemClick;
import com.example.appfoodv2.R;

import java.text.NumberFormat;
import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHodler> {
    private Context context;
    private ArrayList<ProductModels> arrayList;
    private  int type = 0;

    public CartAdapter(Context context, ArrayList<ProductModels> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    public CartAdapter(Context context, ArrayList<ProductModels> arrayList, int type) {
        this.context = context;
        this.arrayList = arrayList;
        this.type= type;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(type==0){
             view = LayoutInflater.from(context).inflate(R.layout.dong_sanpham,parent,false);
        }else if(type ==2){
            view = LayoutInflater.from(context).inflate(R.layout.dong_sanpham_noibat,parent,false);
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.dong_giohang,parent,false);
        }


        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHodler holder, int position) {

        ProductModels productModels = arrayList.get(position);

        holder.txttensp.setText(productModels.getTensp());

        holder.txtgiasp.setText(NumberFormat.getInstance().format(productModels.getGiatien())+" Đ");
        Picasso.get().load(productModels.getHinhanh()).into(holder.hinhanh);
        holder.SetOnItem(new SetOnItemClick() {
            @Override
            //chi tiet san phẩm
            public void SetItemClick(View view, int pos) {

            }
        });
        if(type==1){
            holder.txtbaohanh.setText(productModels.getTrongluong());
            holder.txtsoluong.setText(productModels.getSoluong()+"");
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView txttensp,txtgiasp,txtbaohanh,txtsoluong;
        ImageView hinhanh;
        SetOnItemClick itemClick;

        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            txtgiasp= itemView.findViewById(R.id.txtgiatien);
            txttensp= itemView.findViewById(R.id.txttensp);
            hinhanh= itemView.findViewById(R.id.hinhanh);
            if(type==1){
                txtbaohanh = itemView.findViewById(R.id.txtbaohanh);
                txtsoluong = itemView.findViewById(R.id.txtsoluong);
            }
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
