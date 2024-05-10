public class Example {
    public static void main(String[] args) {
// чтобы заменить лампочку, достаточно вызвать new SuperLamp(),
// остальной код не изменится
        Lamp horizonLamp = new SuperLamp();
        Fridge fridge = new Fridge(horizonLamp);
        fridge.openDoor();
    }
}