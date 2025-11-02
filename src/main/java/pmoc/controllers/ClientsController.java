package pmoc.controllers;


import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;

import pmoc.entities.ClientEntity;

@RequestMapping("/api/clients")
public interface ClientsController {
    Page<ClientEntity> paginateAllClients(int pageNum, int pageSize);
}
