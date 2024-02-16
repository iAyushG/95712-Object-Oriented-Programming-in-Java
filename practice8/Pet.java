package practice8;

public abstract class Pet {
	static int petCount = 0;
	
	public abstract String talk();
	
//	public static int getPetCount() {
//		return petCount;
//	}
}

class Cat extends Pet {
	static int catCount = 0;

	@Override
	public String talk() {
		catCount++;
		petCount++;
		return "Meow...";
	}
	
	public int getCatCount() {
		return catCount;
	}
}

class Dog extends Pet {
    static int dogCount = 0;

    @Override
    public String talk() {
        dogCount++;
        petCount++;
        return "Bark...";
    }

    public int getDogCount() {
        return dogCount;
    }
}

class Bird extends Pet {
    static int birdCount = 0;

    @Override
    public String talk() {
        birdCount++;
        petCount++;
        return "Tweet...";
    }

    public int getBirdCount() {
        return birdCount;
    }
}