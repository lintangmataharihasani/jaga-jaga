package com.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenModel {
	private int id;
	private String nik;
	private String nama;
	private String tempat_lahir;
	private String tanggal_lahir;
	private int jenis_kelamin;
	
	private String rt;
	private String rw;
	private String alamat;
	private String nama_kelurahan;
	private String nama_kecamatan;
	private String nama_kota;
	private String kewarganegaraan;
	private String status_kematian;
	private String jenisKelamin;
	
	private int is_wni;
	private int id_keluarga;
	private String agama;
	private String pekerjaan;
	private String status_perkawinan;
	private String status_dalam_keluarga;
	private String golongan_darah;
	private int is_wafat;
}
