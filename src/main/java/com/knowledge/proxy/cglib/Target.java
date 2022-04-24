package com.knowledge.proxy.cglib;

public class Target {
    public String service(String arg){
        System.out.println(String.format("处理%s业务",arg));
        return arg + "return";
    }

    public void save(){
        System.out.println("saving");
    }

    public void update(){
        System.out.println("updating");

    }

}
