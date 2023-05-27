package com.example.appfoodv2.Presenter;

import com.example.appfoodv2.Model.ProductModels;

public class ProductPreSenter implements IProduct {
    private ProductModels productModels;
    private ProductView callback;
    public ProductPreSenter(ProductView callback){
        this.callback=callback;
        productModels = new ProductModels(this);

    }
    public void HandlegetDataSanPham(){
        productModels.HandlegetDataSanPham();
    }

    public void HandlegetDataSanPhamTU(){
        productModels.HandlegetDataSanPhamThucUong();
    }
    public void HandlegetDataSanPhamHQ(){
        productModels.HandlegetDataSanPhamHanQuoc();
    }

    public void HandlegetDataSanPhamMC(){
        productModels.HandlegetDataSanPhamMiCay();
    }
    public void HandlegetDataSanPhamYT(){
        productModels.HandlegetDataSanPhamYeuThich();
    }
    public void HandlegetDataSanPhamLau(){
        productModels.HandlegetDataSanPhamLau();
    }
    public void HandlegetDataSanPhamGY(){
        productModels.HandlegetDataSanPhamGoiY();
    }
    @Override
    public void getDataSanPham(String id, String tensp, Long giatien, String hinhanh, String loaisp, String mota, Long soluong,
                               String hansudung, Long type,String trongluong) {
       callback.getDataSanPham(id,tensp,giatien,hinhanh,loaisp,mota,soluong,hansudung,type,trongluong);
    }
    @Override
    public void getDataSanPhamTU(String id, String tensp, Long giatien, String hinhanh, String loaisp, String mota, Long soluong,
                               String hansudung, Long type,String trongluong) {
        callback.getDataSanPhamTU(id,tensp,giatien,hinhanh,loaisp,mota,soluong,hansudung,type,trongluong);
    }
    @Override
    public void getDataSanPhamHQ(String id, String tensp, Long giatien, String hinhanh, String loaisp, String mota, Long soluong,
                                 String hansudung, Long type,String trongluong) {
        callback.getDataSanPhamHQ(id,tensp,giatien,hinhanh,loaisp,mota,soluong,hansudung,type,trongluong);
    }
    @Override
    public void getDataSanPhamMC(String id, String tensp, Long giatien, String hinhanh, String loaisp, String mota, Long soluong,
                                 String hansudung, Long type,String trongluong) {
        callback.getDataSanPhamMC(id,tensp,giatien,hinhanh,loaisp,mota,soluong,hansudung,type,trongluong);
    }
    @Override
    public void getDataSanPhamYT(String id, String tensp, Long giatien, String hinhanh, String loaisp, String mota, Long soluong,
                                 String hansudung, Long type,String trongluong) {
        callback.getDataSanPhamYT(id,tensp,giatien,hinhanh,loaisp,mota,soluong,hansudung,type,trongluong);
    }
    @Override
    public void getDataSanPhamLau(String id, String tensp, Long giatien, String hinhanh, String loaisp, String mota, Long soluong,
                                 String hansudung, Long type,String trongluong) {
        callback.getDataSanPhamLau(id,tensp,giatien,hinhanh,loaisp,mota,soluong,hansudung,type,trongluong);
    }
    @Override
    public void getDataSanPhamGY(String id, String tensp, Long giatien, String hinhanh, String loaisp, String mota, Long soluong,
                                 String hansudung, Long type,String trongluong) {
        callback.getDataSanPhamGY(id,tensp,giatien,hinhanh,loaisp,mota,soluong,hansudung,type,trongluong);
    }
    @Override
    public void OnEmptyList() {
        callback.OnEmptyList();
    }
// truyen dữ liệu qua màn hình
    @Override
    public void getDataSanPhamNB(String id, String tensp, Long giatien, String hinhanh, String loaisp, String mota, Long soluong, String hansudung, Long type, String trongluong) {
        callback.getDataSanPhamNB(id,tensp,giatien,hinhanh,loaisp,mota,soluong,hansudung,type,trongluong);
    }

    public void HandlegetDataSanPham(String loaisp,int type) {
        productModels.HandlegetDataSanPham(loaisp,type);
    }


    public void HandlegetDataSanPhamNB() {
        productModels.HandlegetDataSanPhamNoiBat();
    }

}
