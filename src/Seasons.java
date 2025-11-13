public enum Seasons {
    AUTUMN("Осень", 10) {
        @Override
        public String getDescription() {
            return "Холодное время года";
        }
    },
    SUMMER("Лето", 25) {
        @Override
        public String getDescription() {
            return "Теплое время года";
        }
    },
    WINTER("Зима", -5) {
        @Override
        public String getDescription() {
            return "Холодное время года";
        }
    },
    SPRING("Весна", 15) {
        @Override
        public String getDescription() {
            return "Холодное время года";
        }
    };

    private final String russianName;
    private final int averageTemperature;

    private Seasons(String russianName, int averageTemperature) {
        this.russianName = russianName;
        this.averageTemperature = averageTemperature;
    }

    public String getRussianName() {
        return russianName;
    }

    public int getAverageTemperature() {
        return averageTemperature;
    }

    // Абстрактный метод - каждый элемент enum должен его реализовать
    public abstract String getDescription();

    // Метод для получения информации в одну строку
    public String getSeasonInfo() {
        return String.format("%-8s | Температура: %3d°C | %s",
                getRussianName(), getAverageTemperature(), getDescription());
    }
}