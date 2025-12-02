public enum Sizes {
    XXS(32) {
        @Override
        public String getDescription() {
            return "Это детский размер";
        }
    },
    XS(34) {
        @Override
        public String getDescription() {
            return "Это XS размер";
        }
    },
    S(36) {
        @Override
        public String getDescription() {
            return "Это средний S размер";
        }
    },
    M(38) {
        @Override
        public String getDescription() {
            return "Это M размер";
        }
    },
    L(40) {
        @Override
        public String getDescription() {
            return "Это взрослый размер";
        }
    };

    private final int euroSize;  // Добавляем поле для хранения размера

    Sizes(int euroSize) {
        this.euroSize = euroSize;  // Сохраняем переданный размер
    }

    public abstract String getDescription();
}