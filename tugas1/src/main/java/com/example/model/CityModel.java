package com.example.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityModel {
	private int id;
	private String kode_kota;
	private String nama_kota;
	private List<KecamatanModel> kecamatans;
	private int jumlah_penduduk;
	private int jumlah_keluarga;
	
}
