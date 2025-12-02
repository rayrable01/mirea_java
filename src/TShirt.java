public class TShirt extends Clothes implements MenClothing, WomenClothing {
    public TShirt(Sizes size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужчина надевает футболку: " + getInfo());
    }

    @Override
    public void dressWoman() {
        System.out.println("Женщина надевает футболку: " + getInfo());
    }

    @Override
    public String getInfo() {
        return String.format("Футболка [Размер: %s, Цвет: %s, Цена: %.2f руб.]",
                size, color, cost);
    }
}