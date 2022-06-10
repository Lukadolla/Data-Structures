package Heap;

import java.util.LinkedList;
import java.util.Random;

public class PQSort {

    public PQSort(){
        //TODO
    }

    public static void randomFill(LinkedList<Integer> input, int size)
    {
        Random rand = new Random();

        for(int i = 0; i < size; i++)
        {
            input.addLast(rand.nextInt(100));
        }
    }

    public static Integer removeMin(LinkedList<Integer> list)
    {
        int min_Index = 0;
        Integer min = list.get(min_Index);

        for(int i = 1; i < list.size(); i++)
        {
            Integer curr = list.get(i);

            if(curr < min)
            {
                min = curr;
                min_Index = i;
            }
        }

        list.remove(min_Index);
        return min;
    }
    public static void main_1(String[] args) {

        LinkedList<Integer> input = new LinkedList<>();

        int size = 100;

        while (size < 100000) {
            randomFill(input, size);

            long start = System.nanoTime();

            LinkedList<Integer> pQueue = new LinkedList<>();

            //Move elements from Array to PQ
            while (!input.isEmpty()) {
                pQueue.addLast(input.removeFirst());
            }

            //Move elements back according to their keys
            while (!pQueue.isEmpty()) {
                input.addLast(removeMin(pQueue));
            }

            long end = System.nanoTime();
            long elapsedTime = end - start;

            System.out.println(size);
            System.out.println(elapsedTime);
            size = (int) (size * 1.2);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> input = new LinkedList<>();

        int size = 100;

        while (size < 100000) {
            randomFill(input, size);

            long start = System.nanoTime();

            HeapPriorityQueue<Integer, Integer> pQueue = new HeapPriorityQueue<Integer, Integer>();

            //Move elements from Array to PQ
            while (!input.isEmpty()) {
                Integer value = input.removeFirst();
                pQueue.insert(value, value);
            }

            //Move elements back according to their keys
            /*while (!pQueue.isEmpty()) {
                input.addLast((pQueue.removeMin()));
            }*/

            long end = System.nanoTime();
            long elapsedTime = end - start;

            System.out.println(size);
            System.out.println(elapsedTime);
            size = (int) (size * 1.2);
        }
    }
}
