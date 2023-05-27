package com.example.appfoodv2.Presenter;

import com.example.appfoodv2.Model.CartModels;
import com.example.appfoodv2.Model.ProductModels;

import java.util.ArrayList;

public class CartPreSenter implements ICart {
    private CartModels cartModels;
    private CartView callback;

    public CartPreSenter(CartView callback) {
        this.callback = callback;
        cartModels = new CartModels(this);
    }
    public  void AddCart(String idsp){
        cartModels.AddCart(idsp);
    }
    public  void  HandlegetDataGioHang(){
        cartModels.HandlegetDataGioHang();
    }
    public  void  HandlegetDataGioHang(String id){
        cartModels.HandlegetDataGioHang(id);
    }

    @Override
    public void OnSucess() {
        callback.OnSucess();
    }

    @Override
    public void OnFail() {
        callback.OnFail();
    }

    @Override
    public void getDataSanPham(String id, String idsp,String tensp, Long giatien, String hinhanh, String loaisp, Long soluong, String hansudung, Long type, String trongluong) {
        callback.getDataSanPham(id,idsp,tensp,giatien,hinhanh,loaisp,soluong,hansudung,type,trongluong);
    }

    public void HandleAddHoaDon(String ngaydat, String diachi, String hoten, String sdt, String phuongthuc, long tongtien, ArrayList<ProductModels> arrayList) {
        cartModels.HandleThanhToan(ngaydat,diachi,hoten,sdt,phuongthuc,tongtien,arrayList);
    }

    public void HandlegetDataCTHD(String id) {
        cartModels.HandleGetDataCTHD(id);

    }
    public void HandlegetDataCTHD(String id,String uid) {
        cartModels.HandleGetDataCTHD(id,uid);

    }
}
