package fit.se.de_01.services;

import fit.se.de_01.exceptions.AppException;
import fit.se.de_01.models.DienThoai;
import fit.se.de_01.models.LoaiDienThoai;
import fit.se.de_01.repositories.DienThoaiRepository;
import fit.se.de_01.repositories.LoaiDienThoaiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @description
 * @author: vie
 * @date: 18/12/24
 */
@Slf4j
@Service
public class DienThoaiService {
   final DienThoaiRepository dienThoaiRepository;
   private final LoaiDienThoaiRepository loaiDienThoaiRepository;

   public DienThoaiService(DienThoaiRepository dienThoaiRepository, LoaiDienThoaiRepository loaiDienThoaiRepository) {
      this.dienThoaiRepository = dienThoaiRepository;
      this.loaiDienThoaiRepository = loaiDienThoaiRepository;
   }

   public DienThoai save(DienThoai dienThoai) {
      Optional<LoaiDienThoai> loaiOpt = loaiDienThoaiRepository.findById(dienThoai.getLoai().getId());
      if (loaiOpt.isPresent()) {
         dienThoai.setLoai(loaiOpt.get());
      } else {
         throw new AppException("Ma dien thoai khong ton tai", 404);
      }
      return dienThoaiRepository.save(dienThoai);
   }

   public DienThoai update(DienThoai dienThoai) {
      if (!dienThoaiRepository.existsById(dienThoai.getMaDienThoai())) {
         throw new AppException("Điện thoại không tồn tại", 404);
      }
      return dienThoaiRepository.save(dienThoai);
   }

   public boolean delete(Long maDienThoai) {
      if (dienThoaiRepository.existsById(maDienThoai)) {
         dienThoaiRepository.deleteById(maDienThoai);
         return true;
      }
      return false;
   }

   public List<DienThoai> findAll() {
      return (List<DienThoai>) dienThoaiRepository.findAll();
   }

   public DienThoai findById(Long id) {
      return dienThoaiRepository.findById(id)
            .orElseThrow(() -> new AppException("Điện thoại không tồn tại", 404));
   }
}
