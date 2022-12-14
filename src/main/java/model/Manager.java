package model;

import javax.persistence.Entity;

@Entity
public class Manager extends User{
    public Boolean adminPermissions;
    public Manager(Boolean adminPermissions) { this.adminPermissions = adminPermissions; }
    public Manager() {}

    public Boolean IsAnAdmin() { return adminPermissions; }
}
