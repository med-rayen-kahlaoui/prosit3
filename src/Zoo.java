public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    // Instruction 14 : Constante pour la capacité maximale de cages (25)
    public static final int NUMBER_OF_CAGES = 25;
    private int animalCount; // Compteur d'animaux actuellement dans le zoo

    public Zoo() {
        this.animals = new Animal[NUMBER_OF_CAGES];
        this.animalCount = 0;
    }

    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        this.animals = new Animal[NUMBER_OF_CAGES];
        this.animalCount = 0;
    }

    // Getters et Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Le nom du zoo ne peut pas être vide.");
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    // Instruction 15 : Méthode isZooFull
    public boolean isZooFull() {
        return animalCount >= NUMBER_OF_CAGES;
    }

    // Instruction 11 : Recherche d'un animal par son nom
    public int searchAnimal(Animal animal) {
        if (animal == null) return -1;

        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equalsIgnoreCase(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    // Instruction 10 & 12 : Ajout d'un animal avec gestion des doublons et capacité max
    public boolean addAnimal(Animal animal) {
        if (animal == null) {
            return false;
        }

        // Instruction 15 / 12 : Vérification de la capacité max
        if (isZooFull()) {
            System.out.println("Impossible d'ajouter " + animal.getName() + " : Le zoo est plein !");
            return false;
        }

        // Instruction 12 : Unicité de l'animal
        if (searchAnimal(animal) != -1) {
            System.out.println("Impossible d'ajouter " + animal.getName() + " : L'animal existe déjà !");
            return false;
        }

        animals[animalCount] = animal;
        animalCount++;
        return true;
    }

    // Instruction 11 : Affichage des animaux du zoo
    public void displayAnimals() {
        System.out.println("=== Animaux dans le zoo " + name + " ===");
        if (animalCount == 0) {
            System.out.println("Aucun animal présent dans le zoo.");
            return;
        }
        for (int i = 0; i < animalCount; i++) {
            System.out.println("[" + i + "] " + animals[i]);
        }
    }

    // Instruction 13 : Suppression d'un animal et réorganisation du tableau
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            System.out.println("L'animal " + animal.getName() + " n'a pas été trouvé.");
            return false;
        }

        // Décalage des éléments vers la gauche pour combler le vide
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }

    // Instruction 15 : Comparer deux objets Zoo et retourner celui avec le plus d'animaux
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1 == null) return z2;
        if (z2 == null) return z1;

        if (z1.animalCount >= z2.animalCount) {
            return z1;
        } else {
            return z2;
        }
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", nbrCages=" + NUMBER_OF_CAGES +
                ", nombreAnimaux=" + animalCount +
                '}';
    }
}