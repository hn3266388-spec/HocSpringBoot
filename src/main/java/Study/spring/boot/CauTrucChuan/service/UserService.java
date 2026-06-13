package Study.spring.boot.CauTrucChuan.service;

import java.util.List;

import Study.spring.boot.CauTrucChuan.dto.record.UserRp;
import Study.spring.boot.CauTrucChuan.dto.record.UserRq;
import Study.spring.boot.CauTrucChuan.dto.request.UserRequest;
import Study.spring.boot.CauTrucChuan.dto.response.UserResponse;

public interface UserService {
	void create(UserRq rq);

	void update(String id, UserRq rq);

	List<UserRp> index();

	void delete(String id);
}
