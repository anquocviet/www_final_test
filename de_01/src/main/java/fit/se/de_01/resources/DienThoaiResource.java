package fit.se.de_01.resources;

import fit.se.de_01.models.DienThoai;
import fit.se.de_01.services.DienThoaiService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description
 * @author: vie
 * @date: 21/12/24
 */
@RestController
@RequestMapping("/dienthoai")
public class DienThoaiResource {
   private final DienThoaiService dienThoaiService;

   public DienThoaiResource(DienThoaiService dienThoaiService) {
      this.dienThoaiService = dienThoaiService;
   }

   @GetMapping("/all")
   public ResponseEntity<List<DienThoai>> findAll() {
      return ResponseEntity.ok(dienThoaiService.findAll());
   }
}
