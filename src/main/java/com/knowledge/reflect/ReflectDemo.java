package com.knowledge.reflect;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/17 10:22
 */

public class ReflectDemo {
  public static void main(String[] args) {
    Package rootPackage = ReflectDemo.class.getPackage();
    String name = rootPackage.getName();

    String implementationTitle = rootPackage.getImplementationTitle();
    System.out.println(implementationTitle);
  }
}
