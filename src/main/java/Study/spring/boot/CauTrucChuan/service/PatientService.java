package Study.spring.boot.CauTrucChuan.service;

import Study.spring.boot.CauTrucChuan.dto.record.PatientResponseDTO;

import java.util.List;

public interface PatientService {

    List<PatientResponseDTO> getPatientsWithNPlusOne();
}
