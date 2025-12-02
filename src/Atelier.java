public class Atelier {
    public void displayWomenClothing(Clothes[] clothes) {
        System.out.println("=== ИНФОРМАЦИЯ О ЖЕНСКОЙ ОДЕЖДЕ ===");
        for (Clothes item : clothes) {
            if (item instanceof WomenClothing) {
                System.out.println(item.getInfo());
            }
        }
    }

    public void displayMenClothing(Clothes[] clothes) {
        System.out.println("=== ИНФОРМАЦИЯ О МУЖСКОЙ ОДЕЖДЕ ===");
        for (Clothes item : clothes) {
            if (item instanceof MenClothing) {
                System.out.println(item.getInfo());
            }
        }
    }
}
