package com.bryan.stream.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Bryan Zhu
 * @date 2021/3/4 23:13
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress[] addresses = InetAddress.getAllByName("baidu.com");
            for (InetAddress address : addresses) {
                System.out.println(address);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
