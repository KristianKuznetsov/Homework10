package taskStar;

import task1.User;

public class UserStar implements Cloneable {
    private String id;
    private User user;

    public UserStar(String id, User user) {
        this.id = id;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return this.user.getUsername();
    }

    public void setUserName(String username) {
        this.user.setUsername(username);
    }

    public String getUserEmail() {
        return this.user.getEmail();
    }

    public void setUserEmail(String email) {
        this.user.setEmail(email);
    }


    //Поверхностное копирование
    @Override
    public UserStar clone() {
        try {
            UserStar clone = (UserStar) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public UserStar deepClone() {
        try {
            User cloneUser = new User(this.user.getUsername(), this.user.getEmail());
            UserStar clone = (UserStar) super.clone();
            clone.setUser(cloneUser);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "UserStar{" +
                "id='" + id + '\'' +
                ", user=" + user.toString() +
                '}';
    }
}
