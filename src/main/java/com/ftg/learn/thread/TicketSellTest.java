package com.ftg.learn.thread;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TicketSellTest implements Runnable{

    private int ticketNo;

    @SneakyThrows
    @Override
    public void run() {

        while (true){
            TimeUnit.SECONDS.sleep(1L);
            sellTicket();
        }
    }

    private synchronized void sellTicket(){

        if (ticketNo < 100){
            ticketNo++;
            System.out.println(Thread.currentThread() + "卖了" + ticketNo + "号的票票");

        }
    }

    @SneakyThrows
    @Test
    public void test(){
        TicketSellTest ticketSellTest = new TicketSellTest();
        new Thread(ticketSellTest,"江北").start();
        new Thread(ticketSellTest,"香坊").start();

        System.out.println("人为阻塞");
        System.in.read();
    }


}
