package project.assignment.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.security.crypto.password.PasswordEncoder;

import project.assignment.springboot.exception.UserNotFoundException;
import project.assignment.springboot.model.UserList;
import project.assignment.springboot.repository.UserListRepository;

@Service
public class UserListService {
	
	@Autowired
	private UserListRepository userListRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<UserList> findAllUser() {
		
		return userListRepository.findAll();
	}

	public UserList save(@Valid UserList userlist) {
		
		return userListRepository.save(userlist);
	}

	public UserList findById(Integer id) {
		UserList userlist = userListRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not exist with id :" + id));
		return userlist;
	}
	
	public UserList updateUserList(Integer id, UserList userlistDetails){
		UserList userlist = userListRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not exist with id :" + id));
		
		userlist.setFirstName(userlistDetails.getFirstName());
		userlist.setMiddleName(userlistDetails.getMiddleName());
		userlist.setLastName(userlistDetails.getLastName());
		userlist.setMobileNo(userlistDetails.getMobileNo());
		userlist.setEmail(userlistDetails.getEmail());
		userlist.setBirthDate(userlistDetails.getBirthDate());
		userlist.setPassword(userlistDetails.getPassword());
		userlist.setGender(userlistDetails.getGender());
		userlist.setMaritalStatus(userlistDetails.getMaritalStatus());
		
		UserList updatedUserList = userListRepository.save(userlist);
		return updatedUserList;
	}
	
	public UserList deleteUserList(Integer id){
		UserList userlist = userListRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not exist with id :" + id));
		
		userListRepository.delete(userlist);
		return userlist;
	}
	
	// check mail and pass
			public UserList findUserByEmailAndPassword(UserList userlist)throws UserNotFoundException {
				try {
					UserList user = userListRepository.findByEmail(userlist.getEmail());
					String rawPassword = userlist.getPassword();
					if (user != null && userlist.getEmail().equals(user.getEmail())
							&& passwordEncoder.matches(rawPassword, user.getPassword())) {
						UserList Result = user;
						return Result;
					}
					throw new UserNotFoundException("Invalid email or password !, Try again.");
				} catch (Exception e) {
					throw new UserNotFoundException(e.getMessage());
				}		
}
}


