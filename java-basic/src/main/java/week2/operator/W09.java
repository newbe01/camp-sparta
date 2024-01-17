package week2.operator;

public class W09 {
    public static void main(String[] args) {
        short x = 10;
        int y = 20;

        int z = x + y;

        long lx = 30L;
        long lz = z + lx;

        float fx = x;
        float fy = y;
        float fz = z;

        System.out.println("lz = " + lz);
        System.out.println("fx = " + fx);
        System.out.println("fy = " + fy);
        System.out.println("fz = " + fz);
    }
}
