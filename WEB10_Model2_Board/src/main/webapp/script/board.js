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




