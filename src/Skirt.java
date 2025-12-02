public class Skirt extends Clothes implements WomenClothing {
    private String style;

    public Skirt(Sizes size, double cost, String color, String style) {
        super(size, cost, color);
        this.style = style;
    }

    @Override
    public void dressWoman() {
        System.out.println("Женщина надевает юбку: " + getInfo());
    }

    @Override
    public String getInfo() {
        return String.format("Юбка [Размер: %s, Цвет: %s, Стиль: %s, Цена: %.2f руб.]",
                size, color, style, cost);
    }

    public String getStyle() { return style; }
}