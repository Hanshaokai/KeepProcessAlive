package com.example.han.keepprocessalive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnstart = (Button) findViewById(R.id.button);
        btnstart.setOnClickListener(new View.OnClickListener() {
/*

          通过AIDL实现双进程守护机制
          MarsDaemon第三方库，实现进程常驻
           通过AppWiget，android桌面小组件保持进程的运行*/

            @Override
            public void onClick(View view) {
                Log.d("tag", "fds");
                startService(new Intent(MainActivity.this, RemoteService.class));
                /**
                 * RemoteService 另开启一个进程
                 * 运行在一个以这个名字命名的全局的进程中
                 * 将组建运行到了另一个进程相当于另一个应用程序 所以在另一个线程中也将新建一个Application
                 * 的实例 每新建一个进程 Application 的onCreate都将被调用一次
                 *
                 *
                 */
            }
        });

    }
}
