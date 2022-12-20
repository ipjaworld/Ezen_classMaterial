function go_cart(){
	if(document.formm.quantity.value==""){
		alert("수량을 입력하여 주세요.");
		document.formm.quantity.focus();
	}else{
		document.formm.action = "shop.do?command=cartInsert";
		document.formm.submit();
	}
}




function go_cart_delete(){
	
	// 자바스크립트에서 jsp 페이지 내에 있는 동일한 name 의 두개 이상의 입력란(input 태그)들은 하나의 이름의 배열로 인식합니다
	// document.formm.cseq[]
	// 그 말은 곧 배열의 크기를 나타내는 length 속성이 존재한다는 뜻이며 배열 내의 요소 갯수를 저장하고 있습니다.
	// 만약 input 태그가 여러개가 아니고 한개만 존재하는 상태라면 length 값은 undefined 가 됩니다.
	
	
	// 체크박스가 한개만 있는 상태인지, 두개 이상 있는 상태인지를 document.formm.cseq.length 로 구분합니다.
	// 아래는 document.formm.cseq.length 요소를 이용해서 체크박스에 체크가 하나라도 되었는지 점검합니다.
	
	var count = 0;
	if(document.formm.cseq.length == undefined){
		// 체크박스 한개인 경우
		if( document.formm.cseq.checked==true) count++;
	}else{
		// 체크박스 두개 이상인 경우
		for( var i = 0; i<document.formm.cseq.length; i++){
			if(document.formm.cseq[i].checked == true){
				count++;
			}
		}
	}
	
	console.log(`count는 ${count}입니다.`);
	
	if(count == 0){
		alert("삭제할 항목을 선택하세요");
		// 체크박스가 하나도 체크되지 않았다면 '선택하세요' 경고문과 함께 원래대로 돌아갑니다.
	}else{
		// 한개 이상 체크되었다면 체크된 체크박스들을 갖고 (폼이 알아서 같이 갖고 갈꺼에요) 목표지점으로 submit 합니다
		document.formm.action = "shop.do?command=cartDelete";
		document.formm.submit();
	}
	
}




function go_order_insert(){
	document.formm.action = "shop.do?command=orderInsert";
	document.formm.submit();
}










