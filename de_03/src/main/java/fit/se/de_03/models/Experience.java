package fit.se.de_03.models;

import fit.se.de_03.enums.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "experience")
public class Experience {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id", nullable = false)
   private Long id;

   @NotEmpty
   @Column(name = "work_desc")
   private String workDescription;

   @NotNull
   @Enumerated(EnumType.ORDINAL)
   private Roles role;

   @NotEmpty
   @Column(name = "company")
   private String companyName;

   @NotNull
   @Column(name = "from_date")
   private LocalDate fromDate;

   @NotNull
   @Column(name = "to_date")
   private LocalDate toDate;

   @ManyToOne
   @JoinColumn(name = "can_id", nullable = false)
   private Candidate candidate;
}