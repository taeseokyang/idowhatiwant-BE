package yang.idowhatiwant.domain.text.dto;

import lombok.*;
import yang.idowhatiwant.domain.text.domain.Text;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TextResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime date;

    @Builder
    public TextResponse(Text text) {
        id = text.getId();
        title = text.getTitle();
        content = text.getContent();
        date = text.getDate();
    }
}
