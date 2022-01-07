package com.example.anin;

public class Menu{
    private String _id, _nama, _bungkus, _harga;
    public Menu (String id, String nama, String bungkus, String harga) {
        this._id = id;
        this._nama = nama;
        this._bungkus = bungkus;
        this._harga = harga;
    }
    public Menu() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_bungkus() {
        return _bungkus;
    }
    public void set_bungkus(String _bungkus) {
        this._bungkus = _bungkus;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }
}
