package com.test.springboot.entity;

public class UserGroup {
    private String name;
    private String passwd;
    private String groupName;

    public UserGroup() {
    }

    public UserGroup(Object name, Object passwd, Object groupName) {
        this.name = (String) name;
        this.passwd = (String) passwd;
        this.groupName = (String) groupName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
