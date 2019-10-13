package com.github.sparsick.test.tool.assertion;

class Hero {
    private String name;
    private String realName;
    private Boolean supernaturalPower;


    public Hero(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public boolean hasSupernaturalPower() {
        return supernaturalPower;
    }

    public void setSupernaturalPower(boolean supernaturalPower) {
        this.supernaturalPower = supernaturalPower;
    }


    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }


}
