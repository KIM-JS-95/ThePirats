package com.ThePirats.Entity.Dto.Reaponse;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreApiResponse {

    private String name;

    private String description;

    private int level;

    private String businessStatus;
}
