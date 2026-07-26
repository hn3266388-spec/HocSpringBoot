package Study.spring.boot.CauTrucChuan.service.impl;


import Study.spring.boot.CauTrucChuan.dto.record.PatientResponseDTO;
import Study.spring.boot.CauTrucChuan.entity.Checkup;
import Study.spring.boot.CauTrucChuan.entity.Patient;
import Study.spring.boot.CauTrucChuan.repository.PatientRepository;
import Study.spring.boot.CauTrucChuan.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IPatientService implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Transactional(readOnly = true)
    public List<PatientResponseDTO> getPatientsWithNPlusOne() {
        // (1) Bắn 1 câu query lấy N bệnh nhân
        List<Patient> patients = patientRepository.findAll();

        // (2) Bắn thêm N câu query bên trong vòng lặp map
        return patients.stream().map(p -> {
            List<String> diagnoses = p.getCheckups().stream()
                    .map(Checkup::getDiagnosis)
                    .toList();
            return new PatientResponseDTO(p.getId(), p.getFullName(), diagnoses);
        }).toList(); // CGLIB Proxy
    }
}