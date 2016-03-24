package util;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import models.*;


public class GenerationPdf {
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 14,
            Font.NORMAL, BaseColor.RED);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    private String type;
    private Emprunteur emprunteur;
    private ArrayList<Location> locations;
    private int locationId;

    public GenerationPdf(String type, Emprunteur emprunteur, int locationId) {
        this.type = type.substring(0, 1).toUpperCase() + type.substring(1);
        this.emprunteur = emprunteur;
        this.locations = emprunteur.getLocations();
        this.locationId = locationId;

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("pdf/"+type+"/"+ emprunteur.getId()+".pdf"));
            document.open();
            addMetaData(document);
            addContent(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addMetaData(Document document) {
        document.addTitle("Facture #"+locationId);
        document.addSubject("Facture #"+locationId);
        document.addKeywords("facture, location, projet java, efrei");
        document.addAuthor("Adrien Poupa, Stéphane Gateau, Timothée Barbot");
        document.addCreator("Adrien Poupa, Stéphane Gateau, Timothée Barbot");
    }

    private void addContent(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
        Paragraph titre = new Paragraph("LocAppli", catFont);
        titre.setAlignment(Element.ALIGN_CENTER);
        preface.add(titre);
        Paragraph titre2 = new Paragraph(type+" #"+locationId, catFont);
        titre2.setAlignment(Element.ALIGN_CENTER);
        preface.add(titre2);

        addEmptyLine(preface, 2);

        Date time = new Date();
        DateFormat dfl = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);

        preface.add(new Paragraph("Document généré le " + dfl.format(time),
                smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(type+" pour "+emprunteur.getPrenom()+" "+emprunteur.getNom(),
                smallBold));

        addEmptyLine(preface, 2);

        PdfPTable table = new PdfPTable(3);

        PdfPCell c1 = new PdfPCell(new Phrase("Prestation"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Période"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Montant TTC"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        table.setHeaderRows(1);
        table.setWidthPercentage(100);

        String nomVehicule;

        for (Location location : locations) {
            for (LocationExemplaire locationExemplaire : location.getLocationExemplaires()) {

                if (locationExemplaire.getExemplaire().getVehicule() instanceof Auto) {
                    nomVehicule = locationExemplaire.getExemplaire().getVehicule().getMarque() + " " + ((Auto) locationExemplaire.getExemplaire().getVehicule()).getModele();
                } else { // Moto
                    nomVehicule = locationExemplaire.getExemplaire().getVehicule().getMarque() + " " + ((Moto) locationExemplaire.getExemplaire().getVehicule()).getCylindree();
                }

                String periode = location.getDebut().toString() + " - " + location.getFin().toString();

                table.addCell("Véhicule loué : " + nomVehicule);
                table.addCell(periode);
                PdfPCell prix = new PdfPCell(new Phrase(locationExemplaire.getExemplaire().getPrixFinalHorsAssurance() + "€"));
                prix.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(prix);

                if (locationExemplaire.isAssurance()) {
                    table.addCell("Assurance");
                    table.addCell(periode);
                    prix = new PdfPCell(new Phrase(locationExemplaire.getExemplaire().getVehicule().getPrixAssurance() + "€"));
                    prix.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //prix.setMinimumHeight(150);
                    table.addCell(prix);
                }

                if (type.equals("Facture")) {
                    if (locationExemplaire.getExemplaire().getReservoir().equals("Vide")) {
                        table.addCell("Plein d'essence");
                        table.addCell(location.getFin().toString());
                        prix = new PdfPCell(new Phrase(Exemplaire.penaliteReservoir + "€"));
                        prix.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(prix);
                    }


                    if (locationExemplaire.getExemplaire().isEndommage()) {
                        table.addCell("Réparation");
                        table.addCell(location.getFin().toString());
                        if (locationExemplaire.isAssurance()) {
                            prix = new PdfPCell(new Phrase("0€ (assurance)"));
                        } else {
                            prix = new PdfPCell(new Phrase(Exemplaire.penaliteEndommage + "€"));
                        }
                        prix.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(prix);
                    }
                }

                preface.add(table);

                addEmptyLine(preface, 1);

                Paragraph total;

                if (type.equals("Facture")) {
                    total = new Paragraph("Total à régler : " + locationExemplaire.getPrixFinalRetour() + "€",
                            redFont);
                } else {
                    total = new Paragraph("Total devis : " + locationExemplaire.getExemplaire().getPrixFinalHorsAssurance() + "€",
                            redFont);
                }

                total.setAlignment(Element.ALIGN_RIGHT);
                preface.add(total);

                if (type.equals("Devis")) {
                    Paragraph avert = new Paragraph("Attention : le devis ne contient d'éventuels frais de réparation et de plein " +
                            "qui peuvent s'appliquer", smallBold);
                    avert.setAlignment(Element.ALIGN_RIGHT);
                    preface.add(avert);
                }
            }
        }

        addEmptyLine(preface, 8);

        preface.add(new Paragraph("(C) 2016 LocAppli",
                smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Stéphane Gâteau, Adrien Poupa, Timothée Barbot",
                smallBold));

        document.add(preface);
        // Start a new page
        document.newPage();
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}