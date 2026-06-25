class Solution {
    public double myPow(double x, int n) {
      double power =  powH(x, n);
      return n >= 0 ? power : 1 / power;
    }


     public double powH(double A, int B) {
        if(A == 0) return 0;
        if(B == 0) return 1;
        double p = powH(A, B/2); 
        if((B&1) == 1) {
            return (A*p*p);
        }
        else {
            return (p*p);
        }
    }
}
