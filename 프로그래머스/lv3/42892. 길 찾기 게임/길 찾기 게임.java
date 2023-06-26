import java.util.*;
class Solution {
    static class Node{
        public int x;
        public int y;
        public int value;
        public Node left;
        public Node right;
        
        public Node(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    private static void preOrder(Node root, List<Integer> visitList){
        if(root == null)
            return;
        
        visitList.add(root.value);
        preOrder(root.left, visitList);
        preOrder(root.right, visitList);
    }
    private static void postOrder(Node root, List<Integer> visitList){
        if(root == null)
            return;
        
        postOrder(root.left, visitList);
        postOrder(root.right, visitList);
        visitList.add(root.value);
    }
        
    private static void insert(Node root, Node insertNode){
        if(root.x > insertNode.x){// 노드보다 작으면 왼쪽 서브트리
            if(root.left == null){
                root.left = insertNode;
            }else{
                insert(root.left, insertNode);
            }
        }else{// 크면 오른쪽 서브트리
            if(root.right == null){
                root.right = insertNode;
            }else{
                insert(root.right, insertNode);
            }
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        Node[] tree = new Node[nodeinfo.length];
        
        for(int i=0; i<nodeinfo.length; i++){// 노드 형태로 만들어주고 
            tree[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }
        
        Arrays.sort(tree, (a, b) -> b.y - a.y);// y순서에 따라 정렬해주고 
        
        Node root = tree[0];// root노드 설정
        for(int i=1; i<tree.length; i++){// root노드에 연결시켜주는 과정 
            insert(root, tree[i]);
        }
        
        List<Integer> preOrder = new ArrayList<>();// 전위순위
        preOrder(root, preOrder);
        
        List<Integer> postOrder = new ArrayList<>();// 후위순위
        postOrder(root, postOrder);
        
        return new int[][]{
            preOrder.stream().mapToInt(Integer::intValue).toArray(),
            postOrder.stream().mapToInt(Integer::intValue).toArray()
        };
    }
}