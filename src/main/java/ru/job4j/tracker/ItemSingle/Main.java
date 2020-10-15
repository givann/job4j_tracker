package ru.job4j.tracker.ItemSingle;

public class Main {
    public static void main(String[] args) {
        SingleTonEnum singleTonEnum = SingleTonEnum.INSTANCE;
        SingleTonEnum singleTonEnum1 = SingleTonEnum.INSTANCE;
        SingleTonEnum singleTonEnum2 = SingleTonEnum.INSTANCE;
        System.out.println(singleTonEnum.hashCode());
        System.out.println(singleTonEnum1.hashCode());
        System.out.println(singleTonEnum2.hashCode());

//
//        SingleToneSec singleToneSec = SingleToneSec.getInstance();
//        System.out.println(singleToneSec.hashCode());
//        System.out.println(singleToneSec.hashCode());
//        System.out.println(singleToneSec.hashCode());
//        System.out.println(singleToneSec.hashCode());
    }


}
