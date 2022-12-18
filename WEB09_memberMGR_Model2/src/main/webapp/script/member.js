function loginCheck(){
	if( document.frm.userid.value == "" ){
		alert("아이디를 입력하세요");
		document.frm.userid.focus();
		return false;
	}
	if( document.frm.pwd.value == ""){
		alert("암호를 입력하세요");
		document.frm.pwd.focus();
		return false;
	}
	return true;
}


function deleteMember(){
	var bool = confirm("정말로 탈퇴하시겠습니까???");
	if(bool){
		location.href="member.do?command=deleteMember";
	}else{
		return;
	}
}





function idCheck(){
	if( document.frm.userid.value.length==0 ){
		alert("아이디를 입력해주세요");
		document.from.userid.focus();
		return;
	}
		
	var inputid = document.frm.userid.value;
	var opt = "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=200";
	window.open("member.do?command=idcheck&userid=" + inputid , "idcheck", opt);
}
	
	
	
	
function idok( id ){
	opener.document.frm.userid.value=id;
	opener.document.frm.reid.value=id;
	self.close();
}	
	
	
	
function joinCheck(){
		if( document.frm.name.value.length==0){
			alert("이름은 필수입력사항입니다");
			document.frm.name.focus();
			return false;
		}else if( document.frm.userid.value.length<4){
			alert("아이디는 4글자 이상이어야 합니다");
			document.frm.userid.focus();
			return false;
		}else if( document.frm.userid.value != document.frm.reid.value){
			alert("아이디 중복체크를 하지 않으셨습니다");
			document.frm.userid.focus();
			return false;
		}else if( document.frm.pwd.value.length==0){
			alert("비밀번호는 필수입력사항입니다");
			document.frm.pwd.focus();
			return false;
		}else if( document.frm.pwd.value != document.frm.pwd_check.value){
			alert("비밀번호 확인이 일치하지 않습니다");
			document.frm.pwd_check.focus();
			return false;
		}else{
			return true;	
		}
		
	}
	
	
	
	
	
function updateCheck(){
	if( document.frm.name.value.length==0){
		alert("이름은 필수입력 사항입니다");
		document.frm.name.focus();
		return false;
	}else if( document.frm.pwd.value.length==0){
		alert("비밀번호는 필수입력 사항입니다");
		document.frm.pwd.focus();
		return false;
	}else if( document.frm.pwd.value != document.frm.pwd_check.value){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
		document.frm.pwd_check.focus();
		return false;
	}else{
		return true;
	}
}
	
	
	
	
	
	
	
	