package com.example.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KelurahanModel {
	private int id;
	private String kode_kelurahan;
	private String nama_kelurahan;
	private List<FamilyModel> keluarga;
	private List<CitizenModel> penduduk;
	
}
