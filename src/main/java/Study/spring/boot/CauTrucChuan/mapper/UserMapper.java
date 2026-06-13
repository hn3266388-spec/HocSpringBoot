package Study.spring.boot.CauTrucChuan.mapper;

import org.mapstruct.Mapper;
import Study.spring.boot.CauTrucChuan.dto.record.UserRp;
import Study.spring.boot.CauTrucChuan.dto.record.UserRq;
import Study.spring.boot.CauTrucChuan.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRp toResponse(User u);

    User toEntity(UserRq rq);

    void updateUserFromRq(UserRq rq, User user);
}