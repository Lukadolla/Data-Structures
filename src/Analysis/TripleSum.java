package Analysis;
public class TripleSum {

    static int tripleSum (int[] array)
    {
        int count = 0;

        for(int val1 = 0; val1 < (array.length-2); val1++)
        {
            int val3 = val1 + 2;

            for(int val2 = 1; val2 < (array.length-1); val2++)
            {
                for(val3 = 2; val3 < array.length; val3++)
                {
                    if(array[val1] + array[val2] + array[val3] == 0)
                    {
                        count++;
                    }
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] array;
        array = new int[]{30,-30,-20,-10,40,0,10,15};

        System.out.println(tripleSum(array));
    }
}
