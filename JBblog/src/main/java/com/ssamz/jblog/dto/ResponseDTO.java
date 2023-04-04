package com.ssamz.jblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {
	//HTTP 응답 상태 코드
	private int staues;
	
	//실제 응답할 데이터
	private T data;
}
