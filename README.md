## Handler 相关基础点

### 主线程（MainThread）
    *. 当应用程序首次启动时，会同时开启一条主线程。作用是用来处理UI相关的事件如更新UI操作UI等。

### 子线程（工作线程）（WorkThread）
    *. 人为手动开启的线程，用来执行耗时的工作，如网络请求，IO操作，文件处理等。

### 消息（Message）
    *. 线程之间通信的数据单元，用来存储需要操作的通信信息。

### 消息队列（MessageQueue）
    *. 一种先进先出的数据结构，用来存储Handler发送过来的消息（Message）。

### 处理者（Handler）
    *. 主线程和子线程的通讯媒介，线程消息的主要处理者。如添加消息（Message）到消息队列（MessageQueue），
    处理循环器（Looper）分配过来的消息（Message）。

### 循环器（Looper）
    *. 消息队列（MessageQueue）和处理者（Handler）的通信媒介。
    *. 消息循环
        1. 消息获取：循环取出消息队列中的消息;
        2. 消息分发：讲取出的消息（MessageQueue）发给对应的处理者(Handler);

    注意：
        每个线程中只能拥有一个Looper；
        一个Looper可以绑定多个线程的Handler
        即多个线程可往一个Looper所持有的MessageQueue中发送消息，提供了线程间通信的可能

### Handler发送消息到消息队列的方式：
    1. Handler.sendMessage(Message msg); -->将消息发送到消息队列中
    2. Handler.dispatchMessage(Message msg); -->将消息分发给对应的Handler
    3. Handler.post(Runnable r); -->将消息发送到消息队列中
    4. Handler.handleMessage(Message msg); -->根据某个消息进行相关处理或UI操作。