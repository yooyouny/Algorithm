class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++){
            long number = numbers[i];
            if(number % 2 == 0){// 짝수는 항상 마지막 비트가 0
                answer[i] = number + 1;// 다음 숫자가 비트가 1개 다른 제일 작은 수가 됨  
            }else{
                String binaryStr = Long.toString(number, 2);// 정수를 이진수로 변환
                int idx = binaryStr.lastIndexOf("0");
                if(idx == -1){// 1로만 이루어진 이진수 
                    binaryStr = "10" + binaryStr.substring(1, binaryStr.length());
                }else{// 0이 있는 이진수 
                    binaryStr = binaryStr.substring(0, idx) + "10" + binaryStr.substring(idx+2, binaryStr.length());
                }
                answer[i] = Long.parseLong(binaryStr, 2);// 이진수를 정수로 변환 
            }
        }
        return answer;
    }
}