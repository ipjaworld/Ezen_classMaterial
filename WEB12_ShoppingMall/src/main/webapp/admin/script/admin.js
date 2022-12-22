function workerCheck(){
	  if(document.frm.workId.value==""){
	      	alert("아이디를 입력하세요.");
	      	return false;
	  }else if(document.frm.workPwd.value==""){
	     	alert("비밀번호를 입력하세요.");
	      	return false;
	  }else{
			return true; 
	  }
	   
}

function go_wrt(){
	document.frm.action = "shop.do?command=adminProductWriteForm";
	document.frm.submit();
}


function go_save(){
   var theForm = document.frm;
   if( theForm.kind.value==""){  // if( document.frm.kind.value=="" )
      alert('상품분류를 선택하세요');
      theForm.kind.focus();
   }else if (theForm.name.value == "") {
      alert('상품명을 입력하세요.');    
      theForm.name.focus();   
   } else if (theForm.price1.value == "") {
      alert('원가를 입력하세요.');       
      theForm.price1.focus();
   } else if (theForm.price2.value == "") {
      alert('판매가를 입력하세요.');       
      theForm.price2.focus();
   } else if (theForm.content.value == "") {
      alert('상품상세를 입력하세요.');       
      theForm.content.focus();
   } else if (theForm.image.value == "") {
      alert('상품이미지들 입력하세요.');    
      theForm.image.focus();   
   } else{
      theForm.action = "shop.do?command=adminProductWrite";
      theForm.submit();
   }
   // AdminProductWriteAction 클래스를 만들고 cos.jar의 MultipartRequest를 이용해서 파일을 업로드하고,
   // product 테이블에 레코드도 추가해주세요
   // 돌아올 목적지는 productList.jsp입니다.
}




function cal(){
	if( document.frm.price2.value == "" || document.frm.price1.value=="") return; 
	document.frm.price3.value = document.frm.price2.value - document.frm.price1.value; 
}

function go_mov(){
	location.href = "shop.do?command=adminProductList";
}



function go_detail( pseq ){
	var url = "shop.do?command=adminProductDetail&pseq=" + pseq;
	document.frm.action = url; 
	document.frm.submit();
}




function go_mod(pseq){
	var url = "shop.do?command=adminProductUpdateForm&pseq=" + pseq;
	location.href=url;
	// document.frm.action = url;
	// document.frm.submit();
}




function go_mod_save(){
	if (document.frm.kind.value == '') {
		  alert('상품분류를 선택하세요'); 	  
			document.frm.kind.focus();
	 } else if (document.frm.name.value == '') {
		  alert('상품명을 입력하세요');	  
			document.frm.name.focus();
	 } else if (document.frm.price1.value == '') {
		  alert('원가를 입력하세요');	 
 		document.frm.price1.focus();
	 } else if (document.frm.price2.value == '') {
		  alert('판매가를 입력하세요');	  
			document.frm.price2.focus();
	 } else if (document.frm.content.value == '') {
		  alert('상품상세를 입력하세요');	  
			document.frm.content.focus();
	 }else{
		if( confirm('수정하시겠습니까?') ){
			 document.frm.action = "shop.do?command=adminProductUpdate";
			 document.frm.submit();
		}
	}
	// adminProductWriteAction 클래스를 만들고 cos.jar 의 MultipartRequest 를 이용해서 파일을 업로드하고,
	// product 테이블에 레코드도 추가해주세요
	// 돌아올 목적지는 productList.jsp 입니다.
}




function go_search( comm ){
	/*if( document.frm.key.value == "" ){
		alert("검색버튼 사용시에는 검색어 입력이 필수입니다");
	 	return;
	 }*/
	var url = "shop.do?command=" + comm + "&page=1";   // 검색어로 검색한 결과의 1페이지로 이동
	document.frm.action = url;
	document.frm.submit();
}


function go_total( comm ){
	document.frm.key.value="";
	document.frm.action = "shop.do?command=" + comm + "&page=1";
	document.frm.submit();
}



















