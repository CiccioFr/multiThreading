package cruscalucio.multithreading;

import static cruscalucio.multithreading.MyThread.faQualcosa;

/**
 *
 * @author WS2
 */
public class MyThreadTest extends Thread {

        private Test t;

        public MyThreadTest(Test t) {
            super();
            this.t = t;
        }
}