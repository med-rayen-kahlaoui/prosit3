public class ZooManagement {
    public static void main(String[] args) {
        // Création de zoos
        Zoo myZoo = new Zoo("Friguia Park", "Bouficha");
        Zoo secondZoo = new Zoo("Belvédère", "Tunis");

        // Création d'animaux
        Animal lion = new Animal("Félins", "Simba", 5, true);
        Animal elephant = new Animal("Éléphantidés", "Dumbo", 10, true);
        Animal tiger = new Animal("Félins", "Shere Khan", 7, true);
        Animal duplicateLion = new Animal("Félins", "Simba", 5, true);

        System.out.println("--- Instruction 10 & 12 : Ajout des animaux ---");
        myZoo.addAnimal(lion);
        myZoo.addAnimal(elephant);
        myZoo.addAnimal(tiger);

        // Test d'unicité (Instruction 12)
        myZoo.addAnimal(duplicateLion);

        System.out.println("\n--- Instruction 11 : Affichage et Recherche ---");
        myZoo.displayAnimals();

        int index = myZoo.searchAnimal(elephant);
        System.out.println("Indice de Dumbo dans le zoo : " + index);

        Animal unknownAnimal = new Animal("Oiseaux", "Chouette", 2, false);
        System.out.println("Indice d'un animal inexistant : " + myZoo.searchAnimal(unknownAnimal));

        System.out.println("\n--- Instruction 13 : Suppression d'un animal ---");
        System.out.println("Suppression de Dumbo : " + myZoo.removeAnimal(elephant));
        myZoo.displayAnimals();

        System.out.println("\n--- Instruction 15 : Test de plein et comparaison ---");
        secondZoo.addAnimal(new Animal("Oiseaux", "Picoti", 1, false));

        System.out.println("Est-ce que " + myZoo.getName() + " est plein ? " + myZoo.isZooFull());

        Zoo maxZoo = Zoo.comparerZoo(myZoo, secondZoo);
        System.out.println("Le zoo contenant le plus d'animaux est : " + maxZoo.getName());
    }
}