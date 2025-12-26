package com.example.demo.service;
import com.example.demo.dto.request.FormatRequestDto;
import com.example.demo.dto.response.FormatResponseDto;
import com.example.demo.entity.Format;

import java.util.List;

public interface FormatService {

    List<FormatResponseDto> getAll();

    FormatResponseDto getById(Long id);

    FormatResponseDto create(FormatRequestDto dto);

    void delete(Long id);
}
