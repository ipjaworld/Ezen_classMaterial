function loginCheck(){
   if( document.frm.userid.value.length==0){
      alert("아이디를 입력하세요");
      document.frm.userid.focus();
      return false;
   }
   if( document.frm.pwd.value.length==0){
      alert("비밀번호를 입력하세요");
      document.frm.pwd.focus();
      return false;
   }
   return true;
}

function boardCheck(){
	if( document.frm.pass.value==""){
		alert("비밀번호는 수정/삭제시에 필요합니다.");
		document.frm.pass.focus();
		return false;
	}else if( document.frm.title.value==""){
		alert("제목은 필수사항입니다.");
		document.frm.title.focus();
		return false;
	}
	else if( document.frm.content.value==""){
		alert("내용을 입력해주세요");
		document.frm.content.focus();
		return false;
	}
	return true;
}



function checkPass( boardNum, popupWinName ){
	var url = "board.do?command=boardPassForm&num=" + boardNum;
	var opt = "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=500, height=300";
	window.open( url, popupWinName, opt);
}


function passCheck(){
	if( document.frm.pass.value.length == 0 ){
		alert("비밀번호를 입력하세요.");
		document.frm.pass.focus();
		return false;
	}
	return true;
}


function reply_check(){
	if( document.frm_reply.content.value == "" ){
		alert("댓글 내용을 입력하세요.");
		document.frm_reply.content.focus();
		return false;
	}
	return true;
}


function idCheck(){
	if( document.frm.userid.value=="" ){
		alert("아이디를 입력해주세요");
		document.from.userid.focus();
		return;
	}
	var inputid = document.frm.userid.value;
	var opt = "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=200";
	window.open("board.do?command=idcheck&userid=" + inputid , "idcheck", opt);
}
	

function idok( userid ){
	opener.document.frm.userid.value=userid;
	opener.document.frm.reid.value=userid;
	self.close();
}	



function joinCheck(){
	if( document.frm.userid.value==""){
		alert("아이디는 반드시 입력해주셔야합니다.");
		document.frm.pass.focus();
		return false;
	}else if( document.frm.userid.value.length<4){
		alert("아이디는 4글자 이상이어야 합니다.");
		document.frm.title.focus();
		return false;
	}else if( document.frm.name.value==""){
		alert("이름은 필수사항입니다.");
		document.frm.title.focus();
		return false;
	}else if( document.frm.pwd.value==""){
		alert("비밀번호는 필수사항입니다.");
		document.frm.content.focus();
		return false;
	}else if( document.frm.pwd_check.value==""){
		alert("비밀번호 확인을 입력해주세요");
		document.frm.content.focus();
		return false;
	}else if( document.frm.pwd_check.value!=document.frm.pwd.value){
		alert("비밀번호와 비밀번호확인이 일치하지 않습니다.");
		document.frm.content.focus();
		return false;
	}else if( document.frm.userid.value != document.frm.reid.value){
		alert("아이디 중복체크를 하지 않으셨습니다");
		document.frm.userid.focus();
		return false;
	}
	return true;
	
}


function updateMemberCheck(){
	
}



