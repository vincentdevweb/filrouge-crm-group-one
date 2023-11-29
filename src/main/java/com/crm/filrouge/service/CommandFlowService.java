package com.crm.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.filrouge.dao.Client.Client;
import com.crm.filrouge.dao.Client.ClientRepository;
import com.crm.filrouge.dao.Order.Order;
import com.crm.filrouge.dao.Order.OrderRepository;

@Service
public class CommandFlowService {
    
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Client getClientById(Integer clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }
    public Order getOrderById(Integer orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Client updateClient(Client clientUpdate, Integer id) {
        Client existingClient = getClientById(id);
        if (existingClient != null) {
            clientUpdate.setId(existingClient.getId());
            return clientUpdate;
        }
        return null;
    }

    public Order updateOrder(Order orderUpdate, Integer id) {
        Order existingOrder = getOrderById(id);
        if (existingOrder != null) {
            orderUpdate.setId(existingOrder.getId());
            return orderUpdate;
        }
        return null;
    }

    public Client patchClient(Client clientUpdate, Integer id) {
        Client existingClient = getClientById(id);

        if (existingClient != null) {
            if (clientUpdate.getCompanyName() != null) {
                existingClient.setCompanyName(clientUpdate.getCompanyName());
            }
            if (clientUpdate.getFirstName() != null) {
                existingClient.setFirstName(clientUpdate.getFirstName());
            }
            if (clientUpdate.getLastName() != null) {
                existingClient.setLastName(clientUpdate.getLastName());
            }
            if (clientUpdate.getEmail() != null) {
                existingClient.setEmail(clientUpdate.getEmail());
            }
            if (clientUpdate.getPhone() != null) {
                existingClient.setPhone(clientUpdate.getPhone());
            }
            if (clientUpdate.getAddress() != null) {
                existingClient.setAddress(clientUpdate.getAddress());
            }
            if (clientUpdate.getZipCode() != null) {
                existingClient.setZipCode(clientUpdate.getZipCode());
            }
            if (clientUpdate.getCity() != null) {
                existingClient.setCity(clientUpdate.getCity());
            }
            if (clientUpdate.getCountry() != null) {
                existingClient.setCountry(clientUpdate.getCountry());
            }
            if (clientUpdate.getState() != null) {
                existingClient.setState(clientUpdate.getState());
            }

            return existingClient;
        }

        return null;
    }

    public Order patchOrder(Order orderUpdate, Integer id) {
        Order existingOrder = getOrderById(id);

        if (existingOrder != null) {
            if (orderUpdate.getTypePresta() != null) {
                existingOrder.setTypePresta(orderUpdate.getTypePresta());
            }
            if (orderUpdate.getDesignation() != null) {
                existingOrder.setDesignation(orderUpdate.getDesignation());
            }
            if (orderUpdate.getClient() != null) {
                existingOrder.setClient(orderUpdate.getClient());
            }
            if (orderUpdate.getNbDays() != null) {
                existingOrder.setNbDays(orderUpdate.getNbDays());
            }
            if (orderUpdate.getUnitPrice() != null) {
                existingOrder.setUnitPrice(orderUpdate.getUnitPrice());
            }
            if (orderUpdate.getTotalExcludeTaxe() != null) {
                existingOrder.setTotalExcludeTaxe(orderUpdate.getTotalExcludeTaxe());
            }
            if (orderUpdate.getTotalWithTaxe() != null) {
                existingOrder.setTotalWithTaxe(orderUpdate.getTotalWithTaxe());
            }
            if (orderUpdate.getState() != null) {
                existingOrder.setState(orderUpdate.getState());
            }

            return existingOrder;
        }

        return null;
    }

    public Boolean deleteClient(Integer id) {
        Client existingClient = getClientById(id);
        if (existingClient != null) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Boolean deleteOrder(Integer id) {
        Order existingOrder = getOrderById(id);
        if (existingOrder != null) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
