package project.assignment.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

import project.assignment.springboot.exception.UserNotFoundException;
import project.assignment.springboot.model.UserList;
import project.assignment.springboot.repository.UserListRepository;
import project.assignment.springboot.service.UserListService;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
public class UserListController {
	
	@Autowired
	private UserListService userListService;
	
	//get all UserList
	@GetMapping("/userlist")
	public List<UserList> getAllUsers(){
		return userListService.findAllUser();
	}	
	
	// create userlist rest api
		@PostMapping("/userlist")
		public UserList createUsers(@Valid @RequestBody UserList userlist) {
			return userListService.save(userlist);
		}
		
		// get userlist by id rest api
		@GetMapping("/userlist/{id}")
		public UserList getUserListById(@PathVariable Integer id) {
			UserList userlist = userListService.findById(id);
			return userlist;
		}
		
		// update UserList rest api
		@PutMapping("/userlist/{id}")
		public ResponseEntity<UserList> updateUserList(@PathVariable Integer id, @RequestBody UserList userlistDetails){
			UserList userlist = userListService.updateUserList(id, userlistDetails);		
			return ResponseEntity.ok(userlist);
		}
		
		// delete userlist rest api
		@DeleteMapping("/userlist/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteUserList(@PathVariable Integer id){
			UserList userlist = userListService.deleteUserList(id);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
		// Login to the portal
				@PostMapping("/login")
				public @ResponseBody ResponseEntity<?> signIn(@RequestBody UserList userlist) throws UserNotFoundException{
					{
						UserList user = userListService.findUserByEmailAndPassword(userlist);
						if (user == null)
							
							return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
						
						return ResponseEntity.ok(user);
							
//							return ResponseEntity.error("User not found");
//						return Response.success(user);
					}
		
}
}
