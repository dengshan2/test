package com.zd.ssh;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

/**
 * Created by root on 11/30/15.
 * author: zd
 */
public class TwoChannel {
    public static void main(String[] args) throws Exception {
        JSch jSch = new JSch();
        /* 创建会话 */
        Session session = jSch.getSession("root", "192.168.21.147", 22);
        session.setPassword("123dev");
        Hashtable<String, String> config = new Hashtable<String, String>();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        /* 建立一个通道， 用来执行命令 */
        ChannelExec channel = (ChannelExec)session.openChannel("exec");
        channel.setCommand("cat /opt/tmp/112.txt");
        channel.setInputStream(null);
        channel.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(channel.getInputStream()));
        int i = 0;
        int count = 0;
        while (true) {
            if (reader.ready()) {
                count++;
                System.out.println(reader.readLine());
            } else {
                Thread.sleep(100l);
                i++;
                if (i > 50) {
                    break;
                }
            }
        }
        System.out.println("haha");
        System.out.println(count);

        reader.close();
        channel.disconnect();

        /* 关闭会话 */
        session.disconnect();
        System.out.println("session disconnect");
    }

}
