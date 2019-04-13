package ru.saubanova.models;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
//
//    public User(String firstName, String lastName, String login, String password) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.login = login;
//        this.password = password;
//    }
//    public User(Long id, String firstName, String lastName, String login, String password) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.login = login;
//        this.password = password;
//    }
    private User(Builder builder){
        this.id=builder.id;
        this.firstName=builder.firstName;
        this.lastName=builder.lastName;
        this.login=builder.login;
        this.password=builder.password;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String login;
        private String password;

        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName=firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName=lastName;
            return this;
        }

        public Builder login(String login){
            this.login=login;
            return this;
        }

        public Builder password(String password){
            this.password=password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
