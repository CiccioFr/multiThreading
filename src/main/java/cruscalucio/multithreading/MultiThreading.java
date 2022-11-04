package cruscalucio.multithreading;

import static cruscalucio.multithreading.MyThread.*;

/**
 *
 * @author Francesco
 */
public class MultiThreading {

    public static void main(String[] args) {
        // vediamo come si chiama il Thread che sta eseguendo il codice corrente (il metodo main)
        Thread current = Thread.currentThread();
        System.out.println("Thread principale si chiama: " + current.getName());

        faQualcosa(10_000);

        // cambiamogli il name al Thread main
        current.setName("Ciccio");
        Thread t = new MyThread(100_000_000);
        t.setName("Thread Demone");
        t.setDaemon(true);
        t.start();

        faQualcosa(200_000);

        System.out.println(">>>>>>> Interrompo il Thread Demone");
        t.interrupt();  // viene settato qua
        System.out.println(">>>>>>>>>>> Fatto!!");
        
        try {
            System.out.println("Attendo la terminazione del Thread " + t.getName() + "..");
            t.join();
            System.out.println("Thread " + t.getName() + " terminato.\n\nProcedo!");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
        }

        current.setName("Ennesimo alias del MAIN");
        faQualcosa(10_000);

        // metodi deprecati stoped e destroy
        // possono lascaino uno stato sporco assolutamente impredicibile
        // alternativa: invocare da un altro thread il suo metodo interrat, che non interrompe l'esecuzione
//        setta un plag di interruzione
//                il thread in certi punti verifica se gli è stato settato il..
//                e tira la inteructinterceptio
//      es qnd viene chiamato sleep ... quando il Thread va in attesa..


        Test test = new Test();
        Thread t = new MyThreadTest(test);
        t.setName("secondario");
        t.start();
        
        test.eseguiTest("bar");
    }
}