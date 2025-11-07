package pmoc.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pmoc.DTOs.OrderDTO.RequestOrderDTO;
import pmoc.DTOs.OrderDTO.ResponseOrderDTO;
import pmoc.entities.OrderEntity;

@RequestMapping("/api/orders")
public interface OrderController {
    @Operation(summary = "Lista todos os pedidos de forma paginada",
            description = "Retorna uma página de pedidos, permitindo a navegação por número da página e tamanho.")
    @ApiResponse(responseCode = "200", description = "Listagem paginada de pedidos retornada com sucesso")
    @GetMapping
    ResponseEntity<Page<OrderEntity>> pageableAllOrders(
            @Parameter(description = "Número da página (base 0) para a busca.", example = "0")
            @RequestParam(defaultValue = "0") int pageNum,
            @Parameter(description = "Quantidade de itens por página.", example = "10")
            @RequestParam(defaultValue = "25") int pageSize
    );

    @Operation(summary = "Cria um novo pedido de serviço",
            description = "Cria uma nova ordem de serviço associando um cliente e um mecânico.")
    @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso",
            content = @Content(schema = @Schema(implementation = ResponseOrderDTO.class)))
    @ApiResponse(responseCode = "404", description = "Cliente ou Mecânico não encontrado")
    @PostMapping
    ResponseEntity<ResponseOrderDTO> createNewOrder(
            @Valid
            @RequestBody RequestOrderDTO data
    );

    @Operation(summary = "Atualiza um pedido existente",
            description = "Atualiza os dados de um pedido, buscando-o pelo ID.")
    @ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso",
            content = @Content(schema = @Schema(implementation = OrderEntity.class)))
    @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    @PutMapping("/{id}")
    ResponseEntity<OrderEntity> updateOrder(
            @Parameter(description = "ID do pedido para ser atualizad.", example = "1")
            @Valid
            @RequestBody RequestOrderDTO data,
            @PathVariable Long id
    );

    @Operation(summary = "Exclui um pedido",
            description = "Remove um pedido do sistema pelo seu ID.")
    @ApiResponse(responseCode = "204", description = "Pedido excluído (No Content)")
    @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteOrder(
            @Parameter(description = "ID do pedido para ser deletado.", example = "1")
            @PathVariable Long id
    );
}
