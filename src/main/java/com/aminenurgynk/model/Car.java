package com.aminenurgynk.model;

import com.aminenurgynk.model.enums.EStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "CARS")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;
    @Builder.Default
    private LocalDateTime time_rent = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.AVAILABLE;

/*    @ToString.Exclude
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rent> rentList;*/

}
