package com.bryan.stream.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Bryan Zhu
 * @date 2021/3/4 23:01
 */
public class SocketTest {
    public static void main(String[] args) {
        try (Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13)) {
            InputStream inputStream = s.getInputStream();
            Scanner in = new Scanner(inputStream);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
