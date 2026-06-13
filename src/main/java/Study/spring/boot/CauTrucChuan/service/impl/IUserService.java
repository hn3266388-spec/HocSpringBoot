package Study.spring.boot.CauTrucChuan.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Study.spring.boot.CauTrucChuan.dto.record.UserRp;
import Study.spring.boot.CauTrucChuan.dto.record.UserRq;
import Study.spring.boot.CauTrucChuan.dto.request.UserRequest;
import Study.spring.boot.CauTrucChuan.dto.response.UserResponse;
import Study.spring.boot.CauTrucChuan.entity.User;
import Study.spring.boot.CauTrucChuan.mapper.UserMapper;
import Study.spring.boot.CauTrucChuan.repository.UserRepository;
import Study.spring.boot.CauTrucChuan.service.UserService;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class IUserService implements UserService {
      private final UserRepository userRepo;
      private final UserMapper ump;
	@Override
	public void create(UserRq rq) {
	userRepo.save(maptoEntityofMapper(rq));
	}	

	@Override
	public void update(String id, UserRq rq) {
		Optional<User> user= userRepo.findById(id);
		if(user.isEmpty()) {
			throw new IllegalArgumentException("User not exist");
		}
		User userUpdate= user.get();
		userUpdate.setName(rq.name());
		userUpdate.setPhone(rq.phone());
		userUpdate.setEmail(rq.email());
		userUpdate.setPassword(rq.password());
		userUpdate.setUsername(rq.username());
		userRepo.save(userUpdate);
	}

	@Override
	public List<UserRp> index() {
		List<User> list= userRepo.findAll();
		return list.stream().map(this::maptoUserResponesofMapper).toList();	}

	@Override
	public void delete(String id) {
		Optional<User> user= userRepo.findById(id);
		if(user.isEmpty()) {
			throw new IllegalArgumentException("User not exist");
		}
		userRepo.delete(user.get());
	}
//     private User mapToEntity(UserRequest rq) {
//    	 return User.builder()
//    				.name(rq.getName())
//    				.address(rq.getAddress())
//    				.email(rq.getEmail())
//    				.password(rq.getPassword())
//    				.username(rq.getUsername())
//    				.phone(rq.getPhone())
//    				.build();
//     }
//     private UserResponse mapToUserResponse(User u) {
//    	 return UserResponse.builder()
//    			    .id(u.getId())
//    				.name(u.getName())
//    				.address(u.getAddress())
//    				.email(u.getEmail())
//    				.username(u.getUsername())
//    				.phone(u.getPhone())
//    				.build(); 
//     }
	private User maptoEntityofMapper(UserRq rq) {
		return ump.toEntity(rq);
	}
	private UserRp maptoUserResponesofMapper(User u) {
		return ump.toResponse(u);
	}
}
