package com.example.appfoodv2.Presenter;

import com.example.appfoodv2.Model.BillModels;

public class BillPreSenter implements IBill {

    private BillModels billModels;
    private BillView callback;

    public BillPreSenter(BillView callback) {
        this.callback = callback;
        billModels = new BillModels(this);
    }
    public  void HandleReadDataHD(){
        billModels.HandleReadData();
    }

    @Override
    public void getDataHD(String id, String uid, String diachi, String hoten, String ngaydat, String phuongthuc, String sdt, Long tongtien,Long type) {
        callback.getDataHD(id,uid,diachi,hoten,ngaydat,phuongthuc,sdt,tongtien,type);
    }

    @Override
    public void OnSucess() {
        callback.OnSucess();

    }

    @Override
    public void OnFail() {
      callback.OnFail();
    }

    public void CapNhatTrangThai(int i,String id) {
        billModels.HandleUpdateStatusBill(i,id);
    }

    public void HandleReadDataHD(int position) {
        billModels.HandleReadData(position);
    }
}
