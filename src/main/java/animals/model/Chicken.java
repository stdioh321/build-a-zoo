package animals.model;

public class Chicken extends Bird {
    private boolean broiler;

    public Chicken(String name, String favoriteFood, boolean broiler, Float wingLength) {
        super(name, favoriteFood, wingLength);
        this.broiler = broiler;
    }

    public boolean isBroiler() {
        return broiler;
    }

    public void setBroiler(boolean broiler) {
        this.broiler = broiler;
    }


    @Override
    public String toString() {
        return "Chicken{" + "Name='" + this.getName() + '\'' + ", Favorite Food='"
                + this.getFavoriteFood() + '\'' + ", Broiler='" + broiler + '\'' + ", Wing Length='"
                + this.getWingLength() + '\'' + '}';
    }
}
