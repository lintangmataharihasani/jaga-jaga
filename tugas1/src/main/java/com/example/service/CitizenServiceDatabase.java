package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CitizenMapper;
import com.example.model.CitizenModel;
import com.example.model.CityModel;
import com.example.model.FamilyModel;
import com.example.model.KecamatanModel;
import com.example.model.KelurahanModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CitizenServiceDatabase implements CitizenService
{
    @Autowired
    private CitizenMapper citizenMapper;


    @Override
    public CitizenModel selectCitizen(String nik)
    {
        log.info ("select citizen with nik {}", nik);
        return citizenMapper.selectCitizen(nik);
    }
    
    @Override
    public CitizenModel selectCitizenId(String id)
    {
        log.info ("select citizen with id  {}", id);
        return citizenMapper.selectCitizenId(id);
    }
    
    @Override
    public FamilyModel selectFamily(String nkk)
    {
        log.info ("select family with nkk {}", nkk);
        return citizenMapper.selectFamily(nkk);
    }
    
    @Override
    public FamilyModel selectFamilyId(int id_keluarga)
    {
        log.info ("select family with id keluarga {}", id_keluarga);
        return citizenMapper.selectFamilyId(id_keluarga);
    }

    @Override
    public void addCitizen(CitizenModel citizen)
    {
        citizenMapper.addCitizen(citizen);
        log.info ("select citizen with nik {}", citizen.getNik());
    }
    
    @Override
    public void updateCitizen(CitizenModel citizen)
    {
        citizenMapper.updateCitizen(citizen);
        log.info ("update citizen with nik {}", citizen.getNik());
    }
    
    @Override
    public void setWafat(CitizenModel citizen)
    {
        citizenMapper.setWafat(citizen);
        log.info ("Set is_wafat true : citizen with nik {}", citizen.getNik());
    }
    
    @Override
    public void addFamily(FamilyModel family)
    {
        citizenMapper.addFamily(family);
        log.info ("add family with nik {}", family.getNomor_kk());
    }
    
    @Override
    public void updateFamily(FamilyModel family)
    {
        citizenMapper.updateFamily(family);
        log.info ("update family with nomor_kk {}", family.getNomor_kk());
    }
    
    @Override
    public void setTidakBerlaku(FamilyModel family)
    {
        citizenMapper.setTidakBerlaku(family);
        log.info ("Set is_tidak_berlaku true : family with nomor_kk {}", family.getNomor_kk());
    }
    
    @Override
    public String selectKodeKota (String namaKota) {
    	return citizenMapper.selectKodeKota(namaKota);
    }
    
    @Override
    public String selectKodeKecamatan (String namaKecamatan) {
    	return citizenMapper.selectKodeKecamatan(namaKecamatan);
    }
    
    @Override
    public String selectKodeKelurahan (String namaKelurahan) {
    	return citizenMapper.selectKodeKelurahan(namaKelurahan);
    }
    
    @Override
    public String selectKodeKelurahanId(int idKelurahan) {
    	return citizenMapper.selectKodeKelurahanId(idKelurahan);
    }
    
    @Override
    public String selectIdKelurahan (String namaKelurahan) {
    	return citizenMapper.selectIdKelurahan(namaKelurahan);
    }
    
    @Override
    public CityModel selectCity (String id_kota) {
    	return citizenMapper.selectCity(id_kota);
    }
    
    @Override
    public KecamatanModel selectKecamatan (String id_kecamatan) {
    	return citizenMapper.selectKecamatan(id_kecamatan);
    }
    
    @Override
    public KelurahanModel selectKelurahan (String id_kelurahan) {
    	return citizenMapper.selectKelurahan(id_kelurahan);
    }
    
    @Override
    public KecamatanModel selectKecamatanKota (String id_kota) {
    	return citizenMapper.selectKecamatanKota(id_kota);
    }
    
    @Override
    public KelurahanModel selectKelurahanKecamatan (String id_kecamatan) {
    	return citizenMapper.selectKelurahanKecamatan(id_kecamatan);
    }
    
    @Override
    public int countKeluarga() {
    	return citizenMapper.countKeluarga();
    }
    
    @Override
    public int countPenduduk() {
    	return citizenMapper.countPenduduk();
    }
    
    @Override
    public int countIdenticalFamilies(String nomor_kk) {
    	return citizenMapper.countIdenticalFamilies(nomor_kk);
    }
    
    @Override
    public int countIdenticalCitizens(String nik) {
    	return citizenMapper.countIdenticalCitizens(nik);
    }
    
    @Override
    public int countKeluargaKota(String nama_kota) {
    	return citizenMapper.countKeluargaKota(nama_kota);
    }
    
    @Override
    public int countPendudukKota(String nama_kota) {
    	return citizenMapper.countPendudukKota(nama_kota);
    }
    
    @Override
    public CitizenModel selectOldest (String id_kelurahan) {
    	log.info ("Select oldest: citizen with id_kelurahan {}", id_kelurahan);
    	log.info ("Select oldest: citizen with nama {}", citizenMapper.selectOldest(id_kelurahan).getNama());
    	return citizenMapper.selectOldest(id_kelurahan);
    }
    
    @Override
    public CitizenModel selectYoungest (String id_kelurahan) {
    	log.info ("Select youngest: citizen with id_kelurahan {}", id_kelurahan);
    	log.info ("Select youngest: citizen with nama {}", citizenMapper.selectYoungest(id_kelurahan).getNama());
    	return citizenMapper.selectYoungest(id_kelurahan);
    }
}

