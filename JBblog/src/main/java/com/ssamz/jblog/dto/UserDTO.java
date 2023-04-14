package com.ssamz.jblog.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	@NotNull(message = "username이 전달되지 않았습니다.")
	@NotBlank(message = "username은 필수 입력 항목입니다.")
	@Size(min = 1, max = 20, message = "username은 한글자 이상 20자 미만으로 입력하세요.")
	private String username;
	
	@NotNull(message = "email이 전달되지 않았습니다.")
	@NotBlank(message = "email은 필수 입력 항목입니다.")
	@Email(message = "이메일 형식이 아닙니다.")
	private String email;
}
