public class Main {
    public static void main(String[] args) {
        // 4) Создаем массив, содержащий все типы одежды
        Clothes[] wardrobe = {
                new TShirt(Sizes.M, 1500.0, "Белый"),
                new TShirt(Sizes.S, 1200.0, "Черный"),
                new Pants(Sizes.L, 3000.0, "Синий"),
                new Pants(Sizes.M, 2500.0, "Черный"),
                new Skirt(Sizes.S, 2000.0, "Красный", "Карандаш"),
                new Skirt(Sizes.XS, 1800.0, "Розовый", "Солнце"),
        };

        // Создаем ателье
        Atelier atelier = new Atelier();

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Альтернативный вывод - только информация
        atelier.displayWomenClothing(wardrobe);
        System.out.println();
        atelier.displayMenClothing(wardrobe);
    }
}