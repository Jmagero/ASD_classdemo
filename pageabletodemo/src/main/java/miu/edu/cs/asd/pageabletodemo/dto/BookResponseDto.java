package miu.edu.cs.asd.pageabletodemo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {
    private String title;
    private LocalDate publishedDate;
    private BigDecimal price;
}
