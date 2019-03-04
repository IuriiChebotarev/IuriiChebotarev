package hw7.enums;

public enum Radiobuttons {

        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8);

        public int number;

        Radiobuttons(int num) {

                this.number = num;
        }

        @Override
        public String toString() {

                return String.valueOf(number);
        }

        public static Radiobuttons getIndex(int number) {
                for (Radiobuttons element : Radiobuttons.values()) {
                        if (number == element.number) {
                                return element;
                        }
                }
                return null;
        }
}