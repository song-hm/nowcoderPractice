package com.shm.kujiale;
//生产者-消费者
public class TestProduce {
    public static void main(String[] arg) {
        SynStack synStack = new SynStack();
        Producer pro = new Producer(synStack);
        Consumer con = new Consumer(synStack);
        pro.start();
        con.start();
    }
}
class Mantou{
     int id;
     Mantou(int id){
         this.id=id;
     }
}

class SynStack{
    int index = 0;
    Mantou[] ms = new Mantou[10];

    public synchronized void push(Mantou m){
        while (index == ms.length){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();
        ms[index] = m;
        index++;
    }

    public synchronized Mantou pop(){
        while (index == 0){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return ms[index];
    }
}

class Producer extends Thread{
    SynStack ss;
    public Producer(SynStack ss){this.ss = ss;}

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("生产馒头："+i);
            Mantou m = new Mantou(i);
            ss.push(m);
        }
    }
}

class Consumer extends Thread{
    SynStack ss;
    public Consumer(SynStack ss){this.ss = ss;}
    public void run(){
        for (int i = 0; i < 10; i++) {
            Mantou m = ss.pop();
            System.out.println("消费馒头："+m.id);
        }
    }
}

