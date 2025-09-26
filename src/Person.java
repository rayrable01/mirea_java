public class Person {
    private Seasons favoriteSeason = Seasons.SPRING;

    public void iLove(Seasons season) {
        switch (season) {
            case AUTUMN -> System.out.println("Я не люблю осень");
            case SPRING -> System.out.println("Я чутка люблю весну");
            case SUMMER -> System.out.println("Я очень люблю лето");
            case WINTER -> System.out.println("Я не люблю зиму");
        };
    }
}
