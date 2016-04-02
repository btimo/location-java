package location.views.components.panel;

import javax.swing.*;
import java.awt.*;

/**
 * Panneau d'identification
 * @author Timothée Barbot
 * @author Stéphane Gâteau
 */
public class IdentificationPanel extends FlowPanel{

    private JLabel nomLabel;
    private JTextField nomTexte;
    private JTextField prenomTexte;

    /**
     * Constructeur par défaut
     */
    public IdentificationPanel() {
        super();
        initIdentificationPanel();
    }

    /**
     * Constructeur complet
     * @param bgColor couleur de fond
     */
    public IdentificationPanel(Color bgColor){
        super(bgColor);
        initIdentificationPanel();
    }

    /**
     * Création de la fenêtre
     */
    private void initIdentificationPanel(){
        nomLabel = new JLabel("Nom et prénom : ");
        nomTexte = new JTextField(" Nom", 10);
        prenomTexte = new JTextField(" Prénom", 10);

        add(nomLabel);
        add(nomTexte);
        add(prenomTexte);
    }

    /**
     * Récupération du nom
     * @return nom
     */
    public JTextField getNomTexte() {
        return nomTexte;
    }

    /**
     * Modification du nom
     * @param nomTexte nom
     */
    public void setNomTexte(JTextField nomTexte) {
        this.nomTexte = nomTexte;
    }

    /**
     * Récupération du prénom
     * @return prénom
     */
    public JTextField getPrenomTexte() {
        return prenomTexte;
    }

    /**
     * Modification d'un prénom
     * @param prenomTexte prénom
     */
    public void setPrenomTexte(JTextField prenomTexte) {
        this.prenomTexte = prenomTexte;
    }
}
