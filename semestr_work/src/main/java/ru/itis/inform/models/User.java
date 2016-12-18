package ru.itis.inform.models;

/**
 * Created by artur on 08.11.16.
 */
public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String password;
    private String login;

    public User() {
    }

    public User(Builder builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.login = builder.login;
        this.password = builder.password;
    }

    public static class Builder {
        private int userId;
        private String firstName;
        private String lastName;
        private String password;
        private String login;

        public Builder userId(int arg) {
            this.userId = arg;
            return this;
        }

        public Builder firstName(String arg) {
            this.firstName = arg;
            return this;
        }

        public Builder lastName(String arg) {
            this.lastName = arg;
            return this;
        }

        public Builder login(String arg) {
            this.login = arg;
            return this;
        }

        public Builder password(String arg) {
            this.password = arg;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
