package com.example.appfoodv2.View.Bill;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfoodv2.Adapter.ProductAdapter;
import com.example.appfoodv2.Model.BillModels;
import com.example.appfoodv2.Model.ProductModels;
import com.example.appfoodv2.Presenter.CartPreSenter;
import com.example.appfoodv2.Presenter.CartView;
import com.example.appfoodv2.Presenter.BillPreSenter;
import com.example.appfoodv2.Presenter.BillView;
import com.example.appfoodv2.R;

import java.text.NumberFormat;
import java.util.ArrayList;

public class ContentBillAdMinActivity extends AppCompatActivity implements CartView, BillView {
    private Intent intent;
    private BillModels billModels;
    private TextView txtmaHD, txthoten, txtdiachi, txtsdt, txttongtien,txtrangthai;
    private Toolbar toolbar;
    private ImageView hinhanh;
    private Button btncapnhat;
    private CartPreSenter cartPreSenter;
    private ArrayList<ProductModels> arrayList;
    private ProductAdapter productAdapter;
    private RecyclerView rcvBill;
    private BillPreSenter billPreSenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_bill);
        InitWidget();
        Init();
    }

    private void Init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chi tiết hóa đơn");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        intent=getIntent();
        billModels = (BillModels) intent.getSerializableExtra("HD");
        int type = intent.getIntExtra("TYPE",0);
        txtdiachi.setText("Địa chỉ : "+ billModels.getDiachi());
        txtmaHD.setText("Mã HD :"+ billModels.getId());
        txthoten.setText("Họ tên : "+ billModels.getHoten());
        txtsdt.setText("Liên hệ : "+ billModels.getSdt());
        txttongtien.setText("Giá tiền: "+NumberFormat.getNumberInstance().format(billModels.getTongtien()));

        switch ((int) billModels.getType()){
            case  1: txtrangthai.setText("Trạng Thái : Đang xử lý");break;
            case  2: txtrangthai.setText("Trạng Thái : Đang giao hàng");break;
            case  3: txtrangthai.setText("Trạng Thái : Giao Hàng Thành Công");break;
            case  4: txtrangthai.setText("Trạng Thái : Hủy Đơn Hàng");break;
        }



        cartPreSenter = new CartPreSenter(this);
        billPreSenter = new BillPreSenter(this);
        arrayList = new ArrayList<>();
        if(type == 5){
            cartPreSenter.HandlegetDataCTHD(billModels.getId(), billModels.getUid());
        }else{
            cartPreSenter.HandlegetDataCTHD(billModels.getId());
        }

        btncapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DiaLogUpDate();
            }
        });

    }
//Hàm kiểm tra hủy đơn hàng
    private void DiaLogUpDate() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_update_trangthai);
        dialog.show();
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Spinner spiner = dialog.findViewById(R.id.spinerCapNhat);
        String[] s = {"Chọn Mục","Đang xử lý","Đang giao hàng","Giao Hàng Thành Công","Hủy Đơn Hàng"} ;

        ArrayAdapter arrayAdapter  = new ArrayAdapter(this, android.R.layout.simple_list_item_1,s);
        spiner.setAdapter( arrayAdapter);
        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>0){
                    if(billModels.getType() <3){
                        billPreSenter.CapNhatTrangThai(spiner.getSelectedItemPosition(), billModels.getId());
                        dialog.cancel();
                    }else if(billModels.getType() == 4){
                        Toast.makeText(ContentBillAdMinActivity.this, "Đơn hàng đã hủy!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(ContentBillAdMinActivity.this, "Đơn hàng bạn không thể hủy", Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void InitWidget() {
        toolbar = findViewById(R.id.toolbar);
        txtdiachi = findViewById(R.id.txtdiachi);
        txthoten = findViewById(R.id.txthoten);
        txtrangthai=findViewById(R.id.txtrangthaidonhang);
        txtsdt=findViewById(R.id.txtsdt);
        txttongtien=findViewById(R.id.txttongtien);
        txtmaHD=findViewById(R.id.txtmaHD);
        rcvBill=findViewById(R.id.rcvSP);

        btncapnhat=findViewById(R.id.btncapnhat);

    }

    @Override
    public void OnSucess() {
        Toast.makeText(this, "Cập nhật thành công ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void OnFail() {
        Toast.makeText(this, "Thất Bại ! Lỗi hệ thống bảo trì", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getDataSanPham(String id, String idsp, String tensp, Long giatien, String hinhanh, String loaisp, Long soluong, String hansudung, Long type, String trongluong) {
        arrayList.add(new ProductModels(id,idsp,tensp,giatien,hinhanh,loaisp,soluong,hansudung,type,trongluong));
        productAdapter = new ProductAdapter(this,arrayList,1);
        rcvBill.setLayoutManager(new LinearLayoutManager(this));
        rcvBill.setAdapter(productAdapter);
    }


    @Override
    public void getDataHD(String id, String uid, String diachi, String hoten, String ngaydat, String phuongthuc, String sdt, Long tongtien, Long type) {

    }
}
