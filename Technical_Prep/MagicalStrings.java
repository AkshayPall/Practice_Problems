public class MagicalStrings {
    //generate string
    public int magicalString(int n) {
        StringBuffer bfr = new StringBuffer("1221");
        if (n <= 0){
            return 0;
        } else if (n <= 3){
            return 1;
        }
        int left = 0;
        int right = 1;
        while(bfr.length() < n){
            int val = 1;
            if(bfr.charAt(left) == bfr.charAt(right)){
                val++;
            }
            left++;
            right++;
            bfr.append(""+val);
        }
        System.out.println(bfr);

        //iterate through and find repeated
        int numOfOnes = 0;
        for (int i = 0; i < bfr.length(); i++){
            if(bfr.charAt(i) == '1') {
                numOfOnes++;
                System.out.println("ADDED ONE");
            }
        }
        return numOfOnes;
    }
}
