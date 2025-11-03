package pmoc.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pmoc.entities.MecanicsEntity;

@RequestMapping("/api/mecanics")
public interface MecanicsController {
    @GetMapping
    ResponseEntity<Page<MecanicsEntity>> paginateAllMecanics(
        @RequestParam int pageNum,
        @RequestParam(defaultValue = "25") int pageSize
    );
}
