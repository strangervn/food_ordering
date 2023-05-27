package com.example.appfoodv2.View.FragMent;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfoodv2.Adapter.BillAdapter;
import com.example.appfoodv2.Model.BillModels;
import com.example.appfoodv2.Presenter.BillPreSenter;
import com.example.appfoodv2.Presenter.BillView;
import com.example.appfoodv2.R;
import com.example.appfoodv2.View.HomeActivity;

import java.util.ArrayList;

public class FragMent_Bill  extends Fragment  implements BillView {
    View view;
    private RecyclerView rcvBill;
    private BillPreSenter billPreSenter;
    private BillAdapter billAdapter;
    private ArrayList<BillModels> arrayList;
    private ProgressBar progressBar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bill,container,false);


        rcvBill =view.findViewById(R.id.rcvBill);
        progressBar = view.findViewById(R.id.progressbar);
        billPreSenter = new BillPreSenter(this);
        arrayList = new ArrayList<>();

        billPreSenter.HandleReadDataHD();
        HomeActivity.countDownTimer = new CountDownTimer(1,1) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                arrayList.clear();;
                if(billAdapter !=null){
                    billAdapter.notifyDataSetChanged();
                }
                billPreSenter.HandleReadDataHD();
                HomeActivity.countDownTimer.cancel();

            }
        };
        return  view;
    }

    @Override
    public void getDataHD(String id, String uid, String diachi, String hoten, String ngaydat, String phuongthuc, String sdt, Long tongtien,Long type) {
       arrayList.add(new BillModels(id,uid,diachi,hoten,ngaydat,phuongthuc,sdt,tongtien,type));
       billAdapter = new BillAdapter(getContext(),arrayList);
       rcvBill.setLayoutManager(new LinearLayoutManager(getContext()));
       rcvBill.setAdapter(billAdapter);
       progressBar.setVisibility(View.GONE);
    }


    @Override
    public void OnFail() {

    }

    @Override
    public void OnSucess() {

    }
}
