package yang.idowhatiwant.domain.text.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yang.idowhatiwant.domain.text.application.TextService;
import yang.idowhatiwant.domain.text.dto.TextRequest;
import yang.idowhatiwant.domain.text.dto.TextResponse;
import yang.idowhatiwant.domain.text.dto.TextsResponse;
import yang.idowhatiwant.global.config.dto.ResponseDto;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static yang.idowhatiwant.domain.text.presentation.constant.ResponseMessage.SUCCESS_CREATE;
import static yang.idowhatiwant.domain.text.presentation.constant.ResponseMessage.SUCCESS_READ;

@RestController
@RequestMapping("/text")
@RequiredArgsConstructor
public class TextController {
    private final TextService textService;

    @PostMapping
    public ResponseDto<TextResponse> save(@RequestBody TextRequest request) {
        TextResponse response = textService.save(request);
        return ResponseDto.of(OK.value(), SUCCESS_CREATE.getMessage(), response);
    }

    @GetMapping("/{id}")
    public ResponseDto<TextResponse> get(@PathVariable Long id) {
        TextResponse response = textService.get(id);
        return ResponseDto.of(OK.value(), SUCCESS_READ.getMessage(), response);
    }

    @GetMapping("/all")
    public ResponseDto<List<TextsResponse>> getAll() {
        List<TextsResponse> responses = textService.getAll();
        return ResponseDto.of(OK.value(), SUCCESS_READ.getMessage(), responses);
    }
}
