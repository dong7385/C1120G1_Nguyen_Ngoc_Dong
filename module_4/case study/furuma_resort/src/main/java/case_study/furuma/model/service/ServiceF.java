package case_study.furuma.model.service;

import case_study.furuma.model.contract.Contract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "service")
public class ServiceF {
    @Id
    @Column(name = "service_id", length = 45,nullable = false)
    private String serviceId;
    @Column(name = "service_name", length = 45)
    private String serviceName;
    @Column(name = "service_area")
    private Integer serviceArea;
    @Column(name = "service_cost")
    private double serviceCost;
    @Column(name = "service_max_people")
    private Integer serviceMaxPeople;
    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rent_type_id")
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;
    @Column(name = "standard_room", length = 45)
    private String standardRoom;
    @Column(name = "description_other_convenience", length = 45)
    private String descriptionOtherConvenience;
    @Column(name = "pool_area")
    private double poolArea;
    @Column(name = "number_of_floors")
    private Integer numberOfFloors;

    @OneToMany(mappedBy = "serviceF")
    private List<Contract> contractList;
}