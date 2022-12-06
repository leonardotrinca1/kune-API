package br.com.si.CrudApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "event")
@AllArgsConstructor
@NoArgsConstructor
public class EventModelV1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private long id;

    @Column(name = "event_name", nullable = false, length = 50)
    @Setter @Getter
    private String eventName;

    @Column(nullable = false, length = 75)
    @Setter @Getter
    private String address;

    @Column(nullable = false, length = 100)
    @Setter @Getter
    private String description;


}
