package com.example.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.common.BaseResponse;
import com.example.config.UserDetailsImpl;
import com.example.constants.AppConstants;
import com.example.dtos.BlankDTO;
import com.example.dtos.JwtResponse;
import com.example.dtos.LoginRequest;
import com.example.dtos.SignupRequest;
import com.example.entity.AccountEntity;
import com.example.entity.CustomerEntity;
import com.example.entity.RoleEntity;
import com.example.entity.StaffEntity;
import com.example.repositories.IAccountRepository;
import com.example.repositories.IRoleRepository;
import com.example.uitities.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthAPI {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	IAccountRepository accountRepository;

	@Autowired
	IRoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signUpRequest) {
		if (accountRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new BaseResponse<BlankDTO>(false, "Username đã được sử dụng!") {});
		}
		add(signUpRequest, AppConstants.ROLE_USER);
		return ResponseEntity.ok(new BaseResponse<BlankDTO>(true, "Người dùng đăng kí thành công") {});
	}
	
	@PostMapping("/signup/staff")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> registerStaff(@Validated @RequestBody SignupRequest signUpRequest) {
		if (accountRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new BaseResponse<BlankDTO>(false, "Username đã được sử dụng!") {

			});
		}
		add(signUpRequest, AppConstants.ROLE_STAFF);
		return ResponseEntity.ok(new BaseResponse<BlankDTO>(true, "Nhân viên được đăng ký thành công") {});
	}
	
	@PostMapping("/signup/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> registerAdmin(@Validated @RequestBody SignupRequest signUpRequest) {
		if (accountRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new BaseResponse<BlankDTO>(false, "Username đã được sử dụng!") {

			});
		}
		add(signUpRequest, AppConstants.ROLE_ADMIN);
		return ResponseEntity.ok(new BaseResponse<BlankDTO>(true, "Quản trị được đăng ký thành công") {});
	}

	@Transactional
	public void add(SignupRequest signRequest, int typeRole) {
		AccountEntity account = new AccountEntity();
		account.setUsername(signRequest.getUsername());
		account.setPassword(encoder.encode(signRequest.getPassword()));
		account = accountRepository.save(account);
		
		if(typeRole == AppConstants.ROLE_ADMIN) {
			RoleEntity role = roleRepository.findByCode(AppConstants.CODE_ADMIN);
			StaffEntity admin = modelMapper.map(signRequest, StaffEntity.class);
			admin.setAccountS(account);
			account.setRole(role);
			account.setStaff(admin);
		}else if(typeRole == AppConstants.ROLE_STAFF) {
			RoleEntity role = roleRepository.findByCode(AppConstants.CODE_STAFF);
			StaffEntity staff = modelMapper.map(signRequest, StaffEntity.class);
			staff.setAccountS(account);
			account.setRole(role);
			account.setStaff(staff);
		}else if(typeRole == AppConstants.ROLE_USER) {
			RoleEntity role = roleRepository.findByCode(AppConstants.CODE_USER);
			CustomerEntity customer = modelMapper.map(signRequest, CustomerEntity.class);
			customer.setAccountC(account);
			account.setRole(role);
			account.setCustomer(customer);
		}
		accountRepository.save(account);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
