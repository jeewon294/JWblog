// login Object 객체 선언
let loginObject = {
	// init() 함수 선언
	init : function(){
		$("#btn-login").on("click", ()=>{
			this.login();
		});
	},
	
	login: function(){
		alert("회원가입 요청됨");
		let data = {
			username : $("#username").val(),
			password : $("#password").val()
		}
		
		

		$.ajax({
			type: "POST", //요청방식
			url: "/auth/login", // 요청경로
			data: JSON.stringify(data), // 객체를 JSON 형식으로 변환
			//HTTP body에 설정되는 데이터 마임타입
			contentType: "application/json; charset=utf-8"
			//응답으로 들어온 JSON 데이터를 response로 받는다.
		}).done(function(response){
			let message = response["data"];
			alert(message);
			location = "/";
		}).fail(function(error){
			let message = error["data"];
			//에러 메시지를 알림창에 출력
			alert("에러 발생 : " + error);
		});

	},
}

// userObject 객체의 init() 함수 호출.
loginObject.init();