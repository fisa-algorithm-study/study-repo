package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    // 트리를 구성할 노드들.
    // 노드의 ID와 연결된 왼쪽 자식노드, 오른쪽 자식노드를 갖습니다.
    static class node{
        char ID;
        node left;
        node right;

        public node(Character ID, node left, node right){
            this.ID = ID;
            this.left = left;
            this.right = right;
        }

        public node(Character ID){
            this.ID = ID;
            left = null;
            right = null;
        }

        public char getID() {
            return ID;
        }

        public node NodeLeft() {
            return left;
        }

        public node NodeRight() {
            return right;
        }

        public void setLeft(node left) {
            if (left.getID() != '.')
                this.left = left;
        }

        public void setRight(node right) {
            if (right.getID() != '.')
                this.right = right;
        }

        @Override
        public String toString(){
            char leftID = (left != null) ? left.getID(): '.';
            char rightID = (right != null) ? right.getID(): '.';
            return ("( ID: " + ID + ", left: " + leftID + ", right: " + rightID + ")");
        }
    }

    // 순회 알고리즘은 재귀적으로 작성했습니다.
    // 전위순회
    public static void preOrder(node root){
        System.out.printf("%C", root.getID());

        if (root.NodeLeft() != null){
            preOrder(root.NodeLeft());
        }

        if (root.NodeRight() != null){
            preOrder(root.NodeRight());
        }
    }

    // 중위순회
    public static void inOrder(node root){
        if (root.NodeLeft() != null){
            inOrder(root.NodeLeft());
        }

        System.out.printf("%C", root.getID());

        if (root.NodeRight() != null){
            inOrder(root.NodeRight());
        }
    }

    //후위순회
    public static void postOrder(node root){
        if (root.NodeLeft() != null){
            postOrder(root.NodeLeft());
        }

        if (root.NodeRight() != null){
            postOrder(root.NodeRight());
        }

        System.out.printf("%C", root.getID());
    }


    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        // 노드 세팅용 리스트 (이미 노드가 존재하는지)
        ArrayList<node> nodes = new ArrayList<>();
        node root = null;
        for (int i = 0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            char curr_node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            // 첫번째 노드라면 root로 설정하기
            if (root == null) {
                // 오른쪽/왼쪽 노드가 '.'라면 설정 X
                root = new node(curr_node);
                if(left != '.'){
                    root.setLeft(new node(left));
                }
                if(right != '.'){
                    root.setRight(new node(right));
                }
                nodes.add(root);
                if(left != '.')
                    nodes.add(root.NodeLeft());
                if(right != '.')
                nodes.add(root.NodeRight());
            // 루트가 아니라면 이미 있는 노드 업데이트 혹은 새로 생성 
            } else {
                for (int j=0; j<nodes.toArray().length; j++){
                    boolean contains = false;
                    if (nodes.get(j).getID() == curr_node) {
                        if(left != '.') {
                            // left ID를 갖는 노드가 이미 있다면 그 노드를 left에 추가
                            for (node n2 : nodes) {
                                if (n2.getID() == left) {
                                    contains = true;
                                    nodes.get(j).setLeft(n2);
                                    break;
                                }
                            }
                            // 없다면 만들어서 추가
                            if (contains == false) {
                                node leftNode = new node(left);
                                nodes.get(j).setLeft(leftNode);
                                nodes.add(leftNode);
                            }
                            contains = false;
                        }

                        if(right != '.') {
                            // right도 똑같이
                            for (node n2 : nodes) {
                                if (n2.getID() == right) {
                                    contains = true;
                                    nodes.get(j).setRight(n2);
                                    break;
                                }
                            }
                            if (contains == false) {
                                node rightNode = new node(right);
                                nodes.get(j).setRight(rightNode);
                                nodes.add(rightNode);
                            }
                        }
                    }
                }
            }
        }
//
//        for (node n : nodes)
//            System.out.println(n);

        // 전위 순회
        preOrder(root);
        System.out.println();

        // 중위 순회
        inOrder(root);
        System.out.println();

        // 후위 순회
        postOrder(root);
    }
}
