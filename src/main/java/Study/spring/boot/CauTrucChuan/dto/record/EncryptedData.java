package Study.spring.boot.CauTrucChuan.dto.record;

public record EncryptedData(
        String encryptedKey,
        String iv,
        String encryptedData
) {}
