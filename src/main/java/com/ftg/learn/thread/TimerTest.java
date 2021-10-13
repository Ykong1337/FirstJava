package com.ftg.learn.thread;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    @EqualsAndHashCode(callSuper = true)
    @Data
    private static class AlarmClockTask extends TimerTask {

        private boolean ring;

        @Override
        public void run() {

            String dateStr = new SimpleDateFormat("HH:mm:ss").format(new Date());

            if ("10:42:00".equals(dateStr)) {
                ring = true;
            }

            if (ring) {
                System.out.println("闹钟");
            }
        }
    }


    @SneakyThrows
    public static void main(String[] args) {

        Timer timer = new Timer();
        AlarmClockTask alarmClockTask = new AlarmClockTask();
        timer.schedule(alarmClockTask, 0, 1000);

        if (System.in.read() == 'q') {
            timer.cancel();
            alarmClockTask.setRing(false);

        }
    }
}
