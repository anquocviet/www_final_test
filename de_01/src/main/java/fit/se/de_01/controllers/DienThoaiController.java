package fit.se.de_01.controllers;

import fit.se.de_01.models.DienThoai;
import fit.se.de_01.services.DienThoaiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description
 * @author: vie
 * @date: 18/12/24
 */
@Controller
@RequestMapping("/dienthoai")
public class DienThoaiController {
   private final DienThoaiService dienThoaiService;

   public DienThoaiController(DienThoaiService dienThoaiService) {
      this.dienThoaiService = dienThoaiService;
   }

   @GetMapping("/all")
   public String getAll(Model model) {
      model.addAttribute("listDienThoai", dienThoaiService.findAll());
      return "dienthoai/all";
   }

   @GetMapping("/add")
   public String getAdd() {
      return "dienthoai/add";
   }

   @PostMapping("/add")
   public String add(DienThoai dienThoai) {
      dienThoaiService.save(dienThoai);
      return "redirect:/dienthoai/all";
   }

   @GetMapping("/edit")
   public String getEdit(Long id, Model model) {
      DienThoai dienThoai = dienThoaiService.findById(id);
      model.addAttribute("dienThoai", dienThoai);
      return "dienthoai/edit";
   }

   public String update(DienThoai dienThoai) {
      dienThoaiService.update(dienThoai);
      return "redirect:/dienthoai/all";
   }

   @GetMapping("/delete")
   public String getDelete(Long id) {
      dienThoaiService.delete(id);
      return "redirect:/dienthoai/all";
   }
}
