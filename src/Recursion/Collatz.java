package Recursion;
public class Collatz {

    int n;

    public int collatz(int n)
    {
        if(n == 1)
        {
            return 1;
        }

        if(n%2 == 0)
        {
            collatz(n/2);
        }

        if(n%2 != 0)
        {
            collatz(n*3 + 1);
        }
        return 1;
    }

    public static void main(String[] args) {
        Collatz c = new Collatz();
        System.out.println(c.collatz(871));

    }
}
