package fit.se.de_01.services;

import fit.se.de_01.exceptions.AppException;
import fit.se.de_01.models.DienThoai;
import fit.se.de_01.repositories.DienThoaiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @author: vie
 * @date: 18/12/24
 */
@Service
public class DienThoaiService {
   final DienThoaiRepository dienThoaiRepository;

   public DienThoaiService(DienThoaiRepository dienThoaiRepository) {
      this.dienThoaiRepository = dienThoaiRepository;
   }

   public DienThoai save(DienThoai dienThoai) {
      return dienThoaiRepository.save(dienThoai);
   }

   public DienThoai update(DienThoai dienThoai) {
      if (dienThoaiRepository.existsById(dienThoai.getMaDienThoai())) {
         throw new AppException("Điện thoại đã tồn tại", 400);
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
