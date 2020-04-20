package me.suren.leetcodearena.recursion;

public class NPower {

    public static void main(String[] args) {
        NPower obj = new NPower();
        System.out.println(obj.myPow(2, -2147483648));
    }

    double myPow(double x, int n) {
        if(n==0||x==1)return 1.0;
        if(n<0)return 1.0/(x * myPow(x,-(n+1)));
        if(n%2==0){
            return myPow(x*x,n/2);
        }
        else{
            return x*myPow(x*x,(n-1)/2);
        }
    }

    /*public double myPow(double x, int n) {
        if(x == 0 || n == 1) return x;
        if(x == 1 || n == 0) return 1.0;

        double result = 1.0;
        if(Math.abs(n%2) == 1) {
            if(n > 0) {
                result = x;
                n--;
            }
            else {
                result = 1/x;
                n++;
            }
        }

        while(n != 0) {
            if(n > 0) {
                result *= x * x;
                n -= 2;
            }
            else {
                result /= x * x;
                n += 2;
            }
        }

        return result;
    }*/
}