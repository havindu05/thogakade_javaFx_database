package model.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserInfoDTO {
    private int userId;
    private String userame;
    private String email;
    private String password;
}
