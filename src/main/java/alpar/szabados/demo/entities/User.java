package alpar.szabados.demo.entities;

public class User {
    private Long id;
    private String user_name;

    public User(Long id, String user_name) {
        this.id = id;
        this.user_name = user_name;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

}
