package com.netty.client;

import com.domain.common.model.protobuf.Message;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tangjie<https: / / github.com / tang-jie>
 * @filename:MessageCallBack.java
 * @description:MessageCallBack功能模块
 * @blogs http://www.cnblogs.com/jietang/
 * @since 2016/10/7
 */
public class MessageCallBack {

    private Message.Head request;
    private Message.Head response;
    private Lock lock = new ReentrantLock();
    private Condition finish = lock.newCondition();

    public MessageCallBack(Message.Head request) {
        this.request = request;
    }

    public Message.Head start() {
        try {
            lock.lock();
            await();
            if (this.response != null) {
                return this.response;
            } else {
                return null;
            }
        } finally {
            lock.unlock();
        }
    }

    public void over(Message.Head reponse) {
        try {
            lock.lock();
            finish.signal();
            this.response = reponse;
        } finally {
            lock.unlock();
        }
    }

    private void await() {
        boolean timeout = false;
        try {
            timeout = finish.await(30 * 1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
