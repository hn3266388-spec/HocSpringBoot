package Study.spring.boot;

import Study.spring.boot.CauTrucChuan.dto.record.UserRp;
import Study.spring.boot.CauTrucChuan.dto.record.UserRq;
import Study.spring.boot.CauTrucChuan.entity.User;
import Study.spring.boot.CauTrucChuan.mapper.UserMapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-12T20:39:28+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-java-compiler-worker-9.5.1.jar, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserRp toResponse(User u) {
        if ( u == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String address = null;
        String phone = null;
        String email = null;
        String username = null;

        id = u.getId();
        name = u.getName();
        address = u.getAddress();
        phone = u.getPhone();
        email = u.getEmail();
        username = u.getUsername();

        UserRp userRp = new UserRp( id, name, address, phone, email, username );

        return userRp;
    }

    @Override
    public User toEntity(UserRq rq) {
        if ( rq == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( rq.name() );
        user.address( rq.address() );
        user.phone( rq.phone() );
        user.email( rq.email() );
        user.username( rq.username() );
        user.password( rq.password() );

        return user.build();
    }

    @Override
    public void updateUserFromRq(UserRq rq, User user) {
        if ( rq == null ) {
            return;
        }

        user.setName( rq.name() );
        user.setAddress( rq.address() );
        user.setPhone( rq.phone() );
        user.setEmail( rq.email() );
        user.setUsername( rq.username() );
        user.setPassword( rq.password() );
    }
}
