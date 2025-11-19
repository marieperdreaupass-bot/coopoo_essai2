import java.util.ArrayList;

public class quete {
    protected String question;
    protected String[] choix;
    protected int bonneReponse;
    protected String recompense;

    public quete(String question, String[] choix, int bonneReponse, String recompense) {
        ArrayList<quete> quetes = new ArrayList<>();
        quetes.add(new quete("2+2=?", new String[]{"1", "2", "4"},3, "+50PV, +50 degats"));

    }
}

