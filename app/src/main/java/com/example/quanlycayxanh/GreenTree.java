package com.example.quanlycayxanh;

public class GreenTree {

    private String id;
    private String tenKhoaHoc;
    private String tenThuongGoi;
    private String datTa;
    private String mauLa;
    private Integer hinhAnh;

    public GreenTree() {

    }

    public GreenTree(String id, String tenKhoaHoc, String tenThuongGoi, String datTa, String mauLa, Integer hinhAnh) {
        this.id = id;
        this.tenKhoaHoc = tenKhoaHoc;
        this.tenThuongGoi = tenThuongGoi;
        this.datTa = datTa;
        this.mauLa = mauLa;
        this.hinhAnh = hinhAnh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public String getTenThuongGoi() {
        return tenThuongGoi;
    }

    public void setTenThuongGoi(String tenThuongGoi) {
        this.tenThuongGoi = tenThuongGoi;
    }

    public String getDatTa() {
        return datTa;
    }

    public void setDatTa(String datTa) {
        this.datTa = datTa;
    }

    public String getMauLa() {
        return mauLa;
    }

    public void setMauLa(String mauLa) {
        this.mauLa = mauLa;
    }

    public Integer getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(Integer hinhAnh) {
        this.hinhAnh = hinhAnh;
    }


}
