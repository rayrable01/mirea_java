public class Main {
    public static void main(String[] args) {
        System.out.println("Начало выполнения заданий...");
        Person person = new Person();
        person.iLove(Seasons.AUTUMN);

        for (Seasons season : Seasons.values()) {
            System.out.println(season.getSeasonInfo());
        }
    }
}