class NameTag {
    private final String firstName;
    private final String lastName;

    NameTag(String fullName) {
        String[] names = fullName.split(" ");
        firstName = names[0];
        lastName = names[1];
    }

    String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");

        System.out.println(tag.getNickname());
    }
}