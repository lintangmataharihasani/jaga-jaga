package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Many;

import com.example.model.CitizenModel;
import com.example.model.CityModel;
import com.example.model.FamilyModel;
import com.example.model.KecamatanModel;
import com.example.model.KelurahanModel;

@Mapper
public interface CitizenMapper
{
	
	@Select("SELECT p.id, p.nik, p.nama, p.tempat_lahir, p.tanggal_lahir, p.jenis_kelamin, p.is_wni, p.id_keluarga, "
			+ "p.agama, p.pekerjaan, p.status_perkawinan, p.status_dalam_keluarga, p.golongan_darah, p.is_wafat,"
			+ "kel.RT, kel.RW, kel.alamat,lurah.nama_kelurahan, camat.nama_kecamatan, kot.nama_kota  "
			+ "FROM penduduk p, keluarga kel, kelurahan lurah, kecamatan camat, kota kot WHERE nik = #{nik} "
			+ "AND p.id_keluarga = kel.id AND lurah.id = kel.id_kelurahan AND lurah.id_kecamatan = camat.id "
			+ "AND camat.id_kota = kot.id")
    CitizenModel selectCitizen(@Param("nik") String nik);
	
	@Select("SELECT p.id, p.nik, p.nama, p.tempat_lahir, p.tanggal_lahir, p.jenis_kelamin, p.is_wni, p.id_keluarga, "
			+ "p.agama, p.pekerjaan, p.status_perkawinan, p.status_dalam_keluarga, p.golongan_darah, p.is_wafat,"
			+ "kel.RT, kel.RW, kel.alamat,lurah.nama_kelurahan, camat.nama_kecamatan, kot.nama_kota  "
			+ "FROM penduduk p, keluarga kel, kelurahan lurah, kecamatan camat, kota kot WHERE p.id = #{id} "
			+ "AND p.id_keluarga = kel.id AND lurah.id = kel.id_kelurahan AND lurah.id_kecamatan = camat.id "
			+ "AND camat.id_kota = kot.id")
    CitizenModel selectCitizenId(@Param("id") String id);
	
	@Select("SELECT kel.id, kel.nomor_kk, kel.alamat, kel.rt, kel.rw, kel.id_kelurahan, lurah.nama_kelurahan, camat.nama_kecamatan, kot.nama_kota "
			+ "FROM keluarga kel, kelurahan lurah, kecamatan camat, kota kot "
			+ "WHERE kel.id_kelurahan = lurah.id AND lurah.id_kecamatan = camat.id AND camat.id_kota = kot.id "
			+ "AND kel.nomor_kk = #{nkk}")
	@Results(value = {
		@Result(property="id", column="id"),
		@Result(property="nomor_kk", column="nomor_kk"),
		@Result(property="alamat", column="alamat"),
		@Result(property="rt", column="rt"),
		@Result(property="rw", column="rw"),
		@Result(property="nama_kelurahan", column="nama_kelurahan"),
		@Result(property="nama_kecamatan", column="nama_kecamatan"),
		@Result(property="nama_kota", column="nama_kota"),
		@Result(property="is_tidak_berlaku", column="is_tidak_berlaku"),
		@Result(property="anggotaKeluarga", column="id",
		javaType = List.class,
		many=@Many(select="selectCitizens"))
	})
	FamilyModel selectFamily(@Param("nkk") String nkk);
	
	@Select("SELECT kel.id, kel.nomor_kk, kel.alamat, kel.rt, kel.rw, kel.id_kelurahan, lurah.nama_kelurahan, camat.nama_kecamatan, kot.nama_kota "
			+ "FROM keluarga kel, kelurahan lurah, kecamatan camat, kota kot "
			+ "WHERE kel.id_kelurahan = lurah.id AND lurah.id_kecamatan = camat.id AND camat.id_kota = kot.id "
			+ "AND kel.id = #{id_keluarga}")
	@Results(value = {
		@Result(property="id", column="id"),
		@Result(property="nomor_kk", column="nomor_kk"),
		@Result(property="alamat", column="alamat"),
		@Result(property="rt", column="rt"),
		@Result(property="rw", column="rw"),
		@Result(property="nama_kelurahan", column="nama_kelurahan"),
		@Result(property="nama_kecamatan", column="nama_kecamatan"),
		@Result(property="nama_kota", column="nama_kota"),
		@Result(property="is_tidak_berlaku", column="is_tidak_berlaku"),
		@Result(property="anggotaKeluarga", column="id",
		javaType = List.class,
		many=@Many(select="selectCitizens"))
	})
	FamilyModel selectFamilyId(@Param("id_keluarga") int id_keluarga);

	@Select("SELECT p.id, p.nik, p.nama, p.tempat_lahir, p.tanggal_lahir, p.jenis_kelamin, p.is_wni, p.id_keluarga, "
			+ "p.agama, p.pekerjaan, p.status_perkawinan, p.status_dalam_keluarga, p.golongan_darah, p.is_wafat,"
			+ "kel.RT, kel.RW, kel.alamat,lurah.nama_kelurahan, camat.nama_kecamatan, kot.nama_kota  "
			+ "FROM penduduk p, keluarga kel, kelurahan lurah, kecamatan camat, kota kot WHERE p.id_keluarga = #{id_keluarga} "
			+ "AND p.id_keluarga = kel.id AND lurah.id = kel.id_kelurahan AND lurah.id_kecamatan = camat.id "
			+ "AND camat.id_kota = kot.id")
    List<CitizenModel> selectCitizens(@Param("id_keluarga") String id_keluarga);

    @Insert("INSERT INTO penduduk"
    		+ " (id, nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, is_wni, id_keluarga, " 
    		+ "agama, pekerjaan, status_perkawinan, status_dalam_keluarga, golongan_darah, is_wafat) "
    		+ "VALUES (#{id}, #{nik}, #{nama}, #{tempat_lahir}, #{tanggal_lahir}, #{jenis_kelamin}, #{is_wni}, #{id_keluarga}, #{agama},"
    		+ "#{pekerjaan}, #{status_perkawinan}, #{status_dalam_keluarga}, #{golongan_darah}, #{is_wafat})")
    void addCitizen(CitizenModel citizen);
    
    @Insert("UPDATE penduduk SET "
    		+ "nama =  #{nama}, tempat_lahir = #{tempat_lahir}, tanggal_lahir = #{tanggal_lahir}, jenis_kelamin = #{jenis_kelamin}, "
    		+ "is_wni = #{is_wni}, id_keluarga = #{id_keluarga}, agama = #{agama}, pekerjaan = #{pekerjaan}, status_perkawinan = #{status_perkawinan}, "
    		+ "status_dalam_keluarga = #{status_dalam_keluarga}, golongan_darah = #{golongan_darah}, is_wafat = #{is_wafat}, nik = #{nik} "
    		+ "WHERE id = #{id}")
    void updateCitizen(CitizenModel citizen);
    
    @Insert("UPDATE penduduk SET "
    		+ "is_wafat = 1 "
    		+ "WHERE id = #{id}")
    void setWafat(CitizenModel citizen);
    
    @Insert("INSERT INTO keluarga"
    		+ " (id, nomor_kk, alamat, rt, rw, id_kelurahan, is_tidak_berlaku) "
    		+ "VALUES (#{id}, #{nomor_kk}, #{alamat}, #{rt}, #{rw}, #{id_kelurahan}, #{is_tidak_berlaku})")
    void addFamily(FamilyModel family);
    
    @Insert("UPDATE keluarga SET "
    		+ "nomor_kk =  #{nomor_kk}, alamat = #{alamat}, rt = #{rt}, rw = #{rw}, id_kelurahan = #{id_kelurahan}, is_tidak_berlaku = #{is_tidak_berlaku} "
    		+ "WHERE id = #{id}")
    void updateFamily(FamilyModel family);
    
    @Insert("UPDATE keluarga SET "
    		+ "is_tidak_berlaku = 1 "
    		+ "WHERE id = #{id}")
    void setTidakBerlaku(FamilyModel family);
    
    //Select Location Data
    @Select("SELECT * FROM kota WHERE id = #{id_kota}")
    @Results(value = {
    		@Result(property="id", column="id"),
    		@Result(property="kode_kota", column="kode_kota"),
    		@Result(property="nama_kota", column="nama_kota"),
    		@Result(property="kecamatans", column="id",
    		javaType = List.class,
    		many=@Many(select="selectKecamatanKota"))
    	})
    CityModel selectCity (String id_kota);
    
    @Select("SELECT * FROM kecamatan WHERE id = #{id_kecamatan}")
    @Results(value = {
    		@Result(property="id", column="id"),
    		@Result(property="kode_kecamatan", column="kode_kecamatan"),
    		@Result(property="nama_kecamatan", column="nama_kecamatan"),
    		@Result(property="kelurahans", column="id",
    		javaType = List.class,
    		many=@Many(select="selectKelurahanKecamatan"))
    	})
    KecamatanModel selectKecamatan (String id_kecamatan);
    
    @Select("SELECT * FROM kelurahan WHERE id = #{id_kelurahan}")
    @Results(value = {
    		@Result(property="id", column="id"),
    		@Result(property="kode_kelurahan", column="kode_kelurahan"),
    		@Result(property="nama_kelurahan", column="nama_kelurahan"),
    		@Result(property="penduduk", column="id",
    		javaType = List.class,
    		many=@Many(select="selectPendudukKelurahan"))
    	})
    KelurahanModel selectKelurahan (String id_kelurahan);
    
    @Select("SELECT * FROM kecamatan WHERE id_kota = #{id_kota}")
    KecamatanModel selectKecamatanKota (@Param("id_kota") String id_kota);
    
    @Select("SELECT * FROM kelurahan WHERE id_kecamatan = #{id_kecamatan}")
    KelurahanModel selectKelurahanKecamatan (@Param("id_kecamatan") String id_kecamatan);
    
    @Select("SELECT p.id, p.nik, p.nama, p.tempat_lahir, p.tanggal_lahir, p.jenis_kelamin, p.is_wni, p.id_keluarga, "
			+ "p.agama, p.pekerjaan, p.status_perkawinan, p.status_dalam_keluarga, p.golongan_darah, p.is_wafat,"
			+ "kel.RT, kel.RW, kel.alamat,lurah.nama_kelurahan, camat.nama_kecamatan, kot.nama_kota  "
			+ "FROM penduduk p, keluarga kel, kelurahan lurah, kecamatan camat, kota kot WHERE "
			+ "p.id_keluarga = kel.id AND lurah.id = kel.id_kelurahan AND lurah.id_kecamatan = camat.id "
			+ "AND camat.id_kota = kot.id AND lurah.id = #{id_kelurahan}")
    CitizenModel selectPendudukKelurahan (String id_kelurahan);
    
    //Code Retrieval
    @Select("SELECT kode_kota FROM kota WHERE nama_kota = #{nama_kota}")
    String selectKodeKota(@Param("nama_kota") String nama_kota);
    
    @Select("SELECT kode_kecamatan FROM kecamatan WHERE nama_kecamatan = #{nama_kecamatan}")
    String selectKodeKecamatan(@Param("nama_kecamatan") String nama_kecamatan);
    
    @Select("SELECT kode_kelurahan FROM kelurahan WHERE nama_kelurahan = #{nama_kelurahan}")
    String selectKodeKelurahan(@Param("nama_kelurahan") String nama_kelurahan);
    
    @Select("SELECT kode_kelurahan FROM kelurahan WHERE id_kelurahan = #{id_kelurahan}")
    String selectKodeKelurahanId (@Param("id_kelurahan") int id_kelurahan);
    
    @Select("SELECT id FROM kelurahan WHERE nama_kelurahan = #{nama_kelurahan}")
    String selectIdKelurahan(@Param("nama_kelurahan") String nama_kelurahan);
    
    //Miscellaneous
    @Select("SELECT COUNT(id) FROM keluarga")
    int countKeluarga();
    
    @Select("SELECT COUNT(id) FROM penduduk")
    int countPenduduk();
    
    @Select("SELECT COUNT(id) FROM keluarga WHERE nomor_kk LIKE CONCAT('%',#{nomor_kk},'%')")
    int countIdenticalFamilies(String nomor_kk);
    
    @Select("SELECT COUNT(id) FROM penduduk WHERE nik LIKE CONCAT('%',#{nik},'%')")
    int countIdenticalCitizens(String nik);
    
    @Select("SELECT COUNT(*) FROM keluarga, kelurahan, kecamatan, kota WHERE "
    		+ "keluarga.id_kelurahan = kelurahan.id AND kelurahan.id_kecamatan = kecamatan.id "
    		+ "AND kecamatan.id_kota = kota.id AND kota.nama_kota = #{nama_kota}")
    int countKeluargaKota(String nama_kota);
    
    @Select("SELECT COUNT(*) FROM penduduk, keluarga, kelurahan, kecamatan, kota WHERE "
    		+ "keluarga.id_kelurahan = kelurahan.id AND kelurahan.id_kecamatan = kecamatan.id "
    		+ "AND kecamatan.id_kota = kota.id AND penduduk.id_keluarga = keluarga.id AND kota.nama_kota = #{nama_kota}")
    int countPendudukKota(String nama_kota);
    
    @Select("SELECT p.id, p.nik, p.nama, p.tempat_lahir, tanggal_lahir, p.jenis_kelamin, p.is_wni, p.id_keluarga, "
			+ "p.agama, p.pekerjaan, p.status_perkawinan, p.status_dalam_keluarga, p.golongan_darah, p.is_wafat,"
			+ "kel.RT, kel.RW, kel.alamat,lurah.nama_kelurahan, camat.nama_kecamatan, kot.nama_kota  "
			+ "FROM penduduk p, keluarga kel, kelurahan lurah, kecamatan camat, kota kot WHERE "
			+ "p.id_keluarga = kel.id AND lurah.id = kel.id_kelurahan AND lurah.id_kecamatan = camat.id "
			+ "AND camat.id_kota = kot.id AND lurah.id = #{id_kelurahan} "
			+ "ORDER BY tanggal_lahir ASC LIMIT 1 ")
    CitizenModel selectOldest (String id_kelurahan);
    
    @Select("SELECT p.id, p.nik, p.nama, p.tempat_lahir, tanggal_lahir, p.jenis_kelamin, p.is_wni, p.id_keluarga, "
			+ "p.agama, p.pekerjaan, p.status_perkawinan, p.status_dalam_keluarga, p.golongan_darah, p.is_wafat,"
			+ "kel.RT, kel.RW, kel.alamat,lurah.nama_kelurahan, camat.nama_kecamatan, kot.nama_kota  "
			+ "FROM penduduk p, keluarga kel, kelurahan lurah, kecamatan camat, kota kot WHERE "
			+ "p.id_keluarga = kel.id AND lurah.id = kel.id_kelurahan AND lurah.id_kecamatan = camat.id "
			+ "AND camat.id_kota = kot.id AND lurah.id = #{id_kelurahan} "
			+ "ORDER BY tanggal_lahir DESC LIMIT 1 ")
    CitizenModel selectYoungest (String id_kelurahan);
}
