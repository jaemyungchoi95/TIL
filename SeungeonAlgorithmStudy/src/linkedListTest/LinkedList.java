package linkedListTest;

public class LinkedList implements ILinkedList {
	public Node head; // 리스트의 시작 노드
	public Node tail; // 리스트의 마지막 노드
	
	public LinkedList() {
		this.head = new Node(); // 더미 head 노드 생성
		this.tail = new Node(); // 더미 tail 노드 생성
		head.next = tail; // head의 다음 노드를 tail로 설정
		tail.prev = head; // tail의 이전 노드를 head로 설정
	}

	@Override
	public void add(int index, Node node) {
		// 만약 첫번째 값일 경우 (다음
		if (this.head.next == null) {
			Node nd = new Node(index, null, null);
			this.head.next = nd;
			this.tail.prev = nd;
			return ;
		}
		
		// 두번째 이후의 경우
		Node nd = new Node(index, null, this.head.next);
		this.head.prev.next = nd;
		this.head.next = nd;
		
	}

	@Override
	public void remove(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printAll() {
		Node 
		
	}






}
