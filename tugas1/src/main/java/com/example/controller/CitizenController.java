package com.example.controller;

import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.CitizenModel;
import com.example.model.CityModel;
import com.example.model.FamilyModel;
import com.example.model.KecamatanModel;
import com.example.model.KelurahanModel;
import com.example.service.CitizenService;

@Controller
public class CitizenController
{
    @Autowired
    CitizenService citizenDAO;

    @RequestMapping("/")
    public String index(Model model)
    {	
    	CityModel kepulauan_seribu = citizenDAO.selectCity("1");
    	kepulauan_seribu.setJumlah_penduduk(citizenDAO.countPendudukKota("KABUPATEN KEPULAUAN SERIBU"));
    	kepulauan_seribu.setJumlah_keluarga(citizenDAO.countKeluargaKota("KABUPATEN KEPULAUAN SERIBU"));
    	CityModel jakarta_selatan = citizenDAO.selectCity("2");
    	jakarta_selatan.setJumlah_penduduk(citizenDAO.countPendudukKota("KOTA JAKARTA SELATAN"));
    	jakarta_selatan.setJumlah_keluarga(citizenDAO.countKeluargaKota("KOTA JAKARTA SELATAN"));
    	CityModel jakarta_timur = citizenDAO.selectCity("3");
    	jakarta_timur.setJumlah_penduduk(citizenDAO.countPendudukKota("KOTA JAKARTA TIMUR"));
    	jakarta_timur.setJumlah_keluarga(citizenDAO.countKeluargaKota("KOTA JAKARTA TIMUR"));
    	CityModel jakarta_pusat = citizenDAO.selectCity("4");
    	jakarta_pusat.setJumlah_penduduk(citizenDAO.countPendudukKota("KOTA JAKARTA PUSAT"));
    	jakarta_pusat.setJumlah_keluarga(citizenDAO.countKeluargaKota("KOTA JAKARTA PUSAT"));
    	CityModel jakarta_barat = citizenDAO.selectCity("5");
    	jakarta_barat.setJumlah_penduduk(citizenDAO.countPendudukKota("KOTA JAKARTA BARAT"));
    	jakarta_barat.setJumlah_keluarga(citizenDAO.countKeluargaKota("KOTA JAKARTA BARAT"));
    	CityModel jakarta_utara = citizenDAO.selectCity("6");
    	jakarta_utara.setJumlah_penduduk(citizenDAO.countPendudukKota("KOTA JAKARTA UTARA"));
    	jakarta_utara.setJumlah_keluarga(citizenDAO.countKeluargaKota("KOTA JAKARTA UTARA"));
    	
    	int jumlah_penduduk = citizenDAO.countPenduduk();
    	int jumlah_keluarga = citizenDAO.countKeluarga();
    	int rasio = jumlah_penduduk/jumlah_keluarga;
    	model.addAttribute("jumlah_penduduk", jumlah_penduduk);
    	model.addAttribute("jumlah_keluarga", jumlah_keluarga);
    	model.addAttribute("rasio", rasio);
    	
    	model.addAttribute("kepulauan_seribu", kepulauan_seribu);
    	model.addAttribute("jakarta_selatan", jakarta_selatan);
    	model.addAttribute("jakarta_timur", jakarta_timur);
    	model.addAttribute("jakarta_pusat", jakarta_pusat);
    	model.addAttribute("jakarta_barat", jakarta_barat);
    	model.addAttribute("jakarta_utara", jakarta_utara);
        return "index";
    }
    
    @RequestMapping("/index")
    public String indexPath(Model model)
    {
    	
    	CityModel kepulauan_seribu = citizenDAO.selectCity("1");
    	kepulauan_seribu.setJumlah_penduduk(citizenDAO.countPendudukKota("KABUPATEN KEPULAUAN SERIBU"));
    	kepulauan_seribu.setJumlah_keluarga(citizenDAO.countKeluargaKota("KABUPATEN KEPULAUAN SERIBU"));
    	CityModel jakarta_selatan = citizenDAO.selectCity("2");
    	jakarta_selatan.setJumlah_penduduk(citizenDAO.countPendudukKota("KOTA JAKARTA SELATAN"));
    	jakarta_selatan.setJumlah_keluarga(citizenDAO.countKeluargaKota("KOTA JAKARTA SELATAN"));
    	CityModel jakarta_timur = citizenDAO.selectCity("3");
    	jakarta_timur.setJumlah_penduduk(citizenDAO.countPendudukKota("KOTA JAKARTA TIMUR"));
    	jakarta_timur.setJumlah_keluarga(citizenDAO.countKeluargaKota("KOTA JAKARTA TIMUR"));
    	CityModel jakarta_pusat = citizenDAO.selectCity("4");
    	jakarta_pusat.setJumlah_penduduk(citizenDAO.countPendudukKota("KOTA JAKARTA PUSAT"));
    	jakarta_pusat.setJumlah_keluarga(citizenDAO.countKeluargaKota("KOTA JAKARTA PUSAT"));
    	CityModel jakarta_barat = citizenDAO.selectCity("5");
    	jakarta_barat.setJumlah_penduduk(citizenDAO.countPendudukKota("KOTA JAKARTA BARAT"));
    	jakarta_barat.setJumlah_keluarga(citizenDAO.countKeluargaKota("KOTA JAKARTA BARAT"));
    	CityModel jakarta_utara = citizenDAO.selectCity("6");
    	jakarta_utara.setJumlah_penduduk(citizenDAO.countPendudukKota("KOTA JAKARTA UTARA"));
    	jakarta_utara.setJumlah_keluarga(citizenDAO.countKeluargaKota("KOTA JAKARTA UTARA"));
    	
    	int jumlah_penduduk = citizenDAO.countPenduduk();
    	int jumlah_keluarga = citizenDAO.countKeluarga();
    	int rasio = jumlah_penduduk/jumlah_keluarga;
    	model.addAttribute("jumlah_penduduk", jumlah_penduduk);
    	model.addAttribute("jumlah_keluarga", jumlah_keluarga);
    	model.addAttribute("rasio", rasio);
    	
    	model.addAttribute("kepulauan_seribu", kepulauan_seribu);
    	model.addAttribute("jakarta_selatan", jakarta_selatan);
    	model.addAttribute("jakarta_timur", jakarta_timur);
    	model.addAttribute("jakarta_pusat", jakarta_pusat);
    	model.addAttribute("jakarta_barat", jakarta_barat);
    	model.addAttribute("jakarta_utara", jakarta_utara);
    	
        return "index";
    }
    
    @RequestMapping("/penduduk/tambah")
    public String addCitizen()
    {
        return "tambah-penduduk";
    }
    
    @RequestMapping(value = "/penduduk/tambah", method = RequestMethod.POST)
    public String addCitizenSubmit( Model model,
            @RequestParam(value = "nama", required = true) String nama,
            @RequestParam(value = "tempat_lahir", required = true) String tempat_lahir,
            @RequestParam(value = "tanggal_lahir", required = true) String tanggal_lahir,
            @RequestParam(value = "golongan_darah", required = true) String golongan_darah,
            @RequestParam(value = "jenis_kelamin", required = true) String jenis_kelamin,
            @RequestParam(value = "agama", required = true) String agama,
            @RequestParam(value = "status_perkawinan", required = true) String status_perkawinan,
            @RequestParam(value = "pekerjaan", required = true) String pekerjaan,
            @RequestParam(value = "kewarganegaraan", required = true) String kewarganegaraan,
            @RequestParam(value = "status_kematian", required = true) String status_kematian,
            @RequestParam(value = "id_keluarga", required = true) String id_keluarga,
            @RequestParam(value = "status_dalam_keluarga", required = true) String status_dalam_keluarga)
    {	
    	
    	CitizenModel citizen = new CitizenModel();
    	//Assign value
    	citizen.setNama(nama);
    	citizen.setTempat_lahir(tempat_lahir);
    	citizen.setTanggal_lahir(tanggal_lahir);
    	citizen.setGolongan_darah(golongan_darah);
    	citizen.setAgama(agama);
    	citizen.setPekerjaan(pekerjaan.toUpperCase());
    	citizen.setStatus_perkawinan(status_perkawinan);
    	citizen.setId_keluarga(Integer.parseInt(id_keluarga));
    	citizen.setJenis_kelamin(Integer.parseInt(jenis_kelamin));
    	citizen.setStatus_dalam_keluarga(status_dalam_keluarga);
    	citizen.setIs_wafat(Integer.parseInt(status_kematian));
    	
    	//Generate Id
    	citizen.setId(citizenDAO.countPenduduk() + 1);
    	
    	//Convert data is_wni
    	if(kewarganegaraan.equalsIgnoreCase("Indonesia")) {
    		citizen.setIs_wni(1);
    	} else {
    		citizen.setIs_wni(0);
    	}
    	
    	//Generate NIK
    	String nik = "";
    	FamilyModel family = citizenDAO.selectFamilyId(Integer.parseInt(id_keluarga));
    	String kode_kecamatan = citizenDAO.selectKodeKecamatan(family.getNama_kecamatan());
    	nik = (nik + kode_kecamatan.substring(0,6));
    	System.out.println(nik + " panjangnya " + nik.length());
    	
    	//Convert date
    	System.out.println(tanggal_lahir);
    	String tahun = tanggal_lahir.substring(6);
    	String bulan = tanggal_lahir.substring(3, 5);
    	String hari = tanggal_lahir.substring(0, 2);
    	int female_hari = 0;
    	
    	if(Integer.parseInt(jenis_kelamin) == 1) { // Jika perempuan
    		female_hari = Integer.parseInt(hari) + 40;
    		tahun = tahun.substring(2);
    		nik = nik + female_hari + bulan + tahun;
    		System.out.println(nik + " panjangnya " + nik.length());
    	} else {
    		tahun = tahun.substring(2);
    		nik = nik + hari + bulan + tahun;
    		System.out.println(nik + " panjangnya " + nik.length());
    	}
    	
    	//Reverse tanggal_lahir
    	tanggal_lahir = tahun + "-" + bulan + "-" + hari;
    	citizen.setTanggal_lahir(tanggal_lahir);
    	
    	//Generate latest digit
    	int numberOfIdenticalCitizens = citizenDAO.countIdenticalCitizens(nik);
    	System.out.println("jumlah yg serupa " + numberOfIdenticalCitizens);
    	
    	if(numberOfIdenticalCitizens >= 1) {
    		int latestId = numberOfIdenticalCitizens + 1;
    		String convertedId;
    		if(Integer.toString(latestId).length()==1) {
    			convertedId = "000" + latestId;
    		} else if (Integer.toString(latestId).length()==2) {
    			convertedId = "00" + latestId;
    		} else if (Integer.toString(latestId).length()==3) {
    			convertedId = "0" + latestId;
    		} else {
    			convertedId = Integer.toString(latestId);
    		}
    		nik = nik + convertedId;
    		citizen.setNik(nik);
    		System.out.println(nik + " panjangnya " + nik.length());
    		citizenDAO.addCitizen(citizen);
    	} else {
    		nik = nik + "0001";
    		citizen.setNik(nik);
    		System.out.println(nik + " panjangnya " + nik.length());
    		citizenDAO.addCitizen(citizen);
    	}
    	
    	model.addAttribute("nik", nik);
        return "tambah-penduduk-berhasil";
    	
    }
    
    @RequestMapping("/penduduk/ubah/{nik}")
    public String updateCitizenSubmit( Model model,
    		@PathVariable String nik) {
    	CitizenModel citizen = citizenDAO.selectCitizen(nik);
    	if(citizen == null) {
    		model.addAttribute("nik", nik);
    		return "citizen-not-found";
    	}
    	
    	//Convert date
    	String tanggal_lahir = citizen.getTanggal_lahir();
    	System.out.println(tanggal_lahir);
    	String tahun = tanggal_lahir.substring(0, 4);
    	String bulan = tanggal_lahir.substring(5, 7);
    	String hari = tanggal_lahir.substring(8, 10);
    	tanggal_lahir = hari + "-" + bulan + "-" + tahun;
    	System.out.println(tanggal_lahir);
    	
    	//Convert kewarganegaraan
    	String kewarganegaraan = "";
    	if(citizen.getIs_wni() == 1) {
    		kewarganegaraan = "INDONESIA";
    	} else {
    		kewarganegaraan = "ASING";
    	}
    	
    	model.addAttribute("tanggal_lahir", tanggal_lahir);
    	model.addAttribute("kewarganegaraan", kewarganegaraan);
    	model.addAttribute("citizen", citizen);
    	return "ubah-penduduk";
    }
    
    @RequestMapping(value = "/penduduk/ubah/{nik}", method = RequestMethod.POST)
    public String updateCitizenSubmit( Model model,
    		@RequestParam(value = "id", required = true) String id,
            @RequestParam(value = "nama", required = true) String nama,
            @RequestParam(value = "tempat_lahir", required = true) String tempat_lahir,
            @RequestParam(value = "tanggal_lahir", required = true) String tanggal_lahir,
            @RequestParam(value = "golongan_darah", required = true) String golongan_darah,
            @RequestParam(value = "jenis_kelamin", required = true) String jenis_kelamin,
            @RequestParam(value = "agama", required = true) String agama,
            @RequestParam(value = "status_perkawinan", required = true) String status_perkawinan,
            @RequestParam(value = "pekerjaan", required = true) String pekerjaan,
            @RequestParam(value = "kewarganegaraan", required = true) String kewarganegaraan,
            @RequestParam(value = "status_kematian", required = true) String status_kematian,
            @RequestParam(value = "id_keluarga", required = true) String id_keluarga,
            @RequestParam(value = "status_dalam_keluarga", required = true) String status_dalam_keluarga)
    {	
    	//Retrieve old nik
    	String nik_lama = citizenDAO.selectCitizenId(id).getNik();
    	
    	CitizenModel citizen = new CitizenModel();
    	
    		//Set atribut baru
    		citizen.setId(Integer.parseInt(id));
    		citizen.setNama(nama);
    		citizen.setTempat_lahir(tempat_lahir);
    		citizen.setTanggal_lahir(tanggal_lahir);
    		citizen.setGolongan_darah(golongan_darah);
    		citizen.setJenis_kelamin(Integer.parseInt(jenis_kelamin));
    		citizen.setAgama(agama);
    		citizen.setStatus_perkawinan(status_perkawinan);
    		citizen.setPekerjaan(pekerjaan);
    		if(kewarganegaraan.equalsIgnoreCase("INDONESIA")) {
    			citizen.setIs_wni(1);
    		} else {
    			citizen.setIs_wni(0);
    		}
    		citizen.setIs_wafat(Integer.parseInt(status_kematian));
    		citizen.setId_keluarga(Integer.parseInt(id_keluarga));
    		citizen.setStatus_dalam_keluarga(status_dalam_keluarga);    	
    		
    		//Reconfigure NIK
    		String nik = "";
        	FamilyModel family = citizenDAO.selectFamilyId(Integer.parseInt(id_keluarga));
        	String kode_kecamatan = citizenDAO.selectKodeKecamatan(family.getNama_kecamatan());
        	nik = (nik + kode_kecamatan.substring(0,6));
        	System.out.println(nik + " panjangnya " + nik.length());
        	
        	//Convert date
        	System.out.println(tanggal_lahir);
        	String tahun = tanggal_lahir.substring(6);
        	String bulan = tanggal_lahir.substring(3, 5);
        	String hari = tanggal_lahir.substring(0, 2);
        	int female_hari = 0;
        	
        	if(Integer.parseInt(jenis_kelamin) == 1) { // Jika perempuan
        		female_hari = Integer.parseInt(hari) + 40;
        		tahun = tahun.substring(2);
        		nik = nik + female_hari + bulan + tahun;
        		System.out.println(nik + " panjangnya " + nik.length());
        	} else {
        		tahun = tahun.substring(2);
        		nik = nik + hari + bulan + tahun;
        		System.out.println(nik + " panjangnya " + nik.length());
        	}
        	
        	//Reverse tanggal_lahir
        	tanggal_lahir = tahun + "-" + bulan + "-" + hari;
        	citizen.setTanggal_lahir(tanggal_lahir);
        	
        	//Generate latest digit
        	int numberOfIdenticalCitizens = citizenDAO.countIdenticalCitizens(nik);
        	System.out.println("jumlah yg serupa " + numberOfIdenticalCitizens);
        	
        	if(numberOfIdenticalCitizens >= 1) {
        		
        		if(nik.equals(nik_lama.substring(0, 12))) { // NIK tidak berubah
        			
        			citizen.setNik(nik_lama);
            		System.out.println(nik_lama + " panjangnya " + nik_lama.length());
            		citizenDAO.updateCitizen(citizen);
            		System.out.println("NIK sama/Tidak Ada Perubahan Pada Tanggal Lahir dan Keluarga");
            		
        		} else { // NIK berubah
        		
        			int latestId = numberOfIdenticalCitizens + 1;
            		String convertedId;
            		if(Integer.toString(latestId).length()==1) {
            			convertedId = "000" + latestId;
            		} else if (Integer.toString(latestId).length()==2) {
            			convertedId = "00" + latestId;
            		} else if (Integer.toString(latestId).length()==3) {
            			convertedId = "0" + latestId;
            		} else {
            			convertedId = Integer.toString(latestId);
            		}
            		nik = nik + convertedId;
            		
            		citizen.setNik(nik);
                	System.out.println(nik + " panjangnya " + nik.length());
                	citizenDAO.updateCitizen(citizen);
                	
                	System.out.println("NIK Ada Perubahan Pada Tanggal Lahir atau Keluarga");
        		}
        		
        	} else {
        		
        		nik = nik + "0001";
        		
        		citizen.setNik(nik);
        		System.out.println(nik + " panjangnya " + nik.length());
        		citizenDAO.updateCitizen(citizen);
        	}
    		
    	model.addAttribute("nik", nik);
    	model.addAttribute("nik_lama", nik_lama);
        return "ubah-penduduk-berhasil";
    }
    
    @RequestMapping("/keluarga/tambah")
    public String add ()
    {
        return "tambah-keluarga";
    }
    
    @RequestMapping(value = "/keluarga/tambah", method = RequestMethod.POST)
    public String addSubmit ( Model model,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "rt", required = true) String rt,
            @RequestParam(value = "rw", required = true) String rw,
            @RequestParam(value = "nama_kelurahan", required = true) String nama_kelurahan,
            @RequestParam(value = "nama_kecamatan", required = true) String nama_kecamatan,
            @RequestParam(value = "nama_kota", required = true) String nama_kota)
    {	
    	FamilyModel family = new FamilyModel();
    	family.setAlamat(alamat);
    	family.setRt(rt);
    	family.setRw(rw);
    	String id_kelurahan = citizenDAO.selectIdKelurahan(nama_kelurahan.toUpperCase());
    	family.setId_kelurahan(id_kelurahan);
    	family.setId(citizenDAO.countKeluarga() + 1);
    	
    	//Generate Nomor Keluarga
    	String nomor_kk = "";
    	String kode_kelurahan = citizenDAO.selectKodeKelurahan(nama_kelurahan.toUpperCase());
    	nomor_kk = (nomor_kk + kode_kelurahan).substring(0, 6);
    	
    	//Generate tanggal pembuatan
    	DateFormat dateFormatHari = new SimpleDateFormat("dd");
    	Date dateHari = new Date();
    	String hari = dateFormatHari.format(dateHari);
    	DateFormat dateFormatBulan = new SimpleDateFormat("MM");
    	Date dateBulan = new Date();
    	String bulan = dateFormatBulan.format(dateBulan);
    	DateFormat dateFormatTahun = new SimpleDateFormat("yyyy");
    	Date dateTahun = new Date();
    	String tahun = (dateFormatTahun.format(dateTahun)).substring(2);
    	nomor_kk = nomor_kk + hari + bulan + tahun;
    	System.out.println(nomor_kk + " panjangnya " + nomor_kk.length());
    	
    	//Generate latest digit
    	int numberOfIdenticalFamilies = citizenDAO.countIdenticalFamilies(nomor_kk);
    	System.out.println("jumlah yg serupa " + numberOfIdenticalFamilies);
    	
    	if(numberOfIdenticalFamilies >= 1) {
    		int latestId = numberOfIdenticalFamilies + 1;
    		String convertedId;
    		if(Integer.toString(latestId).length()==1) {
    			convertedId = "000" + latestId;
    		} else if (Integer.toString(latestId).length()==2) {
    			convertedId = "00" + latestId;
    		} else if (Integer.toString(latestId).length()==3) {
    			convertedId = "0" + latestId;
    		} else {
    			convertedId = Integer.toString(latestId);
    		}
    		nomor_kk = nomor_kk + convertedId;
    		family.setNomor_kk(nomor_kk);
    		System.out.println(nomor_kk + " panjangnya " + nomor_kk.length());
    		citizenDAO.addFamily(family);
    	} else {
    		nomor_kk = nomor_kk + "0001";
    		family.setNomor_kk(nomor_kk);
    		System.out.println(nomor_kk + " panjangnya " + nomor_kk.length());
    		citizenDAO.addFamily(family);
    	}
    	
    	model.addAttribute("nomor_kk", nomor_kk);
        return "tambah-keluarga-berhasil";
    }
    
    
    @RequestMapping("/keluarga/ubah/{nomor_kk}")
    public String updateFamily( Model model,
    		@PathVariable String nomor_kk) {
    	FamilyModel family = citizenDAO.selectFamily(nomor_kk);
    	
    	if(family == null) {
    		model.addAttribute("nomor_kk", nomor_kk);
    		return "family-not-found";
    	}
    	
    	int id = family.getId();
    	model.addAttribute("id", id);
    	model.addAttribute("family", family);
    	
    	return "ubah-keluarga";
    }
    
    /*@RequestMapping(value = "/keluarga/ubah/{nomor_kk}", method = RequestMethod.POST)
    public String updateFamilySubmit( Model model,
    		@RequestParam(value = "id", required = true) String id,
    		@RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "rt", required = true) String rt,
            @RequestParam(value = "rw", required = true) String rw,
            @RequestParam(value = "nama_kelurahan", required = true) String nama_kelurahan,
            @RequestParam(value = "nama_kecamatan", required = true) String nama_kecamatan,
            @RequestParam(value = "nama_kota", required = true) String nama_kota,
            @RequestParam(value = "is_tidak_berlaku", required = true) String is_tidak_berlaku)
    {	
    	//Retrieve old nomor_kk
    	String nomor_kk_lama = citizenDAO.selectFamilyId(Integer.parseInt(id)).getNomor_kk();
    	
    	FamilyModel family = new FamilyModel();
    	family.setId(Integer.parseInt(id));
    	family.setAlamat(alamat);
    	family.setRt(rt);
    	family.setRw(rw);
    	String id_kelurahan = citizenDAO.selectIdKelurahan(nama_kelurahan.toUpperCase());
    	family.setId_kelurahan(id_kelurahan);
    	
    	//Generate Nomor Keluarga
    	String nomor_kk = "";
    	String kode_kelurahan = citizenDAO.selectKodeKelurahan(nama_kelurahan.toUpperCase());
    	nomor_kk = (nomor_kk + kode_kelurahan).substring(0, 6);
    	
    	//Generate tanggal pembuatan
    	DateFormat dateFormatHari = new SimpleDateFormat("dd");
    	Date dateHari = new Date();
    	String hari = dateFormatHari.format(dateHari);
    	DateFormat dateFormatBulan = new SimpleDateFormat("MM");
    	Date dateBulan = new Date();
    	String bulan = dateFormatBulan.format(dateBulan);
    	DateFormat dateFormatTahun = new SimpleDateFormat("yyyy");
    	Date dateTahun = new Date();
    	String tahun = (dateFormatTahun.format(dateTahun)).substring(2);
    	nomor_kk = nomor_kk + hari + bulan + tahun;
    	System.out.println(nomor_kk + " panjangnya " + nomor_kk.length());
    	
    	//Generate latest digit
    	int numberOfIdenticalFamilies = citizenDAO.countIdenticalFamilies(nomor_kk);
    	System.out.println("jumlah yg serupa " + numberOfIdenticalFamilies);
    	
    	if(numberOfIdenticalFamilies >= 1) {
    		int latestId = 0;
    		//Check if same family
    		//if(nomor_kk.equals(nomor_kk_lama.substring(0,13))) {
    			latestId = numberOfIdenticalFamilies + 1;
    		//} else {
    			//latestId = numberOfIdenticalFamilies;
    		//}
    		String convertedId;
    		if(Integer.toString(latestId).length()==1) {
    			convertedId = "000" + latestId;
    		} else if (Integer.toString(latestId).length()==2) {
    			convertedId = "00" + latestId;
    		} else if (Integer.toString(latestId).length()==3) {
    			convertedId = "0" + latestId;
    		} else {
    			convertedId = Integer.toString(latestId);
    		}
    		nomor_kk = nomor_kk + convertedId;
    		family.setNomor_kk(nomor_kk);
    		System.out.println(nomor_kk + " panjangnya " + nomor_kk.length());
    		citizenDAO.updateFamily(family);
    	} else {
    		nomor_kk = nomor_kk + "0001";
    		family.setNomor_kk(nomor_kk);
    		System.out.println(nomor_kk + " panjangnya " + nomor_kk.length());
    		citizenDAO.updateFamily(family);
    	}
    	
    	model.addAttribute("nomor_kk", nomor_kk);
    	model.addAttribute("nomor_kk_lama", nomor_kk_lama);
    	return "ubah-keluarga-berhasil";
    }*/
    
    @RequestMapping(value = "/keluarga/ubah/{nomor_kk}", method = RequestMethod.POST)
    public String updateFamilySubmit( Model model,
    		@RequestParam(value = "id", required = true) String id,
    		@RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "rt", required = true) String rt,
            @RequestParam(value = "rw", required = true) String rw,
            @RequestParam(value = "nama_kelurahan", required = true) String nama_kelurahan,
            @RequestParam(value = "nama_kecamatan", required = true) String nama_kecamatan,
            @RequestParam(value = "nama_kota", required = true) String nama_kota,
            @RequestParam(value = "is_tidak_berlaku", required = true) String is_tidak_berlaku)
    {	
    	//Retrieve old nomor_kk
    	String nomor_kk_lama = citizenDAO.selectFamilyId(Integer.parseInt(id)).getNomor_kk();
    	
    	FamilyModel family = new FamilyModel();
    	family.setId(Integer.parseInt(id));
    	family.setAlamat(alamat);
    	family.setRt(rt);
    	family.setRw(rw);
    	String id_kelurahan = citizenDAO.selectIdKelurahan(nama_kelurahan.toUpperCase());
    	family.setId_kelurahan(id_kelurahan);
    	
    	//Generate Nomor Keluarga
    	String nomor_kk = "";
    	String kode_kelurahan = citizenDAO.selectKodeKelurahan(nama_kelurahan.toUpperCase());
    	nomor_kk = (nomor_kk + kode_kelurahan).substring(0, 6);
    	
    	//Generate tanggal pembuatan
    	DateFormat dateFormatHari = new SimpleDateFormat("dd");
    	Date dateHari = new Date();
    	String hari = dateFormatHari.format(dateHari);
    	DateFormat dateFormatBulan = new SimpleDateFormat("MM");
    	Date dateBulan = new Date();
    	String bulan = dateFormatBulan.format(dateBulan);
    	DateFormat dateFormatTahun = new SimpleDateFormat("yyyy");
    	Date dateTahun = new Date();
    	String tahun = (dateFormatTahun.format(dateTahun)).substring(2);
    	nomor_kk = nomor_kk + hari + bulan + tahun;
    	System.out.println(nomor_kk + " panjangnya " + nomor_kk.length());
    	
    	//Generate latest digit
    	int numberOfIdenticalFamilies = citizenDAO.countIdenticalFamilies(nomor_kk);
    	System.out.println("jumlah yg serupa " + numberOfIdenticalFamilies);
    	
    	if(numberOfIdenticalFamilies >= 1) {
    		
    		if(nomor_kk.equals(nomor_kk_lama.substring(0, 12))) { // NKK tidak berubah
    			
    			family.setNomor_kk(nomor_kk_lama);
        		System.out.println(nomor_kk_lama + " panjangnya " + nomor_kk_lama.length());
        		citizenDAO.updateFamily(family);
        		System.out.println("NKK sama/Tidak Ada Perubahan Pada Tanggal Pembuatan dan Lokasi");
        		
    		} else { // NKK berubah
    		
    			int latestId = numberOfIdenticalFamilies + 1;
        		String convertedId;
        		if(Integer.toString(latestId).length()==1) {
        			convertedId = "000" + latestId;
        		} else if (Integer.toString(latestId).length()==2) {
        			convertedId = "00" + latestId;
        		} else if (Integer.toString(latestId).length()==3) {
        			convertedId = "0" + latestId;
        		} else {
        			convertedId = Integer.toString(latestId);
        		}
        		nomor_kk = nomor_kk + convertedId;
        		
        		family.setNomor_kk(nomor_kk);
            	System.out.println(nomor_kk + " panjangnya " + nomor_kk.length());
            	citizenDAO.updateFamily(family);
            	
            	System.out.println("NKK Ada Perubahan Pada Tanggal Pembuatan atau Lokasi");
    		}
    		
    	} else {
    		nomor_kk = nomor_kk + "0001";
    		
    		family.setNomor_kk(nomor_kk);
    		System.out.println(nomor_kk + " panjangnya " + nomor_kk.length());
    		citizenDAO.updateFamily(family);
    	}
    	
    	model.addAttribute("nomor_kk", nomor_kk);
    	model.addAttribute("nomor_kk_lama", nomor_kk_lama);
    	return "ubah-keluarga-berhasil";
    }


    @RequestMapping("/penduduk")
    public String viewCitizen(Model model,
            @RequestParam(value = "nik", required = true) String nik)
    {
        CitizenModel citizen = citizenDAO.selectCitizen(nik);

        if (citizen != null) {
        	
        	//Convert Status Kematian
        	if (citizen.getIs_wafat() == 0) {
        		citizen.setStatus_kematian("Hidup");
        	} else {
        		citizen.setStatus_kematian("Wafat");
        	}
        	
        	//Convert Kewarganegaraan
        	if (citizen.getIs_wni() == 0) {
        		citizen.setKewarganegaraan("WNA");
        	} else {
        		citizen.setKewarganegaraan("WNI");
        	}
        	
            model.addAttribute ("citizen", citizen);
            return "penduduk";
        } else {
            model.addAttribute ("nik", nik);
            return "citizen-not-found";
        }
    }


    @RequestMapping("/penduduk/view/{nik}")
    public String viewCitizenPath(Model model,
            @PathVariable(value = "nik") String nik)
    {
    	CitizenModel citizen = citizenDAO.selectCitizen(nik);

    	if (citizen != null) {
        	
        	//Convert Status Kematian
        	if (citizen.getIs_wafat() == 0) {
        		citizen.setStatus_kematian("Hidup");
        	} else {
        		citizen.setStatus_kematian("Wafat");
        	}
        	
        	//Convert Kewarganegaraan
        	if (citizen.getIs_wni() == 0) {
        		citizen.setKewarganegaraan("WNA");
        	} else {
        		citizen.setKewarganegaraan("WNI");
        	}
        	
            model.addAttribute ("citizen", citizen);
            return "penduduk";
        } else {
            model.addAttribute ("nik", nik);
            return "citizen-not-found";
        }
    }
    
    @RequestMapping("/penduduk/mati")
    public String setWafat(Model model,
    		@RequestParam(value = "nik", required = true) String nik) {
    	CitizenModel citizen = citizenDAO.selectCitizen(nik);
    	
    	citizenDAO.setWafat(citizen);
    	citizen = citizenDAO.selectCitizen(nik);
    	int baruBerpulang = 1;
    	
    	if(citizen.getIs_wafat() == 1) {
    		model.addAttribute ("citizen", citizen);
    		model.addAttribute("nik", nik);
    		return "redirect:/penduduk" + "?nik=" + nik;
    	}
    	model.addAttribute("nik", nik);
    	return "citizen-not-found";
    }
    
    @RequestMapping("/keluarga")
    public String viewFamily(Model model,
            @RequestParam(value = "nkk", required = true) String nkk)
    {
        FamilyModel family = citizenDAO.selectFamily(nkk);

        if (family != null) {
        	
        	//Convert is tidak berlaku
        	if (family.getIs_tidak_berlaku() == 0) {
        		family.setBerlaku("Berlaku");
        	} else {
        		family.setBerlaku("Tidak Berlaku");
        	}
        	
        	//Convert Data Individu (Jenis Kelamin, Kewarganegaraan, Status Kematian)
        	
        	for(int i = 0; i < family.getAnggotaKeluarga().size(); i++) {
        		if(family.getAnggotaKeluarga().get(i).getJenis_kelamin() == 0) {
        			family.getAnggotaKeluarga().get(i).setJenisKelamin("Laki-Laki");
        		} else {
        			family.getAnggotaKeluarga().get(i).setJenisKelamin("Perempuan");
        		}
        		
        		if(family.getAnggotaKeluarga().get(i).getIs_wni() == 0) {
        			family.getAnggotaKeluarga().get(i).setKewarganegaraan("WNA");
        		} else {
        			family.getAnggotaKeluarga().get(i).setKewarganegaraan("WNI");
        		}
        		
        		if(family.getAnggotaKeluarga().get(i).getIs_wafat() == 0) {
        			family.getAnggotaKeluarga().get(i).setStatus_kematian("Hidup");
        		} else {
        			family.getAnggotaKeluarga().get(i).setStatus_kematian("Wafat");
        		}
        		
        	}
        	
        	if(family.getIs_tidak_berlaku() == 0) {
        		int countWafat = 0;
        		for(int i = 0; i < family.getAnggotaKeluarga().size(); i++) {
        			if(family.getAnggotaKeluarga().get(i).getIs_wafat() == 1) {
        				countWafat++;
        			}
        		}
        		
        		if(countWafat == family.getAnggotaKeluarga().size() && countWafat > 0) {
        			family.setIs_tidak_berlaku(1);
        			family.setBerlaku("Tidak Berlaku");
        			citizenDAO.setTidakBerlaku(family);
        		}
        	} 
        	
            model.addAttribute ("family", family);
            return "keluarga";
        } else {
            model.addAttribute ("nomor_kk", nkk);
            return "family-not-found";
        }
    }
    
    @RequestMapping("/keluarga/view/{nkk}")
    public String viewFamilyPath(Model model,
            @PathVariable(value = "nkk") String nkk)
    {
        FamilyModel family = citizenDAO.selectFamily(nkk);

        if (family != null) {
        	
        	//Convert is tidak berlaku
        	if (family.getIs_tidak_berlaku() == 0) {
        		family.setBerlaku("Berlaku");
        	} else {
        		family.setBerlaku("Tidak Berlaku");
        	}
        	
        	//Convert Data Individu (Jenis Kelamin, Kewarganegaraan, Status Kematian)
        	
        	for(int i = 0; i < family.getAnggotaKeluarga().size(); i++) {
        		if(family.getAnggotaKeluarga().get(i).getJenis_kelamin() == 0) {
        			family.getAnggotaKeluarga().get(i).setJenisKelamin("Laki-Laki");
        		} else {
        			family.getAnggotaKeluarga().get(i).setJenisKelamin("Perempuan");
        		}
        		
        		if(family.getAnggotaKeluarga().get(i).getIs_wni() == 0) {
        			family.getAnggotaKeluarga().get(i).setKewarganegaraan("WNA");
        		} else {
        			family.getAnggotaKeluarga().get(i).setKewarganegaraan("WNI");
        		}
        		
        		if(family.getAnggotaKeluarga().get(i).getIs_wafat() == 0) {
        			family.getAnggotaKeluarga().get(i).setStatus_kematian("Hidup");
        		} else {
        			family.getAnggotaKeluarga().get(i).setStatus_kematian("Wafat");
        		}
        		
        	}
        	
            model.addAttribute ("family", family);
            return "keluarga";
        } else {
            model.addAttribute ("nomor_kk", nkk);
            return "family-not-found";
        }
    }
    
    @RequestMapping(value = "/penduduk/cari", method = RequestMethod.GET)
    public String searchCitizen(Model model,  
    		@RequestParam(value="kt", required = false) String id_kota,
    		@RequestParam(value="kc", required = false) String id_kecamatan,
    		@RequestParam(value="kl", required = false) String id_kelurahan) {
    	if(id_kota == null && id_kecamatan == null && id_kelurahan == null) {
    		return "pilih-kota";
    		
    	} else if (id_kecamatan == null && id_kelurahan == null) {
    		CityModel city = citizenDAO.selectCity(id_kota);
        	
        	if(city == null) {
        		return "error";
        	} else {
        		model.addAttribute("kota", city);
        		return "pilih-kecamatan";
        	}
        	
    	} else if (id_kelurahan == null) {
    		CityModel city = citizenDAO.selectCity(id_kota);
        	KecamatanModel kecamatan = citizenDAO.selectKecamatan(id_kecamatan);
        	
        	if(kecamatan == null) {
        		return "error";
        	} else {
        		model.addAttribute("kota", city);
        		model.addAttribute("kecamatan", kecamatan);
        		
        		return "pilih-kelurahan";
        	}
    		
    	} else {
    		CityModel city = citizenDAO.selectCity(id_kota);
        	KecamatanModel kecamatan = citizenDAO.selectKecamatan(id_kecamatan);
        	KelurahanModel kelurahan = citizenDAO.selectKelurahan(id_kelurahan);
        	
        	CitizenModel termuda = citizenDAO.selectYoungest(id_kelurahan);
        	CitizenModel tertua = citizenDAO.selectOldest(id_kelurahan);
        	
        	System.out.println(tertua.getNama());
        	System.out.println(termuda.getNama());
        	
        	if(kelurahan == null) {
        		return "error";
        	} else {
        		model.addAttribute("kota", city);
        		model.addAttribute("kecamatan", kecamatan);
        		model.addAttribute("kelurahan", kelurahan);  	
        		model.addAttribute("youngest", termuda);
        		model.addAttribute("oldest", tertua);  	
        		return "penduduk-kelurahan";
        	}
    	}
    }

}
