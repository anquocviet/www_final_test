package fit.se.de_01.controllers;

import fit.se.de_01.models.DienThoai;
import fit.se.de_01.services.DienThoaiService;
import fit.se.de_01.services.LoaiDienThoaiService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description
 * @author: vie
 * @date: 18/12/24
 */
@Slf4j
@Controller
@RequestMapping("/dienthoai")
public class DienThoaiController {
   private final DienThoaiService dienThoaiService;
   private final LoaiDienThoaiService loaiDienThoaiService;

   public DienThoaiController(DienThoaiService dienThoaiService, LoaiDienThoaiService loaiDienThoaiService) {
      this.dienThoaiService = dienThoaiService;
      this.loaiDienThoaiService = loaiDienThoaiService;
   }

   @GetMapping("/all")
   public String getAll(Model model) {
      model.addAttribute("listDienThoai", dienThoaiService.findAll());
      return "dienthoai/all";
   }

   @GetMapping("/add")
   public String getAdd(Model model) {
      model.addAttribute("dienThoai", new DienThoai());
      model.addAttribute("listLoaiDienThoai", loaiDienThoaiService.findAll());
      return "dienthoai/add";
   }

   @PostMapping("/add")
   public String add(@Valid DienThoai dienThoai) {
      dienThoaiService.save(dienThoai);
      return "redirect:/dienthoai/all";
   }

   @GetMapping("/edit/{id}")
   public String getEdit(Model model, @PathVariable Long id) {
      DienThoai dienThoai = dienThoaiService.findById(id);
      model.addAttribute("dienThoai", dienThoai);
      return "dienthoai/edit";
   }

   @PostMapping("/edit")
   public String update(@Valid DienThoai dienThoai) {
      dienThoaiService.update(dienThoai);
      return "redirect:/dienthoai/all";
   }

   @GetMapping("/delete/{id}")
   public String getDelete(@PathVariable Long id) {
      dienThoaiService.delete(id);
      return "redirect:/dienthoai/all";
   }

   @GetMapping("/api")
   public String getApi() {
      return "dienthoai/all-api";
   }
}
