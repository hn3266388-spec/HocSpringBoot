package Study.spring.boot.CauTrucChuan.dto.record;


import java.util.List;

public record PatientResponseDTO(Long id, String fullName, List<String> diagnoses) {}