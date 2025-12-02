public class Pants extends Clothes implements MenClothing, WomenClothing {
    public Pants(Sizes size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужчина надевает штаны: " + getInfo());
    }

    @Override
    public void dressWoman() {
        System.out.println("Женщина надевает штаны: " + getInfo());
    }

    @Override
    public String getInfo() {
        return String.format("Штаны [Размер: %s, Цвет: %s, Цена: %.2f руб.]",
                size, color, cost);
    }
}