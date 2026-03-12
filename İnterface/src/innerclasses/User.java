package innerclasses;

/**
 * Static nested class: Builder. Dış instance'a ihtiyaç duymaz.
 */
public class User {

    private final String name;
    private final String email;

    private User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String email;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(name, email);
        }
    }
}
