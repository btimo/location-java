package location.models;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.sql.Timestamp;

/**
 * Classe de base dont héritent tous les modèles
 * Indispensable pour JPA
 * @author Timothée Barbot
 */
@MappedSuperclass
public abstract class BaseModel extends Model {

    @Id
    @GeneratedValue
    Long id;

    @Version
    Long version;

    @CreatedTimestamp
    Timestamp whenCreated;

    @UpdatedTimestamp
    Timestamp whenUpdated;

    Boolean isActive;

    /**
     * Getter de ID
     * @return ID unique
     */
    public synchronized Long getId() {
        return id;
    }

    /**
     * Setter de UD
     * @param id id unique
     */
    public synchronized void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter de version
     * @return numéro de version
     */
    public synchronized Long getVersion() {
        return version;
    }

    /**
     * Setter de version
     * @param version numéro de version
     */
    public synchronized void setVersion(Long version) {
        this.version = version;
    }

    /**
     * Getter du timestamp de création de l'objet
     * @return timestamp de création de l'objet
     */
    public synchronized Timestamp getWhenCreated() {
        return whenCreated;
    }

    /**
     * Setter du timestamp de création de l'objet
     * @param whenCreated timestamp de création de l'objet
     */
    public synchronized void setWhenCreated(Timestamp whenCreated) {
        this.whenCreated = whenCreated;
    }

    /**
     * Getter du timestamp de mise à jour de l'objet
     * @return timestamp de la mise à jour de l'objet
     */
    public synchronized Timestamp getWhenUpdated() {
        return whenUpdated;
    }

    /**
     * Setter de timestamp de mise à jour de l'objet
     * @param whenUpdated timestamp de la mise à jour de l'objet
     */
    public synchronized void setWhenUpdated(Timestamp whenUpdated) {
        this.whenUpdated = whenUpdated;
    }

    /**
     * Getter de l'activité de l'objet
     * @return booléen : objet actif?
     */
    public synchronized Boolean getActive() {
        return isActive;
    }

    /**
     * Setter de l'activité de l'objet
     * @param active booléen : objet actif?
     */
    public synchronized void setActive(Boolean active) {
        isActive = active;
    }
}