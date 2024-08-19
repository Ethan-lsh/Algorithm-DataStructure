package Tree;

public class TreeTest {

	public static void main(String[] args) {
		String[] names = {"김태희", "이주현", "정보규", "김동열", "권선", "홍길동"};
		
		CompleteBinaryTree<String> tree = new CompleteBinaryTree<>(names.length);
		for (String name: names) {
			tree.add(name);
		}
	
		tree.bfs2();
		System.out.println("====dfs=====");
		tree.dfsByPreOrder(1);
	}

}
