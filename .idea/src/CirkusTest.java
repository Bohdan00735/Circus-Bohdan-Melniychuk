
public class CirkusTest {

    public static void main(String[] args) {
        int moneyForOneShow = 700;
        Circus circus = new Circus("Kiev");
        circus.addArtist("Yarik", "Funambulist", 0, moneyForOneShow);
        circus.addArtist("Vlad", "Jongler", 0, moneyForOneShow);
        circus.doShowOnId(1);
        circus.doShow("Jongler");
        circus.dismissTheDrinkerAcrobat();
        int performed = circus.FindOutHowMuchTimeEachEployeeHasPerformed(1);
        System.out.println(performed);
        circus.goToOtherPlace("Lviv");

    }

}
