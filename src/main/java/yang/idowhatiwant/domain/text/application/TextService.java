package yang.idowhatiwant.domain.text.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yang.idowhatiwant.domain.text.domain.Text;
import yang.idowhatiwant.domain.text.dto.TextRequest;
import yang.idowhatiwant.domain.text.dto.TextResponse;
import yang.idowhatiwant.domain.text.dto.TextsResponse;
import yang.idowhatiwant.domain.text.exception.TextNotFoundException;
import yang.idowhatiwant.domain.text.repository.TextRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TextService {
    private final TextRepository textRepository;

    public TextResponse save(TextRequest request) {
        Text text = Text.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .date(LocalDateTime.now())
                .build();
        Text savedText = textRepository.save(text);
        return new TextResponse(savedText);
    }

    public TextResponse get(Long id) {
        if (!textRepository.existsById(id)) {
            throw new TextNotFoundException();
        }
        Text text = textRepository.findById(id).get();
        return new TextResponse(text);
    }

    public List<TextsResponse> getAll() {
        List<TextsResponse> textsDTO= new ArrayList<>();
        List<Text> texts = textRepository.findAllByOrderByDate();

        for (Text text : texts) {
            TextsResponse dto = new TextsResponse();
            dto.setId(text.getId());
            dto.setTitle(text.getTitle());
            dto.setDate(text.getDate());
            textsDTO.add(dto);
        }
        return textsDTO;
    }
}
