// Add odd and even numbers to dedicated arrays

import java.util.ArrayList;
import java.util.List;

class whileLoop {
    public static void main(String[] args) {
        int i = 0;
        List<Integer> even_numbers = new ArrayList<>();
        List<Integer> odd_numbers = new ArrayList<>();
        do {
            if (i % 2 == 0) {
                even_numbers.add(i);
            } else {
                odd_numbers.add(i);
            }
            i++;
        }
        while (i < 100);
        System.out.println("Odd number list: " + odd_numbers);
        System.out.println("Even number list: " + even_numbers);
    }
}

class forLoop {
    public static void main(String[] args) {
        for (int i = 1; i <=2; i++) {
            System.out.println("Outer loop: " + i);
            for (int j = 1; j <=3; j++) {
                String text = String.format("\tInner loop for the outer index [%d]: %d", i, j);
                System.out.println(text);
            }
        }
    }
}
