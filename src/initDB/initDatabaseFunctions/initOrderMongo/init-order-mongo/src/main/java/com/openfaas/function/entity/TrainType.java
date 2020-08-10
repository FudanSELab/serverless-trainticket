package com.openfaas.function.entity;

/**
 * @author fdse
 */
public enum TrainType {

    /**
     * G
     */
    GAOTIE    (0,"G"),
    /**
     * D
     */
    DONGCHE   (1,"D"),
    /**
     * C
     */
    CHENGJI   (2,"C"),
    /**
     * Z
     */
    ZHIDA     (3,"Z"),
    /**
     * T
     */
    TEKUAI    (4,"T"),
    /**
     * E
     */
    KUAISU    (5,"K"),
    /**
     * L
     */
    LINKE     (6,"L"),
    /**
     * Y
     */
    YOULAN    (7,"Y"),
    /**
     * S
     */
    CHENGJIAO (8,"S"),
    /**
     *
     */
    OTHER     (9,"");

    private int code;
     private String name;

    TrainType(int code, String name){
        this.code = code;
        this.name = name;
    }

    public int getCode(){
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getNameByCode(int code){
        TrainType[] trainTypeSet = TrainType.values();
        for(TrainType trainType : trainTypeSet){
            if(trainType.getCode() == code){
                return trainType.getName();
            }
        }
        return trainTypeSet[0].getName();
    }
}
