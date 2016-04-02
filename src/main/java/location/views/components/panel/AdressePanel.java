package location.views.components.panel;

import location.views.components.misc.CustomFontLabel;

import javax.swing.*;
import java.awt.*;

/**
 * Gestion du panneau d'adresse
 * @author Timothée Barbot
 * @author Stéphane Gâteau
 */
public class AdressePanel extends FlowPanel {

    private CustomFontLabel adresseLabel;

    private JTextField numeroTexte;
    private JTextField rueTexte;
    private JTextField codeTexte;
    private JTextField villeTexte;

    /**
     * Constructeur par défaut
     */
    public AdressePanel(){
        super();
        initAdressePanel();
    }

    /**
     * Constructeur avec couleur
     * @param bgColor couleur du panneau
     */
    public AdressePanel(Color bgColor){
        super(bgColor);
        initAdressePanel();
    }

    /**
     * Initialisation de la fenêtre
     */
    private void initAdressePanel(){
        adresseLabel = new CustomFontLabel("Adresse :");
        numeroTexte = new JTextField("5",3);
        rueTexte = new JTextField("rue",13);
        codeTexte = new JTextField("CP",5);
        villeTexte = new JTextField("ville",5);

        add(adresseLabel);
        add(numeroTexte);
        add(rueTexte);
        add(codeTexte);
        add(villeTexte);
    }

    /**
     * Récupération du numéro
     * @return numéro
     */
    public JTextField getNumeroTexte() {
        return numeroTexte;
    }

    /**
     * Modification du numéro
     * @param numeroTexte numéro
     */
    public void setNumeroTexte(JTextField numeroTexte) {
        this.numeroTexte = numeroTexte;
    }

    /**
     * Récupération de la rue
     * @return rue
     */
    public JTextField getRueTexte() {
        return rueTexte;
    }

    /**
     * Modification du numéro de rue
     * @param rueTexte rue
     */
    public void setRueTexte(JTextField rueTexte) {
        this.rueTexte = rueTexte;
    }

    /**
     * Récupération du code postal
     * @return code postal
     */
    public JTextField getCodeTexte() {
        return codeTexte;
    }

    /**
     * Modification du code postal
     * @param codeTexte code postal
     */
    public void setCodeTexte(JTextField codeTexte) {
        this.codeTexte = codeTexte;
    }

    /**
     * Récupération de la ville
     * @return ville
     */
    public JTextField getVilleTexte() {
        return villeTexte;
    }

    /**
     * Modification de la ville
     * @param villeTexte ville
     */
    public void setVilleTexte(JTextField villeTexte) {
        this.villeTexte = villeTexte;
    }
}
