import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static int[] parent;
    static final int MAX_SIZE = 2501;
    public String[] solution(String[] commands) {
        List<String> result = new ArrayList<>();
        
        parent = new int[MAX_SIZE];// 부모의 인덱스 저장
        String[] table = new String[MAX_SIZE];// 해당 인덱스의 값 저장 
        for(int i=0; i<MAX_SIZE; i++){
            parent[i] = i;// 자기 자신의 인덱스로 초기화 
            table[i] = "";
        }
        
        for(String command : commands){
            String[] parse = command.split(" ");
            switch(parse[0]){
                case "UPDATE" -> {
                    if(parse.length == 3){// UPDATE value1 value2
                        String value1 = parse[1];
                        String value2 = parse[2];
                        for(int i=0; i<MAX_SIZE; i++){
                            if(table[i].equals(value1))
                                table[i] = value2;
                        }
                    }else{// UPDATE r c value
                        int r = Integer.parseInt(parse[1]);
                        int c = Integer.parseInt(parse[2]);
                        String value = parse[3];
                        int idx = getTableIdx(r, c);
                        // 해당 좌표가 병합셀이면 부모셀의 값을 새로운 값으로 변경 
                        table[find(idx)] = value;
                    }
                }
                case "MERGE" -> {// MERGE r1 c1 r2 c2
                    int r1 = Integer.parseInt(parse[1]);
                    int c1 = Integer.parseInt(parse[2]);
                    int r2 = Integer.parseInt(parse[3]);
                    int c2 = Integer.parseInt(parse[4]);
                    int parentIdx1 = find(getTableIdx(r1, c1));// 첫번째 좌표의 부모 인덱스 값
                    int parentIdx2 = find(getTableIdx(r2, c2));// 두번째 좌표의 부모 인덱스 값
                    if(parentIdx1 == parentIdx2) continue; // 이미 병합된 그룹이면 제외
                    String changeStr = table[parentIdx1].length() == 0 ? table[parentIdx2] : table[parentIdx1];// 두 셀 중 하나의 셀만 값이 있는 경우
                    union(parentIdx1, parentIdx2);// 병합
                    table[parentIdx2] = "";
                    table[parentIdx1] = changeStr;
                }
                case "UNMERGE" -> {
                    int r = Integer.parseInt(parse[1]);
                    int c = Integer.parseInt(parse[2]);
                    int idx = getTableIdx(r, c);
                    int root = find(idx);
                    
                    String temp = table[root];// rc위치에 있는 string 저장
                    table[root] = "";// 부모 위치 값 초기화 
                    table[idx] = temp;// rc값 저장 
                    List<Integer> list = new ArrayList<>();
                    for(int i=0; i<MAX_SIZE; i++){
                        if(root == find(i))// 부모가 같으면 
                            list.add(i);
                    }
                    for(int n : list){
                        parent[n] = n;
                    }
                    
                }
                case "PRINT" -> {
                    int r = Integer.parseInt(parse[1]);
                    int c = Integer.parseInt(parse[2]);
                    int root = find(getTableIdx(r, c));
                    result.add(table[root].length() == 0 ? "EMPTY" : table[root]);
                }
            }
        }
        return result.stream().toArray(String[]::new);
    }
    private int getTableIdx(int r, int c){
        int idx = 50 * (r-1);
        return idx + c;
    }
    private int find(int n){
        if(parent[n] == n){// 자기 자신이 부모인 경우
            return n;
        }
        return find(parent[n]);// 다른 집합에 속해있는 경우면 해당 집합의 부모 찾기
    }
    private void union(int a, int b){// 같은 집합인 경우 작은 숫자로 부모를 변경
        a = find(a);
        b = find(b);
        if( a == b ) return; // 이미 같은 집합인 경우 합집한 연산할 필요 x
        parent[b] = a;
    }
}
