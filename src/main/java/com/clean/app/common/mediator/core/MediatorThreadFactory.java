package com.clean.app.common.mediator.core;

import java.util.concurrent.ThreadFactory;

public class MediatorThreadFactory implements ThreadFactory {
    private int count = 0;
    @Override
    public Thread newThread(Runnable r) {
        count++;
        return new Thread(r,"Mediator Thread-"+count);
    }
}
