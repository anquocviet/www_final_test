package fit.se.de_01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dien_thoai")
@ToString
public class DienThoai {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ma_dien_thoai", nullable = false)
   private Long maDienThoai;

   @NotEmpty
   @Column(name = "ten_dien_thoai", nullable = false)
   private String tenDienThoai;

   @NotEmpty
   @Column(name = "dia_chi", nullable = false)
   private String diaChi;

   @NotEmpty
   @Column(name = "gia_von", nullable = false)
   private String giaVon;

   @NotNull
   @ManyToOne
   @JoinColumn(name = "ma_loai", nullable = false)
   private LoaiDienThoai loai;

   @NotEmpty
   @Column(name = "nha_cung_cap", nullable = false)
   private String nhaCungCap;
}