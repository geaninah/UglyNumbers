import java.util.ArrayList;
import java.util.List;

public class UglyNumbers
{
    static int min(int a, int b, int c)
    {
        return  Math.min(a, Math.min(b, c));
    }

    static int kthUglyNumber(int x)
    {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0, 1);

        int index2 = 0, index3 = 0, index5 = 0;

        int multipleOf2 = list.get(index2) * 2;
        int multipleOf3 = list.get(index3) * 3;
        int multipleOf5 = list.get(index5) * 5;

        int uglyNumber = 1;
        // We already have 1 as ugly number
        x--;

        while(x > 0)
        {
            uglyNumber = min(multipleOf2, multipleOf3, multipleOf5);
            
            if(!list.contains(uglyNumber))
            {
                list.add(uglyNumber);
                x--;
            }

            if(uglyNumber == multipleOf2)
            {
                index2++;
                multipleOf2 = list.get(index2) * 2;
            }
            else if(uglyNumber == multipleOf3)
            {
                index3++;
                multipleOf3 = list.get(index3) * 3;
            }
            else if(uglyNumber == multipleOf5)
            {
                index5++;
                multipleOf5 = list.get(index5) * 5;
            }
        }

        return uglyNumber;
    }

    public static void main(String args[])
    {
        System.out.print("Expected value --  1, actual value --");
        System.out.println(kthUglyNumber(1));
        System.out.print("Expected value --  2, actual value --");
        System.out.println(kthUglyNumber(2));
        System.out.print("Expected value --  3, actual value --");
        System.out.println(kthUglyNumber(3));
        System.out.print("Expected value --  4, actual value --");
        System.out.println(kthUglyNumber(4));
        System.out.print("Expected value --  5, actual value --");
        System.out.println(kthUglyNumber(5));
        System.out.print("Expected value --  6, actual value --");
        System.out.println(kthUglyNumber(6));
        System.out.print("Expected value --  8, actual value --");
        System.out.println(kthUglyNumber(7));
        System.out.print("Expected value --  9, actual value --");
        System.out.println(kthUglyNumber(8));
        System.out.print("Expected value --  10, actual value --");
        System.out.println(kthUglyNumber(9));
        System.out.print("Expected value --  12, actual value --");
        System.out.println(kthUglyNumber(10));
        System.out.print("Expected value --  51200000, actual value --");
        System.out.println(kthUglyNumber(1000));
    }
}