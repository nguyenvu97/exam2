package org.springframework.boot.exam2.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufac_Request {
    public String name;
    public String origin;
    public String description;
}
