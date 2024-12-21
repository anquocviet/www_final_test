package fit.se.de_01.services;

import fit.se.de_01.models.LoaiDienThoai;
import fit.se.de_01.repositories.LoaiDienThoaiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @author: vie
 * @date: 21/12/24
 */
@Service
public class LoaiDienThoaiService {
   private final LoaiDienThoaiRepository loaiDienThoaiRepository;

   public LoaiDienThoaiService(LoaiDienThoaiRepository loaiDienThoaiRepository) {
      this.loaiDienThoaiRepository = loaiDienThoaiRepository;
   }

   public List<LoaiDienThoai> findAll() {
      return (List<LoaiDienThoai>) loaiDienThoaiRepository.findAll();
   }
}
