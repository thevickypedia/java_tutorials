public class loop_operations {
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
