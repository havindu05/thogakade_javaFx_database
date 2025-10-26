package model.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class EmployeeDTO {
    private String employeeId;
    private String name;
    private String nic;
    private String dob;
    private String position;
    private String salary;
    private String contactNumber;
    private String address;
    private String joinDate;
    private String status;
}
