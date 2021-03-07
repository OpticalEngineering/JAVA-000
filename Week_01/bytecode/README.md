### HellByteCode.java
<pre>
<code>
package com.bryan.bytecode;

/**
 * @author Bryan Zhu
 * @date 2021/2/26 1:35
 */
public class HelloByteCode {
    public static void main(String[] args) {
        HelloByteCode helloByteCode = new HelloByteCode();
    }
}
</code>
</pre>


### javap
<pre>
<code>
javap com.bryan.bytecode.HelloByteCode

Compiled from "HelloByteCode.java"
public class com.bryan.bytecode.HelloByteCode {
  public com.bryan.bytecode.HelloByteCode();
  public static void main(java.lang.String[]);
}

javap -c  com.bryan.bytecode.HelloByteCode

Compiled from "HelloByteCode.java"
public class com.bryan.bytecode.HelloByteCode {
  public com.bryan.bytecode.HelloByteCode();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class com/bryan/bytecode/HelloByteCode
       3: dup
       4: invokespecial #3                  // Method "<init>":()V
       7: astore_1
       8: return
}

javap -verbose -c  com.bryan.bytecode.HelloByteCode

Classfile /E:/Study/Java进阶训练营/JAVA-000/Week_01/bytecode/src/main/java/com/bryan/bytecode/HelloByteCode.class
  Last modified 2021-2-28; size 307 bytes
  MD5 checksum bbac71a8db8f51e5945be121267a0aa3
  Compiled from "HelloByteCode.java"
public class com.bryan.bytecode.HelloByteCode
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #4.#13         // java/lang/Object."<init>":()V
   #2 = Class              #14            // com/bryan/bytecode/HelloByteCode
   #3 = Methodref          #2.#13         // com/bryan/bytecode/HelloByteCode."<init>":()V
   #4 = Class              #15            // java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Utf8               Code
   #8 = Utf8               LineNumberTable
   #9 = Utf8               main
  #10 = Utf8               ([Ljava/lang/String;)V
  #11 = Utf8               SourceFile
  #12 = Utf8               HelloByteCode.java
  #13 = NameAndType        #5:#6          // "<init>":()V
  #14 = Utf8               com/bryan/bytecode/HelloByteCode
  #15 = Utf8               java/lang/Object
{
  public com.bryan.bytecode.HelloByteCode();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 7: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: new           #2                  // class com/bryan/bytecode/HelloByteCode
         3: dup
         4: invokespecial #3                  // Method "<init>":()V
         7: astore_1
         8: return
      LineNumberTable:
        line 9: 0
        line 10: 8
}
SourceFile: "HelloByteCode.java"

javap -verbose  com.bryan.bytecode.HelloByteCode

Classfile /E:/Study/Java进阶训练营/JAVA-000/Week_01/bytecode/src/main/java/com/bryan/bytecode/HelloByteCode.class
  Last modified 2021-2-28; size 307 bytes
  MD5 checksum bbac71a8db8f51e5945be121267a0aa3
  Compiled from "HelloByteCode.java"
public class com.bryan.bytecode.HelloByteCode
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #4.#13         // java/lang/Object."<init>":()V
   #2 = Class              #14            // com/bryan/bytecode/HelloByteCode
   #3 = Methodref          #2.#13         // com/bryan/bytecode/HelloByteCode."<init>":()V
   #4 = Class              #15            // java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Utf8               Code
   #8 = Utf8               LineNumberTable
   #9 = Utf8               main
  #10 = Utf8               ([Ljava/lang/String;)V
  #11 = Utf8               SourceFile
  #12 = Utf8               HelloByteCode.java
  #13 = NameAndType        #5:#6          // "<init>":()V
  #14 = Utf8               com/bryan/bytecode/HelloByteCode
  #15 = Utf8               java/lang/Object
{
  public com.bryan.bytecode.HelloByteCode();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 7: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: new           #2                  // class com/bryan/bytecode/HelloByteCode
         3: dup
         4: invokespecial #3                  // Method "<init>":()V
         7: astore_1
         8: return
      LineNumberTable:
        line 9: 0
        line 10: 8
}
SourceFile: "HelloByteCode.java"


javap 用法
用法: javap <options> <classes>
其中, 可能的选项包括:
  -help  --help  -?        输出此用法消息
  -version                 版本信息
  -v  -verbose             输出附加信息
  -l                       输出行号和本地变量表
  -public                  仅显示公共类和成员
  -protected               显示受保护的/公共类和成员
  -package                 显示程序包/受保护的/公共类
                           和成员 (默认)
  -p  -private             显示所有类和成员
  -c                       对代码进行反汇编
  -s                       输出内部类型签名
  -sysinfo                 显示正在处理的类的
                           系统信息 (路径, 大小, 日期, MD5 散列)
  -constants               显示最终常量
  -classpath <path>        指定查找用户类文件的位置
  -cp <path>               指定查找用户类文件的位置
  -bootclasspath <path>    覆盖引导类文件的位置

</code>
</pre>
