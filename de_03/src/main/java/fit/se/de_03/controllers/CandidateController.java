package fit.se.de_03.controllers;

import fit.se.de_03.services.CandidateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description
 * @author: vie
 * @date: 21/12/24
 */
@Controller
@RequestMapping("/candidates")
public class CandidateController {
   private final CandidateService candidateService;

   public CandidateController(CandidateService candidateService) {
      this.candidateService = candidateService;
   }

   @GetMapping("/all")
   public String listAllCandidates(Model model) {
      model.addAttribute("candidates", candidateService.findAll());
      return "candidates/all";
   }

   @GetMapping("/details/{id}")
   public String detailCandidate(@PathVariable Long id, Model model) {
      model.addAttribute("candidate", candidateService.findById(id));
      return "candidates/details";
   }

   @GetMapping("/report1")
   public String workedAtCandidates(String company, Model model) {
      return "candidates/report1";
   }

   @GetMapping("/report2")
   public String candidateLessThan5YearExp(Model model) {
      return "candidates/report2";
   }
}
