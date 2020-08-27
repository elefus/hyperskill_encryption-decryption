class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        this.firstName = java.util.Objects.requireNonNullElse(firstName, "");
    }

    public void setLastName(String lastName) {
        this.lastName = java.util.Objects.requireNonNullElse(lastName, "");
    }

    public String getFullName() {
        String fullName = java.util.stream.Stream.of(firstName, lastName)
                                                 .filter(string -> !string.isEmpty())
                                                 .collect(java.util.stream.Collectors.joining(" "));
        return fullName.isEmpty() ? "Unknown" : fullName;
    }
}