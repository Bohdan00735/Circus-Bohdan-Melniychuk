import java.util.ArrayList;

public class Circus {
    private ArrayList<Artist> artists = new ArrayList<Artist>();
    private String place;
    int control = 0;

    public Circus( String place) {
        this.place = place;
    }

    public Artist takeArtistInMas() {
        for (int i = 0; i < artists.size(); i++) {
            Artist artist = artists.get(i);
            return artist;
        }
        return null;
    }


    public void seeAllArtists() {
        Artist artist = takeArtistInMas();
        artist.showArtist();
    }


    public void dismissTheDrinkerAcrobat() {
        int ArtistControl = 0;
        int alcoholControl = 0;

        for (int i = 0; i < artists.size(); i++) {
            Artist artist = artists.get(i);
            if (artist.degreeOfAlcohol >= alcoholControl) {
                ArtistControl = i;
            }
        }
        Artist artist = artists.get(ArtistControl);
        System.out.println(artist + "was dismiss");
        artist = null;


        for (int i = ArtistControl + 1; i <artists.size() ; i++) {
            Artist artist1 = artists.get(i);
            Artist artist2 = artists.get(i - 1);
            artist2 = artist1;
        }
        control -=1;
    }


    public void doShow( String skill) {
        for (int i = 0; i < artists.size() ; i++) {
            Artist artist = artists.get(i);
            if (artist.takeSkillFunambulist().equals(skill) ){
                artist.doShow();
            }else if(artist.equals(skill)){
                artist.doShow();
            }
        }
    }

    public void doShowOnId(int sequenceNumber) {
        Artist artist = artists.get(sequenceNumber - 1);
        artist.doShow();
    }


    public int FindOutHowMuchTimeEachEployeeHasPerformed(int sequenceNumber) {
        Artist artist = artists.get(sequenceNumber - 1);
        return artist.projections;
    }


    public void addArtist(String name, String skill, double money, int manyForOneShow) {
        Funambulist funambulist = new Funambulist(manyForOneShow, name, money);
        OtherArtist otherArtist = new OtherArtist(manyForOneShow, money, name, skill);

        if (funambulist.skill.equals(skill)) {
            artists.add(control,funambulist);
            control++;

        } else {
            artists.add(control,otherArtist);
            control++;
        }
    }


    public void goToOtherPlace(String place) {
        this.place = place;
    }

    abstract class Artist {
        protected int projections = 0;
        protected int manyForOneShow;
        protected int salary = 0;
        protected int degreeOfAlcohol = 0;
        String skill;

        public Artist(int manyForOneShow) {
            this.manyForOneShow = manyForOneShow;
        }

        protected abstract void doShow();


        public abstract void takeSalary();

        public int makeYourSalary() {
            return salary = projections * manyForOneShow;
        }

        public void makeGoodOrBadShow(String skill) {
            int random;
            random = (int) (Math.random() * 0) + 1;

            if (random == 0) {
                System.out.println(skill + " make bad show");
                degreeOfAlcohol++;

            } else {
                System.out.println(skill + " make a big show");
                projections++;
            }
        }

        public String takeSkillFunambulist(){
            Funambulist f = new Funambulist(manyForOneShow, " ", 0);
            return f.skill;
        }



        protected void makePremium() {
            int increase = 100;
            int alcogolControl = 5;
            int premium = 0;

            if (projections >= increase) {
                premium = (salary / 100) * 10;
                salary += premium;

            } else if (degreeOfAlcohol >= alcogolControl) {
                salary -= (premium * 2);
                alcogolControl = 0;
            }
        }

        @Override
        public boolean equals(Object obj) {
            return true;
        }

        public abstract void showArtist();

        public String toString() {
            return " ";
        }
    }


    public class Funambulist extends Artist {
        public String skill = "Funambulist";
        private String name;
        private double money;

        public Funambulist(int manyForOneShow, String name, double money) {
            super(manyForOneShow);
            this.name = name;
            this.money = money;
        }


        @Override
        public void showArtist() {
            String funambulist = toString();
            System.out.println(funambulist);
        }

        @Override
        protected void doShow() {
            makeGoodOrBadShow(skill);
        }

        @Override
        public void makePremium() {
            int increase = 100;
            int alcogolControl = 5;
            int premium = 0;

            if (projections >= increase) {
                premium = (salary / 100) * 10;
                salary += premium;

            } else if (degreeOfAlcohol >= alcogolControl) {
                salary -= (premium * 2);
                alcogolControl = 0;
            }
            salary += (salary / 100) * 10;
        }

        @Override
        public void takeSalary() {
            makeYourSalary();
            makePremium();
            money += salary;
            salary = 0;
        }

        @Override
        public String toString() {
            return skill + "{" +
                    "name='" + name + '\'' +
                    ", skill='" + skill + '\'' +
                    "degreeOfAlcohol=" + degreeOfAlcohol +
                    ", manyForOneShow=" + manyForOneShow +
                    ", projections=" + projections +
                    '}';
        }

        public Boolean compareSkills(String skill) {
            if (this.skill.equals(skill)) {
                return true;
            }
            return false;
        }
    }


    public class OtherArtist extends Artist {
        private String name;
        private double money;

        public OtherArtist(int manyForOneShow, double money, String name, String skill) {
            super(manyForOneShow);
            this.money = money;
            this.name = name;
            this.skill = skill;
        }

        @Override
        protected void doShow() {
            makeGoodOrBadShow(skill);
        }

        @Override
        public void takeSalary() {
            makeYourSalary();
            makePremium();
            money += salary;
            salary = 0;
        }

        @Override
        public void showArtist() {
            String other = toString();
            System.out.println(other);
        }

        @Override
        public boolean equals(Object obj) {
            if (skill.equals(obj)){
                return true;
            }return false;
        }

        @Override
        public String toString() {
            return skill + "{" +
                    "name='" + name + '\'' +
                    ", skill='" + skill + '\'' +
                    "degreeOfAlcohol=" + degreeOfAlcohol +
                    ", manyForOneShow=" + manyForOneShow +
                    ", projections=" + projections +
                    '}';
        }
    }
}
