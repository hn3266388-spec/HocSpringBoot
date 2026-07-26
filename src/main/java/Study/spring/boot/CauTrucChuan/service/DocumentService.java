package Study.spring.boot.CauTrucChuan.service;

import Study.spring.boot.CauTrucChuan.dto.record.DocumentDto;
import Study.spring.boot.CauTrucChuan.entity.Document;

public interface DocumentService {

    Document saveDocument(DocumentDto dto) throws Exception;

    DocumentDto getDocument(Long id) throws Exception;
}
