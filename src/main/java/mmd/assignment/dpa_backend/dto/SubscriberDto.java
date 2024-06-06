package mmd.assignment.dpa_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberDto {
    private Long id;
    private String name;
    private String msisdn;
    private String status;
}
