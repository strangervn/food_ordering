package com.example.appfoodv2.Presenter;

public interface IBill {
    void getDataHD(String id, String uid, String diachi, String hoten, String ngaydat, String phuongthuc, String sdt, Long tongtien,Long type);

    void OnSucess();

    void OnFail();
}
