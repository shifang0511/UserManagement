package org.shifang.usermanage.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private int gender;
    private String image;
    private int job;
    private String entrydate;
    private int dept_id;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
}
