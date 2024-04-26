package yang.idowhatiwant.domain.text.dto;

import lombok.*;
import yang.idowhatiwant.domain.text.domain.Text;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TextsResponse {
    private Long id;
    private String title;
    private LocalDateTime date;

    @Builder
    public TextsResponse(Text text) {
        id = text.getId();
        title = text.getTitle();
        date = text.getDate();
    }
}
