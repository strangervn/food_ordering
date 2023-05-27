package com.example.appfoodv2.Presenter;

public interface CartView {
    void OnSucess();

    void OnFail();

    void getDataSanPham(String id, String idsp,String tensp, Long giatien, String hinhanh, String loaisp, Long soluong, String hansudung, Long type, String trongluong);
}
