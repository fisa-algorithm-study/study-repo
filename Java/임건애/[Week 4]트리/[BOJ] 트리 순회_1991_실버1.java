import java.util.*;
import java.io.*;

class Node {
    char root;
    Node left;
    Node right;
    
    public Node(char root) {
        this.root = root;
        this.left = null;
        this.right = null;
    }
}

class Main
{
    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.root);
        preorder(node.left);
        preorder(node.right);
    }
        
    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.root);
        inorder(node.right);
    }
        
    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.root);
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Node[] tree = new Node[N];
		
		for (int i = 0; i < N; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    char root = st.nextToken().charAt(0);
		    char left = st.nextToken().charAt(0);
		    char right = st.nextToken().charAt(0);
		    
		    int rootIdx = root - 'A';
		    int leftIdx = left - 'A';
		    int rightIdx = right - 'A';
		    
		    if (tree[rootIdx] == null) {
		        tree[rootIdx] = new Node(root);
		    }
		    
		    if (left != '.') {
		        tree[leftIdx] = new Node(left);
		        tree[rootIdx].left = tree[leftIdx];
		    }
		    
		    if (right != '.') {
		        tree[rightIdx] = new Node(right);
		        tree[rootIdx].right = tree[rightIdx];
		    }
		}
		
		preorder(tree[0]);
		System.out.println();
		
		inorder(tree[0]);
		System.out.println();
		
		postorder(tree[0]);
		System.out.println();
		
        br.close();
	}
}