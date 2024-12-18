package fit.se.de_01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dien_thoai")
public class DienThoai {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ma_dien_thoai", nullable = false)
   private Long maDienThoai;

   @Column(name = "ten_dien_thoai", nullable = false)
   private String tenDienThoai;

   @Column(name = "dia_chi", nullable = false)
   private String diaChi;

   @Column(name = "gia_von", nullable = false)
   private String giaVon;

   @Column(name = "loai", nullable = false)
   private String loai;

   @Column(name = "nha_cung_cap", nullable = false)
   private String nhaCungCap;
}