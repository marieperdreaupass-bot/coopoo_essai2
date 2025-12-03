import java.util.ArrayList;
import java.util.*;

public class quete<nbQuete> {

private ArrayList<String> description;
private ArrayList<String> bonnneReponse;

public quete(){

    description = new ArrayList<>();
        description.add("question 1 : Qui est le dieu grec du ciel et le roi des dieux de l'Olympe ?");
        description.add(" question 2 : Comment s'appelle la déesse de l'amour et de la beauté, née de l'écume de la mer ?");
        description.add(" question 3 : Quel est le nom du royaume souterrain des morts, dirigé par le frère de Zeus ?");
        description.add(" question 4 : Quel héros célèbre a vaincu la Méduse, la Gorgone aux cheveux de serpents ?");
    description.add("question 5 : Quel animal sacré est associé à Athéna, déesse de la sagesse ?");

    description.add("question 6 : Quel fleuve traverse les Enfers et dont l'eau rend les âmes oublieuses ?");
    description.add("question 7 : Qui est le dieu de la mer, souvent représenté avec un trident ?");
    description.add("question 8 : Quel est le nom du taureau mi-homme mi-taureau enfermé dans le Labyrinthe ?");
    description.add("question 9 : Quel est le nom du cheval ailé né du sang de Méduse ?");
    description.add("question 10 : Qui est le messager des dieux, reconnaissable à ses sandales ailées ?");

    description.add("question 11 : Qui est le dieu grec du feu, de la forge et des volcans ?");
    description.add("question 12 : Qui a été puni par Zeus en étant condamné à porter le ciel sur ses épaules ?");
    description.add("question 13 : Quel est le nom du monstre à trois têtes qui garde l'entrée des Enfers ?");
    description.add("question 14 : Qui est la déesse grecque de la chasse, souvent représentée avec un arc et des flèches ?");
    description.add("question 15 : Quel héros a réussi les douze travaux, dont celui de tuer l'Hydre de Lerne ?");

    description.add("question 16 : Comment s'appelle la boîte que Pandore a ouverte par curiosité, libérant les maux de l'humanité ?");
    description.add("question 17 : Quel est le nom de la déesse associée à la lune, souvent jumelle d'Apollon ?");
    description.add("question 18 : Quel est le lien de parenté entre Zeus et le Titan Cronos ?");
    description.add("question 19 : Qui est le dieu grec du vin, de la fête et de la folie religieuse ?");
    description.add("question 20 : Quel roi a eu le don de changer en or tout ce qu'il touchait ?");

    description.add("question 21 : Qui est l'incarnation de la Terre Mère, la première entité à émerger du Chaos");
    description.add("question 22 : Quel est le nom du Titan qui a dévoré ses propres enfants de peur qu'ils ne le renversent ?");
    description.add("question 23 : Quel titan, frère de Cronos, a été puni pour avoir donné le feu aux humains ?");
    description.add("question 24 : Qu'est-ce que l'Olympe pour les dieux grecs ?");
    description.add("question 25 : Quel est le nom de la déesse de la victoire, souvent représentée avec des ailes ?");





    bonnneReponse = new ArrayList<>();
    bonnneReponse.add("Zeus");
    bonnneReponse.add("Aphrodite");
    bonnneReponse.add("Hadès");
    bonnneReponse.add("Persée");
    bonnneReponse.add("Chouette");

    bonnneReponse.add("Léthé");
    bonnneReponse.add("Poséidon");
    bonnneReponse.add("Minotaure");
    bonnneReponse.add("Pégase");
    bonnneReponse.add("Hermès");

    bonnneReponse.add("Héphaïstos");
    bonnneReponse.add("Atlas");
    bonnneReponse.add("Cerbère");
    bonnneReponse.add("Artémis");
    bonnneReponse.add("Héraclès");

    bonnneReponse.add("boîte de pandore");
    bonnneReponse.add("Séléné");
    bonnneReponse.add("Héphaïstos");
    bonnneReponse.add("Dionysos");
    bonnneReponse.add("Midas");

    bonnneReponse.add("Gaïa");
    bonnneReponse.add("Cronos");
    bonnneReponse.add("Prométhée");
    bonnneReponse.add("Montagne");
    bonnneReponse.add("Niké");



}

    public int nbQuete ;
    public String getDescription() {
        return description.get( nbQuete);}

    public String getBonnneReponse() {
        return bonnneReponse.get(nbQuete);
    }}


