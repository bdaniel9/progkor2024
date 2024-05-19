package hu.nye.progkor.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "TEAMS")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    /**
     * A csapat azonosítója.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TEAM_ID")
    private int teamID;
    /**
     * A csapat neve.
     */
    @Column(name = "TEAM_NAME")
    @JsonProperty("TEAM_NAME")
    private String teamName;
    /**
     * A csapat fő játékosa.
     */
    @Column(name = "MAIN_PLAYER")
    private String mainPlayer;

    /**
     * A csapat edzője.
     */
    @Column(name = "COACH")
    private String coach;

    /**
     * A stadion neve.
     */
    @Column(name = "STADIUM_NAME")
    private String stadiumName;

    /**
     * A stadion befogadóképessége.
     */
    @Column(name = "STADIUM_CAPACITY")
    private int stadiumCapacity;


}
