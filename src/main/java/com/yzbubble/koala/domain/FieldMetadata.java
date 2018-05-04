package com.yzbubble.koala.domain;

public class FieldMetadata {
    private String name;
    private String type;
    private String originType;
    private String description;
    private String notNull;
    private int length;
    private int varLength;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOriginType() {
        return originType;
    }

    public void setOriginType(String originType) {
        this.originType = originType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotNull() {
        return notNull;
    }

    public void setNotNull(String notNull) {
        this.notNull = notNull;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getVarLength() {
        return varLength;
    }

    public void setVarLength(int varLength) {
        this.varLength = varLength;
    }

    @Override
    public String toString() {
        return "FieldMetadata{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", originType='" + originType + '\'' +
                ", description='" + description + '\'' +
                ", notNull='" + notNull + '\'' +
                ", length=" + length +
                ", varLength=" + varLength +
                '}';
    }
}
