package Study.spring.boot.CauTrucChuan.controller;


import Study.spring.boot.CauTrucChuan.dto.record.PatientResponseDTO;
import Study.spring.boot.CauTrucChuan.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/n-plus-one")
    public ResponseEntity<List<PatientResponseDTO>> getNPlusOne() {
        return ResponseEntity.ok(patientService.getPatientsWithNPlusOne());
    }
}