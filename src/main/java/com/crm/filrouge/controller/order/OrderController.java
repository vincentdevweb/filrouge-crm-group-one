package com.crm.filrouge.controller.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.filrouge.controller.order.dto.OrderDTO;
import com.crm.filrouge.controller.order.dto.OrderMapper;
import com.crm.filrouge.controller.order.dto.OrderPostDTO;
import com.crm.filrouge.dao.Order.Order;
import com.crm.filrouge.service.CommandFlowService;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private CommandFlowService commandFlowService;

    @GetMapping("orders")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<Order> entities = commandFlowService.getAllOrders();
        List<OrderDTO> dtos = new ArrayList<>();
        for (Order entity : entities)
            dtos.add(OrderMapper.convertFromEntityToDto(entity));

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping("orders")
    public ResponseEntity<String> createOrder(@RequestBody OrderPostDTO orderPostDTO) {
        Order order = OrderMapper.convertFromDtoToEntity(orderPostDTO);
        try {
            commandFlowService.saveOrder(order);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Order created successfully");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Error: JSON");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }

    @GetMapping("orders/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable("id") Integer id) {
        Order entity = commandFlowService.getOrderById(id);
        if (entity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
        }
        OrderDTO dto = OrderMapper.convertFromEntityToDto(entity);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("orders/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable("id") Integer id,
            @RequestBody OrderPostDTO orderPutDTO) {
        Order order = OrderMapper.convertFromDtoToEntity(orderPutDTO);
        Order existingOrder = commandFlowService.updateOrder(order, id);
        if (existingOrder != null) {
            try {
                commandFlowService.saveOrder(existingOrder);
                return ResponseEntity.ok("Order Put successfully");
            } catch (DataIntegrityViolationException e) {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body("Error: JSON");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Order Not Found");
    }

    @PatchMapping("orders/{id}")
    public ResponseEntity<String> patchOrder(@PathVariable("id") Integer id,
    @RequestBody OrderPostDTO orderPatchDTO) {
    Order order = OrderMapper.convertFromDtoToEntity(orderPatchDTO);
    Order existingOrder = commandFlowService.patchOrder(order, id);
    if (existingOrder == null) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
    }
    try {
    commandFlowService.saveOrder(existingOrder);
    return ResponseEntity.ok("Order Patch successfully");
    } catch (Exception e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: "
    + e.getMessage());
    }
    }

    @DeleteMapping("orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Integer id) {
        if (commandFlowService.deleteOrder(id)) {
            return ResponseEntity.ok("Order deleted successfully");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
    }
}
