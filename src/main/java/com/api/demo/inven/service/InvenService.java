package com.api.demo.inven.service;

import com.api.demo.common.BadRequestException;
import com.api.demo.common.CommRespDto;
import com.api.demo.inven.domain.Inven;
import com.api.demo.inven.dto.InvenRequestDto;
import com.api.demo.inven.dto.InvenResponseDto;
import com.api.demo.inven.repository.InvenRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvenService {
    private final InvenRepository invenRepository;

    public InvenService(InvenRepository invenRepository) {
        this.invenRepository = invenRepository;
    }

    public List<InvenResponseDto> readPrdOptnInven(String prdNm, String optnNm) {
        List<Inven> invens;

        // 상품명 + 옵션명 조합
        if(!Strings.isEmpty(optnNm)) {
            invens = new ArrayList<>();
            Optional<Inven> item = invenRepository.findByPrdNmAndOptnNm(prdNm, optnNm);

            if(item.isPresent()) {
                invens.add(item.get());
            }
        } else {
            invens = invenRepository.findByPrdNm(prdNm);
        }

        return invens.stream()
                     .map(InvenResponseDto::new)
                     .collect(Collectors.toList());
    }

    @Transactional
    public CommRespDto modifyPrdOptnInven(InvenRequestDto invenRequestDto, int increment) {

        Optional<Inven> item = invenRepository.findByPrdNmAndOptnNm(invenRequestDto.getPrdNm(), invenRequestDto.getOptnNm());

        if(!item.isPresent()) {
            throw new NotFoundException(StringUtils.EMPTY);
        }
        Inven inven = item.get();

        int qnty = invenRequestDto.getPrdQnty() * increment;
        if(!inven.psblQntyUpdate(qnty)) {
            throw new BadRequestException("재고 수량은 0 미만이 될 수 없습니다.");
        }
        inven.addQnty(qnty);

        return CommRespDto.successWithContents(new InvenResponseDto(inven));
    }
}
