package yang.idowhatiwant.domain.text.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TextRequest {
    private String title;
    private String content;
}
