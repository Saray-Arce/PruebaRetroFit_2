package classes;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

import enumerations.UserPrivilege;
import enumerations.Userstatus;

@Root(name = "user")
public class User implements Serializable {

    @Element(name = "id", required = true)
    private Integer id;

    @Element(name = "login", required = true)
    private String login;

    @Element(name= "email")
    private String email;

    @Element(name ="fullname")
    private String fullname;

    @Element(name = "status")
    private Userstatus status;

    @Element (name = "privilege")
    private UserPrivilege privilege;

    @Element (name = "passwd")
    private String passwd;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Userstatus getStatus() {
        return status;
    }

    public void setStatus(Userstatus status) {
        this.status = status;
    }

    public UserPrivilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(UserPrivilege privilege) {
        this.privilege = privilege;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

//   private Set<UserPlant> plants;
 //   private Set<Equipment> equipments;
}
