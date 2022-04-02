package com.emily.infrastructure.test.mainTest;

import com.emily.infrastructure.test.po.User;

import java.lang.ref.ReferenceQueue;

/**
 * @program: spring-parent
 * @description: 弱引用测试
 * @author: Emily
 * @create: 2021/11/13
 */
public class WeakReferenceQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        UserWeakReference reference = new UserWeakReference(new User(), referenceQueue);
        //GC之前弱引用对象是否为空
        System.out.println("Username:" + reference.get());
        //GC回收之前ReferenceQueue是否为空
        System.out.println(referenceQueue.poll());
        System.gc();
        Thread.sleep(5000);
        //GC回收之后弱引用对象输出结果
        System.out.println(reference.get());
        //GC回收之后队列内容
        System.out.println(referenceQueue.poll());
        //GC之后判定ReferenceQueue是否为空
        if (referenceQueue.poll() != null) {
            System.out.println("referenceQueue is not null...");
        }
    }
}
