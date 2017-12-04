/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alen
 */
public class GCD {

    /**
     * @param args the command line arguments
     */
    private static int prime = 2;
    private static ArrayList<Integer> listOfPrimes = new ArrayList<>();
    
    public static void main(String[] args) {
        int a;
        int b;
        Scanner in = new Scanner(System.in);
        a = in.nextInt();
        b = in.nextInt();
        System.out.println(gcdPrimeFactors(a,b));
        System.out.println(gcdEucledian(a,b));
        
    }
    public static int gcdPrimeFactors(int a, int b){
        int x = 1;
        while((a != 1 && a != 1) || (a%prime == 0 || b%prime == 0)){
            if(a%prime == 0 && b%prime == 0)
            {
                listOfPrimes.add(prime);
                a = a/prime;
                b = b/prime;
            }
                
            else if(a%prime == 0 && b%prime != 0)
            {
                a = a/prime;
            } 
            else if(a%prime != 0 && b%prime == 0)
            {
                b = b/prime;
            }
            else if(a%prime != 0 && b%prime != 0)
            {
                prime = findNextPrime();
            }
            
        }
        for(int i = 0; i < listOfPrimes.size(); i++){
            x = listOfPrimes.get(i) * x;
        }
        return x;
    }
    public static int gcdEucledian(int a, int b){
        if(b == 0)
           return a;
        else
        {
          return gcdEucledian(b,a%b);
        }
        
    }
    public static int findNextPrime(){
        if (isPrime())
        return prime;
        else
        {
            prime += 2;
            return findNextPrime();
        }
    }
    public static boolean isPrime() {
        prime++;
    for (int divisor = 2; divisor <= prime / 2; divisor++) {
        if (prime % divisor == 0) {
            return false;
        }
    }
    return true;
}
}
