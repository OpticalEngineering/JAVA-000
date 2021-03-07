package com.bryan.classloader;

import java.net.URL;

/**
 * @author Bryan Zhu
 * @date 2021/3/1 22:21
 */
public class JvmClassLoaderPrintPath {
    public static void main(String[] args) {
        // 启动类
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        System.out.println("启动类加载器");
        for (URL url : urls) {
            System.out.println(" ==> " + url.toExternalForm());
        }
        //扩展类
        printClassLoader("扩展类加载器", JvmClassLoaderPrintPath.class.getClassLoader().getParent());

        //应用类
        printClassLoader("应用类加载器", JvmClassLoaderPrintPath.class.getClassLoader());
    }

    private static void printClassLoader(String name, ClassLoader classLoader) {
        if (classLoader != null) {
            System.out.println(name + " ClassLoader -> " + classLoader.toString());
            printUrlForClassLoader(classLoader);
        } else {
            System.out.println(name + " ClassLoader -> " + null);
        }
    }

    private static void printUrlForClassLoader(ClassLoader classLoader) {
    }
}
