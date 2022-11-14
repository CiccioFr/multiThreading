package cruscalucio.multithreading;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Francesco
 */
public class Test {

    private Map<String, Integer> m = new HashMap();

    public /*synchronized*/ void eseguiTest(String k) {
        System.out.println("Thread: " + Thread.currentThread().getName() + "Chiave" + k + "Eseguo Test");

        synchronized (this) {
            m.put("foo", 1);
            Thread.currentThread().yield(); // yield() dice "ok, caro sheduler, passa il controllo a qualcun altro"
            m.put("bar", 2);
            Thread.currentThread().yield(); // yield() dice "ok, caro sheduler, passa il controllo a qualcun altro"
            m.put("mah", 3);
            Thread.currentThread().yield(); // yield() dice "ok, caro sheduler, passa il controllo a qualcun altro"
            m.put("boh", 4);
            Thread.currentThread().yield(); // yield() dice "ok, caro sheduler, passa il controllo a qualcun altro"

            for (String s : m.keySet()) {
                System.out.println("Chiave: " + s + " --> " + m.get(s));
            }
        }

        // un blocco di codice sincronizzato è sempre collegata ad un oggetto
        Integer v = m.get(k);

        if (v != null) {
            System.out.println("Thread: " + Thread.currentThread().getName() + "Chiave" + k + "TROVATO");
        } else {
            System.out.println("Thread: " + Thread.currentThread().getName() + "Chiave" + k + "NON Trovato");
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Thread: " + Thread.currentThread().getName() + "Chiave" + k + "TROVATO");
        }

    }
}
