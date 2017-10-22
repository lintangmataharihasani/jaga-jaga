package com.example.service;

import java.util.List;

import com.example.model.CitizenModel;
import com.example.model.CityModel;
import com.example.model.FamilyModel;
import com.example.model.KecamatanModel;
import com.example.model.KelurahanModel;

public interface CitizenService
{
    CitizenModel selectCitizen(String nik);
    
    CitizenModel selectCitizenId(String id);

    void addCitizen (CitizenModel citizen);
    
    void updateCitizen (CitizenModel citizen);
    
    void setWafat (CitizenModel citizen);
    
    FamilyModel selectFamily(String nkk);
    
    FamilyModel selectFamilyId(int idKeluarga);
    
    void addFamily (FamilyModel family);
    
    void updateFamily (FamilyModel family);
    
    void setTidakBerlaku (FamilyModel family);
    
    //Select Location Data
    CityModel selectCity (String id_kota);
    
    KecamatanModel selectKecamatan (String id_kecamatan);
    
    KelurahanModel selectKelurahan (String id_kelurahan);
    
    KecamatanModel selectKecamatanKota (String id_kota);
    
    KelurahanModel selectKelurahanKecamatan (String id_kecamatan);
    
    //Code Retrieval Functions
    String selectKodeKota (String namaKota);
    String selectKodeKecamatan (String namaKecamatan);
    String selectKodeKelurahan (String namaKelurahan);
    String selectKodeKelurahanId (int idKelurahan);
    String selectIdKelurahan (String namaKelurahan);
    
    //Miscellaneous
    int countKeluarga();
    int countPenduduk();
    int countIdenticalFamilies(String nomorKk);
    int countIdenticalCitizens(String nik);
    int countKeluargaKota(String namaKota);
    int countPendudukKota(String namaKota);
    
    CitizenModel selectOldest (String id_kelurahan);
    CitizenModel selectYoungest (String id_kelurahan);
}
