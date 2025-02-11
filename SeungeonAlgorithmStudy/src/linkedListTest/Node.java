package linkedListTest;

public class Node {
	int value; // 저장할 데이터
	Node prev; // 이전 데이터
	Node next; // 다음 데이터
	
	// 기본 생성자
	public Node() {
		this.prev = null;
		this.next = null;
	}

	// 값만 받는 경우
	public Node(int value) {
		this.value = value;
		this.prev = null;
		this.next = null;
	}
	
	// 전체 값을 받는 경우
	public Node(int value, Node prev, Node next) {
		super();
		this.value = value;
		this.prev = prev;
		this.next = next;
	}

}

