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