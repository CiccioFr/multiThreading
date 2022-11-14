package cruscalucio.multithreading;

/**
 *
 * @author Francesco
 */
public class MyThreadTest extends Thread {

        private Test t;

        public MyThreadTest(Test t) {
            super();
            this.t = t;
        }
}
