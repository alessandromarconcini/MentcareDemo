package model;

public class Manager {
    public Boolean adminPermissions;


    public Manager(Boolean adminPermissions) { this.adminPermissions = adminPermissions; }
    public Manager() {}

    public Boolean IsAnAdmin() { return adminPermissions; }
}
