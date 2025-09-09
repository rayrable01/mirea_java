public class Author {
    private final String name;
    private String email;
    private final char gender;

    public Author(String username, String userEmail, char userGender) {
        this.name = username;
        this.email = userEmail;

        if (userGender == 'M' || userGender == 'F') {
            this.gender = userGender;
        } else {
            this.gender = 'U';
        };
    };

    public String getName() {
        return this.name;
    };

    public String getEmail() {
        return this.email;
    };

    public void setEmail(String newEmail) {
        this.email = newEmail;
    };

    public char getGender() {
        return this.gender;
    };

    public String toString() {
        return this.name + "\t" + this.gender + "\t" + " at " + this.email;
    }
}
