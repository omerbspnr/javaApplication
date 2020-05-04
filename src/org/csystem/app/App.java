/*----------------------------------------------------------------------------------------------------------------------
    Aşağıda açıklanan sınıfı yazınız:
    Açıklamalar:
    1. Sınıfın ismi CoundownTimer olacaktır

    2. Sınıf abstract olarak yazılacak ve tek bir ctor'unda millisaniye cinsinden toplam zamanı ve
    period değerini milisaniye cinsinden alacaktır. Örnek bir kullanım aşağıdaki gibidir:

    new CountdownTimer(10000, 1000) {...}

    3. Sınıfın onTick ve onCompleted isimli iki adet abstract metodu olacaktır. onTick metodu
    her periyotta çağrılan, onCompleted metodu ise geriye sayım bittiğinde çağrılan metot olarak
    alınacaktır. onTick metodunun her çağrıldığında kalan zamanı milisaniye cinsinden alan bir
    parametesi olacaktır. Örnek bir kullanım:

     new CountdownTimer(10000, 1000) {
        public void onTick(long remaininMs)
        {
            //Her adımda yapılacak iş
        }

        public void onCompleted()
        {
            // Geri sayım bittiğinde yapılacak iş
        }
     }
    4. Sınıfın final start metodu ile timer başlatılatacaktır
    5. Sınfın cancel isimli metodu geriye sayım timer'ını durdurmak için kullanılacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.CSDTimer;
import org.csystem.util.ITimerTask;

import java.util.concurrent.TimeUnit;

class App {
    public static void main(String[] args)
    {
        CSDTimer timer = new CSDTimer(0, 1, TimeUnit.SECONDS);

        timer.start(new ITimerTask() {
            public void run()
            {
                System.out.print(".");
            }
        });
        System.out.println("Tekrar yapınız");
    }
}

