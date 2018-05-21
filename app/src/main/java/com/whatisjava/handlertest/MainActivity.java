package com.whatisjava.handlertest;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.net.MulticastSocket;

public class MainActivity extends AppCompatActivity {

    private static TextView textView;

    private static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            textView.setText("handle message");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Constructor (but the preferred way to get a Message is to call {@link #obtain() Message.obtain()}).
//                Message message = new Message();

                /**
                 * Return a new Message instance from the global pool. Allows us to
                 * avoid allocating new objects in many cases.
                 * 从整个Messge池中返回一个新的Message实例，通过obtainMessage能避免重复Message创建对象。
                 */
//                Message message = Message.obtain();
                Message message = handler.obtainMessage();
                message.arg1 = 1;
                handler.sendMessage(message);
            }
        }).start();
    }

}
