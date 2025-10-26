package model.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CustomerDTO {
    private String CustId;
    private String title;
    private String name;
    private String dob;
    private double salaray;
    private String address;
    private String city;
    private String province;
    private String postalCode;
}
