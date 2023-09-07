import java.util.*;
class Solution {
    static double[] discountPercent = new double[]{0.1, 0.2, 0.3, 0.4};
    static int profitPrice;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int emoLen = emoticons.length;
        
        List<double[]> discountList = new ArrayList<>();
        generateComb(discountList, new double[emoLen], emoLen, 0);

        for(int i=0; i<discountList.size(); i++){
            double[] percent = discountList.get(i);
            Map<Integer, List<Integer>> discountedPrices = getDiscountPrices(percent, emoticons);
            int plusMember = 0;
            profitPrice = 0;
            
            for(int j=0; j<users.length; j++){
                int standardPercent = users[j][0];
                int stadardPrice = users[j][1];
                if(isPlusMember(discountedPrices, standardPercent, stadardPrice)){
                   plusMember++; 
                }
                if(plusMember>answer[0]){
                    answer[0] = plusMember;
                    answer[1] = profitPrice;
                }else if(plusMember == answer[0]){
                    if(profitPrice>answer[1]){
                        answer[0] = plusMember;
                        answer[1] = profitPrice;
                    }
                }
            }
        }
        
        return answer;
    }
    private boolean isPlusMember(Map<Integer, List<Integer>> map, int standardPercent, int standardPrice){
        int sum = 0;
         for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
             if(entry.getKey() < standardPercent) continue;
             List<Integer> price = entry.getValue();
             sum += price.stream().mapToInt(Integer::intValue).sum();
         }
        if(standardPrice <= sum){
            return true;// 플러스 이모티콘 가입 
        }else{
            profitPrice += sum;// 가입을 안하므로 이모티콘 판매액에 포함 
            return false;
        }
    }
    private Map<Integer, List<Integer>> getDiscountPrices(double[] percent, int[] price){
        Map<Integer, List<Integer>> discountedPrices = new HashMap<>();
        for(int i=0; i<price.length; i++){
            int key = (int)(percent[i] * 100);
            discountedPrices.putIfAbsent(key, new ArrayList<>());
            int total = (int)(price[i] - (percent[i] * price[i]));
            discountedPrices.get(key).add(total);
        }
        return discountedPrices;
    }
    private void generateComb(List<double[]> list, double[] discount, int len, int cnt){
        if(cnt == len){
            double[] copy = discount.clone();
            list.add(copy);
            return;
        }
        for(int i = 0; i<4; i++){
            discount[cnt] = discountPercent[i];
            generateComb(list, discount, len, cnt + 1);
        }
    }
}