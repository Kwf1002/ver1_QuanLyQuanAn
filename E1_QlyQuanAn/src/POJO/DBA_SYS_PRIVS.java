/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author SONDAY
 */
public class DBA_SYS_PRIVS {

    private String GRANTEE, PRIVILEGE, ADMIN_OPTION, COMMON;

    public DBA_SYS_PRIVS(String GRANTEE, String PRIVILEGE, String ADMIN_OPTION, String COMMON) {
        this.GRANTEE = GRANTEE;
        this.PRIVILEGE = PRIVILEGE;
        this.ADMIN_OPTION = ADMIN_OPTION;
        this.COMMON = COMMON;
    }

    public DBA_SYS_PRIVS() {
    }

    public String getGRANTEE() {
        return GRANTEE;
    }

    public void setGRANTEE(String GRANTEE) {
        this.GRANTEE = GRANTEE;
    }

    public String getPRIVILEGE() {
        return PRIVILEGE;
    }

    public void setPRIVILEGE(String PRIVILEGE) {
        this.PRIVILEGE = PRIVILEGE;
    }

    public String getADMIN_OPTION() {
        return ADMIN_OPTION;
    }

    public void setADMIN_OPTION(String ADMIN_OPTION) {
        this.ADMIN_OPTION = ADMIN_OPTION;
    }

    public String getCOMMON() {
        return COMMON;
    }

    public void setCOMMON(String COMMON) {
        this.COMMON = COMMON;
    }
}
