package cruscalucio.multithreading;

/**
 *
 * @author Francesco
 */
public class MyThread extends Thread{

    private int n;

    public MyThread(int n) {
        super();
        this.n = n;
    }

    public static void faQualcosa(int n) {
        for (int i = 0; i <= n; i++) {
            // stampa ogni 1000
            if (i % 1_000 == 0) {
                System.out.println("Thread " + Thread.currentThread().getName()
                        + " Sono al passo " + i);
            }
        }
    }
}
