// user Object 객체 선언
let userObject = {
	// init() 함수 선언
	init : function(){
		let _this = this;
		
		// #btn-save 버튼에 click 이벤트가 발생하면 insertUser() 함수 호출
		$("#btn-save").on("click", () => {
			_this.insertUser();
		});
	},
	
	insertUser: function(){
		alert("회원가입 요청됨");
		// 사용자가 입력한 값(usernaem, password, email) 추출
		let user = {
			username : $("#username").val(),
			password : $("#password").val(),
			email : $("#email").val()
		}
		
		// Ajax를 이용한 비동기 호출
		// done() 함수 : 요청 처리에 성공했을 때 실행될 코드
		// fail() 함수 : 요청 처리에 실패했을 때 실행될 코드
		$.ajax({
			type: "POST", //요청방식
			url: "/auth/insertUser", // 요청경로
			data: JSON.stringify(user), // user 객체를 JSON 형식으로 변환
			//HTTP body에 설정되는 데이터 마임타입
			contentType: "application/json; charset=utf-8"
			//응답으로 들어온 JSON 데이터를 response로 받는다.
		}).done(function(response){
			let status = response["status"];
			if(status == 200){
				let message = response["data"];
				alert(message);
				location="/";
			} else{
				let warn = "";
				let errors = response["data"];
				if(errors.username != null) warn = warn + errors.username + "\n";
				if(errors.password != null) warn = warn + errors.password + "\n";
				if(errors.email != null) warn = warn + errors.email + "\n";
				alert(warn);
			}
			//에러 발생시 error로 에러정보를 받는다. 
		}).fail(function(error){
			//에러 메시지를 알림창에 출력
			alert("에러 발생 : " + error);
		});

	},
}

// userObject 객체의 init() 함수 호출.
userObject.init();