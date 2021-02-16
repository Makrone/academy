package by.academy.deal;

public class Bread extends Product {
    private String color;
    private int weight;

    public Bread() {
        super();
    }
    public Bread(String name, String manufacture, Double price, Integer quantity, String color, int weight) {
        super(name, price, manufacture, quantity);
        this.color = color;
        this.weight = weight;
    }

    @Override
    public double discount() {
        if (getQuantity() > 3) {
            return 0.9;
        } else {
            return 1;
        }
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Хлеб{");
        sb.append("наименование - ").append(getName());
        sb.append(", цена - ").append(getPrice()).append("руб");
        sb.append(", количество - ").append(getQuantity()).append(" шт.");
        sb.append(", цвет - ").append(color);
        sb.append(", вес - ").append(weight).append(" гр.");
        sb.append('}');
        return sb.toString();
    }
}

