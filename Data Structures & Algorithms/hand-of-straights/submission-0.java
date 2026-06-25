class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0) return false;

        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        for(Integer num : hand) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }

        for(int num : hand) {
            
            int start = num;

            while(hmap.getOrDefault(start -1, 0) >  0) start--;

            while(start <= num) {
                while(hmap.getOrDefault(start, 0) > 0) {
                    for (int i = start; i < start + groupSize; i++) {
                        if (hmap.getOrDefault(i, 0) == 0) return false;
                        hmap.put(i, hmap.get(i) - 1);
                    }
                }
                start++;
            } 


           

        }


 return true;   
        
    }
}
