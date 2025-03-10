package trivia;

enum Categories {
    POP("Pop"),
    SCIENCE("Science"),
    SPORT("Sports"),
    ROCK("Rock"),
    GEOGRAPHIE("Géographie ")
    ;

    private final String stringValue;

    Categories(final String categorie) {
        stringValue = categorie;
    }

    public String toString() {
        return stringValue;
    }
}