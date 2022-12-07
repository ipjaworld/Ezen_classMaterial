package com.ezen.board.util;

public class Paging {
	private int page = 1;	// ���� ȭ�鿡 ������ ������ ��ȣ
	private int totalCount; // �Խù��� ��ü ����
	private int displayRow = 10;	//�� �������� ǥ���� �Խù� ����
	private int displayPage = 10; 	// ������ư�� ������ư ���̿� ǥ�õ� ������ ����
	private int beginPage;		// ������ư�� ������ư ���̿� ǥ�õ� ���� ������ ��ȣ
	private int endPage; 		// ������ư�� ������ư ���̿� ǥ�õ� �������� ��ȣ
	private boolean prev;	// ���� ��ư�� ���ϰ��� �Ⱥ��ϰ���(true/false)
	private boolean next;	// ���� ��ư�� ���ϰ��� �Ⱥ��ϰ���(true/false)
	private int startNum;		// ���� �������� ǥ�õ� �Խù� ��ȣ�� ���� ��ȣ
	private int endNum;		// ���� �������� ǥ�õ� �Խù��� ��ȣ�� �P ��ȣ
	
	// ������ ǥ�� ��
	//[1] 2 3 4 5 6 7 8 9 10 [��]	- 1���������� ǥ�� prev ����	�Խù� 100�� �̻�
	//[��] 11 12 13 14 [15] 16 17 18 19 20  [��]	- �Խù� ������ 200�� �̻��� ���
	//[��] 21 22 23 24 [25] 26 27 28 29 30  [��]	- �Խù� ������ 200�� �̻��� ���
	//[��] 11 12 13 14 - �Խù� ������ 141~149�� �ΰ��
	
	// �� Ŭ������ �ϳ��� �Խ��ǿ� ��ü �ϳ��� �Ҵ��ؼ� ��ü �Խù� ���� ���� ���� �������� �� ��ҵ���
	// �� ��� ������ �����ϰ� ȭ���� �������� ����������� ���� �°� ǥ���ϴ� Ŭ���� �Դϴ�....

	private void paging(){
		// 1. begiPage �� endPage ���
		double temp = page/(double)displayPage;
		// 1/10->0.1		9/10->0.9
		
		// 1-2. �� ���� ������� �Ҽ��� ù°�ڸ� "�ø�����"�մϴ�
		temp = Math.ceil(temp);
		// 0.1->1.0		0.9->1.0	1.5->2.0	2.5->3.0
		
		endPage = (int)(temp * displayPage);
		// 1.0->10		1.0->10 	2.0->20 	3.0->30
		//endPage = ( (int)(Math.ceil( page/(double)displayPage ))*displayPage );
		
		
		beginPage = endPage - (displayPage -1);
		// endPage�� 10�̸� beginPage�� 1
		// endPage�� 20�̸� beginPage�� 11
		// endPage�� 30�̸� beginPage�� 21
		
		
		// 2. totalPage ���
		// �ѰԽù���(totalCount)�� �Ѱ��� ȭ�鿡 ǥ�õ� �Խù���(displayRow)�� ������, �Ҽ����ڸ� �ø��ؼ� ���
		int totalPage = (int)Math.ceil( totalCount/(double)displayPage );
		// 108/10 -> 10.8	-> 11.0	-> 11 : �ѰԽù��� 108���̸� �ʿ��� ������������ 11���������� �ʿ�
		// 75/10 -> 7.5 -> 8.0 -> 8	: �ѰԽù��� 75���̸� �ʿ��� �� ���������� 8���������� �ʿ�
		
		// totalCount�� �ܺο��� ��ü �ȿ� �־��ִ� ������ ������ �� �����Դϴ�.
		
		
		// 3. next, prev
		if( totalPage < endPage ) {
			endPage = totalPage;
			next = false;
		} else {	// endPage �ڷ� �������� �� ������ next �� ǥ���ϴ� ������ ����
			next = true;
		}
		
		prev = (beginPage==1)?false : true;		// ������������ 1�� ��츸 ǥ�þ���. ������ �� ǥ��
		
		
		// 4. startNum, endNum : ROWNUM�� ������� �Ͽ� �����ϴ� ǥ�õ� �Խù� ��ȣ
		startNum = (page-1)*displayRow+1;
		// ���� ȭ���� ���� �Խù� ��ȣ 1page :  1, 2page : 11, 3page : 21, 4page:31
		endNum = page*displayRow;
		// ���� ȭ���� �P �Խù� ��ȣ		1page:10, 2page:20	,	3page:30,	4page : 40
		
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getDisplayRow() {
		return displayRow;
	}
	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}
	public int getDisplayPage() {
		return displayPage;
	}
	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	
	
	
	
}
