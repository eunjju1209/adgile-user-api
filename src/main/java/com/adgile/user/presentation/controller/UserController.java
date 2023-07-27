package com.adgile.user.presentation.controller;

import com.adgile.user.application.service.user.UserFacade;
import com.adgile.user.common.response.CommonResponse;
import com.adgile.user.presentation.dto.user.UserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/user")
@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserFacade userFacade;


	@PostMapping
	public CommonResponse<String> doRegister(@RequestBody @Valid UserDto.UserCreateRequest request) {
		userFacade.registerUser(request);
		return CommonResponse.OK;
	}

	@PutMapping("{id}")
	public CommonResponse<String> doUpdate(@PathVariable Long id, @RequestBody @Valid UserDto.UserUpdateRequest request) {
		userFacade.updateUser(id, request);
		return CommonResponse.OK;
	}

	@GetMapping("{id}")
	public CommonResponse<UserDto.UserInfoResponse> getUser(@PathVariable Long id) {
		var result = userFacade.getUserById(id);
		return CommonResponse.success(result);
	}
}
